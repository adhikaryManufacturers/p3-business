package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PAYROLL")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long empId;

    @Column(name = "payroll_month")  // ← rename to avoid H2 reserved keyword
    private String month;

    private double baseSalary;
    private double deductions;
    private double advance;
    private double paid;
    private String status;
    private String paidDate;
    private String note;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmpId() { return empId; }
    public void setEmpId(Long empId) { this.empId = empId; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }

    public double getAdvance() { return advance; }
    public void setAdvance(double advance) { this.advance = advance; }

    public double getPaid() { return paid; }
    public void setPaid(double paid) { this.paid = paid; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPaidDate() { return paidDate; }
    public void setPaidDate(String paidDate) { this.paidDate = paidDate; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}