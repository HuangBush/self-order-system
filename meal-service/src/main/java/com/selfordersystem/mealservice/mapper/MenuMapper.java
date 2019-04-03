package com.selfordersystem.mealservice.mapper;

import com.selfordersystem.common.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@Mapper
public interface MenuMapper {
    /**
     * 查询所有菜品：传空值
     * 查询推荐菜品：只传m_position == 2
     * 查询各类型菜品 ： 只传入 m_type == ?
     * @param menu
     * @return
     */
    @Select("<script> select * from menu where 1=1" +
            "<if test='m_position != null'>" +
            "and m_position = #{m_position}" +
            "</if>" +
            "<if test='m_type != null'>" +
            "and m_type = #{m_type} and m_position != 3" +
            "</if>" +
            "</script>")
    List<Menu> queryAllMenu(Menu menu);

    /**
     * 根据id获取菜品信息
     * @param m_id
     * @return
     */
    @Select("select * from menu where m_id = #{m_id}")
    Menu queryMenuById(@Param("m_id")long m_id);

}
