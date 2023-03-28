package com.employee.controller;

import java.util.Scanner;

import com.employee.dao.EmployeeServiceImpl;
import com.employee.model.Employee;

public class Tester {

	public static void main(String[] args) {
		
		EmployeeServiceImpl impl=new EmployeeServiceImpl();
		Scanner scanner=new Scanner(System.in);
		System.out.println("What you want to perfrom?");
		System.out.println("1--> Add Employee");
		System.out.println("2--> View All Employees");
		System.out.println("3--> Delete Employee");
		System.out.println("4--> Update Employee");
		System.out.println("5--> find Employee");
		int choice=scanner.nextInt();
		if(choice==1)
		{
		
		System.out.println("Enter Employee details");
	
		Employee employee=new Employee();
		employee.setId(scanner.nextInt());
		employee.setName(scanner.next());
		employee.setSalary(scanner.nextFloat());
		impl.addEmployee(employee);
		}
		else if(choice==2)
		{
		impl.displayEmployee();	
		}
		else if(choice==3)
		{
			impl.displayEmployee();
			System.out.println("Enter id to delete");
		    int id=scanner.nextInt();
			impl.deleteEmployee(id);
		}
		
		else if(choice==4)
		{
			impl.displayEmployee();
			System.out.println("Enter id to update");
		    int id=scanner.nextInt();
		    System.out.println("Enter salary to update");
		    float sal=scanner.nextFloat();
		    impl.updateEmployee(id, sal);
		}
		
		else if(choice==5)
		{
			System.out.println("Enter Name ?");
			String name=scanner.next();
			impl.findEmployee(name);
		}

	}

}
