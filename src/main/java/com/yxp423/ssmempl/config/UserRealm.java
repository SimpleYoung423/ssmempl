package com.yxp423.ssmempl.config;

import com.yxp423.ssmempl.bean.User;
import com.yxp423.ssmempl.mapper.UserMapper;
import com.yxp423.ssmempl.service.IUserService;
import com.yxp423.ssmempl.utils.consts.UserConst;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-20 10:59
 * @Version: 1.0
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    @Autowired
    IUserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

//        logger.info("---------执行认证逻辑----------");

        //token是Controller中封装前端传来的用户信息的usernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;

        //根据前端输入的用户名趋数据库中查询
        User user = userMapper.getUserByUserAccount(usernamePasswordToken.getUsername());

        if (user==null){

           throw  new UnknownAccountException();
        }
        if(user.getStatus().equals(UserConst.USER_STUTAS_FREEZE)){
           throw  new LockedAccountException();
        }


        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), "");

        return info;
    }





    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

//        logger.info("---------执行授权逻辑----------");


        return null;
    }

}
