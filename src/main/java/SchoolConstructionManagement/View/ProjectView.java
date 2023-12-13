package SchoolConstructionManagement.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import SchoolConstructionManagement.*;

import SchoolConstructionManagement.Objects.BudgetObject;
import SchoolConstructionManagement.Objects.DocumentObject;
import SchoolConstructionManagement.Objects.JobObject;
import SchoolConstructionManagement.Objects.LeaderObject;
import SchoolConstructionManagement.Objects.ManagerObject;
import SchoolConstructionManagement.Objects.ProjectObject;
import SchoolConstructionManagement.Objects.ResourceObject;
import SchoolConstructionManagement.Table.Manager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
public class ProjectView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTable table;
	private JTable table_1;
	private JTextField textField_5;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTable table_2;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	
	private DefaultTableModel data = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Đảm bảo rằng JTable không thể chỉnh sửa
        }
    };
    private DefaultTableModel data1 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Đảm bảo rằng JTable không thể chỉnh sửa
        }
    };
    private DefaultTableModel data2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Đảm bảo rằng JTable không thể chỉnh sửa
        }
    };
	private JTextField textField_32;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Manager m = new Manager();
				ManagerObject id = new ManagerObject();
				int maDA = 1;
				
				try {
					ProjectView frame = new ProjectView(m, id, maDA);
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
	
	public ProjectView(Manager m, ManagerObject ql, int maDA) {
		setResizable(false);
		ProjectObject p = m.findProject(maDA);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Đặt màn hình ở giữa chính giữa
        setLocationRelativeTo(null);
        
		setTitle("Xem chi tiết dự án");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 830);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(96, 182, 191));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trưởng nhóm");
		lblNewLabel.setBounds(10, 33, 112, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Công việc");
		lblNewLabel_1.setBounds(10, 95, 81, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngân sách");
		lblNewLabel_2.setBounds(39, 525, 90, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tài liệu");
		lblNewLabel_3.setBounds(23, 605, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Quay lại");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectView.this.setVisible(false);
				MainMenuView a = new MainMenuView(m, ql);
				a.setVisible(true);
			}
		});
		btnNewButton.setBounds(1006, 754, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Mã ");
		lblNewLabel_5.setBounds(23, 44, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tên");
		lblNewLabel_6.setBounds(140, 44, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Địa chỉ");
		lblNewLabel_7.setBounds(381, 44, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày sinh");
		lblNewLabel_8.setBounds(267, 44, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Số điện thoại");
		lblNewLabel_9.setBounds(507, 44, 78, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Email");
		lblNewLabel_10.setBounds(608, 44, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(100, 7, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(335, 8, 96, 16);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(23, 66, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(140, 66, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(267, 67, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(373, 67, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mã");
		lblNewLabel_4.setBounds(46, 548, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_11 = new JLabel("Tổng số tiền");
		lblNewLabel_11.setBounds(140, 548, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Đã chi");
		lblNewLabel_12.setBounds(267, 548, 45, 13);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Còn lại");
		lblNewLabel_13.setBounds(410, 548, 45, 13);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Trạng thái");
		lblNewLabel_14.setBounds(495, 548, 68, 13);
		contentPane.add(lblNewLabel_14);
		
		JButton btnNewButton_4 = new JButton("Xem danh sách");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectView.this.setVisible(false);
				
				LeaderView a = new LeaderView(m, ql, maDA);
				a.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(747, 65, 128, 21);
		contentPane.add(btnNewButton_4);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(487, 67, 96, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Mã dự án");
		lblNewLabel_15.setBounds(23, 10, 61, 13);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Tên dự án");
		lblNewLabel_16.setBounds(230, 10, 90, 13);
		contentPane.add(lblNewLabel_16);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(608, 66, 96, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(26, 571, 96, 19);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Thêm");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maCV=0, luongNhanCong=0, maTN = 0;
				String tenCV="", moTaCV="", ngayBatDau="", ngayKetThuc="", trangThai="", tienDoCV=""; 
				ProjectObject p = m.findProject(maDA);
				if(p.getMaTN() == 0) {
					JOptionPane.showMessageDialog(null, "Chưa bổ nhiệm trưởng nhóm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					try {
						if(!textField_20.getText().isEmpty()) {
							luongNhanCong = Integer.valueOf(textField_20.getText());
							if(luongNhanCong < 0) luongNhanCong = 0;
						}
						
						if(!textField_14.getText().isEmpty()) tenCV = textField_14.getText();
						if(!textField_15.getText().isEmpty()) moTaCV = textField_15.getText();
						if(!textField_16.getText().isEmpty()) ngayBatDau = textField_16.getText();
						if(!textField_17.getText().isEmpty()) ngayKetThuc = textField_17.getText();
						if(!textField_18.getText().isEmpty()) trangThai = textField_18.getText();
						if(!textField_19.getText().isEmpty()) tienDoCV = textField_19.getText();
						
						if(m.addJob(0, tenCV, moTaCV, ngayBatDau, ngayKetThuc, trangThai, tienDoCV, luongNhanCong, maDA, p.getMaTN())) {
							JOptionPane.showMessageDialog(null, "Thêm công việc thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							data = m.JobListView(maDA);
							table.setModel(data);
						
							textField_32.setText("");
							textField_14.setText("");
							textField_15.setText("");
							textField_16.setText("");
							textField_17.setText("");
							textField_18.setText("");
							textField_19.setText("");
							textField_20.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Thêm công việc thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch(Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lỗi dữ liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}	
				}
			}
		});
		
		btnNewButton_6.setBounds(1172, 91, 85, 21);
		contentPane.add(btnNewButton_6);
		
		JButton btn8 = new JButton("Sửa");
		btn8.setEnabled(false);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maCV=0, luongNhanCong=0, maTN = 0;
				String tenCV="", moTaCV="", ngayBatDau="", ngayKetThuc="", trangThai="", tienDoCV=""; 
				
				if(textField_32.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa chọn công việc.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					try {
						maCV = Integer.valueOf(textField_32.getText());
						int ma = m.findJobMaTN(maCV);
						if(!textField_20.getText().isEmpty()) {
							luongNhanCong = Integer.valueOf(textField_20.getText());
							if(luongNhanCong < 0) luongNhanCong = 0;
						}
						
						if(!textField_14.getText().isEmpty()) tenCV = textField_14.getText();
						if(!textField_15.getText().isEmpty()) moTaCV = textField_15.getText();
						if(!textField_16.getText().isEmpty()) ngayBatDau = textField_16.getText();
						if(!textField_17.getText().isEmpty()) ngayKetThuc = textField_17.getText();
						if(!textField_18.getText().isEmpty()) trangThai = textField_18.getText();
						if(!textField_19.getText().isEmpty()) tienDoCV = textField_19.getText();
						
						if(m.updateJob(maCV, tenCV, moTaCV, ngayBatDau, ngayKetThuc, trangThai, tienDoCV, luongNhanCong, maDA, ma)) {
							JOptionPane.showMessageDialog(null, "Sửa công việc thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							data = m.JobListView(maDA);
							table.setModel(data);
						
							textField_32.setText("");
							textField_14.setText("");
							textField_15.setText("");
							textField_16.setText("");
							textField_17.setText("");
							textField_18.setText("");
							textField_19.setText("");
							textField_20.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Sửa công việc thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch(Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lỗi dữ liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}	
				}
			}
		});
		btn8.setBounds(1172, 145, 85, 21);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("Xóa");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_32.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa chọn công việc.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if(m.deleteJob(Integer.valueOf(textField_32.getText()))) {
						JOptionPane.showMessageDialog(null, "Đã xóa công việc.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						data = m.JobListView(maDA);
						table.setModel(data);
					
						textField_32.setText("");
						textField_14.setText("");
						textField_15.setText("");
						textField_16.setText("");
						textField_17.setText("");
						textField_18.setText("");
						textField_19.setText("");
						textField_20.setText("");
						btn8.setEnabled(false);
						btn9.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null, "Xóa công việc thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btn9.setEnabled(false);
		btn9.setBounds(1172, 191, 85, 21);
		contentPane.add(btn9);
		
		textField_9 = new JTextField();
		textField_9.setBounds(140, 571, 96, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(259, 571, 96, 19);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setBounds(365, 571, 96, 19);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(489, 571, 96, 19);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btn5 = new JButton("Sửa");
		btn5.setEnabled(false);
		btn5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					if(Integer.valueOf(textField_9.getText()) - Integer.valueOf(textField_10.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Tổng số tiền phải lớn hơn số tiền đã chi.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					} else {
						BudgetObject b = new BudgetObject();
						
						b.setMaNganSach(Integer.valueOf(textField_8.getText()));
						b.setTongSoTien(Integer.valueOf(textField_9.getText()));
						b.setSoTienDaChi(Integer.valueOf(textField_10.getText()));
						b.setSoTienConLai(Integer.valueOf(textField_9.getText()) - Integer.valueOf(textField_10.getText()));
						if(textField_12.getText().isEmpty()) {
							b.setTrangThai(" ");
						}else {
							b.setTrangThai(textField_12.getText());
						}
						
						if(m.updateBudget(b)) {
							JOptionPane.showMessageDialog(null, "Sửa ngân sách thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							
							textField_9.setText(String.valueOf(b.getTongSoTien()));
							textField_10.setText(String.valueOf(b.getSoTienDaChi()));
							textField_11.setText(String.valueOf(b.getSoTienConLai()));
							if(b.getTrangThai() == null) {
								textField_12.setText("");
							} else {
								textField_12.setText(String.valueOf(b.getTrangThai()));
							}
						} else {
							JOptionPane.showMessageDialog(null, "Sửa ngân sách thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Dữ liệu không đúng định dạng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btn5.setBounds(698, 570, 85, 21);
		contentPane.add(btn5);
		
		JLabel lblNewLabel_17 = new JLabel("Tài nguyên");
		lblNewLabel_17.setBounds(10, 309, 78, 13);
		contentPane.add(lblNewLabel_17);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 95, 963, 117);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(110, 307, 751, 106);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		JLabel lblNewLabel_18 = new JLabel("Tên ");
		lblNewLabel_18.setBounds(173, 222, 45, 13);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Mô tả");
		lblNewLabel_19.setBounds(300, 222, 45, 13);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Ngày bắt đầu");
		lblNewLabel_20.setBounds(417, 222, 88, 13);
		contentPane.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Ngày kết thúc");
		lblNewLabel_21.setBounds(531, 222, 88, 13);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Trạng thái");
		lblNewLabel_22.setBounds(693, 222, 76, 13);
		contentPane.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Tiến độ");
		lblNewLabel_23.setBounds(809, 222, 45, 13);
		contentPane.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Lương nhân công");
		lblNewLabel_24.setBounds(925, 222, 100, 13);
		contentPane.add(lblNewLabel_24);
		
		textField_14 = new JTextField();
		textField_14.setBounds(176, 253, 96, 21);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(300, 255, 96, 19);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(417, 255, 96, 19);
		contentPane.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(531, 255, 96, 19);
		contentPane.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(659, 254, 96, 19);
		contentPane.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(793, 255, 96, 19);
		contentPane.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBounds(917, 255, 96, 19);
		contentPane.add(textField_20);
		textField_20.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(74, 605, 643, 75);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_25 = new JLabel("Tên ");
		lblNewLabel_25.setBounds(198, 690, 45, 13);
		contentPane.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Ngày lập");
		lblNewLabel_26.setBounds(305, 690, 45, 13);
		contentPane.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Trạng thái");
		lblNewLabel_27.setBounds(414, 690, 68, 13);
		contentPane.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Mô tả");
		lblNewLabel_28.setBounds(520, 690, 45, 13);
		contentPane.add(lblNewLabel_28);
		
		textField_21 = new JTextField();
		textField_21.setBounds(153, 713, 96, 19);
		contentPane.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(264, 713, 96, 19);
		contentPane.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(381, 713, 96, 19);
		contentPane.add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setBounds(495, 713, 96, 19);
		contentPane.add(textField_24);
		textField_24.setColumns(10);
		
		JButton btn1 = new JButton("Thêm");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentObject d = new DocumentObject(" ", " ", " ", " ", maDA);
				if(!textField_21.getText().isEmpty()) {
					d.setTenTL(textField_21.getText());
				}
				if(!textField_22.getText().isEmpty()) {
					d.setNgayLap(textField_22.getText());
				}
				if(!textField_23.getText().isEmpty()) {
					d.setTrangThai(textField_23.getText());
				}
				if(!textField_24.getText().isEmpty()) {
					d.setMoTa(textField_24.getText());
				}
				
				if(m.addDocument(d)) {
					JOptionPane.showMessageDialog(null, "Thêm tài liệu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					data2 = m.DocumentListView(maDA);
					table_2.setModel(data2);
					textField_21.setText("");
					textField_22.setText("");
					textField_23.setText("");
					textField_24.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Thêm tài liệu thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn1.setBounds(808, 601, 85, 21);
		contentPane.add(btn1);
		JButton btn2 = new JButton("Sửa");
		btn2.setEnabled(false);
		btn2.setBounds(808, 632, 85, 21);
		contentPane.add(btn2);
		JButton btn3 = new JButton("Xóa");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ma = Integer.valueOf(textField_25.getText());
				if(m.deleteDocument(ma)) {
					JOptionPane.showMessageDialog(null, "Xóa tài liệu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					data2 = m.DocumentListView(maDA);
					table_2.setModel(data2);
					textField_21.setText("");
					textField_22.setText("");
					textField_23.setText("");
					textField_24.setText("");
					textField_25.setText("");
					btn2.setEnabled(false);
					btn3.setEnabled(false);
					btn1.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa tài liệu thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn3.setEnabled(false);
		btn3.setBounds(808, 659, 85, 21);
		contentPane.add(btn3);
		
		textField_25 = new JTextField();
		textField_25.setEditable(false);
		textField_25.setBounds(39, 713, 96, 19);
		contentPane.add(textField_25);
		textField_25.setColumns(10);
		
		JLabel lblNewLabel_29 = new JLabel("Mã");
		lblNewLabel_29.setBounds(84, 690, 45, 13);
		contentPane.add(lblNewLabel_29);
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ma = Integer.valueOf(textField_25.getText()) ;
				DocumentObject d = new DocumentObject(ma," ", " ", " ", " ", maDA);
				if(!textField_21.getText().isEmpty()) {
					d.setTenTL(textField_21.getText());
				}
				if(!textField_22.getText().isEmpty()) {
					d.setNgayLap(textField_22.getText());
				}
				if(!textField_23.getText().isEmpty()) {
					d.setTrangThai(textField_23.getText());
				}
				if(!textField_24.getText().isEmpty()) {
					d.setMoTa(textField_24.getText());
				}
				
				if(m.updateDocument(d)) {
					JOptionPane.showMessageDialog(null, "Sửa tài liệu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					data2 = m.DocumentListView(maDA);
					table_2.setModel(data2);
					textField_21.setText("");
					textField_22.setText("");
					textField_23.setText("");
					textField_24.setText("");
					textField_25.setText("");
					btn2.setEnabled(false);
					btn3.setEnabled(false);
					btn1.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Sửa tài liệu thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
		
		JButton btn4 = new JButton("Tạo");
		btn4.setEnabled(false);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_9.getText().isEmpty() && textField_10.getText().isEmpty() && textField_12.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập ô nào.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					BudgetObject b = new BudgetObject(0,0,0,0," ",maDA);
					try {
						if(m.findBudget(maDA) == null) { 
							if(textField_9.getText().isEmpty() || Integer.valueOf(textField_9.getText()) < 0) {
								b.setTongSoTien(0);
							} else {
								b.setTongSoTien(Integer.valueOf(textField_9.getText()));
							}
							if(textField_10.getText().isEmpty() || Integer.valueOf(textField_10.getText()) < 0) {
								b.setSoTienDaChi(0);
							} else {
								b.setSoTienDaChi(Integer.valueOf(textField_10.getText()));
							}
							if(b.getTongSoTien() - b.getSoTienDaChi() < 0) {
								JOptionPane.showMessageDialog(null, "Tổng số tiền phải lớn hơn số tiền đã chi.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							} else {
								b.setSoTienConLai(b.getTongSoTien() - b.getSoTienDaChi());
								b.setTrangThai(textField_12.getText());
								if(m.addBudget(b)) {
									JOptionPane.showMessageDialog(null, "Thêm ngân sách thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
									BudgetObject c = m.findBudget(maDA);
									textField_11.setText(String.valueOf(c.getSoTienConLai()));
									textField_8.setText(String.valueOf(c.getMaNganSach()));
									btn4.setEnabled(false);
									btn5.setEnabled(true);
								}else {
									JOptionPane.showMessageDialog(null, "Thêm ngân sách thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Thêm ngân sách thất bại do đã có sẵn.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
						
					} catch(Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lỗi dữ liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				} 
			}
		});
		btn4.setBounds(595, 570, 85, 21);
		contentPane.add(btn4);
		
		JLabel lblNewLabel_30 = new JLabel("Mã");
		lblNewLabel_30.setBounds(46, 466, 50, 13);
		contentPane.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("Tên");
		lblNewLabel_31.setBounds(151, 466, 78, 13);
		contentPane.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("Số lượng");
		lblNewLabel_32.setBounds(267, 466, 45, 13);
		contentPane.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("Trạng thái");
		lblNewLabel_33.setBounds(410, 466, 45, 13);
		contentPane.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("Đơn giá");
		lblNewLabel_34.setBounds(502, 466, 45, 13);
		contentPane.add(lblNewLabel_34);
		
		JLabel lblNewLabel_35 = new JLabel("Ghi chú");
		lblNewLabel_35.setBounds(659, 466, 45, 13);
		contentPane.add(lblNewLabel_35);
		
		textField_26 = new JTextField();
		textField_26.setEditable(false);
		textField_26.setBounds(39, 489, 96, 19);
		contentPane.add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setBounds(150, 489, 96, 19);
		contentPane.add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setBounds(267, 489, 96, 19);
		contentPane.add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setBounds(381, 489, 96, 19);
		contentPane.add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setBounds(487, 489, 96, 19);
		contentPane.add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setBounds(621, 489, 96, 19);
		contentPane.add(textField_31);
		textField_31.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Xem tài nguyên");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_32.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa chọn công việc.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					ProjectView.this.setVisible(false);
					JobDetail j = new JobDetail(m, ql, maDA, Integer.valueOf(textField_32.getText()));
					j.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(1172, 222, 109, 52);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Thêm");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soLuong = 0, donGia = 0;
				String tenTaiNguyen = "",ghiChu = "", trangThai = ""; 
				try {
					if(!textField_28.getText().isEmpty()) {
						soLuong = Integer.valueOf(textField_28.getText());
						if(soLuong < 0) soLuong = 0;
					}
					
					if(!textField_30.getText().isEmpty()) {
						donGia = Integer.valueOf(textField_30.getText());
						if(donGia < 0) donGia = 0;
					}
					if(!textField_27.getText().isEmpty()) tenTaiNguyen = textField_27.getText();
					if(!textField_29.getText().isEmpty()) trangThai = textField_29.getText();
					if(!textField_31.getText().isEmpty()) ghiChu = textField_31.getText();
					
					if(m.addResource(0, tenTaiNguyen, soLuong, trangThai, donGia, ghiChu, maDA)) {
						JOptionPane.showMessageDialog(null, "Thêm tài nguyên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						data1 = m.ResourceListView(maDA);
						table_1.setModel(data1);
						textField_26.setText("");
						textField_27.setText("");
						textField_28.setText("");
						textField_29.setText("");
						textField_30.setText("");
						textField_31.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Thêm tài nguyên thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi dữ liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}	
			}
		});
		btnNewButton_3.setBounds(940, 333, 85, 21);
		contentPane.add(btnNewButton_3);
		JButton btn7 = new JButton("Xóa");
		btn7.setEnabled(false);
		btn7.setBounds(940, 407, 85, 21);
		contentPane.add(btn7);
		JButton btn6 = new JButton("Sửa");
		btn6.setEnabled(false);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soLuong = 0, donGia = 0, maTaiNguyen = 0;
				String tenTaiNguyen = "",ghiChu = "", trangThai = ""; 
				if(textField_26.getText().isEmpty()) {
					try {
						maTaiNguyen = Integer.valueOf(textField_26.getText());
						if(!textField_28.getText().isEmpty()) {
							soLuong = Integer.valueOf(textField_28.getText());
							if(soLuong < 0) soLuong = 0;
						}
						
						if(!textField_30.getText().isEmpty()) {
							donGia = Integer.valueOf(textField_30.getText());
							if(donGia < 0) donGia = 0;
						}
						if(!textField_27.getText().isEmpty()) tenTaiNguyen = textField_27.getText();
						if(!textField_29.getText().isEmpty()) trangThai = textField_29.getText();
						if(!textField_31.getText().isEmpty()) ghiChu = textField_31.getText();
						
						if(m.updateResource(maTaiNguyen, tenTaiNguyen, soLuong, trangThai, donGia, ghiChu, maDA)) {
							JOptionPane.showMessageDialog(null, "Thêm tài nguyên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							data1 = m.ResourceListView(maDA);
							table_1.setModel(data1);
							textField_26.setText("");
							textField_27.setText("");
							textField_28.setText("");
							textField_29.setText("");
							textField_30.setText("");
							textField_31.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Thêm tài nguyên thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
		btn6.setBounds(940, 364, 85, 21);
		contentPane.add(btn6);
		
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_26.getText().isEmpty()) {
						if(m.deleteResource(Integer.valueOf(textField_26.getText()))) {
							JOptionPane.showMessageDialog(null, "Xóa tài nguyên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							data1 = m.ResourceListView(maDA);
							table_1.setModel(data1);
							textField_26.setText("");
							textField_27.setText("");
							textField_28.setText("");
							textField_29.setText("");
							textField_30.setText("");
							textField_31.setText("");
							btn6.setEnabled(false);
							btn7.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(null, "Xóa tài nguyên thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
				} else {
					JOptionPane.showMessageDialog(null, "Chưa chọn tài nguyên.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
		//Hiện các bảng
		if(p.getMaTN() != 0) {
			data = m.JobListView(maDA);
			table.setModel(data);
		}
		
		data1 = m.ResourceListView(maDA);
		table_1.setModel(data1);
		
		data2 = m.DocumentListView(maDA);
		table_2.setModel(data2);
		
		//Begin: table mouse listener
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				data = m.JobListView(maDA);
				int index = table.getSelectedRow();
				textField_32.setText(String.valueOf(data.getValueAt(index, 0)));
				textField_14.setText(String.valueOf(data.getValueAt(index, 1)));
				textField_15.setText(String.valueOf(data.getValueAt(index, 2)));
				textField_16.setText(String.valueOf(data.getValueAt(index, 3)));
				textField_17.setText(String.valueOf(data.getValueAt(index, 4)));
				textField_18.setText(String.valueOf(data.getValueAt(index, 5)));
				textField_19.setText(String.valueOf(data.getValueAt(index, 6)));
				textField_20.setText(String.valueOf(data.getValueAt(index, 7)));
				btn8.setEnabled(true);
				btn9.setEnabled(true);
			}
		});
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				data1 = m.ResourceListView(maDA);
				int index = table_1.getSelectedRow();
				textField_26.setText(String.valueOf(data1.getValueAt(index, 0)));
				textField_27.setText(String.valueOf(data1.getValueAt(index, 1)));
				textField_28.setText(String.valueOf(data1.getValueAt(index, 2)));
				textField_29.setText(String.valueOf(data1.getValueAt(index, 3)));
				textField_30.setText(String.valueOf(data1.getValueAt(index, 4)));
				textField_31.setText(String.valueOf(data1.getValueAt(index, 5)));
				btn6.setEnabled(true);
				btn7.setEnabled(true);
			}
		});
		
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				data2 = m.DocumentListView(maDA);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				
				int index = table_2.getSelectedRow();
				textField_25.setText((String)(data2.getValueAt(index, 0)));
				textField_21.setText((String)(data2.getValueAt(index, 1)));
				textField_22.setText(String.valueOf(data2.getValueAt(index, 2)));
				textField_23.setText((String)(data2.getValueAt(index, 3)));
				textField_24.setText((String)(data2.getValueAt(index, 4)));
			}
		});
		
		
		//End:table listener
		
		//Begin: Hiện thông tin dự án và trưởng nhóm
		
		
		textField.setText(String.valueOf(p.getMaDA()));
		
		JLabel lblNewLabel_36 = new JLabel("Mã");
		lblNewLabel_36.setBounds(39, 222, 45, 13);
		contentPane.add(lblNewLabel_36);
		
		textField_32 = new JTextField();
		textField_32.setEditable(false);
		textField_32.setBounds(26, 254, 96, 19);
		contentPane.add(textField_32);
		textField_32.setColumns(10);
		
		JLabel lblNewLabel_37 = new JLabel("Dùng tài nguyên vào công việc");
		lblNewLabel_37.setBounds(809, 435, 190, 44);
		contentPane.add(lblNewLabel_37);
		
		JButton btnNewButton_1 = new JButton("Dùng");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_26.getText().isEmpty() || textField_32.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Cần chọn công việc và tài nguyên để sử dụng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if(m.addResourceAndJob(Integer.valueOf(textField_26.getText()), Integer.valueOf(textField_32.getText()), "", "", 0, "", 0)) {
						JOptionPane.showMessageDialog(null, "Sử dụng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Dùng thất bại do đã sử dụng tài nguyên này rồi.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNewButton_1.setBounds(831, 488, 85, 21);
		contentPane.add(btnNewButton_1);
		if(p.getTenDA() == null) {
			textField_1.setText(" ");
		} else {
			textField_1.setText(p.getTenDA());
		}
		
		LeaderObject l = m.findLeader(p.getMaTN(), ql.getMaQL());
		
		if(l != null) {
			textField_2.setText(String.valueOf(l.getMaTN()));
			if(l.getTenTN() == null) {
				textField_3.setText(" ");
			} else {
				textField_3.setText(l.getTenTN());
			}
			
			if(l.getNgaySinh() == null) {
				textField_4.setText(" ");
			} else {
				textField_4.setText(l.getNgaySinh());
			}
			if(l.getDiaChi() == null) {
				textField_5.setText(" ");
			} else {
				textField_5.setText(l.getDiaChi());
			}
			if(l.getSoDienThoai() == null) {
				textField_6.setText(" ");
			} else {
				textField_6.setText(l.getSoDienThoai());
			}
			if(l.getEmail() == null) {
				textField_7.setText(" ");
			} else {
				textField_7.setText(l.getEmail());
			}
		}
		//End: Hiện thông tin dự án và trưởng nhóm
		
		
		//Begin: Hiện thông tin ngân sách
		try {
			BudgetObject b = m.findBudget(maDA);
			if(b != null) {
				textField_8.setText(String.valueOf(b.getMaNganSach()));
				textField_9.setText(String.valueOf(b.getTongSoTien()));
				textField_10.setText(String.valueOf(b.getSoTienDaChi()));
				textField_11.setText(String.valueOf(b.getSoTienConLai()));
				if(b.getTrangThai() == null) {
					textField_12.setText("");
				} else {
					textField_12.setText(b.getTrangThai());
				}
			} else {
				textField_8.setText("0");
				btn4.setEnabled(true);
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
