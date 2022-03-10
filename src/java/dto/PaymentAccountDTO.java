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
public class PaymentAccountDTO {

    private int paymentAccountID;
    private int Payment_Id;
    private int Account_Id;
    private String Status;

    public int getPaymentAccountID() {
        return paymentAccountID;
    }

    public void setPaymentAccountID(int paymentAccountID) {
        this.paymentAccountID = paymentAccountID;
    }

    public int getPayment_Id() {
        return Payment_Id;
    }

    public void setPayment_Id(int Payment_Id) {
        this.Payment_Id = Payment_Id;
    }

    public int getAccount_Id() {
        return Account_Id;
    }

    public void setAccount_Id(int Account_Id) {
        this.Account_Id = Account_Id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
