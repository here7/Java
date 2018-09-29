package com.heredh7.lab.entities;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private Date start_date;
    private Date stop_date;
    private int active;

    public User(){

    }

    public User(int id, String username, String password, Date start_date, Date stop_date, int active){
        this.id = id;
        this.username = username;
        this.password = password;
        this.start_date = start_date;
        this.stop_date = stop_date;
        this.active = active;
    }

    /**
     * GETTERS
     */

    public int getId() {
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public Date getStart_date(){
        return this.start_date;
    }

    public Date getStop_date(){
        return this.stop_date;
    }

    public int getActive(){
            return this.active;
    }


    /**
     * SETTERS
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setStart_date(Date start_date){
        this.start_date = start_date;
    }

    public void getStop_date(Date stop_date){
        this.stop_date = stop_date;
    }

    public void setActive(int active){
        this.active = active;
    }
}
