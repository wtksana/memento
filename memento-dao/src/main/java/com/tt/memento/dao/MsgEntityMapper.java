package com.tt.memento.dao;

import com.tt.memento.common.util.Page;
import com.tt.memento.model.MsgEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface MsgEntityMapper {

    int insert(MsgEntity msgEntity);

    int insertSelective(MsgEntity msgEntity);

    MsgEntity select(Long id);

    int update(MsgEntity msgEntity);

    int delete(Long id);

    int updateSelective(MsgEntity msgEntity);

    void batchUpdate(List<MsgEntity> msgEntityList);

    List<MsgEntity> getRecentMsg(@Param("uid") Long uid, @Param("page") Page<List<MsgEntity>> page);
}