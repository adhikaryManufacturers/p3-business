package com.example.demo.repository;

import com.example.demo.entity.VendorPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorPaymentRepository extends JpaRepository<VendorPayment, Long> {
}