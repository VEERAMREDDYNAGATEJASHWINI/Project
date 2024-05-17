package com.java.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.protobuf.TextFormat.ParseException;
import com.java.assetmanagement.model.Employees;

public class EmployeesTest {

	@Test
	public void testToString() {
		
		@SuppressWarnings("unused")
		Employees emp1 = new Employees(1,"Teja","FullStack", "vntsr26@gmail.com","1234");
	
	}
	
	@Test
	public void testEquals() throws ParseException {
		
		Employees emp1 = new Employees(1,"Teja","FullStack", "vntsr26@gmail.com","1234");
		Employees emp2 = new Employees(1,"Teja","FullStack", "vntsr26@gmail.com","1234");
		Employees emp3 = new Employees(1,"Teja","FullStack", "vntsr26@gmail.com","1234");
		assertTrue(emp1.equals(emp2));
		assertFalse(emp1.equals(emp3));
	}
	
	@Test
	public void testHashCode() throws ParseException {
		Employees emp1 = new Employees(1,"Teja","FullStack", "vntsr26@gmail.com","1234");
		Employees emp2 = new Employees(1,"Teja","FullStack", "vntsr26@gmail.com","1234");
		assertEquals(emp1.hashCode(), emp2.hashCode());
	}
	@Test
	public void testGettersAndSetters() throws ParseException {

		Employees employees = new Employees();
		employees.setEmployee_Id(1);
		employees.setName("Teja");
		employees.setDepartment("FullStack");
		employees.setEmail("vntsr26@gmail.com");
		employees.setPassword("1234");
		assertEquals(1, employees.getEmployee_Id());
		assertEquals("Teja", employees.getName());
		assertEquals("FullStack", employees.getDepartment());
		assertEquals("vntsr@gmail.com", employees.getEmail());
		assertEquals("1234", employees.getPassword());

	}
	@Test
	public void testConstructors() throws ParseException {
		Employees employees = new Employees();
		assertNotNull(employees);
		Employees emp = new Employees(1,"Teja","FullStack", "vntsr26@gmail.com","1234");
		
		assertEquals(1, emp.getEmployee_Id());
		assertEquals("Teja", emp.getName());
		assertEquals("FullStack", emp.getDepartment());
		assertEquals("vntsr26@gmail.com", emp.getEmail());
		assertEquals("1234", emp.getPassword());
		
	}


}
