package com.selfordersystem.menuservice.service;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Menu;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description  菜品服务
 * @date 2019/3/31
 */
public interface IMenuService {

    /***
     * 分页查询
     * @param before
     * @param after
     * @return
     */
    Layui getMenuPage(int before, int after);


    /**
     * 根据菜品id获取信息
     * @param m_id
     * @return
     */
     Menu getMenu(int m_id);

    /**
     * 添加菜品
     * @param menu
     * @return
     */
     boolean addMenu(Menu menu);

    /***
     * 动态修改菜品信息
     * 把需要的修改的值传入
     * 状态 0 在售 2 推荐 3 下架
     * @param menu
     * @return
     */
     boolean updateMenu(Menu menu);

    /**
     * 查询所有菜品：传空值
     * 查询推荐菜品：只传m_position == 2
     * 查询各类型菜品 ： 只传入 m_type == ?
     * @param menu
     * @return
     */
    List<Menu> queryAllMenu(Menu menu);
}
