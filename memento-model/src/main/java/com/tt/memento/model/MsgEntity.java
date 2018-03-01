package com.tt.memento.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MsgEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 组id
     */
    private Long gid;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 状态，0正常
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除，0否，1是
     */
    private Integer deleteFlag;

    public MsgEntity() {
    }

    public MsgEntity(Long uid, Long gid, String content) {
        this.uid = uid;
        this.gid = gid;
        this.content = content;
    }
}