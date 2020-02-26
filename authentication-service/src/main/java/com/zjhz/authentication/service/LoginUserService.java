package com.zjhz.authentication.service;


import com.zjhz.authentication.dto.UserDTO;

/**
 * <b>功能名：</b>LoginUserService<br>
 * <b>说明：</b>登入controller<br>
 * <b>著作权：</b> Copyright (C) 2018 zjhz  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019/11/21  张忠豪
 */
public interface LoginUserService {


    /**
    * <b>方法名：</b>查询用户<br>
    * <b>说明：</b> <br>
    * <b>@param </b>[name]<br>
    * <b>@return：</b>ccom.zjhz.base.model.HeadmasterInfo<br>
    * <b>修改履历：</b>
    *
    * @author 2019/11/21   zhangzhonghao
    */
    UserDTO selectByUserName(String name);


}

