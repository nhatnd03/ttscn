package SchoolConstructionManagement.CreateConnection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
	//Phương thức xin kết nối:
	public Connection getConnection(String objectName) throws SQLException;
	
	//Phương thức yêu cầu cầu trả về kết nối:
	public void releaseConnection(Connection con, String objectName) throws SQLException;
}
