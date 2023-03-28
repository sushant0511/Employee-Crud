package com.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.employee.model.Employee;
import com.java.dbConnection.ConnectionFactory;

public class EmployeeServiceImpl implements EmployeeService
{

	@Override
	public void addEmployee(Employee employee) {
	// add in Database 
		try
		{
		Connection connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		String query="insert into employee values('"+employee.getId()+"','"+employee.getName()+"','"+employee.getSalary()+"')";
		statement.executeUpdate(query);
		System.out.println("Data inserted ");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void findEmployee(String n) {
		
		try
		{
		Connection connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("select * from employee where name='"+n+"'");
		while(rs.next())
		{
			System.out.println(rs.getFloat(3));
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteEmployee(int id) {
		
		
		try
		{
		Connection connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		String query="delete from employee where id='"+id+"'";
		statement.executeUpdate(query);
		System.out.println("Data deleted ");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateEmployee(int id,float salary) {
		try
		{
		Connection connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		String query="UPDATE `mytestdb`.`employee` SET `salary` = '"+salary+"' WHERE (`id` = '"+id+"');";
		statement.executeUpdate(query);
		System.out.println("Data Updated ");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void displayEmployee() {
		
		try
		{
		Connection connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("select * from employee");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getFloat(3));
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
