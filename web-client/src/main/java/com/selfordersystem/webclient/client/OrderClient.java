package com.selfordersystem.webclient.client;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.entity.OredritemsTableModel;
import com.selfordersystem.common.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@FeignClient("service-zuul/api-order/")
public interface OrderClient {

    @RequestMapping("getOrderitemsPage")
    Layui getOrderitemsPage(PageUtils pageUtils);

    @RequestMapping("getOrderitemMsgPage")
    Layui getOrderitemMsgPage(PageUtils page, @RequestParam("os_id") long os_id);

    /**
     * 删除子订单信息
     *
     * @param os_id
     * @return
     */
    @RequestMapping("deleteOrderitems")
    boolean deleteOrderitems(@RequestParam("os_id") String os_id);

    /**
     * 切换查询 总订单
     * 按订单id 和 桌面id
     *
     * @param keyWord
     * @param keyType
     * @return
     */
    @RequestMapping("getOrderitemsTable")
    OredritemsTableModel getOrderitemsTable(@RequestParam("keyWord") String keyWord, @RequestParam("keyType") String keyType);

    /**
     * 按照日期查询总订单信息
     *
     * @param orderitems
     * @return
     */
    @RequestMapping("getOrderitemsByDate")
    OredritemsTableModel getOrderitemsByDate(Orderitems orderitems) ;
}
