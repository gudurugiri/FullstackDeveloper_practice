/**
 * 
 */
package com.fullstack.employee.dao;

import java.util.List;

import com.fullstack.employee.entity.Employee;

/**
 * *@author BUJAIR
 *
 */
public interface EmployeeDAO {

	void addEmployee(Employee employee);

	List<Employee> listEmployees();
	
	void updateEmployee(Employee employee);
	
}
