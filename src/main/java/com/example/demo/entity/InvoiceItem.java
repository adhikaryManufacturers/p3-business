package com.example.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class InvoiceItem {

    private Long productId;
    private String desc;
    private double qty;
    private String unit;
    private double rate;

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public double getQty() { return qty; }
    public void setQty(double qty) { this.qty = qty; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }
}