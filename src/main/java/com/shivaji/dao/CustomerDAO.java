package com.shivaji.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

import com.shivaji.dto.Customer;

public class CustomerDAO {
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/user_data";
			String user="root";
			String password="root";
			Connection connection=DriverManager.getConnection(url,user,password);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String save(Customer customer) {
		try {
			Connection connection=getConnection();
			String query="INSERT INTO customer(name,address,contactNo,email)"+" VALUES(?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,customer.getName());
			ps.setString(2,customer.getAddress());
			ps.setString(3,customer.getContactNo());
			ps.setString(4,customer.getEmail());
			int res=ps.executeUpdate();
			connection.close();
			return "no of rows added = "+res;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "something went wrong";
	}
	public Customer getDataById(int id) {
		try {
			Customer customer=new Customer();
			Connection connection=getConnection();
			String query="SELECT * FROM customer WHERE id=?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				customer.setId(res.getInt(1));
				customer.setName(res.getString(2));
				customer.setAddress(res.getString(3));
				customer.setContactNo(res.getString(4));
				customer.setEmail(res.getString(5));
			}
			connection.close();
			return customer;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
