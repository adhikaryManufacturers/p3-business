package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMER_PAYMENT")
public class CustomerPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long custId;
    private Long invoiceId;
    private double amount;
    private String date;
    private String mode;
    private String note;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCustId() { return custId; }
    public void setCustId(Long custId) { this.custId = custId; }

    public Long getInvoiceId() { return invoiceId; }
    public void setInvoiceId(Long invoiceId) { this.invoiceId = invoiceId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}