package com.example.seccion1;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DInjectMocksTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeServiceImpl service;

    @Test
    void findOneTest() {

        //given
        Employee emp = new Employee(1L, "Emp1", 40);
        when(this.repository.findOne(any())).thenReturn(emp);

        //when
        Employee employee = this.service.findOne(1L);
        Employee employee1 = this.service.findOne(1L);
        Employee employee2 = this.service.findOne(2L);
        Employee employee3 = this.service.findOne(600L);

        //then
        assertNotNull(employee);
        assertEquals("Emp1", employee.getName());
        assertEquals("Emp1", employee2.getName());
        assertEquals("Emp1", employee3.getName());

        // verify(repository).findOne(1L);

        verify(repository, times(2)).findOne(1L);
        verify(repository, atMostOnce()).findOne(2L);
        verify(repository, atLeast(1)).findOne(2L);
        verify(repository, never()).findOne(7L);
        verify(repository, times(4)).findOne(any());


    }

}
