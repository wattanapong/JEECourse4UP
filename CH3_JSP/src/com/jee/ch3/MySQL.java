package com.jee.ch3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	private Statement st;
	public ResultSet rs;
	private Boolean connect(String host, String db, String user, String pass) {
		Boolean connected = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String strCon = "jdbc:mysql://" + host + "/" + db;
			Connection conn = DriverManager.getConnection(strCon, user, pass);
			st = conn.createStatement();
			connected = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connected;
	}

	public Boolean connect(String host, String port, String db, String user, String pass) {

		host = host +(port == "" ? "" : ":"+port);
		Boolean connected = connect(host, db, user, pass);

		return connected;
	}
	
	public void Query(String query){
		
		try {
			this.rs = this.st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
