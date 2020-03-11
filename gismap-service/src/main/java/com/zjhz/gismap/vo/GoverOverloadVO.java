package com.zjhz.gismap.vo;

import com.zjhz.base.model.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class GoverOverloadVO extends BaseEntity implements Serializable {
    private Integer id;

    private Integer checkStationId;

    private Integer roadId;

    private String overloadType;

    private Date time;

    private Integer carCount;

    private Integer createUser;

    private Date createDate;

    private Integer updateUser;

    private Date updateDate;

    private Integer isEnable;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

}