package com.davr7.mspayroll.feignclients;

import com.davr7.mspayroll.domain.Employee;
import com.davr7.mspayroll.feignclients.decoder.EmployeeErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="ms-employee", path="employee", configuration = EmployeeErrorDecoder.class)
public interface EmployeeFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<Employee> handleReadEmployeeById(@PathVariable String id);
}
