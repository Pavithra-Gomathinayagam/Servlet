package com.zilker.delegate;

import java.util.ArrayList;

import com.zilker.bean.Student;
import com.zilker.dao.StudentDAO;

public class StudentDelegate {

	public boolean insertStudent(Student student)
	{
		boolean check = false;
		try {
			
			StudentDAO studentDao = new StudentDAO();
			int i = studentDao.insertStudent(student);
			
			
			if(i>0)
				check = true;
			else
				check = false;
			
		}catch(Exception e)
		{
			
		}
		return check;
		
	}
	public ArrayList<Student> displayStudent()
	{
		ArrayList<Student> studentList = new ArrayList<>();
		try {
			
			StudentDAO studentDao = new StudentDAO();
			studentList = studentDao.displayStudent();
			
		}catch(Exception e)
		{
			
		}
		return studentList;
	}
}
