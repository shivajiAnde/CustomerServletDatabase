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

//url mapping done in webapp
public class SaveCustomer extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String contactNo=req.getParameter("contactNo");
		String email=req.getParameter("email");
		Customer customer=new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setContactNo(contactNo);
		customer.setEmail(email);
		
		CustomerDAO dao=new CustomerDAO();
		PrintWriter writer=res.getWriter();
		writer.println(dao.save(customer));
	}

}
