package com.selfordersystem.loginservice.service;

import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@FeignClient("service-zuul/api-order/")
public interface IOrderService {

    /***
     * 动态查询总订单
     * 查询所有订单  传入空值
     * 根据日期查询  只传入日期
     * 根据状态查询  只传入状态
     * 根据桌面id查询 只传入桌面id
     * 根据总订单id查询 只传入总订单id
     *  若要以上几种联合查询 请一起传入
     * @param orderitems
     * @return
     */
    @RequestMapping("queryAllOrderitems")
    List<Orderitems> queryAllOrderitems( Orderitems orderitems);

    /***
     * 根据总订单id查找子订单信息(并获取菜品信息)
     * @param os_id
     * @return
     */
    @RequestMapping("queryItemByOsid")
    List<Orderitem> queryItemByOsid(@RequestParam("os_id") Long os_id);

    /**
     * 删除总订单信息
     *
     * @param os_id
     * @return
     */
    @RequestMapping("deleteOrderitems")
    boolean deleteOrderitems(@RequestParam("os_id") long os_id);

    /***
     * 根据餐桌id和总订单状态总订单和所有子订单的信息 及其菜品信息
     * @param d_id
     * @return
     */
    @RequestMapping("queryOrderAndMenuMsgByDidAndPosition")
    Orderitems queryOrderAndMenuMsgByDidAndPosition(@RequestParam("d_id") Long d_id, @RequestParam("os_position") long os_position) ;

    /**
     * 根据总订单id修改子订单的状态
     *
     * @param oi_position
     * @param os_id
     * @return
     */
    @RequestMapping("updateOrderitemPositionByOsid")
    int updateOrderitemPositionByOsid(@RequestParam("oi_position") long oi_position,@RequestParam("os_id") long os_id);


    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    @RequestMapping("updateOrderitemsPositionById")
    public boolean updateOrderitemsPositionById(@RequestParam("os_position") long os_position,@RequestParam("os_id") long os_id);

    /***
     * 根据餐桌id和总订单状态总订单
     * @param d_id
     * @return
             */
    @RequestMapping("queryOrderAndMenuMsgByDidAndPosition2")
    Orderitems queryOrderAndMenuMsgByDidAndPosition2(@RequestParam("d_id") Long d_id,@RequestParam("os_position") long os_position);
}
