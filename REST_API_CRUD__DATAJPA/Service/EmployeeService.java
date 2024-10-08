package com.example.cruddemo.Service;

import java.util.List;

import com.example.cruddemo.Entity.Employee;

public interface EmployeeService 
{    
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
