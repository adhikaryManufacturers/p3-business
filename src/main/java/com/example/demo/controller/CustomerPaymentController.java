package com.example.demo.controller;

import com.example.demo.entity.CustomerPayment;
import com.example.demo.repository.CustomerPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/customer-payments")
public class CustomerPaymentController {

    @Autowired
    private CustomerPaymentRepository customerPaymentRepository;

    @GetMapping
    public List<CustomerPayment> getAll() {
        return customerPaymentRepository.findAll();
    }

    @PostMapping
    public CustomerPayment add(@RequestBody CustomerPayment payment) {
        return customerPaymentRepository.save(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerPayment> update(@PathVariable Long id, @RequestBody CustomerPayment payment) {
        if (!customerPaymentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        payment.setId(id);
        return ResponseEntity.ok(customerPaymentRepository.save(payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!customerPaymentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        customerPaymentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}