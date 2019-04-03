package com.selfordersystem.mealservice.mapper;

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
     * 根据餐桌id和总订单状态总订单和所有子订单的信息 及其菜品信息
     * @param d_id
     * @return
             */
    @Select("select * from Orderitems where d_id = #{d_id} and os_position = #{os_position} limit 1")
    @Results({
            @Result(column="os_id",property="oiList",
                    many=@Many(select="com.selfordersystem.mealservice.mapper.OrderMapper.queryItemByOsid"))

    })
    Orderitems queryOrderAndMenuMsgByDidAndPosition(@Param("d_id")Long d_id, @Param("os_position")long os_position);

    /***
     * 根据总订单id查找子订单信息(并获取菜品信息)
     * @param os_id
     * @return
     */
    @Select("select * from orderitem where os_id = #{os_id}")
    @Results({
            @Result(column="m_id",property="menu",
                    one=@One(select="com.selfordersystem.mealservice.mapper.MenuMapper.queryMenuById"))
    })
    List<Orderitem> queryItemByOsid(@Param("os_id")Long os_id);

    /***
     * 根据总订单id查询总订单信息并获取子订单和菜品信息
     * 2/27
     * @param os_id
     * @return
     */
    @Select("select * from orderitems where os_id = #{os_id}")
    @Results({
            @Result(column="os_id",property="oiList",
                    many=@Many(select="com.selfordersystem.mealservice.mapper.OrderMapper.queryItemByOsid"))

    })
    Orderitems queryOrderitsmByOsid(@Param("os_id")long os_id);

    /***
     * 增加一个未付款的总订单
     * @Options 用来返回插入后的osid 值在os中
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty ="os_id",keyColumn = "os_id")
    @Insert("insert into orderitems (d_id) values (#{d_id})")
    int addOrderitems(Orderitems os);

    /***
     * 插入一个子订单
     * @param oi
     * @return
     */
    @Insert("insert into orderitem (os_id,m_id,oi_num,oi_price) values (#{os_id},#{m_id},#{oi_num},#{oi_price})")
    int addOrderitem(Orderitem oi);

    /***
     * 根据总订单id和菜品id获取子订单信息
     * @param m_id
     * @param os_id
     * @return
     */
    @Select("select * from orderitem where m_id = #{m_id} and os_id = #{os_id}")
    Orderitem queryOrderitemByMidAndOsid(@Param("m_id")Long m_id,@Param("os_id")Long os_id);

    /***
     * 每次减少一份，并修改子订单总价
     * @param oi
     * @return
     */
    @Update("update orderitem set oi_num = (oi_num-1),oi_price = (oi_price-"
            + "(select m_price from menu where menu.m_id = #{m_id})) "
            + "where oi_id = #{oi_id}")
    int updateOrderitemDec(Orderitem oi);

    /***
     * 每次增加一份，并修改子订单总价
     * @param oi
     * @return
     */
    @Update("update orderitem set oi_num = (oi_num+1),oi_price = (oi_price+"
            + "(select m_price from menu where menu.m_id = #{m_id}) )"
            + "where oi_id = #{oi_id}")
    int updateOrderitemAdd(Orderitem oi);


    /***
     * 根据oiid彻底删除该子订单
     * @param oi_id
     * @return
     */
    @Delete("delete from orderitem where oi_id = #{oi_id}")
    int deleteOrderitemByOiid(@Param("oi_id")long oi_id);

    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    @Update("update orderitems set os_position = #{os_position} where os_id = #{os_id}")
    int updateOrderitemsPositionByOsid(@Param("os_position")long os_position,@Param("os_id")long os_id);

    /***
     * 根据总订单id修改总订单总价
     * @param os_allprice
     * @param os_id
     * @return
     */
    @Update("update orderitems set os_allprice = (os_allprice+#{os_allprice}) where os_id = #{os_id}")
    int updateOrderitemsPriceByOsid(@Param("os_allprice")float os_allprice,@Param("os_id")long os_id);

    /***
     * 修改子订单状态
     * @param oi_id
     * @return
     */
    @Update("update orderitem set oi_position = #{oi_position} where oi_id = #{oi_id}")
    int updateOrderitemPositionByOiid(@Param("oi_position")long oi_position,@Param("oi_id")long oi_id);

    /***
     * 根据餐桌id和总订单状态总订单
     * @param d_id
     * @return
     */
    @Select("select * from Orderitems where d_id = #{d_id} and os_position = #{os_position} limit 1")
    Orderitems queryOrderAndMenuMsgByDidAndPosition2(@Param("d_id")Long d_id, @Param("os_position")long os_position);
}
