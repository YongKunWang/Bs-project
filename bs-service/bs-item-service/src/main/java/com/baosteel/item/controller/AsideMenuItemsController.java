package com.baosteel.item.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baosteel.common.enums.SuccessEnum;
import com.baosteel.common.vo.Meta;
import com.baosteel.common.vo.success.SuccessResult;
import com.baosteel.item.service.AsideMenuItemsService;
import com.baosteel.pojo.AsideMenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AsideMenuItemsController {
    @Autowired
    private AsideMenuItemsService asideMenuItemsService;

    @GetMapping("menus")
    private ResponseEntity<String> queryMeunItems() {

        List<AsideMenuItems> asideMenuItems =  asideMenuItemsService.queryMenuItemLevelZero();
        SuccessResult<List<AsideMenuItems>> successResult = new SuccessResult<List<AsideMenuItems>>(new Meta(SuccessEnum.GET_ASIDEMENU_SUCCESS),asideMenuItems);
        String res = JSON.toJSONString(successResult, SerializerFeature.WriteMapNullValue);
        System.out.println(res);
        return ResponseEntity.ok(res);
    }
}
