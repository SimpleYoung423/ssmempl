package com.yxp423.ssmempl.utils.base;

import lombok.*;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-20 22:32
 * @Version: 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AjaxResult {

    /**
     * 成功默认返回内容
     */
    public static final String RET_SUCCESS_MESSAGE = "响应成功";

    public static final String RESULT_CODE = "1";

    private boolean success;
    private String msg;
    private String error;
    private Object data;
    private String resultCode = RESULT_CODE;



}
