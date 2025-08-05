package com.deutsche.demo.controller;

import com.deutsche.demo.model.Employee;
import com.deutsche.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("emp")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity
                .ok()
                .header("message", "Employee List")
                .body(empService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity
                .ok()
                .header("message", "Employee id: " + id)
                .body(empService.getEmployeeById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name) {
        return ResponseEntity
                .ok()
                .header("message", "Employee name: " + name)
                .body(empService.getEmployeeByName(name));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee addedEmployee = empService.addEmployee(employee);
        return ResponseEntity
                .created(URI.create("/emp/" + addedEmployee.getId())) // Location header
                .header("message", "Employee created")
                .body(addedEmployee);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity
                .ok()
                .header("message", "Employee id: " + employee.getId())
                .body(empService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        empService.deleteEmployee(id);
        return ResponseEntity
                .ok()
                .header("message", "Employee: "+id+" deleted.")
                .body("Deleted employee with id: " + id);
    }
}