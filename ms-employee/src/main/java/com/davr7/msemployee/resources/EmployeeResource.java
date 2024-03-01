package com.davr7.msemployee.resources;

import com.davr7.msemployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="employee")
public class EmployeeResource {

    @Autowired
    EmployeeService employeeServ;
}
