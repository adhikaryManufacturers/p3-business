package com.example.demo.controller;

import com.example.demo.entity.CustomerOrder;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<CustomerOrder> getAll() {
        return orderRepository.findAll();
    }

    @PostMapping
    public CustomerOrder add(@RequestBody CustomerOrder order) {
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerOrder> update(@PathVariable Long id, @RequestBody CustomerOrder order) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        return ResponseEntity.ok(orderRepository.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}