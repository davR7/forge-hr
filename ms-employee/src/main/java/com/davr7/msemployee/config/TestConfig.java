package com.davr7.msemployee.config;

import com.davr7.msemployee.domain.Employee;
import com.davr7.msemployee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile(value="test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepo;

    @Override
    public void run(String... args) throws Exception {
        Employee emp1 = new Employee(null, "David Melo", 200.0);
        Employee emp2 = new Employee(null, "Carol Barros", 300.0);
        Employee emp3 = new Employee(null, "Tiago Dantas", 250.0);

        employeeRepo.saveAll(Arrays.asList(emp1, emp2, emp3));
    }
}
