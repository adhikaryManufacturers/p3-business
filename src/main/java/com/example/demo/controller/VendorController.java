package com.example.demo.controller;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping
    public List<Vendor> getAll() {
        return vendorRepository.findAll();
    }

    @PostMapping
    public Vendor add(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> update(@PathVariable Long id, @RequestBody Vendor vendor) {
        if (!vendorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vendor.setId(id);
        return ResponseEntity.ok(vendorRepository.save(vendor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!vendorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vendorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}