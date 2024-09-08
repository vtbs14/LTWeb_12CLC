package week2.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {

	private final String serverName = "localhost";
	private final String dbName = "QuanLy";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "root";

	// Kết nối SQL Server với Windows Authentication
	public Connection getConnectionW() throws Exception {
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;

			if (instance == null || instance.trim().isEmpty())
				url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName="+ dbName;
			conn = DriverManager.getConnection(url, userID, password);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Drive name: " + dm.getDriverName());
				System.out.println("Drive version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());

				return conn;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnectionW());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
