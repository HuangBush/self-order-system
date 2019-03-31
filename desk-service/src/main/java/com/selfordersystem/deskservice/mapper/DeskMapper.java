package com.selfordersystem.deskservice.mapper;

import com.selfordersystem.common.entity.Desk;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/29
 */
@Mapper
public interface DeskMapper {

    /***
     * 根据餐桌id和密码查找餐桌
     * @param desk
     * @return
     */
    @Select("select * from desk where d_id = #{d_id} and d_password = #{d_password}")
    Desk queryDeskByIdAndPassword(Desk desk);

    /***
     * 动态查询 餐桌（id/name）
     * @param desk
     * @return
     */
    @Select({"<script>" +
            "select * from desk where" +
            "<if test='d_id != null'>"+
            "d_id = #{d_id}"+
            "</if>",
            "<if test='d_name != null'>"+
            "d_name = #{d_name}" +
            "</if>"+
            "</script>"})
    Desk queryDesk(Desk desk);

    /***
     * 根据餐桌id查找餐桌
     * @return
     */
    @Select("select * from desk where d_id = #{d_id}")
    Desk queryDeskById(Desk desk);

    /***
     * 根据餐桌名查找餐桌
     * @return
     */
    @Select("select * from desk where d_name = #{d_name}")
    Desk queryDeskByName(Desk desk);

    /***
     * 查询所有桌子
     * @return
     */
    @Select("select * from desk")
    List<Desk> queryAllDesk();



    /**
     * 动态（id、name）删除桌子
     * @param desk
     * @return
     */
    @Delete({"<script>" +
            "delete from desk " +
            "<where>" ,
            "<if test='d_id != null'>" +
            " d_id = #{d_id}"+
            "</if>" +
            "<if test='d_name != null'>" +
            " d_name = #{d_name}" +
            "</if>" +
            "</where>" +
            "</script>"})
    int deleteDesk(Desk desk);


    /*
     * 根据桌名删除桌子
     */
    @Delete("delete from desk where d_name = #{d_name}")
    int deleteDeskByName(@Param("d_name")String name);
    /**
     * 添加桌子
     * @param desk
     * @return
     */
    @Insert("insert into desk(d_password,d_name,d_place,d_type) value(#{d_password},#{d_name},#{d_place},#{d_type})")
    int addDesk(Desk desk);

    ////////////////刘超 3.15新增///////////////////////////
    /**
     * 根据桌名修改桌子状态
     * @param name
     */
    @Update("update desk set d_position = 0 where d_name = #{d_name}")
    int updateDeskPositionByName(String name);

    /***
     * 修改餐桌的状态根据餐桌id
     * @return
     * 3/1 黄逸峰
     */
    @Update("update desk set d_position= #{d_position} where d_id = #{d_id}")
    int updateDeskPositionByDid(@Param("d_position")long d_position, @Param("d_id")long d_id);

    /**
     * 动态修改餐桌 根据id或者name
     * @param desk
     * @return
     */
     @Update("<script>"+
            "update desk"+
            "<set>"+
            "<if test='d_name != null '>"+
            "d_name = #{d_name},"+
            "</if>"+
            "<if test='d_password != null '>"+
            "d_password = #{d_password},"+
            "</if>"+
            "<if test='d_type != null '>"+
            "d_type = #{d_type},"+
            "</if>"+
            "<if test='d_place != null '>"+
            "d_place = #{d_place},"+
            "</if>"+
            "<if test='d_position != null'>"+
            "d_position = #{d_position},"+
            "</if>"+
            "</set>"+
            "<where>" +
            "<if test='d_id != null'>" +
            "d_id = #{d_id}" +
            "</if>" +
            "<if test='d_name != null'>" +
            "d_name = #{d_name}" +
            "</if>" +
            "</where>"+
            "</script>")
    int updateDesk(Desk desk);
}
