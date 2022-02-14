/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;

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
    private String loaction;
    private int prosted_by;
    private int postId;
    private boolean status;

    public EventDTO() {
    }

    public EventDTO(int id, String speaker, String eventName, String occurDate, String endDate, String registerDate, String expirationDate, int studentCount, String description, String loaction, int prosted_by, int postId, boolean status) {
        this.id = id;
        this.speaker = speaker;
        this.eventName = eventName;
        this.occurDate = occurDate;
        this.endDate = endDate;
        this.registerDate = registerDate;
        this.expirationDate = expirationDate;
        this.studentCount = studentCount;
        this.description = description;
        this.loaction = loaction;
        this.prosted_by = prosted_by;
        this.postId = postId;
        this.status = status;
    }

    public EventDTO(int id, String speaker, String eventName, String loaction) {
        this.id = id;
        this.speaker = speaker;
        this.eventName = eventName;
        this.loaction = loaction;
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
        return loaction;
    }

    public void setLoaction(String loaction) {
        this.loaction = loaction;
    }

    public int getProsted_by() {
        return prosted_by;
    }

    public void setProsted_by(int prosted_by) {
        this.prosted_by = prosted_by;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
