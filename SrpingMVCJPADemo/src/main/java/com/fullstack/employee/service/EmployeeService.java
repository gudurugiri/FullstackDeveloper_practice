package com.fullstack.employee.service;

import java.util.List;

import com.fullstack.employee.entity.Employee;

/**
 * *@author BUJAIR
 *
 */
public interface EmployeeService {

	void addEmployee(Employee employee);

	List<Employee> listEmployees();
	
	void updateEmployee(Employee employee);
}
