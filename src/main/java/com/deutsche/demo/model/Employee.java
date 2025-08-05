package com.deutsche.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK values
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "name should be provided")
    @NotBlank(message = "name can not be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters.")
    @Column(name = "name")
    private String name;

    @Positive(message = "Salary should be more than 0.")
    @Column(name = "salary")
    private double salary;

    public Employee() {
    }

    public Employee(Integer id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + salary;
    }
}
