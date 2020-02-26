package com.zjhz.base.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AdminRole implements Serializable {
    private Long id;

    private String roleName;

    private String remarks;

    private Boolean isEnable;

    private Long createUser;

    private Long updateUser;

    private Date createDate;

    private Date updateDate;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;


}