package com.baosteel.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SuccessEnum {
    // 登录参数
    LOGIN_SUCCESS(1000,"登陆成功"),
    GET_ASIDEMENU_SUCCESS(1000,"获得侧边栏菜单成功"),
            ;
    private int status;
    private String msg;
}
