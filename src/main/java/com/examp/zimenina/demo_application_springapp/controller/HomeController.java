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
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PostService postService;

    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest request) {
        User loggedInUser = (User) request.getSession().getAttribute(
                "loggedInUser");
        if (loggedInUser != null) {
            logger.info(loggedInUser.getUsername());
            model.addAttribute("fullname", loggedInUser.getFullname());
            model.addAttribute("allPostFromUser",
                    this.postService.getAllPost(loggedInUser.getId()));
            return "home";
        }
        return "/";
    }
}
