package com.tt.memento.service.impl;

import com.google.common.base.Strings;
import com.tt.memento.common.ServerResponse;
import com.tt.memento.common.util.MD5Util;
import com.tt.memento.dao.UserEntityMapper;
import com.tt.memento.model.UserEntity;
import com.tt.memento.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ServerResponse<UserEntity> doRegister(UserEntity userEntity) {
        userEntity.setPassword(MD5Util.MD5(userEntity.getPassword()));
        ServerResponse<UserEntity> check = this.checkExists(userEntity);
        if (!check.isSuccess()) {
            return check;
        }
        int count = userEntityMapper.register(userEntity);
        if (count == 1) {
            return ServerResponse.success("注册成功");
        }
        return ServerResponse.error("注册失败");
    }

    @Override
    public ServerResponse<UserEntity> checkExists(UserEntity userEntity) {
        if (!Strings.isNullOrEmpty(userEntity.getUsername())) {
            int count = userEntityMapper.checkUsernameExists(userEntity.getUsername());
            if (count > 0) {
                return ServerResponse.error("用户名已存在");
            }
        }
        if (!Strings.isNullOrEmpty(userEntity.getMobile())) {
            int count = userEntityMapper.checkMobileExists(userEntity.getMobile());
            if (count > 0) {
                return ServerResponse.error("手机号已存在");
            }
        }
        return ServerResponse.success();
    }

    @Override
    public ServerResponse<UserEntity> doLogin(UserEntity userEntity) {
        userEntity.setPassword(MD5Util.MD5(userEntity.getPassword()));
        UserEntity user = userEntityMapper.login(userEntity);
        if (user != null) {
            return ServerResponse.success("登录成功", user);
        }
        return ServerResponse.error("手机号或密码错误");
    }


}
