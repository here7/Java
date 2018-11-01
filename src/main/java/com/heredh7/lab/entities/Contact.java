package com.heredh7.lab.entities;

public class Contact {
    private String messageForm;
/*
    public String Contact(){
        this.formContact = "";
    }*/

    public String getMessageFrom(){
        return this.messageForm;
    }

    public void setMessageForm(String messageForm){
        this.messageForm = messageForm;
    }
}
