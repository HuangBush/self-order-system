package com.selfordersystem.serviceorder.mapper;

import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.entity.Orderitem;
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
public interface OrderitemMapper {

    /***
     * 插入一个子订单
     * @param oi
     * @return
     */
    @Insert("insert into orderitem (os_id,m_id,oi_num,oi_price) values (#{os_id},#{m_id},#{oi_num},#{oi_price})")
    int addOrderitem(Orderitem oi);

    /***
     * 根据oiid彻底删除该子订单
     * @param oi_id
     * @return
     */
    @Delete("delete from orderitem where oi_id = #{oi_id}")
    int deleteOrderitemByOiid(@Param("oi_id")long oi_id);

    /***
     * 根据总订单id查找子订单信息(并获取菜品信息,分页查询)
     * @param os_id
     * @return
     */
    @Select("select * from orderitem where os_id = #{os_id} limit #{before},#{after}")
    @Results({
            @Result(column="m_id",property="menu",
                    one=@One(select="select * from menu where m_id = #{m_id}"))
    })
    List<Orderitem> queryItemByOsidAndLimit(@Param("os_id")Long os_id, @Param("before") int before, @Param("after") int after);

    /***
     * 根据总订单ID计算有多少条子订单数据
     * @return
     */
    @Select("select count(*) from orderitem where os_id = #{os_id}")
    public int count(@Param("os_id")Long os_id);

    /***
     * 根据总订单id查找子订单信息(并获取菜品信息)
     * @param os_id
     * @return
     */
    @Select("select * from orderitem where os_id = #{os_id}")
    @Results({
            @Result(column="m_id",property="menu",
                    one=@One(select="com.selfordersystem.serviceorder.mapper.OrderitemMapper.queryMenuByMid"))
    })
    List<Orderitem> queryItemByOsid(@Param("os_id")Long os_id);

    @Select("select * from menu where m_id = #{m_id}")
    Menu queryMenuByMid(long m_id);


    /***
     * 根据子订单id获取子订单信息
     * @param oi_id
     * @return
     */
    @Select("select * from orderitem where oi_id = #{oi_id}")
    Orderitem queryByOiid(@Param("oi_id")long oi_id);

    /***
     * 根据总订单id和菜品id获取子订单信息
     * @param m_id
     * @param os_id
     * @return
     */
    @Select("select * from orderitem where m_id = #{m_id} and os_id = #{os_id}")
    Orderitem queryOrderitemByMidAndOsid(@Param("m_id")Long m_id,@Param("os_id")Long os_id);

    /*-----------------修改 方法---------*/

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
     * 修改子订单状态
     * @param oi_id
     * @return
     */
    @Update("update orderitem set oi_position = #{oi_position} where oi_id = #{oi_id}")
    int updateOrderitemPositionByOiid(@Param("oi_position")long oi_position,@Param("oi_id")long oi_id);

    /**
     * 修改子订单的总订单id
     * @param os_id
     * @param oi_id
     * @return
     */
	/*@Update("<script>"
			+ "<foreach collection='#{oiList}' item='item' index='index' separator=';'>"
			+ "update orderitem set "
			+ "os_id = #{os_id} "
			+ "where oi_id = #{item.oi_id}"
			+ "</foreach>"
			+ "</script>")*/
    @Update("update orderitem set os_id = #{os_id} where oi_id = #{oi_id}")
    int updateOrderitemOsidByOiid(@Param("os_id")long os_id,@Param("oi_id")long oi_id);

    /**
     * 根据总订单id修改子订单的状态
     * @param os_position
     * @param os_id
     * @return
     */
    @Update("update orderitem  set oi_position = #{oi_position} where os_id = #{os_id}")
    int updateOrderitemPositionByOsid(@Param("oi_position")long os_position,@Param("os_id")long os_id);
}
