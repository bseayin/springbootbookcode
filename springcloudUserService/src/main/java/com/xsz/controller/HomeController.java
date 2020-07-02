package com.xsz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping({"/", "/success"})
    public String toIndex() {
        return "/index.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toogin() {
        return "/login.html";
    }


}
