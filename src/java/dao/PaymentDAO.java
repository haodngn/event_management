/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PaymentDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author HAO
 */
public class PaymentDAO {
    public boolean creatPayment(boolean isFree,float price, int eventID) throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            String sql = "insert into Payment(isFree, Price, Event_Id) "
                    + "values(?,?,?)";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            
            stm.setBoolean(1, isFree);
            stm.setFloat(2, price);
            stm.setInt(3, eventID);

            int row = stm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    public PaymentDTO getPaymentByEventID(int id)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        PaymentDTO dto = null;

        try {
            String sql = "select ID, isFree, Price, Event_Id "
                    + "from Payment "
                    + "where Event_Id=?";

            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {


                int payment_id = rs.getInt("ID");
                boolean isFree = rs.getBoolean("isFree");
                float price = rs.getFloat("Price");        

                dto = new PaymentDTO(payment_id,  isFree,  price,  id);
               

            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return dto;
    }
    
    public boolean createPaymentAccount(int paymentID, int accountID, String status) throws ClassNotFoundException, NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        String sql = "insert into Payment_Account (Account_id, Payment_Id, Status) "
                + "values(?, ?, ?)";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, accountID);
            stm.setInt(2, paymentID);
            stm.setString(3, status);
            
            if(stm.executeUpdate()>0){
                result = true ;
            }
        } finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return result;
        
    }
}
