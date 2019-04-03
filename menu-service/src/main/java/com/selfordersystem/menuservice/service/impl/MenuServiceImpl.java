package com.selfordersystem.menuservice.service.impl;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.menuservice.mapper.MenuMapper;
import com.selfordersystem.menuservice.service.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/31
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    /***
     * 分页查询
     * @param before
     * @param after
     * @return
     */
    public Layui getMenuPage(int before, int after) {
        Layui layui = new Layui();
        //获取统计信息
        layui.setCount(menuMapper.count());
        //获取分页数据信息
        layui.setData(menuMapper.queryMenuPage(before,after));
        return layui;
    }

    /**
     * 根据菜品id获取信息
     * @param m_id
     * @return
     */
    public Menu getMenu(int m_id){
        return menuMapper.queryMenuById(m_id);
    }

    /**
     * 添加菜品
     * @param menu
     * @return
     */
    public boolean addMenu(Menu menu){
        int i = menuMapper.addMenu(menu);
        if (i != 1){
            return false;
        }
        return true;
    }

    /***
     * 动态修改菜品信息
     * 把需要的修改的值传入
     * 状态 0 在售 2 推荐 3 下架
     * @param menu
     * @return
     */
    public boolean updateMenu(Menu menu) {
       if(menu.getm_id() == null){
           return false;
       }
       int i = menuMapper.updateMenu(menu);
       if (i !=1){
           return false;
       }
        return true;
    }

    /**
     * 查询所有菜品：传空值
     * 查询推荐菜品：只传m_position == 2
     * 查询各类型菜品 ： 只传入 m_type == ?
     *
     * @param menu
     * @return
     */
    public List<Menu> queryAllMenu(Menu menu) {
        return menuMapper.queryAllMenu(menu);
    }

}
