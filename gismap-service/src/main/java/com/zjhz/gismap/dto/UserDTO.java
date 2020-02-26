package com.zjhz.gismap.dto;

import com.zjhz.gismap.domain.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * <b>功能名：</b>UserDTO<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2019 ZJHZ  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019-05-13 hufeng
 */
@Data
public class UserDTO {
    public  UserDTO(){}
    public  UserDTO(User user){
        BeanUtils.copyProperties(user, this);
    }

    private  String id;
    private  String name;
    private  Integer sex;

    private String teacherId;
    private String semeterId;
    private String teacherUserId;
    private String kgId;
    private String childId;

    private String userName;

    private String password;

    private String phone;

    private String code;
}
