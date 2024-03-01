package com.davr7.mspayroll.resources;

import com.davr7.mspayroll.domain.Payment;
import com.davr7.mspayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentResource {
    @Autowired
    PaymentService paymentServ;

    @GetMapping("/{employeeId}/days/{days}")
    public ResponseEntity<Payment> handleReadEmployeePay(@PathVariable String employeeId, @PathVariable Integer days) {
        Payment obj = paymentServ.readEmployeePay(employeeId, days);
        return ResponseEntity.ok().body(obj);
    }
}
