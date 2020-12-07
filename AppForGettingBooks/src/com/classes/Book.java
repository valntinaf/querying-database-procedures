/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

/**
 *
 * @author valentina
 */
public class Book {
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private int rating;
    
    public String getTitle(){
        return this.title;
    }
    
    public String getAuthorFirstName(){
        return this.authorFirstName;
    }
    
    public String getAuthorLastName(){
        return this.authorLastName;
    }
    
    public int getRating(){
        return this.rating;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setAuthorFirstName(String authorFirstName){
        this.authorFirstName = authorFirstName;
    }
    
    public void setAuthorLastName(String authorLastName){
        this.authorLastName = authorLastName;
    }
    
    public void setRating(int rating){
        this.rating = rating;
    }
    
}