package com.ohnal.chap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/sign-in")
public class RestPasswordController {

    @GetMapping("/pwsearch")
   private String passwordSearch() {



        return "chap/pwsearch";
    }

}
