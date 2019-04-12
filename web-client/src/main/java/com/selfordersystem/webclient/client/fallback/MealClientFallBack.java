package com.selfordersystem.webclient.client.fallback;

import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.MealClient;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/12
 */
@Component
public class MealClientFallBack implements MealClient {
    @Override
    public Map<Integer, Object> getClassMenu(long d_id, Menu menu) {
        return null;
    }

    @Override
    public Orderitems mydesk(long d_id) {
        return null;
    }

    @Override
    public String addMenu(long m_id, long d_id) {
        return null;
    }

    @Override
    public String decMenu(long m_id, long d_id) {
        return null;
    }

    @Override
    public boolean isEmpty(long os_id) {
        return false;
    }
}
