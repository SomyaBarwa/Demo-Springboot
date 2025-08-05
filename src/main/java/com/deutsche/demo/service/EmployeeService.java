package com.deutsche.demo.service;

import com.deutsche.demo.exception.EmployeeNotFoundException;
import com.deutsche.demo.model.Employee;
import com.deutsche.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository empRepository;

    public List<Employee> getAllEmployees() {
        LOG.info("Fetching all employees.");
        return empRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        LOG.info("Fetching employee with id: {}", id);
        Optional<Employee> employeeOptional = empRepository.findById(id);
        if (employeeOptional.isPresent())
            return employeeOptional.get();
        else
            throw new EmployeeNotFoundException(id);
    }

    public List<Employee> getEmployeeByName(String name) {
        LOG.info("Employees with the name: " + name);
        return empRepository.findByNameIgnoreCase(name);
    }

    public Employee addEmployee(Employee employee) {
        LOG.info("Attempting to add employee: {}", employee);
        if (employee.getId() != null && empRepository.existsById(employee.getId())) {
            throw new IllegalArgumentException("Employee with id " + employee.getId() + " already exists.");
        }
        return empRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        LOG.info("Attempting to update employee with id: {}", employee.getId());
        Optional<Employee> existing = empRepository.findById(employee.getId());
        if (existing.isPresent()) {
            return empRepository.save(employee);
        } else {
            throw new EmployeeNotFoundException(employee.getId());
        }
    }

    public Integer deleteEmployee(Integer id) {
        LOG.info("Attempting to delete employee with id: {}", id);
        Optional<Employee> existing = empRepository.findById(id);
        if (existing.isPresent()) {
            empRepository.delete(existing.get());
            return id;
        } else {
            throw new EmployeeNotFoundException(id);
        }
    }

}

