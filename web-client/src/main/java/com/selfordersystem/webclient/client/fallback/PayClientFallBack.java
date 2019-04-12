package com.selfordersystem.webclient.client.fallback;

import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.PayClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/12
 */
@Component
public class PayClientFallBack implements PayClient {
    @Override
    public String alipay(long os_id) throws IOException {
        return null;
    }

    @Override
    public Map<Integer, Orderitems> returnMsg(Orderitems os1, String out_trade_no) throws Exception {
        return null;
    }
}
