package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zilker.DButils.DBUtils;
import com.zilker.bean.Student;
import com.zilker.constant.QueryConstant;

public class StudentDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int insertStudent(Student student) {
		
		int i = 0;
		try {
			
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(QueryConstant.INSERT_REGISTER);

			ps.setString(1, student.getName());
			ps.setString(2, student.getPass());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getCountry());

			i = ps.executeUpdate(); 
			
			
			
		}catch(Exception e) {
			
		}finally {
			
			DBUtils.closeConnectionStatement(conn,ps);
		}
		return i;
	}
	public ArrayList<Student> displayStudent()
	{
		ArrayList<Student> studentList = new ArrayList<>();
		try {
			
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM REGISTERUSER");
			rs = ps.executeQuery();
			while(rs.next())
			{
				Student student = new Student();
				student.setName(rs.getString(1));
				student.setPass(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setCountry(rs.getString(4));
				studentList.add(student);
			}
			
		}catch(Exception e)
		{
			
		}finally {
			
			DBUtils.closeConnection(conn,ps,rs);
		}
		return studentList;
	}

}
