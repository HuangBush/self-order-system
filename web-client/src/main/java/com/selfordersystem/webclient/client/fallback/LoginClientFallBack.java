package com.selfordersystem.webclient.client.fallback;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.LoginClient;
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
public class LoginClientFallBack implements LoginClient {
    @Override
    public Map<Integer, Object> AdminAndEmployeelogin(String username, String password, String role) {
        return null;
    }

    @Override
    public Map<Integer, Desk> LoginDesk(Desk desk) {
        return null;
    }

    @Override
    public Orderitems addOrder(Desk desk) {
        return null;
    }

    @Override
    public Orderitems continueOrder(Desk desk) {
        return null;
    }

    @Override
    public boolean cleanNoPayMenu(Desk desk) {
        return false;
    }

    @Override
    public boolean leaveDesk(Desk desk) {
        return false;
    }
}
