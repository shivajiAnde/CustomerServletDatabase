package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/teju")
public class Forms extends HttpServlet{
	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String user=req.getParameter("name");
	  int age=Integer.parseInt(req.getParameter("age"));
	  System.out.println(user);
	  System.out.println(age);
	}
	 

}
