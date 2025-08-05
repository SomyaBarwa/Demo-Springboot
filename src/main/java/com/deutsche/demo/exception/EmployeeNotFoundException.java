package com.deutsche.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Integer id) {
        super("Employee with the id " + id + " is not found!");
    }

    public EmployeeNotFoundException(String name) {
        super("Employee not found with name: " + name);
    }
}
