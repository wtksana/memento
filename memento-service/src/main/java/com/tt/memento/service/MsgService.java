package com.tt.memento.service;

import com.tt.memento.common.ServerResponse;
import com.tt.memento.common.util.Page;
import com.tt.memento.model.MsgEntity;

import java.util.List;

/**
 * date: 2018/3/1
 * author: wt
 */
public interface MsgService {
    ServerResponse<Page<List<MsgEntity>>> getRecentMsg(Long uid, Page<List<MsgEntity>> page);

    ServerResponse publishMsg(Long uid, Long gid, String content);
}
