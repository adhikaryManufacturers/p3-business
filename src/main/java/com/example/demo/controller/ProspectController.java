package com.example.demo.controller;

import com.example.demo.entity.Prospect;
import com.example.demo.repository.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/prospects")
public class ProspectController {

    @Autowired
    private ProspectRepository prospectRepository;

    @GetMapping
    public List<Prospect> getAll() {
        return prospectRepository.findAll();
    }

    @PostMapping
    public Prospect add(@RequestBody Prospect prospect) {
        return prospectRepository.save(prospect);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prospect> update(@PathVariable Long id, @RequestBody Prospect prospect) {
        if (!prospectRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prospect.setId(id);
        return ResponseEntity.ok(prospectRepository.save(prospect));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!prospectRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prospectRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}