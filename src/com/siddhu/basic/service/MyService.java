package com.siddhu.basic.service;

import java.util.List;

import com.siddhu.basic.model.Employee;

public interface MyService {
	boolean addEmployee(Employee e);
	boolean updateEmployee(Employee e);
	boolean deleteEmployee(Integer id);
	Employee findEmployeeById(Integer id);
	List<Employee> getAllEmployee();
}
