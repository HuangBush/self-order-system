package com.selfordersystem.webclient.client;

import com.selfordersystem.common.entity.Desk;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/30
 */
@FeignClient("service-zuul/api-desk/")
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
}
