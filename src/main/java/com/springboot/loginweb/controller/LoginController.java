package com.springboot.loginweb.controller;

import com.springboot.loginweb.processor.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginProcessor lp;

    @GetMapping("/")
    public String get(Model model){
        model.addAttribute("message","Enter your username and password");
        return "Login.html";
    }
    @PostMapping("/")
    public String post(@RequestParam String username,
                       @RequestParam String password,
                       Model model){
        boolean login = lp.login(username, password);
        if(login)
            model.addAttribute("message","You have successfully logged in!");
        else
            model.addAttribute("message","Username or password is incorrect");
        return "Main.html";
    }
}
