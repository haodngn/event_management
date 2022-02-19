/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author HAO
 */
public class FeedbackDTO implements Serializable {
    private int id;
    private int event_id;
    private int posted_by;
    private String description_fb;
    private int rating;
    private String post_time;

    public FeedbackDTO(int posted_by, String description_fb, int rating, String post_time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getPosted_by() {
        return posted_by;
    }

    public void setPosted_by(int posted_by) {
        this.posted_by = posted_by;
    }
    
    

    public String getDescription_fb() {
        return description_fb;
    }

    public int getRating() {
        return rating;
    }

    public String getPost_time() {
        return post_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    

    public void setDescription_fb(String description_fb) {
        this.description_fb = description_fb;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    
    
}

