package com.jewlleryShop;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbInfo{
	public Connection getDBConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshop","sanjay","");
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
		
	}
}