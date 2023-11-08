package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ogin")
public class SaveCustomerHttps extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");
		System.out.println(user);
		System.out.println(pass);
		PrintWriter out=resp.getWriter();
		out.println(user);
		out.println(pass);
		
	}
}
