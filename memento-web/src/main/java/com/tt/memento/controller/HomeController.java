package com.tt.memento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * date: 2017/12/29
 * author: wt
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String index1() {
        return "index";
    }


    @RequestMapping("/home")
    public String home() {
        return "home";
    }

}
