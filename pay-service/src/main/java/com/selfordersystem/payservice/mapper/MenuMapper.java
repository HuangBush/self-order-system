package com.selfordersystem.payservice.mapper;

import com.selfordersystem.common.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@Mapper
public interface MenuMapper {

    /***
     * 修改菜品销量
     * @param menu
     * @return
     */
    @Update("update menu set m_num =(m_num+#{m_number}) where m_id = #{m_id}")
    int updateMenuNumByMid(Menu menu);

    /**
     * 根据id获取菜品信息
     * @param m_id
     * @return
     */
    @Select("select * from menu where m_id = #{m_id}")
    Menu queryMenuById(@Param("m_id")long m_id);
}
