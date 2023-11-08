package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shivaji.dao.CustomerDAO;
import com.shivaji.dto.Customer;

@WebServlet("/custom")
public class ServletClassDopost extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		PrintWriter writer=resp.getWriter();
		writer.println(dao.save(customer));
	}

}
