package com.davr7.msemployee.services;

import com.davr7.msemployee.domain.Employee;
import com.davr7.msemployee.repositories.EmployeeRepository;
import com.davr7.msemployee.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepo;

    public Employee readEmployeeById(String id) {
        Optional<Employee> obj = employeeRepo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    public List<Employee> readAllEmployees() {
        return employeeRepo.findAll();
    }
}
