package com.selfordersystem.mealservice.service;

import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import org.apache.ibatis.annotations.*;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
public interface IOrderService {

    /**
     * 根据餐桌id和总订单状态获取该订单详细信息
     * @param d_id
     * @param os_position
     * @return
     */
    Orderitems getOrderAllMsg(long d_id,long os_position);

    /***
     * 增加一个未付款的总订单
     * @Options 用来返回插入后的osid 值在os中
     * @return
     */
    boolean addOrderitems(Orderitems os);

    /***
     * 插入一个子订单
     * @param oi
     * @return
     */
    boolean addOrderitem(Orderitem oi);

    /***
     * 根据总订单id和菜品id获取子订单信息
     * @param m_id
     * @param os_id
     * @return
     */
    Orderitem queryOrderitemByMidAndOsid(Long m_id,Long os_id);

    /***
     * 每次减少一份，并修改子订单总价
     * @param oi
     * @return
     */
    int updateOrderitemDec(Orderitem oi);

    /***
     * 每次增加一份，并修改子订单总价
     * @param oi
     * @return
     */
    int updateOrderitemAdd(Orderitem oi);


    /***
     * 根据oiid彻底删除该子订单
     * @param oi_id
     * @return
     */
    int deleteOrderitemByOiid(long oi_id);

    /***
     * 根据总订单id查询总订单信息并获取子订单和菜品信息
     * 2/27
     * @param os_id
     * @return
     */
    Orderitems queryOrderitsmByOsid(long os_id);

    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    int updateOrderitemsPositionByOsid(long os_position,long os_id);

    /***
     * 根据总订单id修改总订单总价
     * @param os_allprice
     * @param os_id
     * @return
     */
    int updateOrderitemsPriceByOsid(float os_allprice,long os_id);

    /***
     * 修改子订单状态
     * @param oi_id
     * @return
     */
    int updateOrderitemPositionByOiid(long oi_position,long oi_id);
}
