package com.baosteel.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Table(name="user_manager")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
    // 主键自增 配置顺序
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JSONField(ordinal = 1)
    private Long id;

    @JSONField(ordinal = 2)
    private String username;// 用户名

    @JSONField(ordinal = 3)
    private String password;// 密码

    @JSONField(ordinal = 4)
    private String phone;// 电话

    // fastJSON序列化的格式
    @JSONField(format = "yyyy-MM-dd HH:mm:ss",ordinal = 5)
    private Date created;// 创建时间

    public String simpleFormDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        return format.format(this.created);
    }

}
