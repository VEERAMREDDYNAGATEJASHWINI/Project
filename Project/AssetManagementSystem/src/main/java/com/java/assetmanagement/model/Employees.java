package com.java.assetmanagement.model;

public class Employees {

	private int employee_Id;
	private String name;
	private String department;
	private String email;
	private String password;
	public int getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employees(int employee_Id, String name, String department, String email, String password) {
		super();
		this.employee_Id = employee_Id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employees [employee_Id=" + employee_Id + ", name=" + name + ", department=" + department + ", email="
				+ email + ", password=" + password + "]";
	}

	
	
}
