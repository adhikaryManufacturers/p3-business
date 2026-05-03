package com.example.demo.controller;

import com.example.demo.entity.VendorPayment;
import com.example.demo.repository.VendorPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/vendor-payments")
public class VendorPaymentController {

    @Autowired
    private VendorPaymentRepository vendorPaymentRepository;

    @GetMapping
    public List<VendorPayment> getAll() {
        return vendorPaymentRepository.findAll();
    }

    @PostMapping
    public VendorPayment add(@RequestBody VendorPayment payment) {
        return vendorPaymentRepository.save(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorPayment> update(@PathVariable Long id, @RequestBody VendorPayment payment) {
        if (!vendorPaymentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        payment.setId(id);
        return ResponseEntity.ok(vendorPaymentRepository.save(payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!vendorPaymentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vendorPaymentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}