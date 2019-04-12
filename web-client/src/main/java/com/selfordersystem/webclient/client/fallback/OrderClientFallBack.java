package com.selfordersystem.webclient.client.fallback;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.entity.OredritemsTableModel;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.webclient.client.OrderClient;
import org.springframework.stereotype.Component;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/12
 */
@Component
public class OrderClientFallBack implements OrderClient {
    @Override
    public Layui getOrderitemsPage(PageUtils pageUtils) {
        return null;
    }

    @Override
    public Layui getOrderitemMsgPage(PageUtils page, long os_id) {
        return null;
    }

    @Override
    public boolean deleteOrderitems(long os_id) {
        return false;
    }

    @Override
    public OredritemsTableModel getOrderitemsTable(String keyWord, String keyType) {
        return null;
    }

    @Override
    public OredritemsTableModel getOrderitemsByDate(Orderitems orderitems) {
        return null;
    }
}
