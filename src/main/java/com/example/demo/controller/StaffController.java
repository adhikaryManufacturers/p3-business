package com.example.demo.controller;

import com.example.demo.entity.Staff;
import com.example.demo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    // GET all staff
    @GetMapping
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    // POST - add new staff
    @PostMapping
    public Staff addStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    // PUT - update existing staff
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        if (!staffRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        staff.setId(id);
        return ResponseEntity.ok(staffRepository.save(staff));
    }

    // DELETE - remove staff
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable Long id) {
        if (!staffRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        staffRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}