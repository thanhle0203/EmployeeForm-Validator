package com.thanhle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanhle.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

