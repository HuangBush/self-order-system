package com.selfordersystem.webclient.client;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.fallback.MealClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@FeignClient(value = "service-zuul/api-meal/",fallback = MealClientFallBack.class)
public interface MealClient {

    /**
     * 按照菜单类别获取菜品
     * @param menu
     * @return map
     * 0 返回 mList
     */
    @RequestMapping("getClassMenu")
    public Map<Integer,Object> getClassMenu(@RequestParam("d_id") long d_id,@RequestBody Menu menu);

    /**
     * 获取我的餐桌信息
     * @param d_id
     * @return map
     * null  我的餐桌为空
     * 0,bageNum
     * 1,oiList
     * 2,os
     */
    @RequestMapping("mydesk")
    public Orderitems mydesk(@RequestParam("d_id")long d_id);

    /***
     * 加入我的菜单
     * @param m_id
     * @return
     */
    @RequestMapping(value="/addMenu")
    public String addMenu(@RequestParam("m_id") long m_id,@RequestParam("d_id")long d_id);

    /***
     * 减少一分操作
     * @param m_id
     * @return
     */
    @RequestMapping(value="/decMenu.do")
    public  String decMenu(@RequestParam("m_id") long m_id,@RequestParam("d_id")long d_id);

    /***
     * 清空餐桌
     * @param os_id
     * @return
     */
    @RequestMapping("isEmpty")
    public boolean isEmpty(@RequestParam("os_id") long os_id);
}
