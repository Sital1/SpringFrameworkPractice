package com.sital.web_scopes.controllers;

import com.sital.web_scopes.services.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private RandomNumberService numberService; //proxy

    @GetMapping("index")
    public String indexAction(Model model){
        model.addAttribute("message",numberService.getValue());
        return "index.html";
    }
}
