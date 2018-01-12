package com.tt.memento.service.impl;

import com.tt.memento.common.ServerResponse;
import com.tt.memento.common.util.MD5Util;
import com.tt.memento.dao.UserEntityMapper;
import com.tt.memento.model.UserEntity;
import com.tt.memento.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

/**
 * date: 2017/12/26
 * author: wt
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public ServerResponse doRegister(UserEntity userEntity) {
        userEntity.setPassword(MD5Util.MD5(userEntity.getPassword()));
        int count = userEntityMapper.insert(userEntity);
        if (count == 1) {
            return ServerResponse.success("注册成功");
        }
        return ServerResponse.error("注册失败");
    }

    @Override
    public ServerResponse doLogin(UserEntity userEntity) {

        return null;
    }
}
