package com.zilker.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String e = request.getParameter("userEmail");
		String p = request.getParameter("userPass");


		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SERVLET", "root", "password");
			PreparedStatement ps = conn.prepareStatement("SELECT NAME,PASS,EMAIL FROM REGISTERUSER");
			ResultSet rs = ps.executeQuery();
			String name;
			int flag = 0;
			while(rs.next())
			{
				if((rs.getString(3).equalsIgnoreCase(e))&&(rs.getString(2).equalsIgnoreCase(p)))
				{
					System.out.println(rs.getString(3)+""+rs.getString(2));
					name = rs.getString(1);
			        session.setAttribute("uname",name); 
					response.sendRedirect("ProfileServlet");
					flag = 1;
				}
			}
			if(flag != 1)
			{
				System.out.println("Login invalid");
				response.sendRedirect("login.html");
			}
				

		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}
