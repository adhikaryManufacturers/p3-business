package com.example.demo.repository;

import com.example.demo.entity.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment, Long> {
}