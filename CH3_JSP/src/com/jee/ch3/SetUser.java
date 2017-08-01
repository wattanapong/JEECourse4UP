package com.jee.ch3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SetUser {
	private ArrayList<User> userList = new ArrayList<User>();
		public SetUser(){

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jspuser", "jspuser", "jsp2017");
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM user LIMIT 0,1000");
				while(rs.next()){
					User user = new User();
					user.setId( Integer.parseInt( rs.getString("id")) );
					user.setFirst_name(rs.getString("fname"));
					user.setLast_name(rs.getString("lname"));
					user.setCode(Integer.parseInt(rs.getString("code")));
					user.setMajor(rs.getString("major"));
					userList.add(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	public ArrayList<User> getUsers(){
		return userList;
	}
		
}
