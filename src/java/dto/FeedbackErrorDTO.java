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
public class FeedbackErrorDTO implements Serializable{
    private String isEmpty;
    private String disscussLength;
    private String postTimeCheck;
    private String ratingError;
    
    public String getIsEmpty() {
        return isEmpty;
    }

    public String getDisscussLength() {
        return disscussLength;
    }

    public void setIsEmpty(String isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void setDisscussLength(String disscussLength) {
        this.disscussLength = disscussLength;
    }

    public String getPostTimeCheck() {
        return postTimeCheck;
    }

    public void setPostTimeCheck(String postTimeCheck) {
        this.postTimeCheck = postTimeCheck;
    }   

    public String getRatingError() {
        return ratingError;
    }

    public void setRatingError(String ratingError) {
        this.ratingError = ratingError;
    }
    
    
}
