package com.example.demo.controller;

import com.example.demo.entity.RawMaterial;
import com.example.demo.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/raw-materials")
public class RawMaterialController {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @GetMapping
    public List<RawMaterial> getAll() {
        return rawMaterialRepository.findAll();
    }

    @PostMapping
    public RawMaterial add(@RequestBody RawMaterial rawMaterial) {
        return rawMaterialRepository.save(rawMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RawMaterial> update(@PathVariable Long id, @RequestBody RawMaterial rawMaterial) {
        if (!rawMaterialRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rawMaterial.setId(id);
        return ResponseEntity.ok(rawMaterialRepository.save(rawMaterial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!rawMaterialRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rawMaterialRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}