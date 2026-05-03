package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @GetMapping
    public List<PurchaseOrder> getAll() {
        return purchaseOrderRepository.findAll();
    }

    @PostMapping
    public PurchaseOrder add(@RequestBody PurchaseOrder po) {
        return purchaseOrderRepository.save(po);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> update(@PathVariable Long id, @RequestBody PurchaseOrder po) {
        if (!purchaseOrderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        po.setId(id);
        return ResponseEntity.ok(purchaseOrderRepository.save(po));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!purchaseOrderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        purchaseOrderRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}