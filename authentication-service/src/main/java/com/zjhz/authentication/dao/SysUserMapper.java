package com.zjhz.authentication.dao;

import com.zjhz.authentication.domain.SysUser;

import com.zjhz.authentication.vo.SysUserVO;
import com.zjhz.base.model.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserVO> {


    /**
     * 查找用户信息
     * @param userName
     * @return  SysUserVO
     */
     SysUserVO selectByUserName (@Param("userName")String userName);


}