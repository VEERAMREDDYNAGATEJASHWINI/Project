package com.java.assetmanagement.main;

import java.util.Scanner;
import com.java.assetmanagement.dao.EmployeesDao;
import com.java.assetmanagement.dao.EmployeesDaoImpl;
import com.java.assetmanagement.model.Employees;
public class EmployeesSearchMain {
	public static void main(String[] args) throws ClassNotFoundException {
		int employee_id;
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter employee_id :");
			employee_id = sc.nextInt();
		
		EmployeesDao dao = new EmployeesDaoImpl();
		
		Employees employees = dao.searchByEmployee_id(employee_id);
		if(employees != null) {
			System.out.println(employees);
		}
		else {
			System.out.println("---RECORD NOT FOUND---");
		}
		
				
	}
		
}
	
	

