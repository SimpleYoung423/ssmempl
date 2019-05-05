package com.yxp423.ssmempl.controller;

import com.yxp423.ssmempl.service.IFuncService;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-23 10:32
 * @Version: 1.0
 */

@Controller
@RequestMapping("/empl")
public class FuncController {


//    @Autowired
//    FuncMapper funcMapper;
    @Autowired
IFuncService funcService;


//    @RequestMapping("/firstMenu")
//    @ResponseBody
//    public AjaxResult firstMenu(){
//
//        AjaxResult result = funcService.getFirstMenu();
//        return  result;
//
//    }
//
//    @RequestMapping("/secondMenu")
//    @ResponseBody
//    public AjaxResult secondMenu(){
//
//        AjaxResult secondMenu = funcService.getSecondMenu();
//        return  secondMenu;
//
//    }

//
//    @RequestMapping("/myovertime")
//    public AjaxResult myOvertime(){
//
//
//        return
//    }


    @RequestMapping("/funcTree")
    @ResponseBody
    public AjaxResult funcTree(){

        AjaxResult result = funcService.findTree();

        return result;

    }



}
