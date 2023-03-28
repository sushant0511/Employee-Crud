package com.employee.dao;

import com.employee.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	public void findEmployee(String name);
	public void deleteEmployee(int id);
	public void updateEmployee(int id,float salary);
	public void displayEmployee();
}
