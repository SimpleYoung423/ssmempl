package com.yxp423.ssmempl.service.impl;


import com.yxp423.ssmempl.bean.City;
import com.yxp423.ssmempl.bean.Country;
import com.yxp423.ssmempl.bean.Province;
import com.yxp423.ssmempl.bean.User;
import com.yxp423.ssmempl.mapper.RegionsMapper;
import com.yxp423.ssmempl.mapper.UserMapper;
import com.yxp423.ssmempl.service.IUserService;
import com.yxp423.ssmempl.utils.consts.UserConst;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import com.yxp423.ssmempl.utils.base.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-18 17:13
 * @Version: 1.0
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RegionsMapper regionsMapper;


    @Override
    public String getUserAccountPassword(User user) {


        return userMapper.getPasswordByUsername(user.getName());
    }

    @Override
    public User getUserByAccount(String userAccount) {

        User user = userMapper.getUserByUserAccount(userAccount);
        return user;
    }

    @Override
    public AjaxResult saveUserInfo(User user, String provinceId, String cityId, String countryId) {

        AjaxResult result = new AjaxResult();

        if (userMapper.getUserByIdcard(user.getIdCard()) != null) {
            result.setSuccess(false);
            result.setMsg("当前已存在该身份证号的用户");
            return result;

        } else if (userMapper.getUserByPhone(user.getPhone()) != null) {
            result.setSuccess(false);
            result.setMsg("当前已存在该手机号的用户");
            return result;

        } else if (userMapper.getUserByUserAccount(user.getUserAccount()) != null) {

            result.setSuccess(false);
            result.setMsg("当前已存在该用户名的用户");
            return result;

        } else {

            Province province = regionsMapper.getProvinceById(provinceId);

            City city = regionsMapper.getCityByCityId(cityId);

            Country country = regionsMapper.getCountryByCountryId(countryId);

            user.setAddress(province.getName() + city.getName() + country.getName());//设置地址

            user.setPassword(MD5.toMD5(user.getPassword().getBytes()));
            user.setStatus(UserConst.USER_STUTAS_ACTIVITY);
            user.setCreatTime(new Date());
            user.setUpdateTime(new Date());


            try {
                userMapper.inserUser(user);
                result.setSuccess(true);
                result.setMsg("保存用户信息成功");
            }catch (Exception e){
                result.setSuccess(false);
                result.setMsg(e.getMessage());
            }

        }
        return result;
    }

    @Override
    public List<User> getReviewer(String roleCode) {



        return userMapper.getReviewer(roleCode);
    }


}
