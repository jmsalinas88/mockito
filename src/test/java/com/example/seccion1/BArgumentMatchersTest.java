package com.example.seccion1;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static  org.junit.jupiter.api.Assertions.*;

public class BArgumentMatchersTest {

    EmployeeRepository repository;
    EmployeeService service;

    @BeforeEach
    void setUp() {
        this.repository = mock(EmployeeRepository.class);
        this.service = new EmployeeServiceImpl(this.repository);
    }

    @Test
    void findOneTest() {

        //given
        Employee emp = new Employee(1L, "Emp1", 40);
        when(this.repository.findOne(any())).thenReturn(emp);

        //when
        Employee employee = this.service.findOne(1L);
        Employee employee2 = this.service.findOne(2L);
        Employee employee3 = this.service.findOne(600L);

        //then
        assertNotNull(employee);
        assertEquals("Emp1", employee.getName());
        assertEquals("Emp1", employee2.getName());
        assertEquals("Emp1", employee3.getName());

    }

}
