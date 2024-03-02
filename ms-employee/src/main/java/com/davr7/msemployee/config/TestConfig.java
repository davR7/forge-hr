package com.davr7.msemployee.config;

import com.davr7.msemployee.domain.Employee;
import com.davr7.msemployee.domain.Job;
import com.davr7.msemployee.repositories.EmployeeRepository;
import com.davr7.msemployee.repositories.JobRepository;
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

    @Autowired
    JobRepository jobRepo;

    @Override
    public void run(String... args) throws Exception {

        Job job1 = new Job(null, "Gerente de Projetos", 60.0);
        Job job2 = new Job(null, "Designer Gráfico", 40.0);
        Job job3 = new Job(null, "Desenvolvedor", 50.0);

        Employee emp1 = new Employee(null, "David Melo", "davi@test", "12345", job1);
        Employee emp2 = new Employee(null, "Carol Barros", "carol@test", "12345", job2);
        Employee emp3 = new Employee(null, "Tiago Dantas", "tiago@test.com", "12345", job3);

        jobRepo.saveAll(Arrays.asList(job1, job2, job3));
        employeeRepo.saveAll(Arrays.asList(emp1, emp2, emp3));
    }
}
