package com.yxp423.ssmempl.mapper;

import com.yxp423.ssmempl.bean.Travel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TravelMapper {

    @Insert("INSERT INTO travel " +
            "(travel.user_id," +
            "travel.start_time," +
            "travel.end_time," +
            "travel.duration," +
            "travel.place," +
            "travel.`desc`," +
            "travel.`status`," +
            "travel.reviewer_id) " +
            "VALUES (" +
            "#{userId}," +
            "#{startTime}," +
            "#{endTime}," +
            "#{duration}," +
            "#{place}," +
            "#{desc}," +
            "#{status}," +
            "#{reviewerId})"
    )
    int savetravel(Travel travel);




}
