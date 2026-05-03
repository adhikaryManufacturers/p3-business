package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PROSPECT")
public class Prospect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;
    private String contactedOn;
    private String crmStatus;
    private String notes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactedOn() { return contactedOn; }
    public void setContactedOn(String contactedOn) { this.contactedOn = contactedOn; }

    public String getCrmStatus() { return crmStatus; }
    public void setCrmStatus(String crmStatus) { this.crmStatus = crmStatus; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}