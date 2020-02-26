package com.zjhz.authentication.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjhz.authentication.dao.SysUserMapper;
import com.zjhz.authentication.vo.SysUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;

/**
 * @author: zhangzhonghao
 * @description: 自定义Realm
 * @date: 2019/11/25  */
public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);


    @Resource
    SysUserMapper sysUserMapper;

    /**
     * 授权,调用checkRole/checkPermission/hasRole/isPermitted都会执行该方法
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        return authorizationInfo;
    }






    /**
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        String username = (String) authcToken.getPrincipal();
        String password = new String((char[]) authcToken.getCredentials());

        //把AuthenticationToken转换为UsernamePasswordToken,token中储存着输入的用户名和密码 ,用户名用来确定账号是否存在,密码用来盐值加密

        UsernamePasswordToken userToken = (UsernamePasswordToken) authcToken;
        //获取系统管理员账号
        String uname = userToken.getUsername();
        //获取当前登入的系统
        String systemName=userToken.getHost();
        Object principal = null;
        String realmName = "";
        Object credentials = null;
        ByteSource credentialsSalt =null;
        JSONObject jsonObject = JSON.parseObject(systemName);
        //区别登入类型  1.账号密码登入  2 短信登入
        int type=jsonObject.getInteger("type");
        int systemCode=jsonObject.getInteger("systemCode");
        //根据系统管理员账号获取系统管理员信息
        SysUserVO user= sysUserMapper.selectByUserName(uname);

        //系统管理员存在则进行密码校验，否则，抛出异常：系统管理员不存在;
        if (user == null) {
            throw new UnknownAccountException("不存在该用户");
        }
        if(type==1&&(user.getSalt()==null||user.getUserName()==null)){
            throw new IncorrectCredentialsException("账号密码错误");
        }
        //principal：认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对象
        principal = user.getUserName();
        //credentials：数据库中的密码
        credentials = user.getPassword();
        //realmName：当前realm对象的name，调用父类的getName()方法即可
        realmName = getName();
        //credentialsSalt盐值
        if(user.getSalt()!=null) {
            credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        }

        //下面是 单点登陆 （同一时间段只能有一个人登陆）
        //处理session
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
        /*for(Session session:sessions) {

            //判断用是否登录
            SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (simplePrincipalCollection != null) {
                String name = (String) simplePrincipalCollection.getPrimaryPrincipal();
                if (user != null && username.equals(name)) {
                    //session超时
                    if ((new Date().getTime() - session.getStartTimestamp().getTime()) >= session.getTimeout()) {
                        sessionManager.getSessionDAO().delete(session);//移除（提出用户）
                    } else {
                        //sessionManager.getSessionDAO().delete(session);//移除（提出用户）
                       throw new LockedAccountException("账号已在其他处登录");//不移除（不允许其他人登录相同用户）
                    }
                }
            }
        }
*/
        //根据用户的情况，来构建AuthenticationInfo对象,通常使用的实现类为SimpleAuthenticationInfo
        //【与数据库中用户名和密码进行比对，密码盐值加密】
        return new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
    }
}

