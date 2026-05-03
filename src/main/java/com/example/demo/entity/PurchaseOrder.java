package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "PURCHASE_ORDER")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vendorId;
    private String date;
    private double totalAmount;
    private double paid;
    private String status;
    private String dueDate;
    private String notes;

    @ElementCollection
    @CollectionTable(name = "PO_ITEMS", joinColumns = @JoinColumn(name = "po_id"))
    private List<POItem> items;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getPaid() { return paid; }
    public void setPaid(double paid) { this.paid = paid; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public List<POItem> getItems() { return items; }
    public void setItems(List<POItem> items) { this.items = items; }
}