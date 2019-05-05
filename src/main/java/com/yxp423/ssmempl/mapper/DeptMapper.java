package com.yxp423.ssmempl.mapper;


import com.yxp423.ssmempl.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM sys_dept")
    public List<Dept> getDepartment();

}
