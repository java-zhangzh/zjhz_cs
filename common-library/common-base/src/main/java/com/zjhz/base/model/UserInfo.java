package com.zjhz.base.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserInfo implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 账号
     */
    private String userName;
    /**
     * 名称
     */
    private  String  nickname;
    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 启用禁用
     */
    private Integer isEnable;
    /**
     * 操作权限
     */
    private Set<String>  permissionList;

    private static final long serialVersionUID = 1L;

}