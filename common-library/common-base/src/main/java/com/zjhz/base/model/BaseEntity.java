package com.zjhz.base.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by 12947 on 2019/11/26.
 */
@Data
public class BaseEntity {


    private Integer id;

    private Integer createUser;

    private Date createDate;

    private Integer updateUser;

    private Date updateDate;

    private Integer isDeleted;


}
