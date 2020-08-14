package com.baosteel.common.vo.exception;

import com.baosteel.common.enums.ExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum em){
        this.status = em.getStatus();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
