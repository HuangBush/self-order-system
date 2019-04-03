package com.selfordersystem.payservice.mapper;

import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@Mapper
public interface OrderMapper {

    /***
     * 根据总订单id查询总订单信息
     * 2/27
     * @param os_id
     * @return
     */
    @Select("select * from orderitems where os_id = #{os_id}")
    Orderitems queryOrderitsmByOsid(@Param("os_id")long os_id);


    /***
     * 根据总订单id查找子订单信息(并获取菜品信息)
     * @param os_id
     * @return
     */
    @Select("select * from orderitem where os_id = #{os_id}")
    @Results({
            @Result(column="m_id",property="menu",
                    one=@One(select="com.selfordersystem.payservice.mapper.MenuMapper.queryMenuById"))
    })
    List<Orderitem> queryItemByOsid(@Param("os_id")Long os_id);

    /***
     * 修改子订单状态
     * @param oi_id
     * @return
     */
    @Update("update orderitem set oi_position = #{oi_position} where oi_id = #{oi_id}")
    int updateOrderitemPositionByOiid(@Param("oi_position")long oi_position,@Param("oi_id")long oi_id);

    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    @Update("update orderitems set os_position = #{os_position} where os_id = #{os_id}")
    int updateOrderitemsPositionByOsid(@Param("os_position")long os_position,@Param("os_id")long os_id);

    /***
     * 修改子订单的总订单id
     * @return
     */
    @Update("update orderitem set os_id = #{os_id} where oi_id = #{oi_id}")
    int updateOrderitemOsidByOiid(@Param("os_id")long os_id,@Param("oi_id")long oi_id);

    /***
     * 根据总订单id修改总订单总价
     * @param os_allprice
     * @param os_id
     * @return
     */
    @Update("update orderitems set os_allprice = (os_allprice+#{os_allprice}) where os_id = #{os_id}")
    int updateOrderitemsPriceByOsid(@Param("os_allprice")float os_allprice,@Param("os_id")long os_id);

    /***
     * 彻底删除总订单
     * @param os_id
     * @return
     */
    @Delete("delete from orderitems where os_id = #{os_id}")
    int deleteOrderitemsByOsid(@Param("os_id")long os_id);
}
