package com.example.seccion2;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryImpl;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static  org.junit.jupiter.api.Assertions.*;

public class AMockVsSpyTest {

    EmployeeRepository repository;
    EmployeeService service;

    @BeforeEach
    void setUp() {
        this.repository = spy(EmployeeRepositoryImpl.class);
        this.service = new EmployeeServiceImpl(this.repository);
    }

    @Test
    void findOneTest() {

        Employee employee1 = service.findOne(1L);


        verify(repository).findOne(1L);

    }

    @Test
    void findOneTest2() {

        Employee emp = new Employee(1L, "Prueba", 35);
        when(repository.findOne(1l)).thenReturn(emp);

        Employee employee1 = service.findOne(1L);
        assertEquals("Prueba", employee1.getName());

        verify(repository).findOne(1L);

    }

    @Test
    void findOneTest3() {

        Employee emp = new Employee(1L, "Prueba", 35);
        doReturn(emp).when(repository).findOne(1l);

        Employee employee1 = service.findOne(1L);
        assertEquals("Prueba", employee1.getName());

        verify(repository).findOne(1L);

    }



}
