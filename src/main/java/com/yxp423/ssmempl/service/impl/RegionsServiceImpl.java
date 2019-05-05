package com.yxp423.ssmempl.service.impl;

import com.yxp423.ssmempl.bean.City;
import com.yxp423.ssmempl.bean.Country;
import com.yxp423.ssmempl.bean.Province;
import com.yxp423.ssmempl.mapper.RegionsMapper;
import com.yxp423.ssmempl.service.IRegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-28 22:28
 * @Version: 1.0
 */
@Service
public class RegionsServiceImpl implements IRegionsService {

    @Autowired
    RegionsMapper regionsMapper;

    @Override
    public List<Province> getProvince() {

        List<Province> provinceList = regionsMapper.getProvince();



        return provinceList;
    }

    @Override
    public List<City> getCityByProvinceId(String provinceId) {

        List<City> cityList = regionsMapper.getCityByProvinceId(provinceId);

        return cityList;
    }

    @Override
    public List<Country> getCountryByCityId(String cityId) {

        List<Country> countryList = regionsMapper.getCountryByCityId(cityId);

        return countryList;
    }

    @Override
    public Province getProvinceById(String provinceId) {
        return regionsMapper.getProvinceById(provinceId);
    }

    @Override
    public City getCityById(String cityId) {
        return regionsMapper.getCityByCityId(cityId);
    }
}
