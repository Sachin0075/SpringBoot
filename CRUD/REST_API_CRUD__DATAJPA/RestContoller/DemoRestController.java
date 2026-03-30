package com.example.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cruddemo.Entity.Employee;
import com.example.cruddemo.Service.EmployeeService;


@RestController
@RequestMapping("/api")
public class DemoRestController 
{

    //object of dao
    public EmployeeService employeeService;

    @Autowired
    public DemoRestController(EmployeeService employeeService) 
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/emp")
    public List<Employee> findAll() 
    {
        return employeeService.findAll();
    }

  
    @GetMapping("/emp/{eid}")
    public Employee eid(@PathVariable int eid) 
    {

        Employee e = employeeService.findById(eid);

        if (e == null) 
        {
            throw new RuntimeException("Employee not Found " + eid);
        }

        return e;
    }

    @PostMapping("/emp")
    public Employee addEmployee(@RequestBody Employee employee) 
  {
        employee.setId(0);

        Employee e = employeeService.save(employee);

        return e;
    }

    @PutMapping("/emp")
    public Employee updatEmployee(@RequestBody Employee employee) 
    {

        Employee emp = employeeService.save(employee);

        return emp;
    }

    @DeleteMapping("/emp/{eid}")
    public String deleteEmployee(@PathVariable int eid) 
      {
          Employee emp = employeeService.findById(eid);
          if (emp == null) 
          {
            throw new RuntimeException("not found " + eid);
          }
          employeeService.deleteById(eid);
          return ("Deleted User of " + eid);
      }
}
