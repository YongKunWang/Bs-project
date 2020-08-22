package com.baosteel.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

// 父类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreImage {

    // 主键id
    @JSONField(ordinal = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pre_id;
    // 监控摄像头编号
    @JSONField(ordinal = 2)
    private Long pre_monitor_number;

    // 从本地上传到服务器的图片名称
    @JSONField(ordinal = 3)
    private String pre_image_name;

    // 服务器文件存储位置
    @JSONField(ordinal = 4)
    private String pre_image_file;

    // 静态资源url路径
    @JSONField(ordinal = 5)
    private String pre_image_url;

    // 图像文件的上传时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss",ordinal = 6)
    private Date pre_create_time;
}
