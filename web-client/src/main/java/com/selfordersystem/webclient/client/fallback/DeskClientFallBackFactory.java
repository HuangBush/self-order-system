package com.selfordersystem.webclient.client.fallback;

import com.selfordersystem.webclient.client.DeskClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description  fallBack 工厂  能够打印更多信息
 * @date 2019/4/12
 */
@Component
public class DeskClientFallBackFactory implements FallbackFactory<DeskClient> {

    private DeskClientFallback deskClientFallback;

    public DeskClientFallBackFactory(DeskClientFallback deskClientFallback) {
        this.deskClientFallback = deskClientFallback;
    }

    @Override
    public DeskClient create(Throwable throwable) {
        //打印下异常
        throwable.printStackTrace();
        return deskClientFallback;
    }
}
