/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinnt.error;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class CreateEventError implements Serializable{
    private String isEmpty;
    private String speakerLength;
    private String nameLength;
    private String desLength;
    private String locationLength;
    private String registerDateCheck;
    private String expDateCheck;
    private String occurDateCheck;
    private String endDateCheck;

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
