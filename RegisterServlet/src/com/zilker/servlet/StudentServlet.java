package com.zilker.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.bean.Student;
import com.zilker.delegate.StudentDelegate;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Student> studentList = new ArrayList<>();
		try {
			StudentDelegate studentDelegate = new StudentDelegate();
			studentList = studentDelegate.displayStudent();
			request.setAttribute("stud",studentList);
			getServletConfig().getServletContext().getRequestDispatcher("/pages/display.jsp").forward(request,response);
		}catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			
			String name = request.getParameter("userName");
			String pass = request.getParameter("userPass");
			String email = request.getParameter("userEmail");
			String country = request.getParameter("userCountry");
			
			Student student = new Student();
			student.setName(name);
			student.setEmail(email);
			student.setPass(pass);
			student.setCountry(country);
			
			StudentDelegate studentDelegate = new StudentDelegate();
			if(studentDelegate.insertStudent(student))
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("/pages/display.jsp");
				rd.forward(request, response);
				
			}
			
			
		}catch(Exception e) {
			
		}
	}

}
