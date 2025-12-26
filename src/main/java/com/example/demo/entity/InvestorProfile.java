package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "investor_profiles")
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String investorName;

    @Column(nullable = false)
    private String riskProfile;

public boolean isActive() {
    return active;
}

public void setActive(boolean active) {
    this.active = active;
}


    // getters & setters
}
