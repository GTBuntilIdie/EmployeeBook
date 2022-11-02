package com.example.spring.EmployeeBook.service;

import com.example.spring.EmployeeBook.exception.EmployeeAlreadyAddedException;
import com.example.spring.EmployeeBook.exception.EmployeeNotFoundException;
import com.example.spring.EmployeeBook.exception.InvalidInputException;
import com.example.spring.EmployeeBook.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private static final Employee firstPersonDepartment4 = new Employee(
            "Ivan", "Ivanov", 75000, 4);

    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    void add() {
        assertEquals(firstPersonDepartment4, employeeService.add(
                "ivAn", "ivAnOv", 75000, 4));
    }

    @Test
    void EmployeeAlreadyAddedExceptionTest() {
        assertEquals(firstPersonDepartment4, employeeService.add(
                "ivAn", "ivAnOv", 75000, 4));
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(
                "ivAn", "ivAnOv", 75000, 4));
    }

    @Test
    void remove() {
        employeeService.add(
                "ivAn", "ivAnOv", 75000, 4);
        assertEquals(firstPersonDepartment4, employeeService.remove(
                "ivAn", "ivAnOv"));
    }

    @Test
    void EmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove(
                "ivAn", "ivAnOv"));
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(
                "ivAn", "ivAnOv"));
    }

    @Test
    void find() {
        employeeService.add(
                "ivAn", "ivAnOv", 75000, 4);
        assertEquals(firstPersonDepartment4, employeeService.find(
                "ivAn", "ivAnOv"));
    }

    @Test
    void InvalidInputExceptionTest() {
        assertThrows(InvalidInputException.class, () -> employeeService.add(
                "ivПРИВЕТ4", "ivAПРИВЕТnOv", 75000, 4));
        assertThrows(InvalidInputException.class, () -> employeeService.remove(
                "ivПРИВЕТ4", "ivAПРИВЕТnOv"));
        assertThrows(InvalidInputException.class, () -> employeeService.find(
                "ivПРИВЕТ4", "ivAПРИВЕТnOv"));
    }

    @Test
    void findAll() {
        HashMap<String, Employee> test = new HashMap<>();
        test.put("Ivan Ivanov", firstPersonDepartment4);
        employeeService.add(
                "ivAn", "ivAnOv", 75000, 4);
        assertEquals(Collections.unmodifiableCollection(test.values()),
                employeeService.findAll());
    }
}