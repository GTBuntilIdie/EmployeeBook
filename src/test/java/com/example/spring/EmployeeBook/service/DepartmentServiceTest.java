package com.example.spring.EmployeeBook.service;

import com.example.spring.EmployeeBook.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    private List<Employee> employeeActual;
    private static final Employee firstPersonDepartment4 = new Employee(
            "Ivan", "Ivanov", 75000, 4);
    private static final Employee secondPersonDepartment4 = new Employee(
            "Stepan", "Stepanov", 70000, 4);
    private static final Employee firstPersonDepartment3 = new Employee(
            "Young", "Thug", 85000, 3);
    private static final Employee secondPersonDepartment3 = new Employee(
            "Saimir", "Woods", 80000, 3);
    private static final Employee firstPersonDepartment2 = new Employee(
            "SOPHEE", "vyzee", 95000, 2);
    private static final Employee secondPersonDepartment2 = new Employee(
            "Fairy", "Tail", 90000, 2);
    private static final Employee firstPersonDepartment1 = new Employee(
            "Lil", "UziVert", 105000, 1);
    private static final Employee secondPersonDepartment1 = new Employee(
            "Taylor", "Swift", 100000, 1);
    @Mock
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    private void testList() {
        List<Employee> employeeActual = new ArrayList<>();
        employeeActual.add(firstPersonDepartment4);
        employeeActual.add( secondPersonDepartment4);
        employeeActual.add( firstPersonDepartment3);
        employeeActual.add(  secondPersonDepartment3);
        employeeActual.add( firstPersonDepartment2);
        employeeActual.add( secondPersonDepartment2);
        employeeActual.add( firstPersonDepartment1);
        employeeActual.add( secondPersonDepartment1);

        }


    @Test
    void maxSalaryDepartment() {
        Mockito.when(employeeService.getEmployeeList()).thenReturn(employeeActual);

        Employee expected = employeeService.maxSalaryDepartment(1);
        Employee actual = firstPersonDepartment1;
        assertEquals(expected, actual);

    }

    @Test
    void minSalaryDepartment() {
        Mockito.when(employeeService.getEmployeeList()).thenReturn(employeeActual);
        Employee expected = employeeService.minSalaryDepartment(1);
        Employee actual = secondPersonDepartment1;
        assertEquals(expected, actual);
    }

    @Test
    void allDepartment() {
        Mockito.when(employeeService.getEmployeeList()).thenReturn(employeeActual);
        List<Employee> departmentOnelEmployers = new ArrayList<>();
        departmentOnelEmployers.add(firstPersonDepartment1);
        departmentOnelEmployers.add(secondPersonDepartment1);
        assertEquals(employeeService.allDepartment(1), departmentOnelEmployers);
    }

    @Test
    void allEmployee() {
        Mockito.when(employeeService.getEmployeeList()).thenReturn(employeeActual);
        List<Employee> actual = employeeActual;
        assertEquals(employeeService.allEmployee(), actual);
    }
}