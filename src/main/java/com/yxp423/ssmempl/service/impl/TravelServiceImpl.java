package com.yxp423.ssmempl.service.impl;

import com.yxp423.ssmempl.bean.Travel;
import com.yxp423.ssmempl.mapper.TravelMapper;
import com.yxp423.ssmempl.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-05-04 12:23
 * @Version: 1.0
 */
@Service
public class TravelServiceImpl implements ITravelService {

    @Autowired
    private TravelMapper travelMapper;

    @Override
    public int saveTravel(Travel travel) {
        int flag = -1;

        flag = travelMapper.savetravel(travel);
        return flag;
    }
}
