package com.springboot.data.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.data.rest.Entity.Employee;

@RepositoryRestResource(path = "users")
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>
{
    
}
