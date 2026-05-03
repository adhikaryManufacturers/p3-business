package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "VENDOR_PAYMENT")
public class VendorPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vendorId;
    private Long poId;
    private double amount;
    private String date;
    private String mode;
    private String note;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }

    public Long getPoId() { return poId; }
    public void setPoId(Long poId) { this.poId = poId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}