package com.baosteel.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "bs_menus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsideMenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JSONField(ordinal = 1)
    private Integer id;

    @JSONField(ordinal = 2)
    @Column(name = "authName")
    private String authName;

    @JSONField(ordinal = 3)
    private String path;

    @JSONField(ordinal = 4)
    @Column(name = "`order`")
    private Integer order;

    @JSONField(ordinal = 5)
    private Integer pid;

    @JSONField(ordinal = 6)
    @Column(name = "`level`")
    private Integer level;

    // 非数据库表中字段
    // 使用逻辑关系进行维护
    @JSONField(ordinal = 7)
    @Transient
    private List<AsideMenuItems> children;
}
