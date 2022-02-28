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
import javax.mail.MessagingException;
import javax.naming.NamingException;
import utils.DBHelper;
import utils.JavaMailUtils;

/**
 *
 * @author HAO
 */
public class UserDAO {
    
    public UserDTO checkLogin(String email, String password) throws NoSuchAlgorithmException, SQLException, NamingException {
        int id;
        String fullName = "";       
        int roleID;
        String status = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.makeConnection();
            if (conn != null) {
                String sql = "SELECT ID, Name, Role_id, Status FROM Account WHERE Email=? AND Password=? AND Status!=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                stm.setString(3, "disable");
                rs = stm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("ID");
                    fullName = rs.getString("Name");
                    roleID = rs.getInt("Role_id");
                    status = rs.getString("Status");
                    return new UserDTO(id, fullName, email, roleID, status);
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
    
    public boolean createAccount(String name, 
            String email, 
            String password, 
            int roleID, 
            String ProfilePicture) throws SQLException, ClassNotFoundException, NamingException, MessagingException{
        
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            String sql = "insert into Account(Name, Email, Password, ProfilePicture, Role_id, Status, PhoneNumber, Gender) "
                    + "values(?, ?, ?, ?, ?, 'active', 'null', 1)";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, email);
            stm.setString(3, password);
            stm.setString(4, ProfilePicture);
            stm.setInt(5, roleID);
            
            int row = stm.executeUpdate();
            if(row > 0){
//                JavaMailUtils.sendMail(email, code);
                check = true;
            }
        } finally {
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return check;
    }
    public UserDTO getUserByEmail(String email) 
            throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm =null;
        ResultSet rs = null;
        
        UserDTO dto = null;
        
        try {
            String sql = "select ID, Name, PhoneNumber, Gender, ProfilePicture "
                    + "from Account "
                    + "where Email=? ";
            
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();
            if(rs.next()){
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String phone = rs.getString("PhoneNumber");
                String gender = rs.getString("Gender");
                String profilePicture = rs.getString("ProfilePicture");
                Boolean gender1 = gender.equals("1");
                System.out.println(gender1);
                dto = new UserDTO(Integer.parseInt(id), name, email, phone, gender1, profilePicture);
            }
            
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        
        return dto;
    }
    
    public boolean updateUser(String newName ,String newPhone, Boolean newGender, String email ) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean update = false;
        String sql = "update Account "
                + "set Name = ?, phoneNumber = ?, gender = ? "
                + "where Email = ?  ";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, newName);
            stm.setString(2, newPhone);
            stm.setBoolean(3, newGender);
            stm.setString(4, email);
            
            if(stm.executeUpdate()>0){
                update = true ;
            }
        } finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return update;
    }
    
    public String getNameUserByID(int id) 
            throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm =null;
        ResultSet rs = null;
        
        String name = "";
        
        try {
            String sql = "select Name "
                    + "from Account "
                    + "where ID=? ";
            
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()){
                name = rs.getString("Name");
            }
            
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if (con != null){
                con.close();
            }
        }
        
        return name;
    }
}
