package com.example.demo.entity;

public class InvestorProfile {
    private Long id;
    private String investorId;
    private String fullName;
    private String email;
    private Boolean active;

    public InvestorProfile(String investorId, String fullName, String email, Boolean active) {
        this.investorId = investorId;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInvestorId() { return investorId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
