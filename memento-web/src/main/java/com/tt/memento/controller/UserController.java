package com.tt.memento.controller;

import com.tt.memento.common.ServerResponse;
import com.tt.memento.model.UserEntity;
import com.tt.memento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * date: 2017/12/26
 * author: wt
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/doRegister")
    @ResponseBody
    public ServerResponse doRegister(@Validated UserEntity userEntity) {
        return userService.doRegister(userEntity);
    }

    @RequestMapping("/login")
    public String login() {
        return "index";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public ServerResponse doLogin(@Valid UserEntity userEntity) {
        return userService.doLogin(userEntity);
    }
}
