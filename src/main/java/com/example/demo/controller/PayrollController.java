package com.example.demo.controller;

import com.example.demo.entity.Payroll;
import com.example.demo.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollRepository payrollRepository;

    @GetMapping
    public List<Payroll> getAll() {
        return payrollRepository.findAll();
    }

    @PostMapping
    public Payroll add(@RequestBody Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payroll> update(@PathVariable Long id, @RequestBody Payroll payroll) {
        if (!payrollRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        payroll.setId(id);
        return ResponseEntity.ok(payrollRepository.save(payroll));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!payrollRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        payrollRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}