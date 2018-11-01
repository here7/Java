package com.heredh7.lab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {

    @RequestMapping("/")
    public String aboutUs(){
        return "views/about-us";
    }

    @RequestMapping("/faq/")
    public String faq(){
        return "views/faq";
    }
}
