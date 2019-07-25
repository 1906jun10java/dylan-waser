package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	//abstract CRUD operations
	public abstract void createEmployee(String firstName, String lastName, String email, String username, String passw0rd, int managerID) throws SQLException;
	
	public abstract List<Employee> readAllEmployees() throws SQLException;
	public abstract Employee readEmployee(int id) throws SQLException;
	
	public abstract void updateEmployee(Employee e) throws SQLException;
	
	public abstract void deleteEmployee(Employee e) throws SQLException;
}
