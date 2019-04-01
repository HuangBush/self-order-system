package com.selfordersystem.webclient.controller;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.entity.OredritemsTableModel;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.webclient.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@Controller
public class OrderController {

    @Autowired
    private OrderClient orderClient;

    /**
     * 分页获取总订单信息
     * @param pageUtils
     * @return
     */
    @RequestMapping(value = "orders",method = RequestMethod.GET)
    public @ResponseBody
    Layui getOrderitemsPage(PageUtils pageUtils){
        System.out.println("获取总订单分页信息"+pageUtils.getCurr());
        return orderClient.getOrderitemsPage(pageUtils);
    }

    /**
     * 获取子订单的分页信息
     * @param page
     * @param os_id
     * @return
     */
    @RequestMapping(value = "orderitem",method = RequestMethod.GET)
    public  String getOrderitemMsgPage(Model model,PageUtils page, long os_id) {
        System.out.println("获取子订单的分页信息"+os_id);
        model.addAttribute("layui",orderClient.getOrderitemMsgPage(page,os_id));
        return "service/orderitemsDetails.jsp";
    }

    /**
     * 删除子订单信息
     * @param os_id
     * @return
     */
    @RequestMapping(value = "order",method = RequestMethod.DELETE)
    @ResponseBody boolean deleteOrderitems(String os_id) {
        return orderClient.deleteOrderitems(os_id);
    }

    /**
     * 切换查询 总订单
     * 按订单id 和 桌面id
     * @param keyWord
     * @param keyType
     * @return
     */
    /*@RequestMapping(value = "order",method = RequestMethod.PUT)
    public @ResponseBody OredritemsTableModel getOrderitemsTable(@RequestParam("keyWord") String keyWord, @RequestParam("keyType") String keyType) {
        System.out.println("切换查询"+keyType);
        return orderClient.getOrderitemsTable(keyWord,keyType);
    }*/

    /**
     * 按照日期查询总订单信息
     *
     * @param orderitems
     * @return
     */
    @RequestMapping(value = "order",method = RequestMethod.GET)
    @ResponseBody OredritemsTableModel getOrderitemsByDate( Orderitems orderitems) {
        System.out.println("按照日期来查询总订单"+orderitems.getos_regtime());
        return orderClient.getOrderitemsByDate(orderitems);
    }
}
