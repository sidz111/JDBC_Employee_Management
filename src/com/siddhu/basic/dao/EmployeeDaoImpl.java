package com.siddhu.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.siddhu.basic.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String sql;
	
	public EmployeeDaoImpl() {
		try {
			connection = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public boolean addEmployee(Employee e) throws SQLException {
		sql="insert into employee values(?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, e.getId());
		preparedStatement.setString(2, e.getName());
		preparedStatement.setString(3, e.getRole());
		preparedStatement.setDouble(4, e.getSalary());
		preparedStatement.setString(5, e.getJoining_date());
		preparedStatement.setString(6, e.getGender());
		Integer row = preparedStatement.executeUpdate();
		return row>0;
	}

	@Override
	public boolean updateEmployee(Employee e) throws SQLException {
		sql = "update employee set name=?, role=?, salary=?, joining_date=?, gender=? where id = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, e.getName());
		preparedStatement.setString(2, e.getRole());
		preparedStatement.setDouble(3, e.getSalary());
		preparedStatement.setString(4, e.getJoining_date());
		preparedStatement.setString(5, e.getGender());
		preparedStatement.setInt(6, e.getId());
		Integer row = preparedStatement.executeUpdate();
		return row>0;
	}

	@Override
	public boolean deleteEmployee(Integer id) throws SQLException {
		sql = "delete from employee where id = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		Integer row = preparedStatement.executeUpdate();
		return row>0;
	}

	@Override
	public Employee findEmployeeById(Integer id) throws SQLException {
		sql = "select * from employee where id = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		Employee e = new Employee();
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setRole(resultSet.getString(3));
			e.setSalary(resultSet.getDouble(4));
			e.setJoining_date(resultSet.getString(5));
			e.setGender(resultSet.getString(6));
			}
		return e;
	}

	@Override
	public List<Employee> getAllEmployee() throws SQLException {
		sql = "select * from employee";
		preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Employee> emp = new ArrayList<Employee>();
		while(resultSet.next()) {
			Employee e = new Employee();
			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setRole(resultSet.getString(3));
			e.setSalary(resultSet.getDouble(4));
			e.setJoining_date(resultSet.getString(5));
			e.setGender(resultSet.getString(6));
			emp.add(e);
		}
		return emp;
	}

}
