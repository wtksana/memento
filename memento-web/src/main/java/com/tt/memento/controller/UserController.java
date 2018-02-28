package com.tt.memento.controller;

import com.tt.memento.common.ServerResponse;
import com.tt.memento.common.valid.AddGroup;
import com.tt.memento.model.UserEntity;
import com.tt.memento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    public ServerResponse doRegister(@Validated(AddGroup.class) UserEntity userEntity, HttpSession session) {
        ServerResponse<UserEntity> resp = userService.doRegister(userEntity);
        if (resp.isSuccess()) {
            session.setAttribute("user_session", resp.getData());
        }
        return resp;
    }

    @RequestMapping("/login")
    public String login() {
        return "index";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public ServerResponse doLogin(@Validated UserEntity userEntity, HttpSession session) {
        ServerResponse<UserEntity> resp = userService.doLogin(userEntity);
        if (resp.isSuccess()) {
            session.setAttribute("user_session", resp.getData());
        }
        return resp;
    }

    @GetMapping("/logout")
    @ResponseBody
    public ServerResponse logout(HttpSession session) {
        session.removeAttribute("user_session");
        return ServerResponse.success();
    }
}
