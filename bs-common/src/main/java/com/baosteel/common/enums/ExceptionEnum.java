package com.baosteel.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    // 登录参数
    USERNAME_CNNNOT_BE_FULL(200,1002,"用户名不能为空!"),
    PASSWORD_CNNNOT_BE_FULL(200,1002,"密码不能为空!"),
    LOGINUSER_NOT_FIND(200,1003,"未查询到对应用户!"),
            ;
    private int code;
    private int status;
    private String msg;
}
