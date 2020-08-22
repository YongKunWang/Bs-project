package com.baosteel.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitorImage {

    @JSONField(ordinal = 1)
    private Long pre_id;
    @JSONField(ordinal = 2)
    private Long monitor_number;
    @JSONField(ordinal = 3)
    private String _image_name;
    @JSONField(ordinal = 4)
    private String pre_image_url;
    @JSONField(ordinal = 5)
    private String after_image_url;
    // 图像文件的上传时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss",ordinal = 6)
    private Date pre_create_time;

}
