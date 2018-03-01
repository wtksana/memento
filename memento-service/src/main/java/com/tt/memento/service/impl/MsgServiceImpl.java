package com.tt.memento.service.impl;

import com.google.common.base.Strings;
import com.tt.memento.common.ServerResponse;
import com.tt.memento.common.util.Page;
import com.tt.memento.dao.MsgEntityMapper;
import com.tt.memento.model.MsgEntity;
import com.tt.memento.service.MsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * date: 2018/3/1
 * author: wt
 */
@Service
@Slf4j
public class MsgServiceImpl implements MsgService {
    @Autowired
    private MsgEntityMapper msgEntityMapper;

    @Override
    public ServerResponse<Page<List<MsgEntity>>> getRecentMsg(Long uid, Page<List<MsgEntity>> page) {
        List<MsgEntity> msgs = msgEntityMapper.getRecentMsg(uid, page);
        page.setData(msgs);
        return ServerResponse.success(page);
    }

    @Override
    public ServerResponse publishMsg(Long uid, Long gid, String content) {
        if (Strings.isNullOrEmpty(content)) {
            return ServerResponse.error("内容不能为空");
        }
        MsgEntity msgEntity = new MsgEntity(uid, gid, content);
        int count = msgEntityMapper.insertSelective(msgEntity);
        if (count == 1) {
            return ServerResponse.success("发布成功");
        }
        return ServerResponse.error("发布失败");
    }
}
