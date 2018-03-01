package com.tt.memento.controller;

import com.tt.memento.common.ServerResponse;
import com.tt.memento.common.util.Page;
import com.tt.memento.model.MsgEntity;
import com.tt.memento.model.UserEntity;
import com.tt.memento.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * date: 2018/3/1
 * author: wt
 */
@Controller("/msg")
public class MsgController extends BaseController {

    @Autowired
    private MsgService msgService;

    @PostMapping("/publishMsg")
    @ResponseBody
    public ServerResponse publishMsg(String content, Long gid) {
        UserEntity user = getSessionUser();
        if (user == null) {
            return ServerResponse.error("用户未登录");
        }
        return msgService.publishMsg(user.getId(), gid, content);
    }

    @PostMapping("/getRecentMsg")
    @ResponseBody
    public ServerResponse<Page<List<MsgEntity>>> getRecentMsg(Page<List<MsgEntity>> page) {
        UserEntity user = getSessionUser();
        if (user == null) {
            return ServerResponse.error("用户未登录");
        }
        return msgService.getRecentMsg(user.getId(), page);
    }
}
