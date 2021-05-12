package com.examp.zimenina.demo_application_springapp.controller;

import com.examp.zimenina.demo_application_springapp.domain.User;
import com.examp.zimenina.demo_application_springapp.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = LoggerFactory
            .getLogger(IndexController.class);
    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest request) {
        logger.info("Welcome home! The client locale is {}.", locale);
        model.addAttribute("allPost", this.postService.getAllPost());
        User loggedInUser = (User)request.getSession().getAttribute("loggedInUser");
        if( loggedInUser != null ){
            model.addAttribute("loggedIn", true);
        }
        return "index";
    }
}
