package com.siddhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhu.dao.EmployeeDao;
import com.siddhu.dto.Employee;

import reactor.core.publisher.Flux;

@Service
public class EmployeeService {


	@Autowired
	private EmployeeDao dao;

	public List<Employee> loadAllEmployees() {
		long start = System.currentTimeMillis();
		List<Employee> employees = dao.getEmployees();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time : " + (end - start));
		return employees;
	}



	public Flux<Employee> loadAllEmployeesStream() {
		long start = System.currentTimeMillis();
		Flux<Employee> employees = dao.getEmployeesStream();
		long end = System.currentTimeMillis();
		System.out.println("Total execution time : " + (end - start));
		return employees;
	}
}
