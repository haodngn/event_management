/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;
/**
 *
 * @author Admin
 */
public class MyUtils {
    private static final Logger LOGGER = Logger.getLogger(MyUtils.class);
    
    //encrypt password
    public static String encryptPassword(String mess) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(mess.getBytes("UTF-8"));
            
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) sb.append('0');
                sb.append(hex);
            }
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            LOGGER.error("Error at MyUtil: "+e.getMessage());
        }
        return sb.toString();
    }
    
    //random code
    public static String getRandomCode() {
        // chose a Character random from this String 
        String alphaNumericString = "0123456789";
        // create StringBuffer size of 6 
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            // generate a random number between 0 to AlphaNumericString variable length 
            int index = (int) (alphaNumericString.length() * Math.random());

            // add Character one by one in end of sb 
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}
