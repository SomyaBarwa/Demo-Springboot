//package com.deutsche.demo.service;
//
//import com.deutsche.demo.model.Employee;
//import com.deutsche.demo.repository.EmployeeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class EmployeeServiceTest {
//
//    @Autowired
//    private EmployeeService empService;
//
//    @Autowired
//    private EmployeeRepository empRepository;
//
//    @BeforeEach
//    void setUp() {
//        empRepository.deleteAll();
//        empRepository.save(new Employee("ram", 10000));
//        empRepository.save(new Employee("shyam", 12000));
//        empRepository.save(new Employee("hari", 9000));
//        empRepository.save(new Employee("vishnu", 8000));
//        empRepository.save(new Employee("krishna", 16000));
//    }
//
//    @Test
//    void testGetAllEmployees() {
//        List<Employee> all = empService.getAllEmployees();
//        assertEquals(2, all.size());
//    }
//
//    @Test
//    void testGetEmployeeByName() {
//        List<Employee> list = empService.getEmployeeByName("Alice");
//        assertFalse(list.isEmpty());
//        assertEquals("Alice", list.get(0).getName());
//    }
//
//    @Test
//    void testAddEmployee() {
//        Employee e = new Employee("Charlie", 60000);
//        Employee saved = empService.addEmployee(e);
//        assertNotNull(saved.getId());
//        assertEquals("Charlie", saved.getName());
//        assertTrue(empRepository.existsById(saved.getId()));
//    }
//
//    @Test
//    void testUpdateEmployee() {
//        Employee existing = empRepository.findAll().get(0);
//        existing.setSalary(70000);
//        Employee updated = empService.updateEmployee(existing);
//
//        assertNotNull(updated);
//        assertEquals(70000, updated.getSalary());
//
//        Employee fromDb = empRepository.findById(existing.getId()).orElse(null);
//        assertNotNull(fromDb);
//        assertEquals(70000, fromDb.getSalary());
//    }
//
//    @Test
//    void testDeleteEmployee() {
//        int initialCount = empRepository.findAll().size();
//        Employee toDelete = empRepository.findAll().get(0);
//
//        Integer deletedId = empService.deleteEmployee(toDelete.getId());
//
//        assertEquals(toDelete.getId(), deletedId);
//        assertFalse(empRepository.existsById(deletedId));
//        assertEquals(initialCount - 1, empRepository.findAll().size());
//    }
//
//}
