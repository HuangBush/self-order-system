package com.selfordersystem.serviceorder.service;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.entity.OredritemsTableModel;
import com.selfordersystem.common.utils.PageUtils;
import org.apache.ibatis.annotations.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
public interface IOrderService {

    /**
     * 分页：仅获取总订单信息
     * @param pageUtils
     * @return
     */
    Layui getOrderitemsPage(PageUtils pageUtils);

    /**
     * 切换查询 总订单
     * 按订单id 和 桌面id
     * @param keyWord
     * @param keyType
     * @return
     */
     OredritemsTableModel getOrderitemsTable(String keyWord, String keyType);

    /**
     * 按照日期查询总订单信息
     * @param orderitems
     * @return
     */
    OredritemsTableModel getOrderitemsByDate(Orderitems orderitems);

    /**
     * 根据总订单id查询所有子订单 分页
     * @param page
     * @param orderitems
     * @return
     */
    Layui getOrderitemMsgByOsid(PageUtils page,Orderitems orderitems);

    /**
     * 删除总订单信息
     * @param os_id
     * @return
     */
    boolean delOrderitemsMsg(long os_id);

    /*                  提供给 登录服务                        */

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
    List<Orderitems> queryAllOrderitems(Orderitems orderitems);

    /***
     * 根据总订单id查找子订单信息(并获取菜品信息)
     * @param os_id
     * @return
     */
    List<Orderitem> queryItemByOsid(Long os_id);

    /***
     * 根据餐桌id和总订单状态总订单和所有子订单的信息 及其菜品信息
     * @param d_id
     * @return
     */
    Orderitems queryOrderAndMenuMsgByDidAndPosition(Long d_id, long os_position);

    /**
     * 根据总订单id修改子订单的状态
     * @param os_position
     * @param os_id
     * @return
     */
    int updateOrderitemPositionByOsid(long os_position,long os_id);

    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    boolean updateOrderitemsPositionById(long os_position,long os_id);
}
