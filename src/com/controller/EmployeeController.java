package com.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

//create table employee( id int primary key auto_increment,name varchar(30),age int);
public class EmployeeController {

	// loading drive
	// db connection

	/// statement crration
	/// preapre query
	// submit query

	public void addEmployee() {

		// connection
		// DML DDL
		Connection conn = DBConnection.getDBConnection(); // static Method...
		if (conn != null) {

			// statement interface
			try {
				Statement stmt = conn.createStatement(); // 3rd statement -->
				String insertSQL = "insert into employee(name,age)value('ram',23)"; // 4ths tpe...
				int res = stmt.executeUpdate(insertSQL);
				// stmt.execute(insertSQL) //DML --> false DDL ->true
				// stmt.executeQuery(insertSQL)
				if (res > 0) {
					System.out.println(res + " rows inserted..");
				} else {
					System.out.println("no record inserted...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	
	public void addEmployee1() {

		// connection
		// DML DDL
		Connection conn = DBConnection.getDBConnection(); // static Method...
		Scanner sc = new Scanner(System.in);
		if (conn != null) {

			// statement interface
			try {
				Statement stmt = conn.createStatement(); // 3rd statement -->
				System.out.println("enter name");
				String name = sc.next();
				System.out.println("enter age");
				int age = sc.nextInt();
				
				String insertSQL = "insert into employee(name,age)value('"+name+"',"+age+")"; // 4ths tpe...
				int res = stmt.executeUpdate(insertSQL);
				// stmt.execute(insertSQL) //DML --> false DDL ->true
				// stmt.executeQuery(insertSQL)
				if (res > 0) {
					System.out.println(res + " rows inserted..");
				} else {
					System.out.println("no record inserted...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void deleteEMployee() {
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			int id=1;
			try {
				Statement stmt= conn.createStatement();
				String DELETESQL = "delete from employee where id ="+id+"";
				int res = stmt.executeUpdate(DELETESQL);
				if(res>0) {
					System.out.println("reccord deleted.."+res);
				}
				else {
					System.out.println("record not deleted...");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public void getALlData() {
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			try {
				Statement stmt = conn.createStatement();
				String SELECTSQL= "select * from employee";
				ResultSet rs= stmt.executeQuery(SELECTSQL);
				while(rs.next()) {
					
					System.out.print(rs.getInt("id"));
					System.out.print("\t"+rs.getString("name"));
					System.out.print("\t"+rs.getInt("age"));
					System.out.println();
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	


	public static void main(String[] args) {

		EmployeeController emp = new EmployeeController();
		//emp.addEmployee1();
		//emp.deleteEMployee();
		emp.getALlData();

	}
}
