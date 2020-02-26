package com.zjhz.authentication.service.impl;




import com.zjhz.authentication.dao.SysUserMapper;
import com.zjhz.authentication.dto.UserDTO;
import com.zjhz.authentication.enums.AuthenticationEnum;
import com.zjhz.authentication.exception.AuthenticationException;
import com.zjhz.authentication.service.LoginUserService;



import com.zjhz.authentication.vo.SysUserVO;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>功能名：</b>HeadmasterServiceImpl<br>
 * <b>说明：</b>登入controller<br>
 * <b>著作权：</b> Copyright (C) 2018 WULUXIXING  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019/11/21  张忠豪
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    SysUserMapper userMapper;

    public UserDTO selectByUserName(String name) {
        SysUserVO sysUserVO=   userMapper.selectByUserName(name);
        if(sysUserVO==null){
            throw  new AuthenticationException(AuthenticationEnum.AccountNotExisted);
        }
        UserDTO  sysUserDTO = new UserDTO(sysUserVO);
        return sysUserDTO;
    }


}