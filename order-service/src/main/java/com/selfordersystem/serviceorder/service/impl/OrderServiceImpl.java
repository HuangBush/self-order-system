package com.selfordersystem.serviceorder.service.impl;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.entity.OredritemsTableModel;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.serviceorder.mapper.OrderitemMapper;
import com.selfordersystem.serviceorder.mapper.OrderitemsMapper;
import com.selfordersystem.serviceorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderitemMapper orderitemMapper;

    @Resource
    private OrderitemsMapper orderitemsMapper;


    /**
     * 分页：仅获取总订单信息
     *
     * @param pageUtils
     * @return layui
     */
    public Layui getOrderitemsPage(PageUtils pageUtils) {
        Layui layui = new Layui();
        layui.setData(orderitemsMapper.findAllPage(pageUtils.before(),pageUtils.after()));
        layui.setCount(orderitemsMapper.count());
        return layui;
    }

    /**
     * 切换查询 总订单
     * 按订单id 和 桌面id
     *
     * @param keyWord
     * @param keyType
     * @return
     */
    public OredritemsTableModel getOrderitemsTable(String keyWord, String keyType) {
        List<Orderitems> list = new ArrayList<Orderitems>();
        Orderitems os = new Orderitems();
        //判断是什么类型 进行什么查询
        if(keyType.equals("os_id")){
            long osid = Long.parseLong(keyWord);
            os = orderitemsMapper.queryOrderitemsByOsId(osid);
            list.add(os);
        }else if(keyType.equals("d_id")){
            long did = Long.parseLong(keyWord);
            os.setd_id(did);
            list =  orderitemsMapper.queryAllOrderitems(os);
        }
        //将订单插入
        OredritemsTableModel ot = new OredritemsTableModel();
        ot.setCode(0);
        ot.setCount(1000);
        ot.setData(list);
        return ot;
    }

    /**
     * 按照日期查询总订单信息
     *
     * @param orderitems
     * @return
     */
    public OredritemsTableModel getOrderitemsByDate(Orderitems orderitems) {
        OredritemsTableModel ot = new OredritemsTableModel();
        ot.setCode(0);
        ot.setCount(1000);
        ot.setData(orderitemsMapper.queryAllOrderitems(orderitems));
        return ot;
    }

    /**
     * 根据总订单id查询所有子订单 分页
     *
     * @param page
     * @param orderitems
     * @return
     */
    public Layui getOrderitemMsgByOsid(PageUtils page, Orderitems orderitems) {
        Layui layui = new Layui();
        layui.setCount(orderitemMapper.count(orderitems.getos_id()));
        layui.setData(orderitemMapper.queryItemByOsidAndLimit(orderitems.getos_id(),page.before(),page.after()));
        return layui;
    }

    /**
     * 删除子订单信息
     *
     * @param os_id
     * @return
     */
    public boolean delOrderitemsMsg(String os_id) {
        long osid = Long.parseLong(os_id);
        int i = orderitemsMapper.deleteOrderitemsMsgByOsid(osid);
        if(i == 1){
            return true;
        }else{
            return false;
        }
    }
}
