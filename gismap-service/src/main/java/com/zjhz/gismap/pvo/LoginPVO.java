package com.zjhz.gismap.pvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by 12947 on 2019/11/26.
 */

@Data
public class LoginPVO {

    @NotNull(message="账号不能为空")
    @ApiModelProperty(notes = "账号",dataType="String",required = true)
    protected  String name;

    @NotNull(message="密码不能为空")
    @ApiModelProperty(notes = "密码",dataType="String")
    protected  String password;

    @ApiModelProperty(notes = "是否记住密码（暂时不用）",dataType="Integer")
    protected  boolean rememberMe;

    @ApiModelProperty(notes = "类型 1账号密码登入 2短信登入（暂时不用） ",dataType="Integer")
    protected  int type;
}
