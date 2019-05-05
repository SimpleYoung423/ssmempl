package com.yxp423.ssmempl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Description: 省份表的实体类
 * @Author: yxp
 * @CreateDate: 2019-04-28 14:33
 * @Version: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Province {

    private Integer id;
    private String name;
    private String provinceId;
    private List children;
}
