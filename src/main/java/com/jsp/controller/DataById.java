package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.shivaji.dao.CustomerDAO;
import com.shivaji.dto.Customer;

public class DataById extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		CustomerDAO dao=new CustomerDAO();
		Customer customer=dao.getDataById(id);
		PrintWriter out=res.getWriter();
		out.println(customer);	
	}
}
