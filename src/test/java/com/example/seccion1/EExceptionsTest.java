package com.example.seccion1;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static  org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class EExceptionsTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeServiceImpl service;

    @Test
    void checkException() {

        when(this.repository.findOne(any())).thenThrow(new IllegalArgumentException());

        Optional<Employee> result = this.service.findOneOptional(1L);
        assertNotNull(result);
        assertFalse(result.isPresent()); // se comprueba que esta vacio

    }
}
