package com.zjhz.authentication.dto;


import com.zjhz.authentication.vo.SysUserVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserDTO  implements Serializable {

    public UserDTO(){}
    public UserDTO(SysUserVO sysUserVO){
        BeanUtils.copyProperties(sysUserVO, this);
    }


    @ApiModelProperty(notes = "id",dataType="Integer",required = true)
    private Integer id;


    @ApiModelProperty(notes = "登陆名称",dataType="String",required = true)
    private String userName;

    @ApiModelProperty(notes = "登陆密码",dataType="String",required = true)
    private String password;

    @ApiModelProperty(notes = "盐",dataType="String",required = true)
    private String salt;

    @ApiModelProperty(notes = "昵称",dataType="String",required = true)
    private String nickName;

    @ApiModelProperty(notes = "性别(男：0,1:女)",dataType="String",required = true)
    private Integer sex;

    @ApiModelProperty(notes = "手机号",dataType="String",required = true)
    private String phone;

    @ApiModelProperty(notes = "用户头像",dataType="String",required = true)
    private String userLogo;



    private static final long serialVersionUID = 1L;


}