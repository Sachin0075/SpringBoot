package com.springboot.datajpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.datajpa.Entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>
{
    
}
