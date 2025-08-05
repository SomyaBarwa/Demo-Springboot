//package com.deutsche.demo.service;
//
//import com.deutsche.demo.model.Employee;
//import com.deutsche.demo.repository.EmployeeRepository;
//import com.deutsche.demo.exception.EmployeeNotFoundException;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class EmployeeServiceMockitoTest {
//
//    @Mock
//    private EmployeeRepository empRepository;
//
//    @InjectMocks
//    private EmployeeService empService;
//
//    @Test
//    void testGetAllEmployees() {
//        List<Employee> mockList = List.of(new Employee("Alice", 40000), new Employee("Bob", 50000));
//        when(empRepository.findAll()).thenReturn(mockList);
//
//        List<Employee> result = empService.getAllEmployees();
//
//        assertEquals(2, result.size());
//        verify(empRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testGetEmployeeById_Found() {
//        Employee emp = new Employee("Alice", 40000);
//        emp.setId(1);
//        when(empRepository.findById(1)).thenReturn(Optional.of(emp));
//
//        Employee result = empService.getEmployeeById(1);
//
//        assertEquals("Alice", result.getName());
//        verify(empRepository).findById(1);
//    }
//
//    @Test
//    void testGetEmployeeById_NotFound() {
//        when(empRepository.findById(999)).thenReturn(Optional.empty());
//
//        assertThrows(EmployeeNotFoundException.class, () -> empService.getEmployeeById(999));
//        verify(empRepository).findById(999);
//    }
//
//    @Test
//    void testGetEmployeeByName() {
//        List<Employee> mockList = List.of(new Employee("Alice", 40000));
//        when(empRepository.findByName("Alice")).thenReturn(mockList);
//
//        List<Employee> result = empService.getEmployeeByName("Alice");
//
//        assertEquals(1, result.size());
//        assertEquals("Alice", result.get(0).getName());
//        verify(empRepository).findByName("Alice");
//    }
//
//    @Test
//    void testAddEmployee_Success() {
//        Employee emp = new Employee("Charlie", 60000);
//        when(empRepository.save(emp)).thenReturn(emp);
//
//        Employee result = empService.addEmployee(emp);
//
//        assertEquals("Charlie", result.getName());
//        verify(empRepository).save(emp);
//    }
//
//    @Test
//    void testAddEmployee_WithExistingId_ThrowsException() {
//        Employee emp = new Employee("Charlie", 60000);
//        emp.setId(10);
//        when(empRepository.existsById(10)).thenReturn(true);
//
//        assertThrows(IllegalArgumentException.class, () -> empService.addEmployee(emp));
//        verify(empRepository).existsById(10);
//        verify(empRepository, never()).save(any());
//    }
//
//    @Test
//    void testUpdateEmployee_Exists() {
//        Employee emp = new Employee("Alice", 40000);
//        emp.setId(1);
//
//        when(empRepository.existsById(1)).thenReturn(true);
//        when(empRepository.save(any(Employee.class))).thenReturn(emp);
//
//        Employee updated = empService.updateEmployee(emp);
//
//        assertNotNull(updated);
//        assertEquals("Alice", updated.getName());
//        assertEquals(40000, updated.getSalary());
//        verify(empRepository).save(emp);
//    }
//
//    @Test
//    void testUpdateEmployee_NotExists() {
//        Employee emp = new Employee("Bob", 50000);
//        emp.setId(2);
//        when(empRepository.existsById(2)).thenReturn(false);
//
//        Employee result = empService.updateEmployee(emp);
//
//        assertNull(result);
//        verify(empRepository, never()).save(any());
//    }
//
//    @Test
//    void testDeleteEmployee_Exists() {
//        Integer idToDelete = 5;
//        when(empRepository.existsById(idToDelete)).thenReturn(true);
//        doNothing().when(empRepository).deleteById(idToDelete);
//
//        Integer result = empService.deleteEmployee(idToDelete);
//
//        assertEquals(idToDelete, result);
//        verify(empRepository).deleteById(idToDelete);
//    }
//
//    @Test
//    void testDeleteEmployee_NotExists() {
//        when(empRepository.existsById(404)).thenReturn(false);
//
//        Integer result = empService.deleteEmployee(404);
//
//        assertEquals(-1, result);
//        verify(empRepository, never()).deleteById(any());
//    }
//}
