package SchoolConstructionManagement.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import SchoolConstructionManagement.Objects.JobObject;
import SchoolConstructionManagement.Objects.ManagerObject;
import SchoolConstructionManagement.Table.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JobDetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
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
					int maDA = 2, maCV = 8;
					JobDetail frame = new JobDetail(m,ql,maDA, maCV);
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
	public JobDetail(Manager m, ManagerObject ql, int maDA, int maCV) {
		setBackground(new Color(96, 182, 191));

		setTitle("Chi tiết tài nguyên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 726);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(96, 182, 191));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi tiết tài nguyên");
		lblNewLabel.setBounds(238, 10, 296, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên công việc");
		lblNewLabel_1.setBounds(210, 91, 101, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã công việc");
		lblNewLabel_2.setBounds(74, 91, 84, 13);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(74, 114, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(210, 114, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 185, 719, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Mã tài nguyên");
		lblNewLabel_3.setBounds(74, 406, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Loại tài nguyên");
		lblNewLabel_4.setBounds(180, 406, 76, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mô tả");
		lblNewLabel_5.setBounds(321, 406, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Chi phí");
		lblNewLabel_6.setBounds(414, 406, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ngày thanh toán");
		lblNewLabel_7.setBounds(545, 406, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tổng chi phí");
		lblNewLabel_8.setBounds(677, 406, 92, 13);
		contentPane.add(lblNewLabel_8);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(37, 429, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 429, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(296, 429, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(414, 429, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(545, 429, 96, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(673, 429, 96, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		JButton btn1 = new JButton("Sửa");
		btn1.setEnabled(false);
		btn1.setBounds(122, 474, 85, 21);
		contentPane.add(btn1);
		JButton btn2 = new JButton("Xóa");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa chọn tài nguyên.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if(m.deleteResourceAndJobTNCV(Integer.valueOf(textField.getText()), Integer.valueOf(textField_2.getText()))) {
						JOptionPane.showMessageDialog(null, "Xóa thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						data = m.RJListView(maCV);
						table.setModel(data);
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
						textField_7.setText("");
						btn1.setEnabled(false);
						btn2.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null, "Xóa thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btn2.setEnabled(false);
		btn2.setBounds(296, 474, 85, 21);
		contentPane.add(btn2);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maTaiNguyen, maCV, chiPhiTN=0, tongChiPhi=0;
				String loaiTN="", moTa="", ngayThanhToan="";
				if(!textField_2.getText().isEmpty()) {
					try {
						maTaiNguyen = Integer.valueOf(textField_2.getText());
						maCV = Integer.valueOf(textField.getText());
						if(!textField_5.getText().isEmpty()) {
							chiPhiTN = Integer.valueOf(textField_5.getText());
							if(chiPhiTN < 0) chiPhiTN = 0;
						}
						
						if(!textField_7.getText().isEmpty()) {
							tongChiPhi = Integer.valueOf(textField_7.getText());
							if(tongChiPhi < 0) tongChiPhi = 0;
						}
						if(!textField_3.getText().isEmpty()) loaiTN = textField_3.getText();
						if(!textField_4.getText().isEmpty()) moTa = textField_4.getText();
						if(!textField_6.getText().isEmpty()) ngayThanhToan = textField_6.getText();
						
						if(m.updateResourceAndJob(maTaiNguyen, maCV, loaiTN, moTa, chiPhiTN, ngayThanhToan, tongChiPhi)) {
							JOptionPane.showMessageDialog(null, "Sửa thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							data = m.RJListView(maCV);
							table.setModel(data);
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
							textField_7.setText("");
							btn1.setEnabled(false);
							btn2.setEnabled(false);
							
						} else {
							JOptionPane.showMessageDialog(null, "Sửa thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch(Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lỗi dữ liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}	
				} else {
					JOptionPane.showMessageDialog(null, "Chưa chọn tài nguyên.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("Quay lại");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobDetail.this.setVisible(false);
				ProjectView a = new ProjectView(m, ql, maDA);
				a.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(469, 474, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_9 = new JLabel("Danh sách tài nguyên");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(249, 162, 240, 13);
		contentPane.add(lblNewLabel_9);
		
		JobObject j = m.findJob(maCV);
		textField.setText(String.valueOf(j.getMaCV()));
		textField_1.setText(j.getTenCV());
		
		data = m.RJListView(maCV);
		table.setModel(data);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				data = m.RJListView(maCV);
				int index = table.getSelectedRow();
				textField_2.setText(String.valueOf(data.getValueAt(index, 0)));
				textField_3.setText(String.valueOf(data.getValueAt(index, 1)));
				textField_4.setText(String.valueOf(data.getValueAt(index, 2)));
				textField_5.setText(String.valueOf(data.getValueAt(index, 3)));
				textField_6.setText(String.valueOf(data.getValueAt(index, 4)));
				textField_7.setText(String.valueOf(data.getValueAt(index, 5)));
				
				btn1.setEnabled(true);
				btn2.setEnabled(true);
			}
		});
	}
}
