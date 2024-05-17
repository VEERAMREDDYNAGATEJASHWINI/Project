package com.java.assetmanagement.main;


import java.sql.SQLException;
import java.util.List;

import com.java.assetmanagement.dao.EmployeesDao;
import com.java.assetmanagement.dao.EmployeesDaoImpl;
import com.java.assetmanagement.model.Employees;

public class EmployeeShowMain {

	public static void main(String[] args) {
		
		EmployeesDao dao = new EmployeesDaoImpl();
		
		try {
			List<Employees> employeeList = dao.showEmployeeDao();
			for (Employees employees : employeeList) {
				System.out.println(employees);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}