package com.selfordersystem.webclient.client;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.utils.FileUploadUtil;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.webclient.client.fallback.MenuClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/31
 */
@FeignClient(value = "service-zuul/api-menu/",fallback = MenuClientFallBack.class)//使用网关地址
public interface MenuClient {

    @GetMapping("getMenuPage")
    Layui getMenuPage(PageUtils pageUtils);

    /**
     * 根据菜品id获取信息
     * @param m_id
     * @return
     */
    @GetMapping("getMenu")
     Menu getMenu(@RequestParam("m_id") int m_id);

    /**
     * 添加菜品
     * @param menu
     * @return
     */
    @RequestMapping("addMenu")
     boolean addMenu(Menu menu);

    /***
     * 动态修改菜品信息
     * 把需要的修改的值传入
     * 状态 0 在售 2 推荐 3 下架
     * @param menu
     * @return
     */
    @RequestMapping("updateMenu")
     boolean updateMenu(Menu menu) ;

    /**
     * 查询所有菜品：传空值
     * 查询推荐菜品：只传m_position == 2
     * 查询各类型菜品 ： 只传入 m_type == ?
     *
     * @param menu
     * @return
     */
    @RequestMapping("getAllMenu")
    List<Menu> getAllMenu(Menu menu);

}
