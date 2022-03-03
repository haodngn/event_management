/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class UserDTO {
    
    int userID;
    String name;
    String email;
    String password;
    String phoneNumber;
    Boolean gender;
    int roleID;
    String ProfilePicture;
    String status;

    public UserDTO(int userID, String name, String email, String password, String phoneNumber, Boolean gender, int roleID, String ProfilePicture, String status) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.roleID = roleID;
        this.ProfilePicture = ProfilePicture;
        this.status = status;
    }

    public UserDTO(String name, String email, int roleID, String ProfilePicture) {
        this.name = name;
        this.email = email;
        this.roleID = roleID;
        this.ProfilePicture = ProfilePicture;
    }

    public UserDTO(int userID, String name, String email, String phoneNumber, Boolean gender, String ProfilePicture) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.ProfilePicture = ProfilePicture;
    }

        public UserDTO(int userID, String name, String email, int roleID, String ProfilePicture) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.roleID = roleID;
        this.ProfilePicture = ProfilePicture;
    }

    public UserDTO(int userID, String name, String email, String phoneNumber, Boolean gender) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String ProfilePicture) {
        this.ProfilePicture = ProfilePicture;
    }
    
}
