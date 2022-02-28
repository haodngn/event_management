/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
    
}
