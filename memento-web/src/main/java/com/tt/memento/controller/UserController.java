package com.tt.memento.controller;

import com.tt.memento.common.ServerResponse;
import com.tt.memento.model.UserEntity;
import com.tt.memento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * date: 2017/12/26
 * author: wt
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ServerResponse register(@Valid UserEntity userEntity){
        return userService.register(userEntity);
    }
}
