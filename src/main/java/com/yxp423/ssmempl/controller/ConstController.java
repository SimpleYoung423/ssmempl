package com.yxp423.ssmempl.controller;

import com.yxp423.ssmempl.bean.User;
import com.yxp423.ssmempl.service.IUserService;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import com.yxp423.ssmempl.utils.consts.UserConst;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 公共拦截器，如获取当前用户，获取审核人列表
 * @Author: yxp
 * @CreateDate: 2019-05-04 12:32
 * @Version: 1.0
 */
@Controller
@RequestMapping("/const")
public class ConstController {

    @Autowired
    private IUserService userService;



    @GetMapping("/getCurrentUsername")
    @ResponseBody
    public AjaxResult getCurrentUsername() {

        AjaxResult result = new AjaxResult();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String name = user.getName();
        result.setSuccess(true);
        result.setData(name);

        return result;
    }



    @GetMapping("/getReviewer")
    @ResponseBody
    public AjaxResult getReviewer() {

        AjaxResult result = new AjaxResult();

        List<User> userList = userService.getReviewer(UserConst.USER_ROLE_PROJECTMANAGE);
        if (userList != null) {

            result.setSuccess(true);
            result.setData(userList);
        }

        return result;
    }


}
