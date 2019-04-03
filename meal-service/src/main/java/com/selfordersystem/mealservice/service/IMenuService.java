package com.selfordersystem.mealservice.service;

import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.mealservice.mapper.MenuMapper;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
public interface IMenuService {

    /**
     * 查询所有菜品：传空值
     * 查询推荐菜品：只传m_position == 2
     * 查询各类型菜品 ： 只传入 m_type == ?
     * @param menu
     * @return
     */
    List<Menu> getClassMenu(Menu menu);

    /**
     * 根据id获取菜品信息
     * @param m_id
     * @return
     */
    Menu queryMenuById(long m_id);
}
