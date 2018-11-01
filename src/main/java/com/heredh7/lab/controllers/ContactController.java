package com.heredh7.lab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @RequestMapping("/")
    public String contactPage(Model model){
        model.addAttribute("messageForm","kjkljkl");
        return "views/contact";
    }

}
