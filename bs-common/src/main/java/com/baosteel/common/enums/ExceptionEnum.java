package com.baosteel.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    // 登录参数
    USERNAME_CNNNOT_BE_FULL(200,1002,"用户名不能为空"),
    PASSWORD_CNNNOT_BE_FULL(200,1002,"密码不能为空"),
    LOGINUSER_NOT_FIND(200,1003,"用户或密码错误"),
    PRE_IMAGE_CANNOT_FIND(200,1003,"无法找见最新的原始图像数据"),
    AFTER_IMAGE_CANNOT_FIND(200,1003,"无法与原始图像数据相对应的识别图片"),
    PRE_AFTER_IMAGE_CANNOT_MATCHING(200,1003,"原始图像数据与识别后的图像不一致")

    ;
    private int code;
    private int status;
    private String msg;
}
