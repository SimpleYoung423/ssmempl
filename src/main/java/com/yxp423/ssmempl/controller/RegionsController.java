package com.yxp423.ssmempl.controller;

import com.yxp423.ssmempl.bean.City;
import com.yxp423.ssmempl.bean.Country;
import com.yxp423.ssmempl.bean.Province;
import com.yxp423.ssmempl.service.IRegionsService;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-29 15:45
 * @Version: 1.0
 */

@Controller
@RequestMapping("/regions")
public class RegionsController {

    @Autowired
    IRegionsService regionsService;



    @GetMapping("/province")
    @ResponseBody
    public AjaxResult getProvince(){

        AjaxResult result = new AjaxResult();
        List<Province> provinceList = regionsService.getProvince();


        if (provinceList.size() > 0){

            result.setSuccess(true);
            result.setMsg("获取省份成功");
            result.setData(provinceList);
        }

        return result;
    }

    @GetMapping("/cities")
    @ResponseBody
    public AjaxResult getCities(String provinceId){

        AjaxResult result = new AjaxResult();
        List<City> cityList = regionsService.getCityByProvinceId(provinceId);

        if (cityList.size() > 0){

            result.setSuccess(true);
            result.setData(cityList);

        }else {
            result.setSuccess(false);
            result.setMsg("获取城市列表失败");
        }

        return result;

    }


    @GetMapping("/country")
    @ResponseBody
    public AjaxResult getCountry(String cityId){

        AjaxResult result = new AjaxResult();
        List<Country> countryList = regionsService.getCountryByCityId(cityId);
        if (countryList.size() > 0){


            result.setSuccess(true);
            result.setData(countryList);

        }else{

            result.setSuccess(false);
            result.setMsg("获取区列表失败");
        }

        return result;

    }


}
