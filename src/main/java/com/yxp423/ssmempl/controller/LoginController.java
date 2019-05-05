package com.yxp423.ssmempl.controller;

import com.yxp423.ssmempl.utils.base.AjaxResult;
import com.yxp423.ssmempl.utils.base.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-16 22:03
 * @Version: 1.0
 */

@Controller
public class LoginController {


    Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping({"/", "loginPage"})
    public String loginPage() {

        return "login";
    }


    @GetMapping("/index")
    public String index(){

        return "index";
    }

//    登录验证

    @GetMapping("/login")
    @ResponseBody
    public AjaxResult login(String userAccount, String password) {

        AjaxResult result = new AjaxResult();
        String passwordMd5 = MD5.toMD5(password.getBytes());

        //获得subject对象
        Subject subject = SecurityUtils.getSubject();

        // 封装前端传来的用户信息，在UserRealm中可调用
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userAccount, passwordMd5);

        //执行登录操作
        try {
            //登陆成功
            subject.login(usernamePasswordToken);
            result.setSuccess(true);
            result.setMsg("登陆成功");

        } catch (UnknownAccountException e) { //UnknownAccountException 无此用户名异常

            result.setSuccess(false);
            result.setMsg("帐户不存在");

        } catch (IncorrectCredentialsException e) {
            result.setSuccess(false);
            result.setMsg("密码错误");

        }catch (LockedAccountException e){
            result.setSuccess(false);
            result.setMsg("账号已被冻结");

        } catch (AuthenticationException e) {//AuthenticationException:认证异常
            e.printStackTrace();
        }


        return result;
    }



    @GetMapping("/logout")
    @ResponseBody
    public AjaxResult logout(){

        AjaxResult result = new AjaxResult();
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();

        result.setSuccess(true);
        result.setMsg("退出成功");

        return result;
    }
}
