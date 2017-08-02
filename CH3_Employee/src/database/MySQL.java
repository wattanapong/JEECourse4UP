package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	private Statement st;
	public ResultSet rs;
	private String host = "localhost";
	private String db = "jspuser";
	private String user = "jspuser";
	private String pass = "jsp2017";
	public MySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String strCon = "jdbc:mysql://" + host + "/" + db;
			Connection conn = DriverManager.getConnection(strCon, user, pass);
			st = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean Authenticate( String user, String pass) {
		
		try {
			st.executeQuery("SELECT * FROM user WHERE username = '"+ user +"'");
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				if (rs.getString("password").equals(pass)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
