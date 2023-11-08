package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Display extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String country=req.getParameter("country");
		String skills=req.getParameter("skills");
		String exp=req.getParameter("exp");
		
		PrintWriter out= res.getWriter();
		out.println(name);
		out.println(country);
		out.println(exp);
		out.println(skills);
	}
}
