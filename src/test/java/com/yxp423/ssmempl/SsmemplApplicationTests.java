package com.yxp423.ssmempl;

import com.alibaba.druid.filter.config.ConfigTools;
import com.yxp423.ssmempl.bean.Dept;
import com.yxp423.ssmempl.bean.Func;
import com.yxp423.ssmempl.bean.Overtime;
import com.yxp423.ssmempl.bean.User;
import com.yxp423.ssmempl.mapper.*;
import com.yxp423.ssmempl.service.IRegionsService;
import com.yxp423.ssmempl.service.impl.FuncServiceEmpl;
import com.yxp423.ssmempl.service.impl.UserService;
import com.yxp423.ssmempl.utils.base.AjaxResult;
import com.yxp423.ssmempl.utils.base.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmemplApplicationTests {


    @Autowired
    DataSource dataSource;

    @Autowired
    ApplicationContext application;

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    FuncMapper funcMapper;

    @Autowired
    FuncServiceEmpl funcService;

    @Autowired
    RegionsMapper regionsMapper;

    @Autowired
    IRegionsService regionsService;

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    OvertimeMapper overtimeMapper;

    @Test
    public void contextLoads() {

        System.out.println(dataSource.getClass());


    }

    @Test
//    druid加密
    public void test1() throws Exception {

        System.out.println(ConfigTools.decrypt("123456"));


    }

    @Test
    //md5加密
    public void test2() {

        String password = "123456";
        String s = MD5.toMD5(password.getBytes());
        System.out.println(s);//e10adc3949ba59abbe56e057f20f883e

        String salt = "fff00";
        String md5 = MD5.toMD5((password + salt).getBytes());
        System.out.println(md5);


    }

//    @Test
//    public void  test3(){
//
//        User user = new User();
//        user.setUserAccount("yxp");
//        System.out.println(user);
//        String usernamePassword = userService.getUserByAccount(user.);
//
//        System.out.println(usernamePassword);
//
//    }

    @Test
    public void test4() {

        User user = userMapper.getUserById(1);

        System.out.println(user);

    }

    //    druid解密
    @Test
    public void test5() throws Exception {

        String password = "ed2IeC5oFiM0kFtwBbKFhOZUIhdDSZj8fGhIJ/ADRh5lvnUbzAkY5eWX2uX8NmJAfQRdrD4Rk3xYmkfhyQAV+g==";

        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAL6pRszWZneUt2RHIvwglToXFyuHR7XWGuGArtZzZuaLq4HIAIMRoNe61YTaNFOSwWByL1asnaEIT5gKT6gP4jECAwEAAQ==";

        String decrypt = ConfigTools.decrypt(publicKey, password);
        System.out.println(decrypt);//19960423
    }

    @Test
    public void test6() {

        List<Func> allMenu = funcMapper.getAllMenu();
        for (Func menu : allMenu) {
            System.out.println(menu);
        }


    }

    @Test
    public void test7() {


        funcService.findTree();

    }

    @Test
    public void test8() {

        regionsService.getProvince();


    }

    @Test
    public void test9() {

        List<Dept> department = deptMapper.getDepartment();
        System.out.println(department);

    }

    @Test
    public void test10() {

        regionsService.getCityByProvinceId("450000000000");

    }
    @Test
    public void test11() {

        Overtime overtime = new Overtime(3,"1",new Date(),new Date(),"1","2","单元测试","1","1");
        overtimeMapper.saveOvertimeApply(overtime);

    }

}
