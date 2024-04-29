package com.siddhu.basic.dao;

import java.sql.SQLException;
import java.util.List;

import com.siddhu.basic.model.Employee;

public interface EmployeeDao {
	boolean addEmployee(Employee e) throws SQLException;
	boolean updateEmployee(Employee e) throws SQLException;
	boolean deleteEmployee(Integer id) throws SQLException;
	Employee findEmployeeById(Integer id) throws SQLException;
	List<Employee> getAllEmployee() throws SQLException;	
}
