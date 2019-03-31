package com.selfordersystem.webclient.client;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.utils.FileUploadUtil;
import com.selfordersystem.common.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/31
 */
@FeignClient("service-menu")
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

}
