package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String size;
    private String hsn;
    private int stock;
    private double price;
    private String unit;

    @Column(columnDefinition = "TEXT")
    private String stockMeta;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getHsn() { return hsn; }
    public void setHsn(String hsn) { this.hsn = hsn; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getStockMeta() { return stockMeta; }
    public void setStockMeta(String stockMeta) { this.stockMeta = stockMeta; }
}