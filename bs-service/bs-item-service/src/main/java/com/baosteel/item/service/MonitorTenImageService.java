package com.baosteel.item.service;

import com.baosteel.common.enums.ExceptionEnum;
import com.baosteel.common.exception.BsException;
import com.baosteel.item.mapper.AfterMonitorTenImageMapper;
import com.baosteel.item.mapper.PreMonitorTenImageMapper;
import com.baosteel.pojo.AfterImage;
import com.baosteel.pojo.AfterMonitorTenImage;
import com.baosteel.pojo.PreImage;
import com.baosteel.pojo.PreMonitorTenImage;
import com.baosteel.pojo.vo.MonitorImage;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MonitorTenImageService {
    @Autowired
    private PreMonitorTenImageMapper preMonitorTenImageMapper;

    @Autowired
    private AfterMonitorTenImageMapper afterMonitorTenImageMapper;

    // 得到原始图像的实体类别
    // 每一次都是最新的数据
    // select * from xxx order by id desc limit 1;
    public PreImage getMonitorPreImage(Long number) {
        List<PreMonitorTenImage> preMonitorTenImages = null;
        if (number == 10) {
            // SELECT * from monitor_ten_preimages ORDER BY id DESC LIMIT 1;
            Example example = new Example(PreMonitorTenImage.class);
            example.setOrderByClause("pre_id desc");
            PageHelper.startPage(0,1);
            preMonitorTenImages = preMonitorTenImageMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(preMonitorTenImages)){
                throw new BsException(ExceptionEnum.PRE_IMAGE_CANNOT_FIND);
            }
            return preMonitorTenImages.get(0);
        }
        return preMonitorTenImages.get(0);
    }

    public AfterImage  getMonitorAfterImage(Long number) {
        List<AfterMonitorTenImage> afterMonitorTenImages = null;
        if (number == 10) {
            Example example = new Example(AfterMonitorTenImage.class);
            example.setOrderByClause("after_id desc");
            PageHelper.startPage(0,1);
            afterMonitorTenImages = afterMonitorTenImageMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(afterMonitorTenImages)){
                throw new BsException(ExceptionEnum.AFTER_IMAGE_CANNOT_FIND);
            }
            return afterMonitorTenImages.get(0);
        }
        return afterMonitorTenImages.get(0);
    }

    public MonitorImage getMonitorImage(Long number) {
        PreImage preImage = this.getMonitorPreImage(number);
        AfterImage afterImage = this.getMonitorAfterImage(number);
        if (!preImage.getPre_image_name().equals(afterImage.getAfter_image_name())) {
            throw new BsException(ExceptionEnum.PRE_AFTER_IMAGE_CANNOT_MATCHING);
        }
        MonitorImage monitorImage = new MonitorImage();
        monitorImage.setPre_id(preImage.getPre_id());
        monitorImage.setMonitor_number(preImage.getPre_monitor_number());
        monitorImage.set_image_name(preImage.getPre_image_name());
        monitorImage.setPre_image_url(preImage.getPre_image_url());
        monitorImage.setAfter_image_url(afterImage.getAfter_image_url());
        monitorImage.setPre_create_time(preImage.getPre_create_time());

        return monitorImage;
    }
}
