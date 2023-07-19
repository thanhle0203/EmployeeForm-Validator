package com.thanhle.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhle.domain.Employee;
import com.thanhle.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int empId) {
		Optional<Employee> optEmployee = employeeRepository.findById(empId);
		if(optEmployee.isPresent()) {
			return optEmployee.get();
		}
		return null;
	}

	@Override
	public void deleteById(int empId) {
		employeeRepository.deleteById(empId);
		
	}

}
