package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBConnection;

//create table employee( id int primary key auto_increment,name varchar(30),age int);
public class EmployeeController {
	
	//loading drive
	//db connection
	
	///statement crration
	///preapre query
	//submit query
	
	
	public void addEmployee() {
		
		//connection
		//DML DDL
		Connection conn = DBConnection.getDBConnection(); //static Method...
		if(conn!=null) {
			
			//statement interface
			try {
				Statement stmt = conn.createStatement(); //3rd statement -->
				String insertSQL = "insert into employee(name,age)value('ram',23)"; //4ths tpe...
				int res = stmt.executeUpdate(insertSQL);
				//stmt.execute(insertSQL) //DML --> false DDL ->true
				//stmt.executeQuery(insertSQL)
				if(res>0) {
					System.out.println(res+" rows inserted..");
				}
				else {
					System.out.println("no record inserted...");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	

	public static void main(String[] args) {
		
		EmployeeController emp = new EmployeeController();
		emp.addEmployee();
		
	}
}
