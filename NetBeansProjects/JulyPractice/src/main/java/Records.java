/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class Records {
    
    private String username;
    private String password;
    
    //methods
    public  String getUser(){
        return username;
    }
    
    public void setUser(String name){
        this.username = name;
    }
    
    public String getPass(){
        return password;
    }
    
    public void setPass(String pass){
        this.password = pass;
    }
}
