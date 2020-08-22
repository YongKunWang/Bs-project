package com.baosteel.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfterImage {
    // 主键id
    @JSONField(ordinal = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long after_id;

    @JSONField(ordinal = 2)
    private String after_image_name;

    @JSONField(ordinal = 3)
    private Long after_monitor_number;

    @JSONField(ordinal = 4)
    private String after_image_file;

    @JSONField(ordinal = 5)
    private String after_image_url;

    @JSONField(ordinal = 6)
    private Integer after_is_warnning;

    @JSONField(ordinal = 7)
    private String after_warnning_info;

    @JSONField(ordinal = 8)
    private String after_warnning_coord;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss",ordinal = 9)
    private Date after_detection_image;
}
