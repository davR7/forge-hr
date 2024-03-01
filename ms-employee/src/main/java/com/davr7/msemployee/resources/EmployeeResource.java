package com.davr7.msemployee.resources;

import com.davr7.msemployee.domain.Employee;
import com.davr7.msemployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="employee")
public class EmployeeResource {

    @Autowired
    EmployeeService employeeServ;
    @GetMapping("/{id}")
    public ResponseEntity<Employee> handleReadEmployeeById(@PathVariable String id) {
        Employee obj = employeeServ.readEmployeeById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> handleReadAllEmployee() {
        List<Employee> list = employeeServ.readAllEmployees();
        return ResponseEntity.ok().body(list);
    }
}
