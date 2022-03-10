/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author HAO
 */
public class EventErrorDTO implements Serializable{
    private String isEmpty;
    private String speakerLength;
    private String nameLength;
    private String desLength;
    private String locationLength;
    private String registerDateCheck;
    private String expDateCheck;
    private String occurDateCheck;
    private String endDateCheck;
    private String amountStudentErr;


    public EventErrorDTO(String isEmpty, String speakerLength, String nameLength, String desLength, String locationLength, String registerDateCheck, String expDateCheck, String occurDateCheck, String endDateCheck) {
        this.isEmpty = isEmpty;
        this.speakerLength = speakerLength;
        this.nameLength = nameLength;
        this.desLength = desLength;
        this.locationLength = locationLength;
        this.registerDateCheck = registerDateCheck;
        this.expDateCheck = expDateCheck;
        this.occurDateCheck = occurDateCheck;
        this.endDateCheck = endDateCheck;
    }

    public EventErrorDTO() {
    }

    public String getAmountStudentErr() {
        return amountStudentErr;
    }

    public void setAmountStudentErr(String amountStudentErr) {
        this.amountStudentErr = amountStudentErr;
    }
    
    public String getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(String isEmpty) {
        this.isEmpty = isEmpty;
    }

    public String getSpeakerLength() {
        return speakerLength;
    }

    public void setSpeakerLength(String speakerLength) {
        this.speakerLength = speakerLength;
    }

    public String getNameLength() {
        return nameLength;
    }

    public void setNameLength(String nameLength) {
        this.nameLength = nameLength;
    }

    public String getDesLength() {
        return desLength;
    }

    public void setDesLength(String desLength) {
        this.desLength = desLength;
    }

    public String getLocationLength() {
        return locationLength;
    }

    public void setLocationLength(String locationLength) {
        this.locationLength = locationLength;
    }

    public String getRegisterDateCheck() {
        return registerDateCheck;
    }

    public void setRegisterDateCheck(String registerDateCheck) {
        this.registerDateCheck = registerDateCheck;
    }

    public String getExpDateCheck() {
        return expDateCheck;
    }

    public void setExpDateCheck(String expDateCheck) {
        this.expDateCheck = expDateCheck;
    }

    public String getOccurDateCheck() {
        return occurDateCheck;
    }

    public void setOccurDateCheck(String occurDateCheck) {
        this.occurDateCheck = occurDateCheck;
    }

    public String getEndDateCheck() {
        return endDateCheck;
    }

    public void setEndDateCheck(String endDateCheck) {
        this.endDateCheck = endDateCheck;
    }
    
}
