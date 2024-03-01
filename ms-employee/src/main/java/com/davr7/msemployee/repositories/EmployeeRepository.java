package com.davr7.msemployee.repositories;

import com.davr7.msemployee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
