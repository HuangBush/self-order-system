package com.selfordersystem.serviceorder.mapper;

import com.selfordersystem.common.entity.Orderitems;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@Mapper
public interface OrderitemsMapper {

    /***
     * 根据餐桌id和总订单状态总订单和所有子订单的信息 及其菜品信息
     * @param d_id
     * @return
     */
    @Select("select * from Orderitems where d_id = #{d_id} and os_position = #{os_position} ")
    @Results({
            @Result(column="os_id",property="oiList",
                    many=@Many(select="com.selfordersystem.serviceorder.mapper.OrderitemMapper.queryItemByOsid"))

    })
    Orderitems queryOrderAndMenuMsgByDidAndPosition(@Param("d_id")Long d_id, @Param("os_position")long os_position);


    /************   订单后台管理方法     *****************/

    /***
     * 动态查询总订单
     * 查询所有订单  传入空值
     * 根据日期查询  只传入日期
     * 根据状态查询  只传入状态
     * 根据桌面id查询 只传入桌面id
     * 根据总订单id查询 只传入总订单id
     * 若要以上几种联合查询 请一起传入
     *
     * @param orderitems
     * @return
     */
    @Select("<script>select * from orderitems where 1=1 " +
            "<if test='os_regtime != null'>" +
            "and os_regtime = #{os_regtime}" +
            "</if>" +
            "<if test='os_position != null'>" +
            "and os_position = #{os_position}" +
            "</if>" +
            "<if test='d_id != null'>" +
            "and d_id = #{d_id}" +
            "</if>" +
            "<if test='os_id != null'>" +
            "and os_id = #{os_id}" +
            "</if>" +
            "</script>")
    List<Orderitems> queryAllOrderitems(Orderitems orderitems);

    /***
     * 根据订单ID查询订单信息
     * @param os_id
     * @return
     */
    @Select("select * from orderitems where os_id = #{os_id}")
    Orderitems queryOrderitemsByOsId(@Param("os_id") long os_id);

    /***
     * 删除;将订单状态修改为3
     * @param os_id
     * @return
     */
    @Update("update orderitems set os_position = 3 where os_id = #{os_id}")
    int deleteOrderitemsMsgByOsid(@Param("os_id")long os_id);

    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    @Update("update orderitems set os_position = #{os_position} where os_id = #{os_id}")
    int updateOrderitemsPositionById(@Param("os_position")long os_position,@Param("os_id")long os_id);

    /***
     * 按照分页获取内容
     * @param before
     * @param after
     * @return
     */
    @Select("select * from orderitems limit #{before},#{after} ")
    public List<Orderitems> findAllPage(@Param("before") int before,@Param("after") int after);

    /***
     * 计算有多少条数据
     * @return
     */
    @Select("select count(*) from orderitems")
    public int count();


}
