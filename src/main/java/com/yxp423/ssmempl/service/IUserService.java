package com.yxp423.ssmempl.service;


import com.yxp423.ssmempl.bean.User;
import com.yxp423.ssmempl.utils.base.AjaxResult;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-18 17:11
 * @Version: 1.0
 */


public interface IUserService {

    /**
     *
     * 获得用户账号密码
     * @return
     */
     String getUserAccountPassword(User user);


    /**
     * 根据登录名获得用户
     * @param userAccount
     * @return
     */
     User getUserByAccount(String userAccount);


    /**
     * 保存用户信息
     * @param user
     * @return
     */
     AjaxResult saveUserInfo(User user,String province,String city,String country);


    /**
     * 根据角色编号模糊查询
     * @param roleCode
     * @return
     */
     List<User> getReviewer(String roleCode);


}
