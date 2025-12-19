package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.security.Timestamp;
@Entity 
public class LoadSheddingEvent {
    @Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
   
    private String investorId;
    private String fullName;

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
    public void setcreatedAt(LocalDateTime  ) {
        this.triggeredByForecastId= triggeredByForecastId;
    }
    public Double getexpectedDemandReductionMW() {
     return expectedDemandReductionMW;
    }
    public void setexpectedDemandReductionMW(Double expectedDemandReductionMW) {
        this.expectedDemandReductionMW= expectedDemandReductionMW;
    }

    
    public LoadSheddingEvent( long id,Double expectedDemandReductionMW ,Timestamp eventStart,Timestamp eventEnd, String zone, String reason, Long triggeredByForecastId ){
        this.id = id;
        this.expectedDemandReductionMW= expectedDemandReductionMW;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.reason = reason;
        this.triggeredByForecastId=triggeredByForecastId;
        this.zone=zone;
    }

    public LoadSheddingEvent(){
    }

}