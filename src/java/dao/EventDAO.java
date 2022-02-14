/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EventDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author Admin
 */
public class EventDAO implements Serializable{
    List<EventDTO> listEvent;
    
    public List<EventDTO> getListEvent() {
        return listEvent;
    }
     
    public int countAllEvent() 
            throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm =null;
        ResultSet rs = null;
        int countPage = 0;
        try {
            String sql = "select count(ID) as row "
                    + "from Event "
                    + "where status=1";
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
        }finally {
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
        
        return countPage;
    }
    
    public void getAllEvent(int index) 
            throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.listEvent = new ArrayList<>();
        
        try {
            String sql = "select ID, Speaker, EventName, Location "
                    + "from Event "
                    + "where status=1 "
                    + "order by OccurDate "
                    + "OFFSET ? ROWS  FETCH NEXT 5 ROWS ONLY";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 5);
            rs = stm.executeQuery();
            System.out.println("sql: "+ sql);
            while(rs.next()){
                int Id = rs.getInt("ID");
                String speaker = rs.getString("EventName");
                String name = rs.getString("Speaker");
                String location = rs.getString("Location");
                
                EventDTO dto = new EventDTO(Id, speaker, name, location);
                if(this.listEvent == null){
                    this.listEvent = new ArrayList<>();
                }
                this.listEvent.add(dto);
            }
            
        }finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public int getMaxId() throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        int maxid = 0;
        try {
            String sql = "SELECT MAX(ID) as row FROM Event";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if(rs.next()){
                maxid = rs.getInt("row");
            }
            
            return maxid;
        }finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public boolean createEvent(String speaker, String eventName,
            String occurDate, String enddate, String registerDate,
            String expirationDate, int studentCount, String description,
            String loaction, int prosted_by, int postId) throws SQLException, ClassNotFoundException, NamingException, ParseException{
        
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            String sql = "insert into Event(Speaker, EventName, Description, EndDate, ExpirationDate, Location, OccurDate, Post_id,"
                    + "Posted_by, RegisterDate, StudentCount, Status) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,1)";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            
            Date occur= Date.valueOf(occurDate);
            Date end= Date.valueOf(enddate); 
            Date register= Date.valueOf(registerDate); 
            Date expiration= Date.valueOf(expirationDate); 
            
           
            stm.setString(1, speaker);
            stm.setString(2, eventName);
            stm.setString(3, description);
            stm.setDate(4, end);
            stm.setDate(5, expiration);
            stm.setString(6, loaction);
            stm.setDate(7, occur);
            stm.setInt(8, prosted_by);
            stm.setInt(9, postId);
            stm.setDate(10, register);
            stm.setInt(11, studentCount);
            
            int row = stm.executeUpdate();
            if(row > 0){
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
    
}