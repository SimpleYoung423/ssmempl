package com.yxp423.ssmempl.controller;

import com.yxp423.ssmempl.bean.Func;
import com.yxp423.ssmempl.bean.User;
import com.yxp423.ssmempl.service.IFuncService;
import com.yxp423.ssmempl.service.IUserService;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-25 15:20
 * @Version: 1.0
 */

@Controller
@RequestMapping("/system")
public class SysController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IFuncService funcService;

    @RequestMapping("/adduser")
    public String addUser() {


        return "adduser";
    }

    @GetMapping("/checkUserAccount")
    @ResponseBody
    public AjaxResult checkUserAccount(String userAccount) {

        AjaxResult result = new AjaxResult();
        User user = userService.getUserByAccount(userAccount);

        if (user == null) {
            result.setSuccess(true);
            result.setMsg("用户名可用");
        } else {
            result.setSuccess(false);
            result.setMsg("该用户名已存在");
        }


        return result;
    }


    @GetMapping("/saveUserInfo")
    @ResponseBody
    public AjaxResult saveUserInfo(User user, String provinceId, String cityId, String countryId) {
        AjaxResult result = new AjaxResult();

        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();

        if (currentUser == null) {

            result.setSuccess(false);
            result.setMsg("你没有操作权限,请登录");
            return result;
        }

        result = userService.saveUserInfo(user, provinceId, cityId, countryId);


        return result;
    }

    @GetMapping("/funcmana")
    public String funcManage() {

        return "funcmana";
    }

    @GetMapping("addFunc")
    @ResponseBody
    public AjaxResult addFunc(Func func) {

        AjaxResult result = new AjaxResult();
        int flag = funcService.saveFunc(func);
        if (flag > 0){
            result.setSuccess(true);
            result.setMsg("添加成功");
        }

        return result;
    }

}
