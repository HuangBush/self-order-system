package com.selfordersystem.serviceorder.controller;

import com.selfordersystem.common.entity.Layui;
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
     * 删除子订单信息
     *
     * @param os_id
     * @return
     */
    @RequestMapping("deleteOrderitems")
    boolean deleteOrderitems(@RequestParam("os_id") String os_id) {
        return orderServiceImpl.delOrderitemsMsg(os_id);
    }
}
