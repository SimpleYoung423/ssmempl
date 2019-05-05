package com.yxp423.ssmempl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.awt.*;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-23 10:01
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Func {

    private  String funcId;
    private String funcName;
    private  String funcUrl;
    private String funcLevel;
    private String pid;
    private  String icon;
    private int order;
    private String userRole;
    private List<Func> childFunc;//存放子菜单

}
