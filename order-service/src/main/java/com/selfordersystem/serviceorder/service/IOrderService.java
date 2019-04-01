package com.selfordersystem.serviceorder.service;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.entity.OredritemsTableModel;
import com.selfordersystem.common.utils.PageUtils;
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
     * 删除子订单信息
     * @param os_id
     * @return
     */
    boolean delOrderitemsMsg(String os_id);

}
