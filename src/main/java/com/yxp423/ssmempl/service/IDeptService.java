package com.yxp423.ssmempl.service;

import com.yxp423.ssmempl.bean.Dept;

import java.util.List;

public interface IDeptService {

    /**
     * 获取所有部门信息
     * @return
     */
    public List<Dept> getDepartment();

}
