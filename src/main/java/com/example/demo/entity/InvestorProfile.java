package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.security.Timestamp;
import jakarta.persistence.column;
@Entity 
public class InvestorProfile {
    @Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
   
    private String investorId;
    private String fullName;
    @Column(unique=true)
    private String email;
    private Boolean active;
    private LocalDateTime createdAt;
    public long getId() {
      return id;
    }
    public void setId(int id) {
        this.id= id;
    }
    public String getinvestorId() {
        return investorId;
    }
    public void setinvestorId(String investorId) {
        this.investorId = investorId;
    }
    public String getfullName() {
       return fullName ;
    }
    public void setfullName(String fullName) {
        this.fullName= fullName;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email= email;
    }
    public Boolean getactive() {
     return active;
    }
    public void setactive(Boolean active) {
        this.active= active;
    }
    public LocalDateTime createdAt() {
     return createdAt;
    }
    public void setcreatedAt(LocalDateTime createdAt ) {
        this.createdAt= createdAt;
    }

    
    public InvestorProfile ( Long id, String investorId , String fullName , String email , Boolean active , LocalDateTime createdAt ){
        this.id = id;
        this.investorId= investorId;
        this.fullName = fullName ;
        this.email = email;
        this.active = active;
        this.createdAt=createdAt;
        
    }

    public InvestorProfile(){
    }

}