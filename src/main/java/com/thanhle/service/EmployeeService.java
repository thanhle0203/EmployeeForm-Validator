package com.thanhle.service;

import java.util.List;

import com.thanhle.domain.Employee;

public interface EmployeeService {
	
	public Employee save(Employee e);
	public List<Employee> findAll();
	public Employee findById(int empId);
	public void deleteById(int empId);

}

