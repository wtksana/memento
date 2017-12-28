package com.tt.memento.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date: 2017/12/29
 * author: wt
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public Object index(){
        return "hello, sb";
    }
}
