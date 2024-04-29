package com.siddhu.basic.service;

import java.sql.SQLException;
import java.util.List;

import com.siddhu.basic.dao.EmployeeDao;
import com.siddhu.basic.dao.EmployeeDaoImpl;
import com.siddhu.basic.model.Employee;

public class MyServiceImpl implements MyService {

	EmployeeDao employeeDao;

	public MyServiceImpl() {

		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public boolean addEmployee(Employee e) {
		try {
			if (employeeDao.addEmployee(e)) {
				return true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		try {
			if(employeeDao.updateEmployee(e)) {
				return true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		try {
			if(employeeDao.deleteEmployee(id)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		Employee e = null;
		try {
			e =employeeDao.findEmployeeById(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emp = null;
		try {
			emp = employeeDao.getAllEmployee();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

}
