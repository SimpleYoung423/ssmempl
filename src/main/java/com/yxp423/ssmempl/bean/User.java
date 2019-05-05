package com.yxp423.ssmempl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-16 20:56
 * @Version: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {

    private Integer userId;
    private String userAccount;
    private String password;
    private String name;
    private String sex;
    private String idCard;
    private String phone;
    private String address;
    private Date creatTime;
    private Date updateTime;
    private String deptCode;
    private String status;
    private String userRole;

}
