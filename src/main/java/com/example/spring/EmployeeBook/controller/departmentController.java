package com.example.spring.EmployeeBook.controller;


import com.example.spring.EmployeeBook.model.Employee;
import com.example.spring.EmployeeBook.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class departmentController {
    private final EmployeeService service;

    public departmentController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryDepartment(@RequestParam int department) {
        return service.maxSalaryDepartment(department);
    }
    @GetMapping("/min-salary")
    public Employee minSalaryDepartment(@RequestParam int department) {
        return service.minSalaryDepartment(department);
    }
    @GetMapping(value = "/all", params = "department")
    public List<Employee> allDepartment(@RequestParam int department) {
        return service.allDepartment(department);
    }
    @GetMapping("/all")
    public List<Employee> allEmployee() {
        return service.allEmployee();
    }
}

