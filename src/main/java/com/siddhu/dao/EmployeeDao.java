package com.siddhu.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.siddhu.dto.Employee;

import reactor.core.publisher.Flux;

@Component
public class EmployeeDao {

	 private static void sleepExecution(int i){
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Employee> getEmployees()  {
	        return IntStream.rangeClosed(1, 5)
	                .peek(EmployeeDao::sleepExecution)
	                .peek(i -> System.out.println("processing Iteration count : " + i))
	                .mapToObj(i -> new Employee(i, "Employee" + i))
	                .collect(Collectors.toList());
	    }


	    public Flux<Employee> getEmployeesStream()  {
	        return Flux.range(1,5)
	                .delayElements(Duration.ofSeconds(1))
	                .doOnNext(i -> System.out.println("processing Iteration count in stream flow : " + i))
	                .map(i -> new Employee(i, "Employee" + i));
	    }

	  
}