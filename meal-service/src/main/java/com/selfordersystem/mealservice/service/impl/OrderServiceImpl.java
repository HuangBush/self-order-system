package com.selfordersystem.mealservice.service.impl;

import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.mealservice.mapper.MenuMapper;
import com.selfordersystem.mealservice.mapper.OrderMapper;
import com.selfordersystem.mealservice.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private MenuMapper menuMapper;

    /**
     * 根据餐桌id和总订单状态获取该订单详细信息
     *
     * @param d_id
     * @param os_position
     * @return
     */
    public Orderitems getOrderAllMsg(long d_id, long os_position) {
        return orderMapper.queryOrderAndMenuMsgByDidAndPosition(d_id,os_position);
    }

    /***
     * 增加一个未付款的总订单
     * @Options 用来返回插入后的osid 值在os中
     * @return
     */
    public boolean addOrderitems(Orderitems os) {
        int i = orderMapper.addOrderitems(os);
        return i==1;
    }

    /***
     * 插入一个子订单
     * @param oi
     * @return
     */
    public boolean addOrderitem(Orderitem oi) {
        //插入一个子订单
        System.out.println("总订单的价格正在修改----------------------------------------------");
        int i =  orderMapper.addOrderitem(oi);
        if(i == 1){
            //获取菜品单价
            Menu menu = menuMapper.queryMenuById(oi.getm_id());
            //再修改总订单的总价
            int j = orderMapper.updateOrderitemsPriceByOsid(menu.getm_price(), oi.getos_id());
            System.out.println("总订单的价格已修改---------------------------------------");
            return j==1;
        }else{
            return i==1;
        }
    }


    /***
     * 根据总订单id和菜品id获取子订单信息
     * @param m_id
     * @param os_id
     * @return
     */
    public Orderitem queryOrderitemByMidAndOsid(Long m_id, Long os_id) {
        return orderMapper.queryOrderitemByMidAndOsid(m_id,os_id);
    }

    /***
     * 每次减少一份，并修改子订单总价
     * @param oi
     * @return
     */
    public int updateOrderitemDec(Orderitem oi) {
        int i = orderMapper.updateOrderitemDec(oi);
        //同时修改总订单总价
        if(i ==1){
            //获取菜品单价
            Menu menu = menuMapper.queryMenuById(oi.getm_id());
            int j = orderMapper.updateOrderitemsPriceByOsid(-menu.getm_price(), oi.getos_id());
            System.out.println("总订单的价格已修改---------------------------------------");
            return j;
        }
        return i;
    }

    /***
     * 每次增加一份，并修改子订单总价
     * @param oi
     * @return
     */
    public int updateOrderitemAdd(Orderitem oi) {
        int i = orderMapper.updateOrderitemAdd(oi);
        //同时修改总订单总价
        if(i ==1){
            //获取菜品单价
            Menu menu = menuMapper.queryMenuById(oi.getm_id());
            int j = orderMapper.updateOrderitemsPriceByOsid(menu.getm_price(),oi.getos_id());
            //System.out.println("总订单的价格已修改--++++++++++++++++++++++++++++++++++++++++------"+orderMapper.queryOrderitemsByOsId(oi.getos_id()).getos_allprice());
            return j;
        }
        return i;
    }

    /***
     * 根据oiid彻底删除该子订单
     * @param oi_id
     * @return
     */
    @Override
    public int deleteOrderitemByOiid(long oi_id) {
        return orderMapper.deleteOrderitemByOiid(oi_id);
    }

    /***
     * 根据总订单id查询总订单信息并获取子订单和菜品信息
     * 2/27
     * @param os_id
     * @return
     */
    public Orderitems queryOrderitsmByOsid(long os_id) {
        return orderMapper.queryOrderitsmByOsid(os_id);
    }

    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    public int updateOrderitemsPositionByOsid(long os_position, long os_id) {
        return orderMapper.updateOrderitemsPositionByOsid(os_position,os_id);
    }

    /***
     * 根据总订单id修改总订单总价
     * @param os_allprice
     * @param os_id
     * @return
     */
    public int updateOrderitemsPriceByOsid(float os_allprice, long os_id) {
        return orderMapper.updateOrderitemsPriceByOsid(os_allprice,os_id);
    }

    /***
     * 修改子订单状态
     * @param oi_id
     * @return
     */
    public int updateOrderitemPositionByOiid(long oi_position, long oi_id) {
        return orderMapper.updateOrderitemPositionByOiid(oi_position,oi_id);
    }
}
