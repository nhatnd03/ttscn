package SchoolConstructionManagement.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import SchoolConstructionManagement.Objects.DocumentObject;
import SchoolConstructionManagement.Objects.LeaderObject;
import SchoolConstructionManagement.Objects.ManagerObject;
import SchoolConstructionManagement.Objects.ProjectObject;
import SchoolConstructionManagement.Table.Manager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LeaderView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private DefaultTableModel data = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Đảm bảo rằng JTable không thể chỉnh sửa
        }
    };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager m = new Manager();
					ManagerObject ql = new ManagerObject();
					int maDA = 1;
					LeaderView frame = new LeaderView(m, ql, maDA);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LeaderView(Manager m, ManagerObject ql, int maDA) {

		setTitle("Trưởng nhóm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(96, 182, 191));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 51, 639, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		data = m.LeaderListView(ql.getMaQL());
		table.setModel(data);
		
		
		JButton btnNewButton = new JButton("Bổ nhiệm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chọn trưởng nhóm muốn bổ nhiệm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int ma = Integer.valueOf(textField.getText());
					ProjectObject p = m.findProject(maDA);
					
					if(m.updateProject(p.getMaDA(), p.getTenDA(), p.getNgayBatDau(), p.getNgayKetThuc(), p.getTienDo(), p.getMoTaDA(), p.getMaQL(), ma)
						&& m.updateJobMaTN(maDA, p.getMaTN(), ma)) {
						JOptionPane.showMessageDialog(null, "Bổ nhiệm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
					} else {
						try {
							m.getCon().rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Bổ nhiệm thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(64, 362, 106, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sửa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chọn trưởng nhóm muốn sửa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int ma = Integer.valueOf(textField.getText()) ;
					LeaderObject d = new LeaderObject(ma, " "," ", " ", " ", " ", ql.getMaQL());
					
					if(!textField_1.getText().isEmpty()) {
						d.setTenTN(textField_1.getText());
					}
					if(!textField_2.getText().isEmpty()) {
						d.setNgaySinh(textField_2.getText());
					}
					if(!textField_3.getText().isEmpty()) {
						d.setDiaChi(textField_3.getText());
					}
					if(!textField_4.getText().isEmpty()) {
						d.setSoDienThoai(textField_4.getText());
					}
					if(!textField_5.getText().isEmpty()) {
						d.setEmail(textField_5.getText());
					}
					
					if(m.updateLeader(d)) {
						JOptionPane.showMessageDialog(null, "Sửa thông tin thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						data = m.LeaderListView(ql.getMaQL());
						table.setModel(data);
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Sửa thông tin thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(313, 362, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy chọn trưởng nhóm muốn xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}else {
					ProjectObject p = m.findProject(maDA);
					int maCu = Integer.valueOf(textField.getText());
					if(p.getMaTN() == maCu) {
						m.updateJobMaTN(maDA, maCu, 0);
						m.updateProject(p.getMaDA(), p.getTenDA(), p.getNgayBatDau(), p.getNgayKetThuc(), p.getTienDo(), p.getMoTaDA(), p.getMaQL(), 0);
					}
						
					
					if(m.deleteLeader(maCu)) {
						JOptionPane.showMessageDialog(null, "Xóa thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						data = m.LeaderListView(ql.getMaQL());
						table.setModel(data);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Xóa thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		btnNewButton_2.setBounds(427, 362, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Thêm");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeaderObject d = new LeaderObject(0, " "," ", " ", " ", " ", ql.getMaQL());
				if(!textField_1.getText().isEmpty()) {
					d.setTenTN(textField_1.getText());
				}
				if(!textField_2.getText().isEmpty()) {
					d.setNgaySinh(textField_2.getText());
				}
				if(!textField_3.getText().isEmpty()) {
					d.setDiaChi(textField_3.getText());
				}
				if(!textField_4.getText().isEmpty()) {
					d.setSoDienThoai(textField_4.getText());
				}
				if(!textField_5.getText().isEmpty()) {
					d.setEmail(textField_5.getText());
				}
				
				if(m.addLeader(d)) {
					JOptionPane.showMessageDialog(null, "Thêm trưởng nhóm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					data = m.LeaderListView(ql.getMaQL());
					table.setModel(data);
				} else {
					JOptionPane.showMessageDialog(null, "Thêm trưởng nhóm thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_3.setBounds(192, 362, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Quay lại");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LeaderView.this.setVisible(false);
				ProjectView a = new ProjectView(m, ql, maDA);
				a.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(552, 362, 85, 21);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Danh sách trưởng nhóm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(192, 10, 364, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(62, 301, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 301, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(302, 301, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(427, 301, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(552, 301, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã");
		lblNewLabel_1.setBounds(62, 278, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên");
		lblNewLabel_2.setBounds(211, 278, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
		lblNewLabel_3.setBounds(444, 278, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setBounds(552, 278, 85, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(691, 278, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày sinh");
		lblNewLabel_6.setBounds(293, 278, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(669, 301, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				
				textField.setText((String)(data.getValueAt(index, 0)));
				textField_1.setText((String)(data.getValueAt(index, 1)));
				textField_2.setText(String.valueOf(data.getValueAt(index, 2)));
				textField_3.setText((String)(data.getValueAt(index, 3)));
				textField_4.setText((String)(data.getValueAt(index, 4)));
				textField_5.setText((String)(data.getValueAt(index, 5)));
			}
			
		});
	}
}
