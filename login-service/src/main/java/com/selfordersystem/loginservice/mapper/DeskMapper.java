package com.selfordersystem.loginservice.mapper;

import com.selfordersystem.common.entity.Desk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
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
     * 修改餐桌的状态根据餐桌id
     * @return
     * 3/1 黄逸峰
     */
    @Update("update desk set d_position= #{d_position} where d_id = #{d_id}")
    int updateDeskPositionByDid(@Param("d_position")long d_position, @Param("d_id")long d_id);
}
