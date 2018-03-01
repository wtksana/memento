package com.tt.memento.controller;

import com.tt.memento.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * date: 2018/3/1
 * author: wt
 */
public class BaseController {
    @Autowired
    private HttpSession session;

    protected UserEntity getSessionUser() {
        return (UserEntity) session.getAttribute("user_session");
    }
}
