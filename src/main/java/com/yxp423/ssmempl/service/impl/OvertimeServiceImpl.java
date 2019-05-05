package com.yxp423.ssmempl.service.impl;

import com.yxp423.ssmempl.bean.Overtime;
import com.yxp423.ssmempl.mapper.OvertimeMapper;
import com.yxp423.ssmempl.service.IOvertimeService;
import com.yxp423.ssmempl.utils.consts.ApplyConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-05-03 15:31
 * @Version: 1.0
 */

@Service
public class OvertimeServiceImpl implements IOvertimeService {

    @Autowired
    private OvertimeMapper overtimeMapper;


    @Override
    public int saveOvertimeApply(Overtime overtime) {
        int flag = -1;

        overtime.setStatus(ApplyConst.STATUS_CHECKING);


        try {

            flag = overtimeMapper.saveOvertimeApply(overtime);
        } catch (Exception e) {

            return flag;
        }
        return flag;
    }
}
