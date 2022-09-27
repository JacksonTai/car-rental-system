/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jackson
 */
public abstract class User {
    
    private String userID;
    private String username;
    private String password;
    
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public String getUserID() {
        return this.userID;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public static void login(String email, String password){
   
    }
    
}
