package SchoolConstructionManagement.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import SchoolConstructionManagement.CreateConnection.*;
import SchoolConstructionManagement.Objects.BudgetObject;
import SchoolConstructionManagement.Objects.DocumentObject;
import SchoolConstructionManagement.Objects.JobObject;
import SchoolConstructionManagement.Objects.LeaderObject;
import SchoolConstructionManagement.Objects.ManagerObject;
import SchoolConstructionManagement.Objects.ProjectObject;
import SchoolConstructionManagement.Objects.ResourceAndJobObject;
import SchoolConstructionManagement.Objects.ResourceObject;


public class Manager {
	private Connection con;
	private ConnectionPool cp;
	
	
	public Manager() {
		this.cp = new ConnectionPoolImpl();
		
		try {
			this.con = this.cp.getConnection("ProductGroup");
			if(this.con.getAutoCommit()) {
				this.con.setAutoCommit(false); // tat o day
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}

	public Connection getCon() {
		// TODO Auto-generated method stub
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	//Manager
	//Project
	//Leader
	//Job
	//Document
	//Budget
	//Resource and job
	//Resource
	
	//Manager
	public int findPass(String sdt, String email, String pass1) {
		String sql = "SELECT * FROM nguoiquanly WHERE soDienThoai = ? AND email = ? AND matKhau = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, sdt);
			pre.setString(2, email);
			pre.setString(3, pass1);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				return rs.getInt("maQL");
			} 
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return 0;
	}
	
	public boolean addManager(ManagerObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO nguoiquanly(");
		sql.append("tenQL, ngaySinh, soDienThoai, email, diaChi, taiKhoan, matKhau)");
		sql.append("VALUE(?,?,?,?,?,?,?)");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			//truyen gia tri
			
			pre.setString(1, item.getTenQL());
			pre.setString(2, item.getNgaySinh());
			pre.setString(3, item.getSoDienThoai());
			pre.setString(4, item.getEmail());
			pre.setString(5, item.getDiaChi());
			pre.setString(6, item.getTaiKhoan());
			pre.setString(7, item.getMatKhau());
			
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updatePass(int maQL, String pass) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE nguoiquanly " +
                "SET matKhau = ? " +
                "WHERE maQL = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			pre.setString(1, pass);
			pre.setInt(2, maQL);
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	public boolean updateManager(ManagerObject item) {
		StringBuilder sql = new StringBuilder();
	
		sql.append("UPDATE nguoiquanly " +
                "SET tenQL = ?, ngaySinh = ?, diaChi = ? " +
                "WHERE maQL = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getTenQL());
			pre.setString(2, item.getNgaySinh());
			pre.setString(3, item.getDiaChi());
			pre.setInt(4, item.getMaQL());
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteManager(int id) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from nguoiquanly " +
                "WHERE maQL = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, id);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public ManagerObject findManager(int maQL) {
		ManagerObject m = new ManagerObject(0, " ", " ", " ");
		String sql = "SELECT * FROM nguoiquanly WHERE maQL = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maQL);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				m.setMaQL(rs.getInt("maQL"));
				m.setTenQL(rs.getString("tenQL"));
				m.setNgaySinh(rs.getString("ngaySinh"));
				m.setDiaChi(rs.getString("diaChi"));
				rs.close();
				return m;
			} 
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	//Project
	public boolean addProject(ProjectObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO duan(");
		sql.append("tenDA, ngayBatDau, ngayKetThuc, tienDo, moTaDA, maQL, maTN)");
		sql.append("VALUE(?,?,?,?,?,?,?)");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			//truyen gia tri
			
			pre.setString(1, item.getTenDA());
			pre.setString(2, item.getNgayBatDau());
			pre.setString(3, item.getNgayKetThuc());
			pre.setString(4, item.getTienDo());
			pre.setString(5, item.getMoTaDA());
			pre.setInt(6, item.getMaQL());
			pre.setInt(7, item.getMaTN());
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	public boolean deleteProject(int id) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from duan " +
                "WHERE maDA = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, id);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	public boolean updateProject(int maDA, String tenDA, String ngayBatDau, String ngayKetThuc, String tienDo, String moTaDA, int maQL,
			int maTN) {
		StringBuilder sql = new StringBuilder();
	
		sql.append("UPDATE duan " +
                "SET tenDA = ?, ngayBatDau = ?, ngayKetThuc = ?, tienDo = ?, moTaDA = ?, maTN = ? " +
                "WHERE maDA = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, tenDA);
			pre.setString(2, ngayBatDau);
			pre.setString(3, ngayKetThuc);
			pre.setString(4, tienDo);
			pre.setString(5, moTaDA);
			pre.setInt(6, maTN);
			pre.setInt(7, maDA);
			
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}	
	
	public ProjectObject findProject(int maDA){
		
		ProjectObject item = new ProjectObject();
		
		String sql = "SELECT * FROM duan ";
		sql += "WHERE maDA = ? ";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			//Truyền tổng số bản ghi cần lấy
			pre.setInt(1, maDA);
			
			//Lấy danh sách bản ghi
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				item.setMaDA(rs.getInt("maDA"));
				item.setTenDA(rs.getString("tenDA"));
				item.setNgayBatDau(rs.getString("ngayBatDau"));
				item.setNgayKetThuc(rs.getString("ngayKetThuc"));
				item.setTienDo(rs.getString("tienDo"));
				item.setMoTaDA(rs.getString("moTaDA"));
				item.setMaQL(rs.getInt("maQL"));
				item.setMaTN(rs.getInt("maTN"));
				
				//Đóng tập kết quả
				rs.close();
				return item;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//Trở về trạng thái an toàn của kết nối
			
		}
		return item;
	}

	public DefaultTableModel ProjectListView(int maQL) {
		DefaultTableModel data = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Đảm bảo rằng JTable không thể chỉnh sửa
            }
        };
		//DefaultTableModel data = new DefaultTableModel();
        data.addColumn("ID");
		data.addColumn("Tên");
		data.addColumn("Ngày bắt đầu");
		data.addColumn("Ngày kết thúc");
		data.addColumn("Tiến độ");
		data.addColumn("Mô tả");
		
		String sql = "SELECT * FROM duan ";
		sql += "WHERE maQL = ? ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyền tổng số bản ghi cần lấy:
			pre.setInt(1, maQL);
			// Lấy danh sách bản ghi:
			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				//Thêm dữ liệu từ ResultSet vào DefaultTableModel:
				while(rs.next()) {
					Vector row = new Vector<>();
					
					row.add(rs.getString("maDA"));
					row.add(rs.getString("tenDA"));
					row.add(rs.getString("ngayBatDau"));
					row.add(rs.getString("ngayKetThuc"));
					row.add(rs.getString("tienDo"));
					row.add(rs.getString("moTaDA"));
			
					data.addRow(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Trở về trạng thái an toàn của kết nối:
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return data;
	}
	
	//Leader
	public boolean addLeader(LeaderObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO truongnhom(");
		sql.append("tenTN, diaChi, ngaySinh, soDienThoai, email, maQL, maTN)");
		sql.append("VALUE(?,?,?,?,?,?,?)");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			//truyen gia tri
			
			pre.setString(1, item.getTenTN());
			pre.setString(2, item.getDiaChi());
			pre.setString(3, item.getNgaySinh());
			pre.setString(4, item.getSoDienThoai());
			pre.setString(5, item.getEmail());
			pre.setInt(6, item.getMaQL());
			pre.setInt(7, item.getMaTN());
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateLeader(LeaderObject item) {
		StringBuilder sql = new StringBuilder();
	
		sql.append("UPDATE truongnhom " +
                "SET tenTN = ?, ngaySinh = ?, diaChi = ?, soDienThoai = ?, email = ? " +
                "WHERE maTN = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getTenTN());
			pre.setString(2, item.getNgaySinh());
			pre.setString(3, item.getDiaChi());
			pre.setString(4, item.getSoDienThoai());
			pre.setString(5, item.getEmail());
			pre.setInt(6, item.getMaTN());
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	public DefaultTableModel LeaderListView(int maQL) {
		DefaultTableModel data = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Đảm bảo rằng JTable không thể chỉnh sửa
            }
        };
		//DefaultTableModel data = new DefaultTableModel();
        data.addColumn("ID");
		data.addColumn("Tên");
		data.addColumn("Ngày sinh");
		data.addColumn("Địa chỉ");
		data.addColumn("Số điện thoại");
		data.addColumn("Email");
		
		String sql = "SELECT * FROM truongnhom ";
		sql += "WHERE maQL = ? ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyền tổng số bản ghi cần lấy:
			pre.setInt(1, maQL);
			// Lấy danh sách bản ghi:
			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				//Thêm dữ liệu từ ResultSet vào DefaultTableModel:
				while(rs.next()) {
					Vector row = new Vector<>();
					
					row.add(rs.getString("maTN"));
					row.add(rs.getString("tenTN"));
					row.add(rs.getString("ngaySinh"));
					row.add(rs.getString("diaChi"));
					row.add(rs.getString("soDienThoai"));
					row.add(rs.getString("email"));
			
					data.addRow(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Trở về trạng thái an toàn của kết nối:
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return data;
	}
	public LeaderObject findLeader(int maTN, int maQL) {
		LeaderObject m = new LeaderObject(0, " ", " ", " ", " ", " ", 0);
		String sql = "SELECT * FROM truongnhom WHERE maTN = ? AND maQL = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maTN);
			pre.setInt(2, maQL);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				m.setMaTN(rs.getInt("maTN"));
				m.setTenTN(rs.getString("tenTN"));
				m.setNgaySinh(rs.getString("ngaySinh"));
				m.setDiaChi(rs.getString("diaChi"));
				m.setSoDienThoai(rs.getString("soDienThoai"));
				m.setEmail(rs.getString("email"));
				m.setMaQL(rs.getInt("maQL"));
				rs.close();
				return m;
			} else {
				rs.close();
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean deleteLeader(int id) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from truongnhom " +
                "WHERE maTN = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, id);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	//Job
	public boolean deleteJob(int id) {
		if(this.findRJ(id)) {
			if(!this.deleteResourceAndJobCV(id)) return false;
		}
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from congviec " +
                "WHERE maCV = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, id);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	public boolean addJob(int maCV, String tenCV, String moTaCV, String ngayBatDau, String ngayKetThuc, String trangThai,
			String tienDoCV, int luongNhanCong, int maDA, int maTN) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO congviec(");
		sql.append("tenCV, moTaCV, ngayBatDau, ngayKetThuc, trangThai, tienDoCV, luongNhanCong, maDA, maTN)");
		sql.append("VALUE(?,?,?,?,?,?,?,?,?)");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			//truyen gia tri
			
			pre.setString(1, tenCV);
			pre.setString(2, moTaCV);
			pre.setString(3, ngayBatDau);
			pre.setString(4, ngayKetThuc);
			pre.setString(5, trangThai);
			pre.setString(6, tienDoCV);
			pre.setInt(7, luongNhanCong);
			pre.setInt(8, maDA);
			pre.setInt(9, maTN);
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateJobMaTN(int maDA, int maTNcu, int maTNmoi) {
		
		String sql1 = "SELECT maCV FROM congviec WHERE maDA = ? AND maTN = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql1);
			
			pre.setInt(1, maDA);
			pre.setInt(2, maTNcu);
			
			ResultSet rs = pre.executeQuery();
			
				while(rs.next()) {
					StringBuilder sql = new StringBuilder();
					
					sql.append("UPDATE congviec " +
			                "SET maTN = ? " +
			                "WHERE maCV = ?");
					
					//biên dịch
					try {
						PreparedStatement pre1 = this.con.prepareStatement(sql.toString());
						
						pre1.setInt(1, maTNmoi);
						pre1.setInt(2, rs.getInt("maCV"));
						
						
						
						int result = pre1.executeUpdate(); //thực thi
						if(result == 0) {
							this.con.rollback();
							return false;
						}
						
						//xác nhận thực thi sau cùng
						this.con.commit();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						try {
							this.con.rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				
			}
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}
	public boolean updateJob(int maCV, String tenCV, String moTaCV, String ngayBatDau, String ngayKetThuc, String trangThai,
			String tienDoCV, int luongNhanCong, int maDA, int maTN) {
		StringBuilder sql = new StringBuilder();
	
		sql.append("UPDATE congviec " +
                "SET tenCV = ?, moTaCV = ?, ngayBatDau = ?, ngayKetThuc = ?, trangThai = ?, tienDoCV = ?, luongNhanCong = ?, maTN = ? " +
                "WHERE maCV = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			pre.setString(1, tenCV);
			pre.setString(2, moTaCV);
			pre.setString(3, ngayBatDau);
			pre.setString(4, ngayKetThuc);
			pre.setString(5, trangThai);
			pre.setString(6, tienDoCV);
			pre.setInt(7, luongNhanCong);
			pre.setInt(8, maTN);
			pre.setInt(9, maCV);
			
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public DefaultTableModel JobListView(int maDA) {
		DefaultTableModel data = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Đảm bảo rằng JTable không thể chỉnh sửa
	        }
	    };
		//DefaultTableModel data = new DefaultTableModel();
	    data.addColumn("ID");
		data.addColumn("Tên");
		data.addColumn("Mô tả");
		data.addColumn("Ngày bắt đầu");
		data.addColumn("Ngày kết thúc");
		data.addColumn("Trạng thái");
		data.addColumn("Tiến độ");
		data.addColumn("Lương nhân công");
		
		String sql = "SELECT * FROM congviec ";
		sql += "WHERE maDA = ? ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyền tổng số bản ghi cần lấy:
			pre.setInt(1, maDA);
			// Lấy danh sách bản ghi:
			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				//Thêm dữ liệu từ ResultSet vào DefaultTableModel:
				while(rs.next()) {
					Vector row = new Vector<>();
					
					row.add(rs.getString("maCV"));
					row.add(rs.getString("tenCV"));
					row.add(rs.getString("moTaCV"));
					row.add(rs.getString("ngayBatDau"));
					row.add(rs.getString("ngayKetThuc"));
					row.add(rs.getString("trangThai"));
					row.add(rs.getString("tienDoCV"));
					row.add(rs.getString("luongNhanCong"));
			
					data.addRow(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Trở về trạng thái an toàn của kết nối:
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return data;
	}
	
	public boolean findJobAll(int maDA) {
		String sql = "SELECT * FROM congviec WHERE maDA = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maDA);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				rs.close();
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public JobObject findJob(int maCV) {
		JobObject m = new JobObject();
		String sql = "SELECT * FROM congviec WHERE maCV = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maCV);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				m.setMaCV(rs.getInt("maCV"));
				m.setTenCV(rs.getString("tenCV"));
				m.setMoTaCV(rs.getString("moTaCV"));
				m.setNgayBatDau(rs.getString("ngayBatDau"));
				m.setNgayKetThuc(rs.getString("ngayKetThuc"));
				m.setTrangThai(rs.getString("trangThai"));
				m.setTienDoCV(rs.getString("tienDoCV"));
				m.setLuongNhanCong(rs.getInt("luongNhanCong"));
				m.setMaDA(rs.getInt("maDA"));
				m.setMaTN(rs.getInt("maTN"));
				rs.close();
				return m;
			} 
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	public int findJobMaTN(int maCV) {
		JobObject m = new JobObject();
		String sql = "SELECT * FROM congviec WHERE maCV = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maCV);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				m.setMaTN(rs.getInt("maTN"));
				rs.close();
				return m.getMaTN();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return 0;
	}
	
	public boolean deleteJobAll(int maDA) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from congviec WHERE maDA = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, maDA);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	// Document
	public boolean addDocument(DocumentObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tailieu(");
		sql.append("tenTL, ngayLap, trangThai, moTa, maDA)");
		sql.append("VALUE(?,?,?,?,?)");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			//truyen gia tri
			
			pre.setString(1, item.getTenTL());
			pre.setString(2, item.getNgayLap());
			pre.setString(3, item.getTrangThai());
			pre.setString(4, item.getMoTa());
			pre.setInt(5, item.getMaDA());
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateDocument(DocumentObject item) {
		StringBuilder sql = new StringBuilder();
	
		sql.append("UPDATE tailieu " +
                "SET tenTL = ?, ngayLap = ?, trangThai = ?, moTa = ?" +
                "WHERE maTL = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			pre.setString(1, item.getTenTL());
			pre.setString(2, item.getNgayLap());
			pre.setString(3, item.getTrangThai());
			pre.setString(4, item.getMoTa());
			pre.setInt(5, item.getMaTL());
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteDocument(int id) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from tailieu " +
                "WHERE maTL = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, id);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public DefaultTableModel DocumentListView(int maDA) {
		DefaultTableModel data = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Đảm bảo rằng JTable không thể chỉnh sửa
            }
        };
		//DefaultTableModel data = new DefaultTableModel();
        data.addColumn("ID");
		data.addColumn("Tên");
		data.addColumn("Ngày lập");
		data.addColumn("Trạng thái");
		data.addColumn("Mô tả");
		
		String sql = "SELECT * FROM tailieu ";
		sql += "WHERE maDA = ? ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyền tổng số bản ghi cần lấy:
			pre.setInt(1, maDA);
			// Lấy danh sách bản ghi:
			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				//Thêm dữ liệu từ ResultSet vào DefaultTableModel:
				while(rs.next()) {
					Vector row = new Vector<>();
					
					row.add(rs.getString("maTL"));
					row.add(rs.getString("tenTL"));
					row.add(rs.getString("ngayLap"));
					row.add(rs.getString("trangThai"));
					row.add(rs.getString("moTa"));
			
					data.addRow(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Trở về trạng thái an toàn của kết nối:
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return data;
	}

	public boolean findDocument(int maDA) {
		
		String sql = "SELECT * FROM tailieu WHERE maDA = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maDA);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				rs.close();
				return true;
			} 
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteDocumentAll(int maDA) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from tailieu WHERE maDA = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, maDA);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	//Budget
	public boolean addBudget(BudgetObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ngansach(");
		sql.append("tongSoTien, soTienDaChi, soTienConLai, trangThai, maDA)");
		sql.append("VALUE(?,?,?,?,?)");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			//truyen gia tri
			
			pre.setInt(1, item.getTongSoTien());
			pre.setInt(2, item.getSoTienDaChi());
			pre.setInt(3, item.getTongSoTien() - item.getSoTienDaChi());
			pre.setString(4, item.getTrangThai());
			pre.setInt(5, item.getMaDA());
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateBudget(BudgetObject item) {
		StringBuilder sql = new StringBuilder();
	
		sql.append("UPDATE nganSach " +
                "SET tongSoTien = ?, soTienDaChi = ?, soTienConLai = ?, trangThai = ?" +
                " WHERE maNganSach = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			pre.setInt(1, item.getTongSoTien());
			pre.setInt(2, item.getSoTienDaChi());
			pre.setInt(3, item.getTongSoTien() - item.getSoTienDaChi());
			pre.setString(4, item.getTrangThai());
			pre.setInt(5, item.getMaNganSach());
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public BudgetObject findBudget(int maDA) {
		BudgetObject m = new BudgetObject(0, 0, 0, 0, " ", maDA);
		String sql = "SELECT * FROM ngansach WHERE maDA = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maDA);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				m.setMaNganSach(rs.getInt("maNganSach"));
				m.setTongSoTien(rs.getInt("tongSoTien"));
				m.setSoTienDaChi(rs.getInt("soTienDaChi"));
				m.setSoTienConLai(rs.getInt("soTienConLai"));
				m.setTrangThai(rs.getString("trangThai"));
				rs.close();
				return m;
			} else {
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	public boolean deleteBudget(int id) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from ngansach " +
                "WHERE maDA = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, id);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	// resource and job
	public boolean findResourceAndJob(int maDA) {
		String sql = "SELECT * FROM tainguyen_congviec WHERE maTN = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maDA);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				rs.close();
				return true;
			} else {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean addResourceAndJob(int maTaiNguyen, int maCV, String loaiTN, String moTa, int chiPhiTN,
			String ngayThanhToan, int tongChiPhi) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tainguyen_congviec(");
		sql.append("maTaiNguyen, maCV, loaiTN, moTa, chiPhiTN, ngayThanhToan, tongChiPhi)");
		sql.append("VALUE(?,?,?,?,?,?,?)");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			//truyen gia tri
			
			pre.setInt(1, maTaiNguyen);
			pre.setInt(2, maCV);
			pre.setString(3, loaiTN);
			pre.setString(4, moTa);
			pre.setInt(5, chiPhiTN);
			pre.setString(6, ngayThanhToan);
			pre.setInt(7, tongChiPhi);
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateResourceAndJob(int maTaiNguyen, int maCV, String loaiTN, String moTa, int chiPhiTN,
			String ngayThanhToan, int tongChiPhi) {
		StringBuilder sql = new StringBuilder();
	
		sql.append("UPDATE tainguyen_congviec " +
                "SET loaiTN = ?, moTa = ?, chiPhiTN = ?, ngayThanhToan = ?, tongChiPhi = ? " +
                "WHERE maTaiNguyen = ? AND maCV = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			pre.setString(1, loaiTN);
			pre.setString(2, moTa);
			pre.setInt(3, chiPhiTN);
			pre.setString(4, ngayThanhToan);
			pre.setInt(5, tongChiPhi);
			pre.setInt(6, maTaiNguyen);
			pre.setInt(7, maCV);
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteResourceAndJobCV(int idCV) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from tainguyen_congviec " +
                "WHERE maCV = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, idCV);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteResourceAndJobMaTN(int idCV) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from tainguyen_congviec " +
                "WHERE maTaiNguyen = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, idCV);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteResourceAndJobTNCV(int idCV, int idTN) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from tainguyen_congviec " +
                "WHERE maTaiNguyen = ? AND maCV = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, idTN);
			pre.setInt(2, idCV);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	public DefaultTableModel RJListView(int maCV) {
		DefaultTableModel data = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Đảm bảo rằng JTable không thể chỉnh sửa
            }
        };
		//DefaultTableModel data = new DefaultTableModel();
        data.addColumn("Mã tài nguyên");
		data.addColumn("Loại tài nguyên");
		data.addColumn("Mô tả");
		data.addColumn("Chi phí");
		data.addColumn("Ngày thanh toán");
		data.addColumn("Tổng chi phí");
		
		String sql = "SELECT * FROM tainguyen_congviec ";
		sql += "WHERE maCV = ? ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyền tổng số bản ghi cần lấy:
			pre.setInt(1, maCV);
			// Lấy danh sách bản ghi:
			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				//Thêm dữ liệu từ ResultSet vào DefaultTableModel:
				while(rs.next()) {
					Vector row = new Vector<>();
					
					row.add(rs.getInt("maTaiNguyen"));
					row.add(rs.getString("loaiTN"));
					row.add(rs.getString("moTa"));
					row.add(rs.getInt("chiPhiTN"));
					row.add(rs.getString("ngayThanhToan"));
					row.add(rs.getInt("tongChiPhi"));
			
					data.addRow(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Trở về trạng thái an toàn của kết nối:
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return data;
	}
	
	public boolean findRJ(int maCV) {
		String sql = "SELECT * FROM tainguyen_congviec WHERE maCV = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maCV);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				rs.close();
				return true;
			} 
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	public boolean findRJTN(int maTN) {
		String sql = "SELECT * FROM tainguyen_congviec WHERE maTN = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maTN);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				rs.close();
				return true;
			} 
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteRJ(int maDA) {
		
		String sql1 = "SELECT maCV FROM congviec WHERE maDA = ?";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql1);
			
			//truyen gia tri
			pre.setInt(1, maDA);
			
			ResultSet rs= pre.executeQuery(); //thực thi
			
			while(rs.next()) {
				String sq = "DELETE tainguyen_congviec WHERE maCV = ?";
				try {
					PreparedStatement pre1 = this.con.prepareStatement(sq);
					
					//truyen gia tri
					pre1.setInt(1, rs.getInt("maCV"));
					
					int rs1 = pre1.executeUpdate(); //thực thi
					if(rs1 == 0) {
						this.con.rollback();
						return false;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					try {
						this.con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//xác nhận thực thi sau cùng
			
			return false;
		}
	}
	//Resource
	public boolean addResource(int maTaiNguyen, String tenTaiNguyen, int soLuong, String trangThai, int donGia,
			String ghiChu, int maDA) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tainguyen(");
		sql.append("tenTaiNguyen, soLuong, trangThai, donGia, ghiChu, maDA)");
		sql.append("VALUE(?,?,?,?,?,?)");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			//truyen gia tri
			
			pre.setString(1, tenTaiNguyen);
			pre.setInt(2, soLuong);
			pre.setString(3, trangThai);
			pre.setInt(4, donGia);
			pre.setString(5, ghiChu);
			pre.setInt(6, maDA);
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateResource(int maTaiNguyen, String tenTaiNguyen, int soLuong, String trangThai, int donGia,
			String ghiChu, int maDA) {
		StringBuilder sql = new StringBuilder();
	
		sql.append("UPDATE tainguyen " +
                "SET tenTaiNguyen = ?, soLuong = ?, trangThai = ?, donGia = ?, ghiChu = ? " +
                "WHERE maTaiNguyen = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			pre.setString(1, tenTaiNguyen);
			pre.setInt(2,soLuong);
			pre.setString(3, trangThai);
			pre.setInt(4, donGia);
			pre.setString(5, ghiChu);
			pre.setInt(6, maTaiNguyen);
			
			int result = pre.executeUpdate(); //thực thi
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteResource(int id) {
		if(this.findResourceAndJob(id)) {
			this.deleteResourceAndJobMaTN(id);
		}
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from tainguyen " +
                "WHERE maTaiNguyen = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, id);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public DefaultTableModel ResourceListView(int maDA) {
		DefaultTableModel data = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Đảm bảo rằng JTable không thể chỉnh sửa
            }
        };
		//DefaultTableModel data = new DefaultTableModel();
        data.addColumn("ID");
		data.addColumn("Tên");
		data.addColumn("Số lượng");
		data.addColumn("Trạng thái");
		data.addColumn("Đơn giá");
		data.addColumn("Ghi chú");
		
		String sql = "SELECT * FROM tainguyen ";
		sql += "WHERE maDA = ? ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyền tổng số bản ghi cần lấy:
			pre.setInt(1, maDA);
			// Lấy danh sách bản ghi:
			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				//Thêm dữ liệu từ ResultSet vào DefaultTableModel:
				while(rs.next()) {
					Vector row = new Vector<>();
					
					row.add(rs.getInt("maTaiNguyen"));
					row.add(rs.getString("tenTaiNguyen"));
					row.add(rs.getInt("soLuong"));
					row.add(rs.getString("trangThai"));
					row.add(rs.getInt("donGia"));
					row.add(rs.getString("ghiChu"));
			
					data.addRow(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Trở về trạng thái an toàn của kết nối:
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return data;
	}
	
	public boolean findResource(int maTN) {
		String sql = "SELECT * FROM tainguyen WHERE maTaiNguyen = ?";
		try {
			//nap cau lenh
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, maTN);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				rs.close();
				return true;
			} 
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteResourceAll(int maDA) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from tainguyen where maDA = ?");
		
		//biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			//truyen gia tri
			pre.setInt(1, maDA);
			
			int result = pre.executeUpdate(); //thực thi
			
			if(result == 0) {
				this.con.rollback();
				return false;
			}
			
			//xác nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	
}
