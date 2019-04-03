package com.selfordersystem.payservice.service.impl;

import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.payservice.mapper.OrderMapper;
import com.selfordersystem.payservice.service.IOrderService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /***
     * 根据总订单id查询总订单信息
     * 2/27
     * @param os_id
     * @return
     */
    public Orderitems queryOrderitsmByOsid(long os_id) {
        return orderMapper.queryOrderitsmByOsid(os_id);
    }

    /***
     * 根据总订单id查找子订单信息
     * @param os_id
     * @return
     */
    public List<Orderitem> queryItemByOsid(Long os_id) {
        return orderMapper.queryItemByOsid(os_id);
    }

    /***
     * 修改子订单状态
     * @param oi_id
     * @return
     */
    @Override
    public int updateOrderitemPositionByOiid(long oi_position, long oi_id) {
        return orderMapper.updateOrderitemPositionByOiid(oi_position,oi_id);
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
     * 修改子订单的总订单id
     * @return
     */
    public int updateOrderitemOsidByOiid(long os_id, long oi_id) {
        return orderMapper.updateOrderitemOsidByOiid(os_id,oi_id);
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
     * 彻底删除总订单
     * @param os_id
     * @return
     */
    public int deleteOrderitemsByOsid(long os_id) {
        return orderMapper.deleteOrderitemsByOsid(os_id);
    }
}
