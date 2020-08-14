package com.baosteel.item.service;

import com.baosteel.item.mapper.AsideMenuItemsMapper;
import com.baosteel.pojo.AsideMenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsideMenuItemsService {

    @Autowired
    private AsideMenuItemsMapper asideMenuItemsMapper;

    public List<AsideMenuItems> queryMenuItemLevelZero() {
        // 1. 获得父级
        AsideMenuItems asideMenuItem = new AsideMenuItems();
        asideMenuItem.setLevel(0);
        List<AsideMenuItems> items = asideMenuItemsMapper.select(asideMenuItem);
//        System.out.println(items);
        // 获得子级并且进行添加！
        List<AsideMenuItems> res = getAsideMenuItems(items);

//        System.out.println(res);
        return res;
    }

    public List<AsideMenuItems> getAsideMenuItems(List<AsideMenuItems> levelZeros) {
        for (int i = 0; i < levelZeros.size(); i++){
            //1. 获得父级
            AsideMenuItems item = levelZeros.get(i);
            //2.建立查询参数 层级为1 并且 父级id
            AsideMenuItems query = new AsideMenuItems();
            query.setLevel(1); // 层次2
            query.setPid(item.getId()); // 父级pid
//            System.out.println("query:" + query);
            List<AsideMenuItems> children = asideMenuItemsMapper.select(query);
//            System.out.println(children);
            // 添加
            item.setChildren(children);
        }
        return levelZeros;
    }
}
