package com.baosteel.item.controller;

import com.alibaba.fastjson.JSON;
import com.baosteel.common.enums.ExceptionEnum;
import com.baosteel.common.enums.SuccessEnum;
import com.baosteel.common.exception.BsException;
import com.baosteel.common.vo.Meta;
import com.baosteel.common.vo.success.SuccessResult;
import com.baosteel.pojo.LoginUser;
import com.baosteel.item.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    // 大坑
    // 参考资料： https://blog.csdn.net/csdn_yudong/article/details/79668655
    public ResponseEntity<String> loginIn(@RequestBody  LoginUser loginUser){
        if (loginUser.getUsername() == null){
            throw new BsException(ExceptionEnum.USERNAME_CNNNOT_BE_FULL);
        }
        if (loginUser.getPassword() == null){
        throw new BsException(ExceptionEnum.PASSWORD_CNNNOT_BE_FULL);
        }
        SuccessResult<LoginUser> successResult = new SuccessResult<LoginUser>(new Meta(SuccessEnum.LOGIN_SUCCESS),loginService.loginIn(loginUser));
        String res = JSON.toJSONString(successResult);
//        System.out.println(res);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
