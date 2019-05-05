package com.yxp423.ssmempl.mapper;


import com.yxp423.ssmempl.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionsMapper {

    /**
     * 获得所有省
     * @return
     */

    @Select("SELECT * FROM province")
     List<Province> getProvince();

    /**
     * 根据省ID获得省信息
     * @param provinceId
     * @return
     */
    @Select("SELECT * FROM province WHERE province_id=#{provinceId}")
    Province getProvinceById(String provinceId);

    /**
     * 获得所有城市
     * @return
     */
    @Select("SELECT * FROM city")
     List<City> getCity();

    /**
     * 根据市ID获得市的信息
     * @param cityId
     * @return
     */
    @Select("SELECT * FROM city WHERE city_id= #{cityId} ")
     City getCityByCityId(String cityId);

    /**
     * 根据省份获得该省份下的所有市
     * @param provinceId
     * @return
     */
    @Select("SELECT * FROM city WHERE province_id=#{provinceId}")
     List<City> getCityByProvinceId(String provinceId);

    /**
     * 获得所有区信息
     * @return
     */
    @Select("SELECT * FROM country")
     List<Country> getCountry();

    /**
     * 根据区ID获取区信息
     * @param countryId
     * @return
     */
    @Select("SELECT * FROM country WHERE country_id = #{countryId}")
     Country getCountryByCountryId(String countryId);

    /**
     * 根据城市ID获得该城市下的所有区
     * @param cityId
     * @return
     */
    @Select("SELECT * FROM country WHERE city_id=#{cityId}")
     List<Country> getCountryByCityId(String cityId);

    /**
     * 获得所有县
     * @return
     */
    @Select("SELECT * FROM town")
     List<Town> getTown();

    /**
     * 根据区ID获得该区下的所有县
     * @param countryId
     * @return
     */
    @Select("SELECT * FROM town WHERE country= #{countryId}")
     List<Town> getTownByCountryId(String countryId);



}
