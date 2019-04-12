package com.selfordersystem.webclient.client.fallback;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.DeskClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/12
 */
@Component
public class DeskClientFallback implements DeskClient {
    @Override
    public List<Desk> getAllDesk() {
        return null;
    }

    @Override
    public Desk getDesk(Desk desk) {
        return null;
    }

    @Override
    public boolean deleteDesk(Desk desk) {
        return false;
    }

    @Override
    public boolean addDesk(Desk desk) {
        return false;
    }

    @Override
    public boolean updateDesk(Desk desk) {
        return false;
    }

    @Override
    public Orderitems querytDeskById(Desk desk) {
        return null;
    }

    @Override
    public boolean updateDeskPosition(long d_id) {
        return false;
    }
}
