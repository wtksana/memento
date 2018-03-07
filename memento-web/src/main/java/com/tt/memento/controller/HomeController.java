package com.tt.memento.controller;

import com.tt.memento.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * date: 2017/12/29
 * author: wt
 */
@Controller
public class HomeController extends BaseController {

    @RequestMapping("/")
    public String index() {
        UserEntity userEntity = getSessionUser();
        if (userEntity != null) {
            return "redirect:/home";
        }
        return "index";
    }

    @RequestMapping("/index")
    public String index1() {
        return "redirect:/";
    }


    @RequestMapping("/home")
    public String home() {
        return "home";
    }

}
