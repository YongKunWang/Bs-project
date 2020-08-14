package com.baosteel.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baosteel.common.enums.ExceptionEnum;
import com.baosteel.common.enums.SuccessEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应状态
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Meta {
    @JSONField(ordinal = 1)
    Integer status;  // 响应码
    @JSONField(ordinal = 2)
    String msg;    // 响应信息

    public Meta(SuccessEnum successEnum){
        this.setStatus(successEnum.getStatus());
        this.setMsg(successEnum.getMsg());
    }
    public Meta(ExceptionEnum exceptionEnum){
        this.setStatus(exceptionEnum.getStatus());
        this.setMsg(exceptionEnum.getMsg());
    }
}

