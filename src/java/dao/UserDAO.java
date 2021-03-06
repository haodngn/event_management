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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import utils.DBHelper;

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
            String ProfilePicture) throws SQLException, ClassNotFoundException, NamingException, MessagingException {

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
            if (row > 0) {
//                JavaMailUtils.sendMail(email, code);
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
    
    public boolean createManagerAccount(String name,
            String email,
            String password,
            int roleID,
            String phone,
            boolean gender) throws SQLException, ClassNotFoundException, NamingException, MessagingException {

        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            String sql = "insert into Account(Name, Email, Password, Role_id, Status, PhoneNumber, Gender) "
                    + "values(?, ?, ?, ?, 'active', ?, ?)";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, email);
            stm.setString(3, password);
            stm.setInt(4, roleID);
            stm.setString(5, phone);
            stm.setBoolean(6, gender);

            int row = stm.executeUpdate();
            if (row > 0) {
//                JavaMailUtils.sendMail(email, code);
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

    public UserDTO getUserByEmail(String email)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
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
            if (rs.next()) {
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

    public boolean updateUser(String newName, String newPhone, Boolean newGender, String email) throws ClassNotFoundException, SQLException, NamingException {
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

            if (stm.executeUpdate() > 0) {
                update = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return update;
    }

    public String getNameUserByID(int id)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
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
            if (rs.next()) {
                name = rs.getString("Name");
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

        return name;
    }

    public boolean deleteUser(int id) throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        String sql = "update Account set status=? where id=?";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "disable");
            stm.setInt(2, id);

            if (stm.executeUpdate() > 0) {
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

    // dem bao nhieu trang (moi trang 5 user)
    public int pagingUser () throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int countPage = 0;
        
        try {
            String sql = "select count(ID) as row from Account";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                int total = rs.getInt("row");
                countPage = total / 5;
                if(total % 5 != 0){
                    countPage++;
                }
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
        return countPage;
    }
    public List<UserDTO> getAllUser(int index)
            throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<UserDTO> listUser = null;
        UserDTO userDTO = null;
        try {
            String sql = "Select ID, Name, Email, PhoneNumber, "
                    + "Gender, Status "
                    + "from Account "
                    + "order by ID "
                    + "OFFSET ? ROWS  FETCH NEXT 5 ROWS ONLY";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 5);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String phoneNumber = rs.getString("PhoneNumber");
                boolean gender = rs.getBoolean("Gender");
                String status = rs.getString("Status");
                userDTO = new UserDTO(id, name, email, phoneNumber, status, gender);
                if (listUser == null) {
                    listUser = new ArrayList<>();
                }
                listUser.add(userDTO);
            }
            return listUser;
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
    }

    public int countTotalUser() throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs;
        int userCount = 0;
        String sql = "Select count(ID) as totalUser from Account";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            if (rs.next()) {
                userCount = rs.getInt("totalUser");
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return userCount;
    }

    // dem bao nhieu trang (moi trang 5 user)
    public int pagingUserBySearch (String searchValue) throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int countPage = 0;
        
        if(searchValue.equals("")){
            searchValue = null;
        }else{
            searchValue = "%"+searchValue+"%";
        }
        
        try {
            String sql = "select count(ID) as row from Account where Name like ?";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, searchValue);
            rs = stm.executeQuery();
            while(rs.next()){
                int total = rs.getInt("row");
                System.out.println("row: "+total);
                countPage = total / 5;
                if(total % 5 != 0){
                    countPage++;
                }
            }
            System.out.println("total page: "+countPage);
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
        return countPage;
    }
    
    public List<UserDTO> getUserByName(String username, int index)
            throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<UserDTO> listUser = null;
        UserDTO userDTO;

        try {
            String sql = "Select ID, Name, Email, PhoneNumber, "
                    + "Gender, Status "
                    + "from Account "
                    + "where Name like ? "
                    + "order by ID "
                    + "OFFSET ? ROWS  FETCH NEXT 5 ROWS ONLY";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + username + "%");
            stm.setInt(2, (index - 1) * 5);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String phoneNumber = rs.getString("PhoneNumber");
                boolean gender = rs.getBoolean("Gender");
                String status = rs.getString("Status");

                userDTO = new UserDTO(id, name, email, phoneNumber, status, gender);
                if (listUser == null) {
                    listUser = new ArrayList<>();
                }
                listUser.add(userDTO);
            }
            return listUser;
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
    }

    public boolean banUser(String email)
            throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;

        try {
            String sql = "Update Account Set Status = ? Where email like ?";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "deactive");
            stm.setString(2, email);
            if (stm.executeUpdate() > 0) {
                check = true;
            }
            return check;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean unbanUser(String email)
            throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;

        try {
            String sql = "Update Account Set Status = ? Where email like ?";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "active");
            stm.setString(2, email);
            if (stm.executeUpdate() > 0) {
                check = true;
            }
            return check;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
