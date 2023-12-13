package SchoolConstructionManagement.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import SchoolConstructionManagement.Objects.ManagerObject;
import SchoolConstructionManagement.Table.Manager;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;


public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel txtMatKhau;
	private JTextField textTaiKhoan;
	private JTextField textField;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					LoginView frame = new LoginView();
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
	public LoginView() {
		setResizable(false);
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 455);
		txtMatKhau = new JPanel();
		txtMatKhau.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(txtMatKhau);
		txtMatKhau.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		lblNewLabel.setBounds(178, 100, 116, 28);
		txtMatKhau.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(207, 137, 69, 13);
		txtMatKhau.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(210, 200, 66, 13);
		txtMatKhau.add(lblNewLabel_2);
		
		textTaiKhoan = new JTextField();
		textTaiKhoan.setBounds(120, 171, 242, 19);
		txtMatKhau.add(textTaiKhoan);
		textTaiKhoan.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager m = new Manager();
				if(textTaiKhoan.getText().isEmpty() || textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String taiKhoan = textTaiKhoan.getText();
					String mk = textField.getText();
					
					String sql = "SELECT * FROM nguoiquanly WHERE taiKhoan = ?";
					
					// phai tat setAutocomit dong 22 cau lenh duoc bien dich truoc chi can nhap tham so
					try {
						PreparedStatement pre = m.getCon().prepareStatement(sql);
						
						//truyen gia tri
						pre.setString(1, taiKhoan);
						
						ResultSet rs = pre.executeQuery(); //thực thi
						
						if(rs == null) {
							JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						} else {
							rs.next();
							ManagerObject item = new ManagerObject();	
							
							item.setMatKhau(rs.getString("matKhau"));
							
							if(mk.equalsIgnoreCase(item.getMatKhau())) {
								ManagerObject ql = new ManagerObject(0, " ", " ", " ");
								
								ql.setMaQL(rs.getInt("maQL"));
								ql.setTenQL(rs.getString("tenQL"));
								ql.setNgaySinh(rs.getString("ngaySinh"));
								ql.setDiaChi(rs.getString("diaChi"));
								
								LoginView.this.setVisible(false);
								
								MainMenuView a = new MainMenuView(m, ql);
								a.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
							}
							//dong tap ket qua
							
						}
						rs.close();
						//xác nhận thực thi sau cùng
						m.getCon().commit();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
						try {
							m.getCon().rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							//JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				
			}
		});
		btnNewButton.setBounds(120, 266, 101, 21);
		txtMatKhau.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đăng ký");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView.this.setVisible(false);
				ResisterView r = new ResisterView();
				r.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(281, 266, 85, 21);
		txtMatKhau.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Đổi mật khẩu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView.this.setVisible(false);
				ChangePassWordView a = new ChangePassWordView();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(178, 326, 129, 21);
		txtMatKhau.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(99, 223, 290, 19);
		txtMatKhau.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\D\\thuctapcosonganh\\1x\\login.png"));
		lblNewLabel_3.setBounds(10, 0, 464, 438);
		txtMatKhau.add(lblNewLabel_3);
	}
}
