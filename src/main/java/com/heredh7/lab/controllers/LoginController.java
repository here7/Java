package com.heredh7.lab.controllers;

import com.heredh7.lab.entities.Login;
import com.heredh7.lab.entities.User;
import com.heredh7.lab.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView showLogin( HttpServletRequest request, HttpServletResponse response){
        ModelAndView my_model = new ModelAndView("login");
        my_model.addObject("login",new Login());

        return my_model;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {
        ModelAndView mav = null;
        User user = UserService.validateUser(login);

        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("username", user.getUsername());
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;

    }
}
