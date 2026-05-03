package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long custId;
    private String date;
    private String deliveryDate;
    private double discount;
    private boolean gstEnabled;
    private double gstRate;
    private double paid;
    private double prevOutstanding;
    private String status;
    private boolean delivered;
    private String deliveredDate;
    private boolean isCarryForward;
    private Long cfInvoiceId;
    private Long prevFromInvoice;
    private Long fromOrderId;

    @ElementCollection
    @CollectionTable(name = "INVOICE_ITEMS", joinColumns = @JoinColumn(name = "invoice_id"))
    private List<InvoiceItem> items;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCustId() { return custId; }
    public void setCustId(Long custId) { this.custId = custId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public boolean isGstEnabled() { return gstEnabled; }
    public void setGstEnabled(boolean gstEnabled) { this.gstEnabled = gstEnabled; }

    public double getGstRate() { return gstRate; }
    public void setGstRate(double gstRate) { this.gstRate = gstRate; }

    public double getPaid() { return paid; }
    public void setPaid(double paid) { this.paid = paid; }

    public double getPrevOutstanding() { return prevOutstanding; }
    public void setPrevOutstanding(double prevOutstanding) { this.prevOutstanding = prevOutstanding; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isDelivered() { return delivered; }
    public void setDelivered(boolean delivered) { this.delivered = delivered; }

    public String getDeliveredDate() { return deliveredDate; }
    public void setDeliveredDate(String deliveredDate) { this.deliveredDate = deliveredDate; }

    public boolean isIsCarryForward() { return isCarryForward; }
    public void setIsCarryForward(boolean isCarryForward) { this.isCarryForward = isCarryForward; }

    public Long getCfInvoiceId() { return cfInvoiceId; }
    public void setCfInvoiceId(Long cfInvoiceId) { this.cfInvoiceId = cfInvoiceId; }

    public Long getPrevFromInvoice() { return prevFromInvoice; }
    public void setPrevFromInvoice(Long prevFromInvoice) { this.prevFromInvoice = prevFromInvoice; }

    public Long getFromOrderId() { return fromOrderId; }
    public void setFromOrderId(Long fromOrderId) { this.fromOrderId = fromOrderId; }

    public List<InvoiceItem> getItems() { return items; }
    public void setItems(List<InvoiceItem> items) { this.items = items; }
}