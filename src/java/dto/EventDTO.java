/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class EventDTO implements Serializable{
    private int id;
    private String speaker;
    private String eventName;
    private String occurDate;
    private String endDate;
    private String registerDate;
    private String expirationDate;
    private int studentCount;
    private String description;
    private String location;
    private int prosted_by;
    private boolean status;

    public EventDTO() {
    }

    public EventDTO(int id, String speaker, String eventName, String occurDate, String endDate, String registerDate, String expirationDate, int studentCount, String description, String location, int prosted_by, boolean status) {
        this.id = id;
        this.speaker = speaker;
        this.eventName = eventName;
        this.occurDate = occurDate;
        this.endDate = endDate;
        this.registerDate = registerDate;
        this.expirationDate = expirationDate;
        this.studentCount = studentCount;
        this.description = description;
        this.location = location;
        this.prosted_by = prosted_by;
       
        this.status = status;
    }

    public EventDTO(int id, String speaker, String eventName, String loaction) {
        this.id = id;
        this.speaker = speaker;
        this.eventName = eventName;
        this.location = loaction;
    }

    public EventDTO(String speaker, String eventName, String occurDate, String endDate, String registerDate, String expirationDate, String description, String location) {
        this.speaker = speaker;
        this.eventName = eventName;
        this.occurDate = occurDate;
        this.endDate = endDate;
        this.registerDate = registerDate;
        this.expirationDate = expirationDate;
        this.description = description;
        this.location = location;
    }

    public EventDTO(int id, String speaker, String eventName, String occurDate, String endDate, String registerDate, String expirationDate, int studentCount, String description, String location, int prosted_by) {
        this.id = id;
        this.speaker = speaker;
        this.eventName = eventName;
        this.occurDate = occurDate;
        this.endDate = endDate;
        this.registerDate = registerDate;
        this.expirationDate = expirationDate;
        this.studentCount = studentCount;
        this.description = description;
        this.location = location;
        this.prosted_by = prosted_by;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(String occurDate) {
        this.occurDate = occurDate;
    }

    public String getEnddate() {
        return endDate;
    }

    public void setEnddate(String endDate) {
        this.endDate = endDate;
      
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLoaction() {
        return location;
    }

    public void setLoaction(String loaction) {
        this.location = loaction;
    }

    public int getProsted_by() {
        return prosted_by;
    }

    public void setProsted_by(int prosted_by) {
        this.prosted_by = prosted_by;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
}
