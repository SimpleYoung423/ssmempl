package com.yxp423.ssmempl.mapper;

import com.yxp423.ssmempl.bean.Func;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-23 10:28
 * @Version: 1.0
 */

@Mapper
public interface FuncMapper {


    @Select("SELECT * FROM sys_func WHERE func_level = '1' ")
    public List<Func> getFirstMenu();


    @Select("SELECT * FROM sys_func")
    public List<Func> getAllMenu();


    @Select("SELECT * FROM sys_func WHERE func_level = '2' ")
    public List<Func> getSecondMenu();

    @Select("SELECT * FROM sys_func WHERE pid = #{pid} ")
    public List<Func> getSecondMenuByPid(String pid);

    @Insert("INSERT INTO sys_func(func_name,func_url,func_level,pid,`order`) " +
            "VALUES(#{funcName},#{funcUrl},#{funcLevel},#{pid},#{order})")
    int saveFunc(Func func);


}
