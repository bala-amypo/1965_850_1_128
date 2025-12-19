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
    private String ;
    private Timestamp eventEnd;
    private long triggeredByForecastId;
    private Double expectedDemandReductionMW;
    public long getId() {
      return id;
    }
    public void setId(int id) {
        this.id= id;
    }
    public String getzone() {
        return zone;
    }
    public void setzone(String zone) {
        this.zone = zone;
    }
    public Timestamp geteventStart() {
       return eventStart ;
    }
    public void seteventStart(Timestamp eventStart) {
        this.eventStart= eventStart;
    }
    public Timestamp geteventEnd() {
        return eventEnd;
    }
    public void seteventEnd(Timestamp eventEnd) {
        this.eventEnd= eventEnd;
    }
    public String getreason() {
     return reason;
    }
    public void setreason(Timestamp reason) {
        this.reason= reason;
    }
    public Long gettriggeredByForecastId() {
     return triggeredByForecastId;
    }
    public void settriggeredByForecastId(Long triggeredByForecastId) {
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