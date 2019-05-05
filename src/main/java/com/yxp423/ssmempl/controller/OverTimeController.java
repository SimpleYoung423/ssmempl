package com.yxp423.ssmempl.controller;

import com.yxp423.ssmempl.bean.Overtime;
import com.yxp423.ssmempl.bean.User;
import com.yxp423.ssmempl.service.IOvertimeService;
import com.yxp423.ssmempl.service.IUserService;
import com.yxp423.ssmempl.utils.consts.UserConst;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-24 19:51
 * @Version: 1.0
 */
@Controller
@RequestMapping("/overtime")
public class OverTimeController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOvertimeService overtimeService;


    @GetMapping("/myovertime")
    public String overtime() {


        return "myovertime";
    }

    @GetMapping("/applyovertime")
    public String applyOvertime() {

        return "applyovertime";
    }


    @GetMapping("/submitApply")
    @ResponseBody
    public AjaxResult submitApply(Overtime overtime, String name, String date, String sTime, String eTime) throws ParseException {

        AjaxResult result = new AjaxResult();
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        if (user == null){
            result.setSuccess(false);
            result.setMsg("请登录");
            return result;
        }

        if (!user.getName().equals(name) ) {

            result.setSuccess(false);
            result.setMsg("申请人只能是当前登录账号人");
            return result;
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date dateStartTime = df.parse(date +" "+ sTime);
        Date dateEndTime = df.parse(date +" "+ eTime);

        overtime.setUserId(user.getUserId().toString());
        overtime.setStartTime(dateStartTime);
        overtime.setEndTime(dateEndTime);


        int flag = overtimeService.saveOvertimeApply(overtime);

        if (flag < 0) {
            result.setSuccess(false);
            result.setMsg("保存失败");


        }else {
            result.setSuccess(true);
            result.setMsg("保存成功");

        }

        return result;
    }
}
