package com.zjhz.base.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MenuPermission implements Serializable {
    private Long id;

    private Long menuId;

    private String name;

    private Boolean isEnable;

    private String code;

    private Long createUser;

    private Long updateUser;

    private Date createDate;

    private Date updateDate;

    private Integer isDeleted;

    private String remarks;

    private static final long serialVersionUID = 1L;

}