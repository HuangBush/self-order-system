package com.selfordersystem.menuservice.mapper;

import com.selfordersystem.common.entity.Employee;
import com.selfordersystem.common.entity.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/31
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

    /**
     * 添加菜品
     * @param menu
     * @return
     */
    @Insert("insert into menu(m_name,m_price,m_img,m_type) value(#{m_name},#{m_price},#{m_img},#{m_type})")
    int addMenu(Menu menu);


    /***
     * 动态修改菜品信息
     * 把需要的修改的值传入
     * 状态 0 在售 2 推荐 3 下架
     * @param menu
     * @return
             */
    @Update("<script>"+
            "update menu"+
            "<set>"+
            "<if test='m_name != null '>"+
            "m_name = #{m_name},"+
            "</if>"+
            "<if test='m_type != null '>"+
            "m_type = #{m_type},"+
            "</if>"+
            "<if test='m_price != null '>"+
            "m_price = #{m_price},"+
            "</if>"+
            "<if test='m_img != null '>"+
            "m_img = #{m_img},"+
            "</if>"+
            "<if test='m_position != null'>"+
            "m_position = #{m_position},"+
            "</if>"+
            "<if test='m_num != null'>"+
            "m_num = #{m_num},"+
            "</if>"+
            "</set>"+
            "<where>" +
            "<if test='m_id != null'>" +
            "m_id = #{m_id}" +
            "</if>" +
            "</where>"+
            "</script>")
    int updateMenu(Menu menu);

    /***
     * 按照分页获取内容
     * @param before
     * @param after
     * @return
     */
    @Select("select * from menu limit #{before},#{after} ")
    List<Menu> queryMenuPage(@Param("before") int before,@Param("after") int after);
    /***
     * 查询总共多少条数据
     * @return
     */
    @Select("select count(*) from menu")
    int count();
}
