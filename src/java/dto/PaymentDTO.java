/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author HAO
 */
public class PaymentDTO {

    private int paymentID;
    private boolean isFree;
    private float price;
    private int eventID;

    public PaymentDTO(int paymentID, boolean isFree, float price, int eventID) {
        this.paymentID = paymentID;
        this.isFree = isFree;
        this.price = price;
        this.eventID = eventID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

}
