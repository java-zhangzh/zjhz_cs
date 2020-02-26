package com.zjhz.authentication.vo;


import com.zjhz.base.model.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserVO extends BaseEntity implements Serializable {


    private String userName;

    private String password;

    private String salt;

    private String nickName;

    private Integer sex;

    private String phone;

    private String userLogo;



    private static final long serialVersionUID = 1L;


}