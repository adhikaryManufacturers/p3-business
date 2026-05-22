package com.example.demo.model;

public class LoginResponse {

    private boolean success;
    private Long    id;       // ← NEW — needed by website to link orders
    private String  name;     // ← NEW
    private String  email;
    private String  phone;    // ← NEW
    private String  role;     // ← NEW — "ADMIN" or "CUSTOMER"
    private String  address;  // ← NEW
    private String  message;

    public LoginResponse() {}

    // Minimal constructor (backward compat)
    public LoginResponse(boolean success, String email, String message) {
        this.success = success;
        this.email   = email;
        this.message = message;
    }

    // Full constructor
    public LoginResponse(boolean success, Long id, String name, String email,
                         String phone, String role, String address, String message) {
        this.success = success;
        this.id      = id;
        this.name    = name;
        this.email   = email;
        this.phone   = phone;
        this.role    = role;
        this.address = address;
        this.message = message;
    }

    // Getters & Setters
    public boolean isSuccess()              { return success; }
    public void    setSuccess(boolean s)    { this.success = s; }

    public Long    getId()                  { return id; }
    public void    setId(Long id)           { this.id = id; }

    public String  getName()                { return name; }
    public void    setName(String n)        { this.name = n; }

    public String  getEmail()               { return email; }
    public void    setEmail(String e)       { this.email = e; }

    public String  getPhone()               { return phone; }
    public void    setPhone(String p)       { this.phone = p; }

    public String  getRole()                { return role; }
    public void    setRole(String r)        { this.role = r; }

    public String  getAddress()             { return address; }
    public void    setAddress(String a)     { this.address = a; }

    public String  getMessage()             { return message; }
    public void    setMessage(String m)     { this.message = m; }
}