package com.yxp423.ssmempl.controller;

import com.yxp423.ssmempl.bean.City;
import com.yxp423.ssmempl.bean.Province;
import com.yxp423.ssmempl.bean.Travel;
import com.yxp423.ssmempl.bean.User;
import com.yxp423.ssmempl.service.IRegionsService;
import com.yxp423.ssmempl.service.ITravelService;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import com.yxp423.ssmempl.utils.consts.ApplyConst;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-05-04 12:25
 * @Version: 1.0
 */
@Controller
@RequestMapping("travel")
public class TravelController {

    @Autowired
    ITravelService travelService;
    @Autowired
    IRegionsService regionsService;

    @RequestMapping("applytravel")
    public String applyTravel() {


        return "applytravel";
    }

    @GetMapping("/submitApply")
    @ResponseBody
    public AjaxResult submitApply(Travel travel, String provinceId, String cityId) {

        AjaxResult result = new AjaxResult();
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        Province province = regionsService.getProvinceById(provinceId);
        City city = regionsService.getCityById(cityId);

        travel.setUserId(user.getUserId().toString());
        travel.setPlace(province.getName() + city.getName());
        travel.setStatus(ApplyConst.STATUS_CHECKING);
        int flag = -1;
        try {
            flag = travelService.saveTravel(travel);

        } catch (Exception e) {

            result.setSuccess(false);
            result.setMsg(e.getMessage());

        }

        if (flag > 0) {
            result.setSuccess(true);
            result.setMsg("保存成功");
        }


        return result;
    }

}
