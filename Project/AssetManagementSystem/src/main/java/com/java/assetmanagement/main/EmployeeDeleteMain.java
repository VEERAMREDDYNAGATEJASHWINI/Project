package com.java.assetmanagement.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.assetmanagement.dao.EmployeesDao;
import com.java.assetmanagement.dao.EmployeesDaoImpl;

public class EmployeeDeleteMain {


public static void main(String[] args) {
		
		int employee_id;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter employee no : ");
			employee_id=sc.nextInt();
		}
		EmployeesDao dao =new EmployeesDaoImpl();
		try {
			System.out.println(dao.deleteEmployeeDao(employee_id));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
