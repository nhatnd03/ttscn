package SchoolConstructionManagement.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SchoolConstructionManagement.Objects.ManagerObject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import SchoolConstructionManagement.Objects.ManagerObject;
import SchoolConstructionManagement.Table.Manager;


import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dimension;
public class ResisterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSDT;
	private JTextField textEmail;
	private JTextField textTK;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					ResisterView frame = new ResisterView();
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
	public ResisterView() {
		setResizable(false);
		setMaximumSize(new Dimension(43, 13));
		setTitle("Đăng ký");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(256, 24, 111, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại");
		lblNewLabel_1.setBounds(168, 75, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(168, 139, 64, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tài khoản");
		lblNewLabel_3.setBounds(168, 204, 85, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mật khẩu");
		lblNewLabel_4.setBounds(168, 271, 85, 13);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager m = new Manager();
				if(textSDT.getText().isEmpty() || textTK.getText().isEmpty() || textEmail.getText().isEmpty() || textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					String taiKhoan = textTK.getText();
					String matKhau = textField.getText();
					
					String sdt = textSDT.getText();
					String email = textEmail.getText();
					ManagerObject m1 = new ManagerObject();
					m1.setTaiKhoan(taiKhoan);
					m1.setMatKhau(matKhau);
					m1.setSoDienThoai(sdt);
					m1.setEmail(email);
					if(m.addManager(m1)) {
						
						JOptionPane.showMessageDialog(null, "Đăng ký thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						textTK.setText("");
						textField.setText("");
						textSDT.setText("");
						textEmail.setText("");
					} else {
						
						JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(158, 337, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quay lại");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResisterView.this.setVisible(false);
				LoginView a = new LoginView();
				a.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(311, 337, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textSDT = new JTextField();
		textSDT.setBounds(158, 110, 271, 19);
		contentPane.add(textSDT);
		textSDT.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(158, 162, 271, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textTK = new JTextField();
		textTK.setBounds(158, 227, 271, 19);
		contentPane.add(textTK);
		textTK.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(158, 294, 271, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(ResisterView.class.getResource("/SchoolConstructionManagement/anh/register.png")));
		lblNewLabel_5.setBounds(-9, -29, 613, 442);
		contentPane.add(lblNewLabel_5);
	}
}
