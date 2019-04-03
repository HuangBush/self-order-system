package com.selfordersystem.payservice.service;

import com.selfordersystem.common.entity.Menu;
import org.apache.ibatis.annotations.Update;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
public interface IMenuService {

    /***
     * 修改菜品销量
     * @param menu
     * @return
     */
    int updateMenuNumByMid(Menu menu);
}
