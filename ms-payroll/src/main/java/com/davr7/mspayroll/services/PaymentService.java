package com.davr7.mspayroll.services;

import com.davr7.mspayroll.domain.Employee;
import com.davr7.mspayroll.domain.Payment;
import com.davr7.mspayroll.feignclients.EmployeeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    EmployeeFeignClient employeeFeignClient;

    public Payment readEmployeePay(String employeeId, Integer days) {
        Employee employee = employeeFeignClient.handleReadEmployeeById(employeeId).getBody();
        if (employee == null) throw new IllegalArgumentException();
        return new Payment(employee.getName(), employee.getDailyIncome(), days);
    }
}
