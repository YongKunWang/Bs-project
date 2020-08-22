package com.baosteel.item.controller;

import com.alibaba.fastjson.JSON;
import com.baosteel.common.enums.SuccessEnum;
import com.baosteel.common.vo.Meta;
import com.baosteel.common.vo.success.SuccessResult;
import com.baosteel.item.service.MonitorTenImageService;
import com.baosteel.pojo.PreMonitorTenImage;
import com.baosteel.pojo.vo.MonitorImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("monitor")
public class PreMonitorTenImageController {
    @Autowired
    private MonitorTenImageService monitorTenImageService;

    @GetMapping("preimages/{number}")
    public ResponseEntity<String> getMonitorPreImage(@PathVariable("number") Long number) {
        System.out.println(number);
        MonitorImage monitorImage = monitorTenImageService.getMonitorImage(number);
        SuccessResult<MonitorImage> successResult = new SuccessResult<>(new Meta(SuccessEnum.GET_MONITOR_IMAGE_SUCCESS),monitorImage);
        String json = JSON.toJSONString(successResult);
        return ResponseEntity.ok(json);
    }
}
