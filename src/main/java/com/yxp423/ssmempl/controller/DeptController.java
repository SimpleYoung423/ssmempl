package com.yxp423.ssmempl.controller;

import com.yxp423.ssmempl.bean.Dept;
import com.yxp423.ssmempl.service.IDeptService;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-29 19:08
 * @Version: 1.0
 */

@Controller
@RequestMapping("/adduser")
public class DeptController {

    @Autowired
    IDeptService deptService;


    @RequestMapping("/department")
    @ResponseBody
    public AjaxResult department(){

        AjaxResult result = new AjaxResult();

        List<Dept> deptList = deptService.getDepartment();

        if (deptList.size() > 0){

            result.setSuccess(true);
            result.setData(deptList);
        }else {
            result.setSuccess(false);
            result.setData(null);
        }

        return result;

    }

}
