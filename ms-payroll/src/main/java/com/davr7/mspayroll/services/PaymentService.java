package com.davr7.mspayroll.services;

import com.davr7.mspayroll.domain.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment readEmployeePay(String id, Integer days) {
        return new Payment("User Mock", 200.0, 30);
    }
}
