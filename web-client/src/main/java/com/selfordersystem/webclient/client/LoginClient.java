package com.selfordersystem.webclient.client;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.fallback.LoginClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@FeignClient(value = "service-zuul/api-login/",fallback = LoginClientFallBack.class)
public interface LoginClient {

    /***
     * 后台登陆
     * @return map
     * 0 管理员成功  "countDesk.action";
     * 1 员工成功  "countDesk.action";
     * null失败 "service/login.jsp";
     */
    @RequestMapping("login")
     Map<Integer,Object> AdminAndEmployeelogin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role);

    /***
     * 餐桌登录
     * @param desk
     * @return Map<Integer,Desk>
     * null 表示登录失败
     * 0 表示进入空闲点餐模式 "redirect:queryRecommendMenu.do";
     * 1  进入加餐模式 "redirect:client/isMydesk.jsp";   要再存一个again
     * 2 有未付款的订单 "redirect:client/isMydesk1.jsp";
     *
     */
    @RequestMapping("clientLogin")
    Map<Integer, Desk> LoginDesk(Desk desk);

    /***
     * 我的餐桌继续加餐
     * @param desk
     * @return
     */
    @RequestMapping("addOrder")
    Orderitems addOrder(@RequestBody Desk desk);

    /**
     * 不小心退出继续点餐
     * @param desk
     * @return
     */
    @RequestMapping("continueOrder")
    Orderitems continueOrder( Desk desk);

    /**
     * 清空未付款订单
     * @param desk
     * @return boolean
     */
    @RequestMapping("cleanNoPayMenu")
    public boolean cleanNoPayMenu( Desk desk);

    /***
     * 结束用餐
     * @return
     */
    @RequestMapping("leaveDesk")
    public boolean leaveDesk(Desk desk);
}
