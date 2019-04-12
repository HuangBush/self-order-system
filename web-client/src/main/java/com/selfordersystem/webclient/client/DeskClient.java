package com.selfordersystem.webclient.client;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.fallback.DeskClientFallBackFactory;
import com.selfordersystem.webclient.client.fallback.DeskClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description   fallbackFactory 比 fallback 能在控制台打印更多信息，比如错误状态 但也要使用对应的工厂类
 * @date 2019/3/30
 */
@FeignClient(value = "service-zuul/api-desk/",fallbackFactory= DeskClientFallBackFactory.class)
public interface DeskClient {

    @GetMapping("getAllDesk")
    List<Desk> getAllDesk();

    @GetMapping("getDesk")
    Desk getDesk(Desk desk);

    @GetMapping("deleteDesk")
    boolean deleteDesk(Desk desk);

    @GetMapping("addDesk")
    boolean addDesk(Desk desk);

    @GetMapping("updateDesk")
    boolean updateDesk(Desk desk);

    /**
     * 根据id查询桌面
     * @return
     */
    @RequestMapping("querytDeskById")
    public Orderitems querytDeskById(Desk desk);

    /**
     * 根据修改桌子状态
     * @param d_id
     */
    @RequestMapping("updateDeskPositionByName")
    public boolean updateDeskPosition(@RequestParam("d_id") long d_id);
}
