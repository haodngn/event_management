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

    public String getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(String isEmpty) {
        this.isEmpty = isEmpty;
    }
    
}
