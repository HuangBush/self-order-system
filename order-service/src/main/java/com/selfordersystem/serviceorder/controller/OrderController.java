package com.selfordersystem.serviceorder.controller;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.entity.OredritemsTableModel;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.serviceorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderServiceImpl;

    /**
     * 分页：仅获取总订单信息
     *
     * @param pageUtils
     * @return
     */
    @RequestMapping("getOrderitemsPage")
    Layui getOrderitemsPage(@RequestBody PageUtils pageUtils) {
        System.out.println("分页：仅获取总订单信息"+pageUtils.after());
        return orderServiceImpl.getOrderitemsPage(pageUtils);
    }

    /**
     * 切换查询 总订单
     * 按订单id 和 桌面id
     *
     * @param keyWord
     * @param keyType
     * @return
     */
    @RequestMapping("getOrderitemsTable")
    OredritemsTableModel getOrderitemsTable(@RequestParam("keyWord") String keyWord, @RequestParam("keyType") String keyType) {
        return orderServiceImpl.getOrderitemsTable(keyWord,keyType);
    }

    /**
     * 按照日期查询总订单信息
     *
     * @param orderitems
     * @return
     */
    @RequestMapping("getOrderitemsByDate")
    OredritemsTableModel getOrderitemsByDate(@RequestBody Orderitems orderitems) {
        System.out.println("按照日期查询总订单信息"+orderitems.getos_regtime());
        return orderServiceImpl.getOrderitemsByDate(orderitems);
    }

    /**
     * 根据总订单id查询所有子订单 分页
     *
     * @param page
     * @param os_id
     * @return
     */
    @RequestMapping("getOrderitemMsgPage")
    Layui getOrderitemMsgPage(@RequestBody PageUtils page,@RequestParam("os_id") long os_id) {
        Orderitems orderitems = new Orderitems();
        orderitems.setos_id(os_id);
        System.out.println(os_id+"根据总订单id查询所有子订单 分页"+page.getLimit());
        return orderServiceImpl.getOrderitemMsgByOsid(page,orderitems);
    }

    /**
     * 删除总订单信息
     *
     * @param os_id
     * @return
     */
    @RequestMapping("deleteOrderitems")
    boolean deleteOrderitems(@RequestParam("os_id") long os_id) {
        return orderServiceImpl.delOrderitemsMsg(os_id);
    }

    /*                给其他服务调用              */
    /***
     * 动态查询总订单
     * 查询所有订单  传入空值
     * 根据日期查询  只传入日期
     * 根据状态查询  只传入状态
     * 根据桌面id查询 只传入桌面id
     * 根据总订单id查询 只传入总订单id
     * 若要以上几种联合查询 请一起传入
     * @param orderitems
     * @return
     */
    @RequestMapping("queryAllOrderitems")
    public List<Orderitems> queryAllOrderitems(@RequestBody Orderitems orderitems) {
        System.out.println("动态查询总订单");
        return orderServiceImpl.queryAllOrderitems(orderitems);
    }

    /***
     * 根据总订单id查找子订单信息(并获取菜品信息)
     * @param os_id
     * @return
     */
    @RequestMapping("queryItemByOsid")
    List<Orderitem> queryItemByOsid(@RequestParam("os_id") Long os_id) {
        System.out.println("根据总订单id查找子订单信息(并获取菜品信息)"+os_id);
        return orderServiceImpl.queryItemByOsid(os_id);
    }

    /***
     * 根据餐桌id和总订单状态总订单和所有子订单的信息 及其菜品信息
     * @param d_id
     * @return
     */
    @RequestMapping("queryOrderAndMenuMsgByDidAndPosition")
    Orderitems queryOrderAndMenuMsgByDidAndPosition(@RequestParam("d_id") Long d_id, @RequestParam("os_position") long os_position) {
        return orderServiceImpl.queryOrderAndMenuMsgByDidAndPosition(d_id,os_position);
    }

    /**
     * 根据总订单id修改子订单的状态
     *
     * @param oi_position
     * @param os_id
     * @return
     */
    @RequestMapping("updateOrderitemPositionByOsid")
    int updateOrderitemPositionByOsid(@RequestParam("oi_position") long oi_position, @RequestParam("os_id") long os_id) {
        System.out.println("根据总订单id修改子订单的状态");
        return orderServiceImpl.updateOrderitemPositionByOsid(oi_position,os_id);
    }

    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    @RequestMapping("updateOrderitemsPositionById")
    public boolean updateOrderitemsPositionById(@RequestParam("os_position") long os_position, @RequestParam("os_id") long os_id){
        return orderServiceImpl.updateOrderitemsPositionById(os_position,os_id);
    }

    /***
     * 根据餐桌id和总订单状态总订单
     * @param d_id
     * @return
     */
    @RequestMapping("queryOrderAndMenuMsgByDidAndPosition2")
    Orderitems queryOrderAndMenuMsgByDidAndPosition2(@RequestParam("d_id") Long d_id,@RequestParam("os_position") long os_position) {
        return orderServiceImpl.queryOrderAndMenuMsgByDidAndPosition2(d_id,os_position);
    }
}
