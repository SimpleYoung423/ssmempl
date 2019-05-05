package com.yxp423.ssmempl.service;


import com.yxp423.ssmempl.bean.Func;
import com.yxp423.ssmempl.utils.base.AjaxResult;

public interface IFuncService {


    public AjaxResult getFirstMenu();

    public AjaxResult getSecondMenu();

    public AjaxResult findTree();

    int saveFunc(Func func);

}
