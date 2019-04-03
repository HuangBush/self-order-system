package com.selfordersystem.payservice.service.impl;

import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.payservice.mapper.MenuMapper;
import com.selfordersystem.payservice.service.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    /***
     * 修改菜品销量
     * @param menu
     * @return
     */
    @Override
    public int updateMenuNumByMid(Menu menu) {
        return menuMapper.updateMenuNumByMid(menu);
    }
}
