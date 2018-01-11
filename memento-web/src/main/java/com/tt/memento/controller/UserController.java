package com.tt.memento.controller;

import com.tt.memento.common.ServerResponse;
import com.tt.memento.model.UserEntity;
import com.tt.memento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/register")
    @ResponseBody
    public ServerResponse register(@Validated UserEntity userEntity) {
        return userService.register(userEntity);
    }

    @PostMapping("/login")
    @ResponseBody
    public ServerResponse login(@Valid UserEntity userEntity) {
        return userService.login(userEntity);
    }
}
