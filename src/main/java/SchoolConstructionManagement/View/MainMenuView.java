package SchoolConstructionManagement.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import SchoolConstructionManagement.*;

import SchoolConstructionManagement.Objects.BudgetObject;
import SchoolConstructionManagement.Objects.DocumentObject;
import SchoolConstructionManagement.Objects.LeaderObject;
import SchoolConstructionManagement.Objects.ManagerObject;
import SchoolConstructionManagement.Objects.ProjectObject;
import SchoolConstructionManagement.Table.Manager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class MainMenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textADD;
	private JTextField textDate;
	private JTextField textName;
	private JTextField textID;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static String maDA;
	private JTextField textField_5;
	DefaultTableModel data = new DefaultTableModel() {
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
			Manager m = new Manager();
			ManagerObject ql = new ManagerObject();
			public void run() {
				try {
					MainMenuView frame = new MainMenuView(m, ql);
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
	public MainMenuView(Manager m, ManagerObject item) {
		setTitle("Trang chủ");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 641);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(96, 182, 191));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách dự án");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(13, 218, 182, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý dự án");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(105, 10, 143, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã quản lý");
		lblNewLabel_2.setBounds(124, 88, 84, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên quản lý");
		lblNewLabel_3.setBounds(124, 123, 84, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày sinh");
		lblNewLabel_4.setBounds(124, 146, 71, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Địa chỉ");
		lblNewLabel_5.setBounds(124, 175, 59, 13);
		contentPane.add(lblNewLabel_5);
		
		textADD = new JTextField();
		textADD.setBounds(226, 172, 238, 19);
		contentPane.add(textADD);
		textADD.setColumns(10);
		
		textDate = new JTextField();
		textDate.setBounds(226, 143, 238, 19);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(227, 114, 237, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(227, 85, 237, 19);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().isEmpty() && textDate.getText().isEmpty() && textADD.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập ô nào.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if(item.getTenQL() == null) {
						item.setTenQL(" ");
					}
					if(item.getNgaySinh() == null) {
						item.setNgaySinh(" ");
					}
					if(item.getDiaChi() == null) {
						item.setDiaChi(" ");
					}
					
					// Lay du lieu tu o text
					if(!textName.getText().isEmpty()) {
						item.setTenQL(textName.getText());
					} else {
						item.setTenQL(" ");
					}
					if(!textDate.getText().isEmpty()) {
						item.setNgaySinh(textDate.getText());
					} else {
						item.setNgaySinh(" ");
					}
					if(!textADD.getText().isEmpty()) {
						item.setDiaChi(textADD.getText());
					} else {
						item.setDiaChi(" ");
					}
					
					if(m.updateManager(item)) {
						JOptionPane.showMessageDialog(null, "Sửa thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Sửa thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(226, 54, 85, 21);
		contentPane.add(btnNewButton);
		
		//Hiện danh sách dự án
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 369, 632, 145);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectObject p = new ProjectObject(0, " ", " ", " ", " ", " ", item.getMaQL(), 0);
				if(textField.getText().isEmpty()) {
					p.setTenDA(" ");
				} else {
					p.setTenDA(textField.getText());
				}
				if(textField_1.getText().isEmpty()) {
					p.setNgayBatDau(" ");
				} else {
					p.setNgayBatDau(textField_1.getText());
				}
				if(textField_2.getText().isEmpty()) {
					p.setNgayKetThuc(" ");
				} else {
					p.setNgayKetThuc(textField_2.getText());
				}
				if(textField_3.getText().isEmpty()) {
					p.setTienDo(" ");
				} else {
					p.setTienDo(textField_3.getText());
				}
				if(textField_4.getText().isEmpty()) {
					p.setMoTaDA(" ");
				} else {
					p.setMoTaDA(textField_4.getText());
				}
				if(m.addProject(p)) {
					JOptionPane.showMessageDialog(null, "Thêm dự án thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					data = m.ProjectListView(item.getMaQL());
					table.setModel(data);
				} else {
					data = m.ProjectListView(item.getMaQL());
					table.setModel(data);
					JOptionPane.showMessageDialog(null, "Thêm dự án thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		btnNewButton_1.setBounds(702, 367, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btn2 = new JButton("Sửa");
		btn2.setEnabled(false);
		btn2.setBounds(702, 429, 85, 21);
		contentPane.add(btn2);
		JButton btn3 = new JButton("Xóa");
		btn3.setEnabled(false);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa chọn dự án.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int maDA = Integer.valueOf(textField_5.getText());
					boolean check = true;
					//xóa ngân sách, tài liệu, tài nguyên -> xóa tn_cv , xóa CV, xóa TN, 
					BudgetObject b = m.findBudget(maDA);
					if(b != null) {
						if(!m.deleteBudget(b.getMaDA())) check = false;
					}
					if(m.findDocument(maDA)) if(!m.deleteDocumentAll(maDA)) check = false;
					
					if(!m.deleteRJ(maDA)) check = false;
					if(m.findResource(maDA)) if(!m.deleteResourceAll(maDA)) check = false;
					if(m.findJobAll(maDA))	if(!m.deleteJobAll(maDA)) check = false;
					
					if(m.deleteProject(maDA) && check) {
						JOptionPane.showMessageDialog(null, "Đã xóa dự án.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						data = m.ProjectListView(item.getMaQL());
						table.setModel(data);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						btn2.setEnabled(false);
						btn3.setEnabled(false);
					} else {
						data = m.ProjectListView(item.getMaQL());
						table.setModel(data);
						JOptionPane.showMessageDialog(null, "Xóa dự án thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btn3.setBounds(702, 478, 85, 21);
		contentPane.add(btn3);
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(26, 277, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maDA = 0, maTN = 0;
				String tenDA = "", ngayBatDau="", ngayKetThuc="", tienDo="", moTaDA=""; 
				
				
				if(textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa chọn dự án.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					ProjectObject p = m.findProject(Integer.valueOf(textField_5.getText()));

					if(!textField.getText().isEmpty()) tenDA = textField.getText();
					if(!textField_1.getText().isEmpty()) ngayBatDau = textField_1.getText();
					if(!textField_2.getText().isEmpty()) ngayKetThuc = textField_2.getText();
					if(!textField_3.getText().isEmpty()) tienDo = textField_3.getText();	
					if(!textField_4.getText().isEmpty()) moTaDA = textField_4.getText();
						
					if(m.updateProject(p.getMaDA(), tenDA, ngayBatDau, ngayKetThuc, tienDo, moTaDA, item.getMaQL(), p.getMaTN())) {
						JOptionPane.showMessageDialog(null, "Sửa dự án thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						data = m.ProjectListView(item.getMaQL());
						table.setModel(data);
					
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						btn2.setEnabled(false);
						btn3.setEnabled(false);
						
					} else {
						data = m.ProjectListView(item.getMaQL());
						table.setModel(data);
						JOptionPane.showMessageDialog(null, "Sửa dự án thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}		
			}
		});
		
		JButton btnNewButton_4 = new JButton("Đăng xuất");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuView.this.setVisible(false);
				LoginView a = new LoginView();
				a.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(641, 528, 108, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btn1 = new JButton("Chi tiết");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy chọn một dự án.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					MainMenuView.this.setVisible(false);
					ProjectView a = new ProjectView(m, item, Integer.valueOf(textField_5.getText()) );
					a.setVisible(true);
				}
			}
		});

		btn1.setBounds(702, 398, 84, 21);
		contentPane.add(btn1);
		
		JLabel lblNewLabel_6 = new JLabel("Quản lý");
		lblNewLabel_6.setBounds(124, 58, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tên dự án");
		lblNewLabel_7.setBounds(184, 254, 78, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tiến độ");
		lblNewLabel_8.setBounds(308, 254, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Ngày bắt đầu");
		lblNewLabel_9.setBounds(439, 254, 77, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Ngày kết thúc");
		lblNewLabel_10.setBounds(564, 254, 96, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Mô tả");
		lblNewLabel_11.setBounds(59, 336, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		textField = new JTextField();
		textField.setBounds(182, 277, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(439, 277, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(564, 277, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(303, 277, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(124, 333, 536, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Mã");
		lblNewLabel_12.setBounds(41, 254, 45, 13);
		contentPane.add(lblNewLabel_12);
		
		
		
		String sql1 = "SELECT * FROM nguoiquanly ";
		sql1 += "WHERE maQL = ?";
		try {
			PreparedStatement pre = m.getCon().prepareStatement(sql1);
			// Truyền tổng số bản ghi cần lấy:
			
			pre.setInt(1, item.getMaQL());
			
			// Lấy danh sách bản ghi:
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				textID.setText(String.valueOf(rs.getInt("maQL")));
				textName.setText(rs.getString("tenQL"));
				textDate.setText(rs.getString("ngaySinh"));
				textADD.setText(rs.getString("diaChi"));
			}
			rs.close();
			m.getCon().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			// Trở về trạng thái an toàn của kết nối:
			try {
				m.getCon().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		data = m.ProjectListView(item.getMaQL());
		table.setModel(data);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon(MainMenuView.class.getResource("/SchoolConstructionManagement/anh/mainmn  1.png")));
		lblNewLabel_13.setBounds(13, 35, 718, 169);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon(MainMenuView.class.getResource("/SchoolConstructionManagement/anh/Asset 5.png")));
		lblNewLabel_14.setBounds(10, 254, 795, 320);
		contentPane.add(lblNewLabel_14);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				data = m.ProjectListView(item.getMaQL());
				textField_5.setText((String)(data.getValueAt(index, 0)));
				textField.setText((String)(data.getValueAt(index, 1)));
				textField_1.setText((String)(data.getValueAt(index, 2)));
				textField_2.setText(String.valueOf(data.getValueAt(index, 3)));
				textField_3.setText((String)(data.getValueAt(index, 4)));
				textField_4.setText((String)(data.getValueAt(index, 5)));
				btn2.setEnabled(true);
				btn3.setEnabled(true);
			}
			
		});
	}
}
