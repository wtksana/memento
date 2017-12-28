package com.tt.memento.dao;


import com.tt.memento.model.UserEntity;

import java.util.List;

public interface UserEntityMapper {

    int insert(UserEntity userEntity);

    UserEntity select(Long id);

    int update(UserEntity userEntity);

    int delete(Long id);

    int updateSelective(UserEntity userEntity);

    void batchUpdate(List<UserEntity> userEntityList);

}