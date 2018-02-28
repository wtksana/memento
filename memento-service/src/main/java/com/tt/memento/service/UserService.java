package com.tt.memento.service;

import com.tt.memento.common.ServerResponse;
import com.tt.memento.model.UserEntity;

/**
 * date: 2017/12/26
 * author: wt
 */
public interface UserService {
    ServerResponse<UserEntity> doRegister(UserEntity userEntity);

    ServerResponse<UserEntity> doLogin(UserEntity userEntity);

    ServerResponse<UserEntity> checkExists(UserEntity userEntity);

}
