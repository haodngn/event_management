/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author HAO
 */
public class UserDAO {
    
    public UserDTO checkLogin(String userID, String password) throws NoSuchAlgorithmException, SQLException, NamingException {
        String fullName = "";
        String email = "";
        int roleID;
        String status = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String sql = "SELECT Name, Role_id, Status FROM Account WHERE Email=? AND Password=? AND Status!=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                stm.setString(3, "disable");
                rs = stm.executeQuery();
                if (rs.next()) {
                    fullName = rs.getString("Name");
                    roleID = rs.getInt("Role_id");
                    status = rs.getString("Status");
                    return new UserDTO(fullName, email, roleID, status);
                }
            }
        } catch (ClassNotFoundException | SQLException | NamingException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
    
}
