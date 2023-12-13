package SchoolConstructionManagement.CreateConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPoolImpl implements ConnectionPool {

	private String driver;
	
	//Đường dẫn thực thi của MySQL:
	private String url;
	
	//Tài khoản làm việc:
	private String username;
	private String userpass;
	
	//Đối tương lưu trữ các kết nối:
	private Stack<Connection> pool; // luu dia chi ket noi bo nho
	
	public ConnectionPoolImpl() {
		//Xác định trình điều khiển:
		this.driver = "com.mysql.cj.jdbc.Driver"; // bản mysql 8. cần .cj.
		
		//Nạp trình điều khiển:
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Xác định đường dẫn thực thi:
		this.url = "jdbc:mysql://localhost:3306/TTCSN";
		
		//Xác định tài khoản làm việc:
		this.username = "root";
		this.userpass = "123456";
		
		//Khởi tạo bộ nhớ cho đối tượng lưu trữ:
		this.pool = new Stack<Connection>();
		
	}
	@Override
	public Connection getConnection(String objectName) throws SQLException {
		// TODO Auto-generated method stub
		
		if(this.pool.isEmpty()) {
			System.out.println(objectName+" have created a new Connection!");
			return DriverManager.getConnection(this.url, this.username, this.userpass);
		}else {
			System.out.println(objectName+" have popped the Connection!");
			return this.pool.pop();
		}
		
	}

	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(objectName+" have pushed the Connection!");
		this.pool.push(con);
	}
	
	protected void finalize() throws Throwable{
		//Loại bỏ các kết nối trong pool:
		this.pool.clear();
		this.pool = null;
		
		System.out.println("ConnectionPool is closed");
	}
}
