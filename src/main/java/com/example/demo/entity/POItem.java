package com.example.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class POItem {

    private String material;
    private double qty;
    private String unit;
    private double rate;

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public double getQty() { return qty; }
    public void setQty(double qty) { this.qty = qty; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }
}