package com.yxp423.ssmempl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-29 18:58
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Dept {

    private Integer deptId;
    private String deptCode;
    private String deptName;

}
