package com.yxp423.ssmempl.service;

import com.yxp423.ssmempl.bean.City;
import com.yxp423.ssmempl.bean.Country;
import com.yxp423.ssmempl.bean.Province;

import java.util.List;

public interface IRegionsService {

    /**
     * 获取所有省份
     * @return
     */
    public List<Province> getProvince();

    /**
     * 根据省份ID获取城市
     * @param provinceId
     * @return
     */
    public List<City> getCityByProvinceId(String provinceId);

    /**
     * 根据城市ID获取区
     * @param cityId
     * @return
     */
    public List<Country> getCountryByCityId(String cityId);


    Province getProvinceById(String provinceId);

    City getCityById(String cityId);

}
