package com.example.spring.EmployeeBook.service;

import com.example.spring.EmployeeBook.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName, double salary, int department);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();

    Employee maxSalaryDepartment(int department);
    Employee minSalaryDepartment(int department);
    List<Employee> allDepartment(int department);

    List<Employee> allEmployee();
}
