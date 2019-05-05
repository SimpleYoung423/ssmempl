package com.yxp423.ssmempl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 区、乡、县的实体类表
 * @Author: yxp
 * @CreateDate: 2019-04-28 14:39
 * @Version: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Country {

    private Integer id;
    private String name;
    private String countryId;
    private String cityId;

}
