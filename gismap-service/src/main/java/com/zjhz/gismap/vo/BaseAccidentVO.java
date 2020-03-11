package com.zjhz.gismap.vo;

import com.zjhz.base.model.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseAccidentVO extends BaseEntity implements Serializable {
    private Integer id;

    private String title;

    private Integer typeId;

    private Date time;

    private String place;

    private Double longitude;

    private Double latitude;

    private String details;

    private Integer createUser;

    private Date createDate;

    private Integer updateUser;

    private Date updateDate;

    private Integer isEnable;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

}