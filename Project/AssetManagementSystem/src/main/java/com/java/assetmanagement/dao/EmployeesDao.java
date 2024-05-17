package com.java.assetmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.assetmanagement.model.Employees;

public interface EmployeesDao {

	List<Employees> showEmployeeDao() throws ClassNotFoundException, SQLException;

	String deleteEmployeeDao(int employeeId) throws ClassNotFoundException, SQLException;

	String updateEmployeeDao(Employees employees) throws ClassNotFoundException, SQLException;

	String addEmployeeDao(Employees employees) throws ClassNotFoundException, SQLException;

	Employees searchEmployeeDao(int employee_id) throws ClassNotFoundException, SQLException;

	Employees searchByEmployee_id(int employee_id);

}
