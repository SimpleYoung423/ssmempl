package com.yxp423.ssmempl.service;

import com.yxp423.ssmempl.bean.Overtime;

public interface IOvertimeService {

    /**
     * 保存加班申请信息
     * @param overtime
     * @return
     */
    int saveOvertimeApply(Overtime overtime);

}
