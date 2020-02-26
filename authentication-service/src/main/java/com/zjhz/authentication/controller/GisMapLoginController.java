package com.zjhz.authentication.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;


import com.zjhz.authentication.dto.UserDTO;
import com.zjhz.authentication.pvo.LoginPVO;
import com.zjhz.authentication.service.LoginUserService;
import com.zjhz.authentication.util.LoginVerification;
import com.zjhz.base.enums.ProcuctCodeEnum;
import com.zjhz.base.model.HttpResult;
import com.zjhz.base.model.UserInfo;
import com.zjhz.base.model.ValidResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <b>功能名：</b>登入controller<br>
 * <b>说明：</b>登入controller<br>
 * <b>著作权：</b> Copyright (C) zjhz  CORPORATION  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019/11/21  张忠豪
 */
@Api(description = "GISMAP登陆中心接口",tags="登陆中心接口")
@RestController
@RequestMapping(value = "/gismap")
public class GisMapLoginController {
    private static Logger logger = LoggerFactory.getLogger(GisMapLoginController.class);
    @Autowired
    private RedisTemplate redisCacheTemplate;
    @Autowired
    private LoginUserService loginUserService;
    @Value("${redisTime}")
    private String redisTime;

    /**
     * <b>方法名：</b>登入<br>
     * <b>说明：</b>登入时调用方法<br>
     * <b>@param </b>AuthRequestObject : 用户名  用户密码<br>
     * <b>@return：</b>LHttpResult 用户信息<br>
     * <b>修改履历：</b>
     *
     * @author 2019/11/21  张忠豪
     */
    @ApiOperation(value = "登录认证" ,  notes="登录认证")
    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    public HttpResult authLogin(@Valid @RequestBody LoginPVO requestParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }
        HttpResult result = new HttpResult();
        Subject subject = SecurityUtils.getSubject();
      /*  try {*/

            // 判断密码是否为空
            if (StringUtil.isEmpty(requestParam.getPassword())){
                result.setSuccess(false);
                result.setErrorMessage("账号或者密码错误");
                return result;
            }
            // 根据用户名查询账户信息
            UserDTO user = loginUserService.selectByUserName(requestParam.getName());

            // 账户不存在
            if (user == null) {
                result.setSuccess(false);
                result.setErrorMessage("账号不存在");
                return result;
            }
            System.out.println("========================================1");
            System.out.println("========================================1");
            System.out.println("========================================1");
            UserInfo userInfo = new UserInfo();
            userInfo.setId(user.getId().longValue());
            userInfo.setNickname(user.getNickName());
            userInfo.setUserName(user.getUserName());
            // 操作权限
            Set<String> permission = new HashSet<>();
            permission.add("clientGisMap");
            userInfo.setPermissionList(permission);
            System.out.println("========================================2");
            System.out.println("========================================2");
            System.out.println("========================================2");

            //清除重复登入
            LoginVerification.getAccountByDharmaByName(redisCacheTemplate, ProcuctCodeEnum.GisMap.getCode() + "," + userInfo.getId());
            System.out.println("========================================3");
            System.out.println("========================================3");
            System.out.println("========================================3");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("systemCode", ProcuctCodeEnum.GisMap.getCode());
            jsonObject.put("type", 1);
            UsernamePasswordToken token = new UsernamePasswordToken(requestParam.getName(), requestParam.getPassword(), true, jsonObject.toJSONString());
            System.out.println("========================================4");
            System.out.println("========================================4");
            System.out.println("========================================4");
            try {
                System.out.println("========================================5");
                System.out.println("========================================5");
                System.out.println("========================================5");
                subject.login(token);
                System.out.println("========================================6");
                System.out.println("========================================6");
                System.out.println("========================================6");
                JSONObject object = new JSONObject();
                String tokenStr = subject.getSession().getId() + "," + ProcuctCodeEnum.GisMap.getCode() + "," + userInfo.getId();
                object.put("token", tokenStr);
                object.put("userInfo", user);
                result.setModel(object);
                result.setSuccess(true);
                //添加到缓存中
                redisCacheTemplate.opsForValue().set(tokenStr, userInfo, Long.parseLong(redisTime), TimeUnit.HOURS);
                System.out.println("========================================7");
                System.out.println("========================================7");
                System.out.println("========================================7");
            } catch (UnknownAccountException e) {
                result.setSuccess(false);
                result.setErrorMessage("账号不存在");
            } catch (IncorrectCredentialsException e) {
                result.setSuccess(false);
                result.setErrorMessage("账号或者密码错误");
            }catch (LockedAccountException e) {
                result.setSuccess(false);
                result.setErrorMessage("账号已在其他处登录");
            }catch (ExcessiveAttemptsException e) {
                result.setSuccess(false);
                result.setErrorMessage("登录失败多次，账户锁定10分钟");
            }
      /*  } catch (Exception e) {
            result.fromException(e);
        }*/
        return result;
    }

    /**
     * <b>方法名：</b>退出<br>
     * <b>说明：</b>退出时调用方法<br>
     * <b>@return：</b><br>
     * <b>修改履历：</b>
     *
     * @author 2019/11/21  张忠豪
     */
    @ApiOperation(value = "退出登录" ,  notes="退出登录")
    @PostMapping(value = "/logout", produces = "application/json;charset=utf-8")
    public HttpResult logout() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");
        //清除
        ValueOperations<String, String> vo = redisCacheTemplate.opsForValue();
        vo.getOperations().delete(token);
        HttpResult result = new HttpResult();
        result.setSuccess(true);
        return result;
    }

}
