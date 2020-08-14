package com.baosteel.item.service;

import com.baosteel.common.enums.ExceptionEnum;
import com.baosteel.common.exception.BsException;
import com.baosteel.item.mapper.LoginMapper;
import com.baosteel.pojo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;
    public LoginUser loginIn(LoginUser loginUser) {

        List<LoginUser> loginUsers = loginMapper.select(loginUser);
        if(CollectionUtils.isEmpty(loginUsers)){
            throw new BsException(ExceptionEnum.LOGINUSER_NOT_FIND);
        }
        return loginUsers.get(0);
    }
}
