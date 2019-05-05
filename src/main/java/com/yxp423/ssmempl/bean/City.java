package com.yxp423.ssmempl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 城市表的实体类
 * @Author: yxp
 * @CreateDate: 2019-04-28 14:35
 * @Version: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class City {

    private Integer id;
    private String name;
    private String cityId;
    private String provinceId;

}
