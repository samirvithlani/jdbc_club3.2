package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnection;

//create table student(sid int primary key auto_increment,name varchar(30),marks int);
public class StudentController {
	
	//statment --> query everytime compile
	//prepared statement --> query 1 time compile
	
	public void addStudent() {
		
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			//? place holder..
			String insertSQL = "insert into student(name,marks)value(?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				String name = "ajay";
				int marks = 88;
				pstmt.setString(1, name);
				pstmt.setInt(2, marks);
				
				int res = pstmt.executeUpdate();
				if(res>0) {
					System.out.println("Student inserted...");
				}
				else {
					System.out.println("student not inserted...");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
		
	}
	
	
	public void updateStudent() {
		
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			String updateSQL = "update student set name=?, marks =? where sid =?";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, "JAY");
				pstmt.setInt(2, 91);
				pstmt.setInt(3, 1);
				
				
				int res = pstmt.executeUpdate();
				if(res>0) {
					System.out.println("student updated...");
				}
				else {
					System.out.println("student not updated..");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}
		
		
		
	}

	public static void main(String[] args) {
		
		StudentController studentController = new StudentController();
		studentController.addStudent();
		//studentController.updateStudent();
				
	}
}
