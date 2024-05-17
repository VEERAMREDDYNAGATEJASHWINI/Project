package com.java.assetmanagement.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.assetmanagement.dao.EmployeesDao;
import com.java.assetmanagement.dao.EmployeesDaoImpl;
import com.java.assetmanagement.model.Employees;

public class EmployeesInsertMain {
	public static void main(String[] args) {
		Employees employee = new Employees();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Employee Id ");
			employee.setEmployee_Id(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter name ");
			employee.setName(sc.nextLine());
			System.out.println("Enter department ");
			employee.setDepartment(sc.nextLine());
			System.out.println("Enter email ");
			employee.setEmail(sc.nextLine());
			System.out.println("Enter password ");
			employee.setPassword(sc.nextLine());
		}
		EmployeesDao dao =new EmployeesDaoImpl();
		try {
			System.out.println(dao.addEmployeeDao(employee));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
