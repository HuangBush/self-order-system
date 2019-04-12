package com.selfordersystem.webclient.client;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.fallback.PayClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@FeignClient(value = "service-zuul/api-pay/",fallback = PayClientFallBack.class)
public interface PayClient {

    /***
     * 支付宝支付接口
     * @return
     * @throws IOException
     */
    @RequestMapping("alipay.do")
    public String alipay(@RequestParam("os_id") long os_id) throws IOException;

    /**
     * 获取返回信息 完成支付
     * @param os1
     * @return map
     * 0  当前订单详细
     * 1  判断 进入无加餐的页面
     * 2  原订单详细（加餐）
     * 3 判断 进入加餐页面 client/myMenu12.jsp
     * -1 错误
     *
     * @throws Exception
     */
    @RequestMapping("returnMsg.do")
    public Map<Integer, Orderitems> returnMsg(@RequestBody Orderitems os1,@RequestParam("out_trade_no") String out_trade_no) throws Exception;
}
