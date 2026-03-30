package com.springboot.datajpa.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.datajpa.Entity.Employee;
import com.springboot.datajpa.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService 
{
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) 
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() 
    {
        return employeeRepository.findAll();

    }

    @Override
    public Optional<Employee> findById(int id)
    {
        
        Optional<Employee> emp= employeeRepository.findById(id);
    
        if(emp.isPresent())
    {
        return emp;
    }
    else 
    return null;

    }
  
    @Transactional
    @Override
    public Employee save(Employee theemployee) 
    {
        return employeeRepository.save(theemployee);

    }

    @Transactional
    @Override
    public void deleteById(int id) 
    {
        employeeRepository.deleteById(id);

    }
}
