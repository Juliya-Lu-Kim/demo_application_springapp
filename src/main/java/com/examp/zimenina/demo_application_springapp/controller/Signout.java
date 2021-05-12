package com.examp.zimenina.demo_application_springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signout")
public class Signout {
    @RequestMapping( method = RequestMethod.GET)
    public String signOut(HttpServletRequest request ){
        request.getSession().setAttribute("loggedInUser", null);
        return "redirect:/";
    }
}
