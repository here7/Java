package com.heredh7.lab.services;

import com.heredh7.lab.entities.Login;
import com.heredh7.lab.entities.User;

import java.util.Date;

public class UserService {
    public static User validateUser( Login login ){
        //PARAMS: int id, String username, String password, Date start_date, Date stop_date, int active
        Date start_date = new Date();
        Date stop_date = new Date();
        User new_user = new User(1,"dani","123", start_date, stop_date, 1);
        return new_user;
    }
}
