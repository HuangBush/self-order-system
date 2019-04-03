package com.selfordersystem.payservice.service;

import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
public interface IOrderService {

    /***
     * 根据总订单id查询总订单信息
     * 2/27
     * @param os_id
     * @return
     */
    Orderitems queryOrderitsmByOsid(long os_id);

    /***
     * 根据总订单id查找子订单信息
     * @param os_id
     * @return
     */
    List<Orderitem> queryItemByOsid(Long os_id);

    /***
     * 修改子订单状态
     * @param oi_id
     * @return
     */
    int updateOrderitemPositionByOiid(long oi_position,long oi_id);

    /***
     * 修改总订单状态
     * @param os_id
     * @return
     */
    int updateOrderitemsPositionByOsid(long os_position,long os_id);

    /***
     * 修改子订单的总订单id
     * @return
     */
    int updateOrderitemOsidByOiid(long os_id,long oi_id);

    /***
     * 根据总订单id修改总订单总价
     * @param os_allprice
     * @param os_id
     * @return
     */
    int updateOrderitemsPriceByOsid(float os_allprice,long os_id);

    /***
     * 彻底删除总订单
     * @param os_id
     * @return
     */
    int deleteOrderitemsByOsid(long os_id);
}
