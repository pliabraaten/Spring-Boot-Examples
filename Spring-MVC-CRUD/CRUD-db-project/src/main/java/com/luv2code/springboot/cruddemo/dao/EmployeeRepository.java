package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add method to sort by last name
                        // Spring Data JPA will parse the method name behind the scenes
    public List<Employee> findAllByOrderByLastNameAsc();

}
