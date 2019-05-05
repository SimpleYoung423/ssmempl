package com.yxp423.ssmempl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 村表实体类
 * @Author: yxp
 * @CreateDate: 2019-04-28 21:45
 * @Version: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Village {

    private Integer id;
    private String name;
    private String villageId;
    private String townId;


}
