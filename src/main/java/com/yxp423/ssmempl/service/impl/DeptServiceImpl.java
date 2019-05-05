package com.yxp423.ssmempl.service.impl;

import com.yxp423.ssmempl.bean.Dept;
import com.yxp423.ssmempl.mapper.DeptMapper;
import com.yxp423.ssmempl.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-29 19:05
 * @Version: 1.0
 */

@Service
public class DeptServiceImpl  implements IDeptService {

    @Autowired
    DeptMapper deptMapper;


    @Override
    public List<Dept> getDepartment() {


        List<Dept> depaList = deptMapper.getDepartment();


        return depaList;
    }
}
