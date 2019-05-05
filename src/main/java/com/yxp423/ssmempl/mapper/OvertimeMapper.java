package com.yxp423.ssmempl.mapper;

import com.yxp423.ssmempl.bean.Overtime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OvertimeMapper {

    @Insert("INSERT INTO overtime (user_id,start_time,end_time,duration,`desc`,festival,`status`,reviewerId) " +
            "VALUES (#{userId},#{startTime},#{endTime},#{duration},#{desc},#{festival},#{status},#{reviewerId})")

    /**
     * 保存加班申请
     */
    public int saveOvertimeApply(Overtime overtime);


}
