package com.java.assetmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.assetmanagement.model.Employees;
import com.java.assetmanagement.util.DBConnUtil;
import com.java.assetmanagement.util.DBPropertyUtil;

public class EmployeesDaoImpl implements EmployeesDao {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Employees> showEmployeeDao() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from Employees";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employees> employeeList = new ArrayList<Employees>();
		Employees employees = null;
		while(rs.next()) {
			employees = new Employees();
			employees.setEmployee_Id(rs.getInt("employee_Id"));
			employees.setName(rs.getString("name"));
			employees.setDepartment(rs.getString("department"));
			employees.setEmail(rs.getString("email"));
			employees.setPassword(rs.getString("password"));
			
			employeeList.add(employees);
		}
		return employeeList;
	}

	@Override
	public Employees searchEmployeeDao(int employee_id) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = "select * from Employees where employee_Id=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employee_id);
		ResultSet rs = pst.executeQuery();
		
		Employees employees = null;
		if(rs.next()) {
			employees = new Employees();
			employees.setEmployee_Id(rs.getInt("employee_Id"));
			employees.setName(rs.getString("name"));
			employees.setDepartment(rs.getString("department"));
			employees.setEmail(rs.getString("email"));
			employees.setPassword(rs.getString("password"));
		}return employees;
	
	}

	@Override
	public String addEmployeeDao(Employees employees) throws ClassNotFoundException, SQLException {
		
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String cmd = " insert into Employees(employee_Id,name,department,email,password) " + " values(?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employees.getEmployee_Id());
		pst.setString(2, employees.getName());
		pst.setString(3, employees.getDepartment());
		pst.setString(4, employees.getEmail());
		pst.setString(5, employees.getPassword());
		pst.executeUpdate();
		return "Employee Record Inserted";
	}

	@Override
	public String updateEmployeeDao(Employees employees) throws ClassNotFoundException, SQLException {
		
		Employees empFound= searchEmployeeDao(employees.getEmployee_Id());
		if(empFound !=null) {
			String connStr = DBPropertyUtil.connectionString("db");
			connection = DBConnUtil.getConnection(connStr);
			
			String cmd = "update Employees set name=? , department=? , email=? , password=? where employee_Id=? " ;
			pst = connection.prepareStatement(cmd);
			pst.setString(1, employees.getName());
			pst.setString(2, employees.getDepartment());
			pst.setString(3, employees.getEmail());
			pst.setString(4, employees.getPassword());
			pst.setInt(5, employees.getEmployee_Id());
			pst.executeUpdate();
			return "Employee Record Updated";
		}
		else {
			return "Employee Record not found";
		}
		
	}

	@Override
	public String deleteEmployeeDao(int employee_Id) throws ClassNotFoundException, SQLException {
		
		Employees empFound= searchEmployeeDao(employee_Id);
		if(empFound !=null) {
			String connStr = DBPropertyUtil.connectionString("db");
			connection = DBConnUtil.getConnection(connStr);
			
			String cmd = "delete from Employees where employee_Id=? " ;
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, employee_Id);
			pst.executeUpdate();
			return "Employee Record Deleted";
		}
		else {
			return "Employee Record not found";
		}
	}

	@Override
	public Employees searchByEmployee_id(int employee_id) {
		// TODO Auto-generated method stub
		return null;
	}

}