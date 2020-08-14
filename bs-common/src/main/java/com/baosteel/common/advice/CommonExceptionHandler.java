package com.baosteel.common.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baosteel.common.enums.ExceptionEnum;
import com.baosteel.common.exception.BsException;
import com.baosteel.common.vo.Meta;
import com.baosteel.common.vo.exception.ExceptionRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

//    // 原始版本的异常返回，由于不符合自定义的标准数据格式，于是在此基础上进行了修改！
//    @ExceptionHandler(BsException.class)
//    public ResponseEntity<ExceptionResult> handleException(BsException e){
//        ExceptionEnum exceptionEnum = e.getExceptionEnum();
//
//        return ResponseEntity.status(exceptionEnum.getCode()).body(new ExceptionResult(exceptionEnum));
//    }

    /**
     * 非正确数据的返回形式：
     * {
     *   "data": "null",
     *   "meta": {
     *     "msg": "未查询到对应用户!",
     *     "status": 404
     *   }
     * }
     * @param e
     * @return
     */
    @ExceptionHandler(BsException.class)
    public ResponseEntity<String> handleException(BsException e){
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getCode()).body(JSON.toJSONString(new ExceptionRes(new Meta(exceptionEnum),"null")));
    }
}
