package com.xsz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URLController {
    @GetMapping("/login")
    public String toLogin(){
        return "/login.html";
    }
}
