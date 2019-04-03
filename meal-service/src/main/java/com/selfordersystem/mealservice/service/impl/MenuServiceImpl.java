package com.selfordersystem.mealservice.service.impl;

import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.mealservice.mapper.MenuMapper;
import com.selfordersystem.mealservice.service.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 查询所有菜品：传空值
     * 查询推荐菜品：只传m_position == 2
     * 查询各类型菜品 ： 只传入 m_type == ?
     * @param menu
     * @return
     */
    public List<Menu> getClassMenu(Menu menu) {
        return menuMapper.queryAllMenu(menu);
    }

    /**
     * 根据id获取菜品信息
     *
     * @param m_id
     * @return
     */
    public Menu queryMenuById(long m_id) {
        return menuMapper.queryMenuById(m_id);
    }
}
