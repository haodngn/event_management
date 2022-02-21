/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CommentDTO;
import dto.EventDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author HAO
 */
public class CommentDAO implements Serializable{
    
    List<CommentDTO> listComment;

    public List<CommentDTO> getListComment() {
        return listComment;
    }
    
    public boolean createFeedback(int event_id, int posted_by, String description_fb, int rating, String post_time) throws SQLException, ClassNotFoundException, NamingException, ParseException {

        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        
        try {
            String sql = "insert into Comment(Event_id,Posted_by ,DescriptionFB, Rating,"
                    + "PostTime) "
                    + "values(?,?,?,?,?)";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, event_id);
            stm.setInt(2, posted_by);
            stm.setString(3, description_fb);
            stm.setInt(4, rating);
            stm.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            
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
    
    public void getAllFeedback(int event_id)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.listComment = new ArrayList<>();

        try {
            String sql = "select Posted_by, DescriptionFB, Rating, PostTime "
                    + "from Comment "
                    + "where Event_id=? ";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, event_id);
            rs = stm.executeQuery();
           
            while (rs.next()) {
                int posted_by = rs.getInt("Posted_by");
                String description_fb = rs.getString("DescriptionFB");
                int rating = rs.getInt("Rating");
                
                DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
                String post_time = rs.getString("PostTime");

                CommentDTO dto = new CommentDTO(posted_by, description_fb, rating, post_time);
                if (this.listComment == null) {
                    this.listComment = new ArrayList<>();
                }
                this.listComment.add(dto);
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
    }
    
    
}
