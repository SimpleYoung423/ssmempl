package com.yxp423.ssmempl.service.impl;

import com.yxp423.ssmempl.bean.Func;
import com.yxp423.ssmempl.mapper.FuncMapper;
import com.yxp423.ssmempl.service.IFuncService;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-23 10:33
 * @Version: 1.0
 */
@Service
public class FuncServiceEmpl implements IFuncService {

    @Autowired
    FuncMapper funcMapper;


    @Override
    public AjaxResult getFirstMenu() {

        AjaxResult result = new AjaxResult();
        List<Func> firstMenu = funcMapper.getFirstMenu();
        for (Func menu : firstMenu) {
            List<Func> secondMenu = funcMapper.getSecondMenuByPid(menu.getFuncId());

        }

        if (firstMenu != null) {

            result.setSuccess(true);
            result.setData(firstMenu);
        } else {
            result.setSuccess(false);
            result.setMsg("没找到一级菜单");
        }
        return result;
    }

    @Override
    public AjaxResult getSecondMenu() {

        AjaxResult result = new AjaxResult();

        List<Func> secondMenu = funcMapper.getSecondMenu();
        if (secondMenu != null) {
            result.setSuccess(true);
            result.setData(secondMenu);

        } else {
            result.setSuccess(false);
            result.setMsg("没找到二级菜单");
        }

        return result;
    }





    public AjaxResult findTree() {

        AjaxResult result = new AjaxResult();

        //查询所有菜单
        List<Func> allMenu = funcMapper.getAllMenu();

        //根节点数组
        List<Func> rootMenu = new ArrayList<>();

        try {
            for (Func menu : allMenu) {

                //如果父节点是0，那么就是根节点（一级菜单）
                if (menu.getPid().equals("0")) {
                    rootMenu.add(menu);
                }
            }

            Collections.sort(rootMenu, order());

            //为根目录设置子菜单
            for (Func menu : rootMenu) {

                //获取根节点下的所有子节点
                List<Func> childList = getChildMenu(menu, allMenu);
                menu.setChildFunc(childList);

            }

            /**
             * 输出构建好的菜单数据。
             *
             */
//            data.put("success", "true");
//            data.put("list", rootMenu);
//            return data;

            result.setSuccess(true);
            result.setMsg("菜单加载成功!");
            result.setData(rootMenu);
            return result;

        }catch (Exception e){
//            data.put("success","false");
//            data.put("list", new ArrayList());
//            return data;
            result.setSuccess(false);
            result.setMsg("系统出错");
            return result;
        }

    }



    /**
     *
     * 对菜单排序
     */
    public Comparator<Func> order() {

        Comparator<Func> comparator = new Comparator<Func>() {
            @Override
            public int compare(Func o1, Func o2) {

                if (o1.getOrder() != o2.getOrder()) {

                    return o1.getOrder() - o2.getOrder();
                }

                return 0;
            }
        };

        return comparator;
    }


    public List<Func> getChildMenu(Func parentMenu , List<Func> allMenu) {

        //子菜单数组
        List<Func> childList = new ArrayList<>();

        // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
        for (Func menu : allMenu) {

            //相等说明：为该根节点的子节点。
            if (menu.getPid().equals(parentMenu.getFuncId())) {

                menu.setFuncUrl(parentMenu.getFuncUrl() + menu.getFuncUrl());
                childList.add(menu);
            }

        }

//        for (Func menu : childList) {
//
//            //递归
//            menu.setChildFunc(getChildMenu(menu.getFuncId(), childList));
//
//        }  //只有两级菜单 所以不用再递归查找下级
        Collections.sort(childList, order());//排序
        if (childList.size() == 0) {

            return new ArrayList<Func>();
        }

        return childList;
    }


    @Override
    public int saveFunc(Func func) {

        int flag = -1;

        flag = funcMapper.saveFunc(func);

        return flag;
    }

}
