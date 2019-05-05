package com.yxp423.ssmempl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 镇 表的实体类
 * @Author: yxp
 * @CreateDate: 2019-04-28 21:43
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Town {


    private Integer id;
    private String name;
    private String townId;
    private String countryId;

}
