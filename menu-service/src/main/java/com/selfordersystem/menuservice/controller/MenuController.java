package com.selfordersystem.menuservice.controller;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.utils.FileUploadUtil;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.menuservice.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description 菜品服务 增删采购
 * @date 2019/3/31
 */
@RestController
public class MenuController {

    @Autowired
    private IMenuService menuServiceImpl;

    /***
     * 分页查询
     * @return
     */
    @RequestMapping("getMenuPage")
    public Layui getMenuPage(@RequestBody PageUtils pageUtils) {
        return menuServiceImpl.getMenuPage(pageUtils.before1(),pageUtils.after());
    }

    /**
     * 根据菜品id获取信息
     * @param m_id
     * @return
     */
    @RequestMapping("getMenu")
    public Menu getMenu(@RequestParam("m_id") int m_id){
        System.out.println("根据菜品id获取信息 service-menu"+m_id);
        return menuServiceImpl.getMenu(m_id);
    }

    /**
     * 添加菜品
     * @param menu
     * @return
     */
    @RequestMapping("addMenu")
    public boolean addMenu(@RequestBody Menu menu){
        System.out.println("添加菜品"+menu.getm_name());
        return menuServiceImpl.addMenu(menu);
    }

    /***
     * 动态修改菜品信息
     * 把需要的修改的值传入
     * 状态 0 在售 2 推荐 3 下架
     * @param menu
     * @return
     */
    @RequestMapping("updateMenu")
    public boolean updateMenu(@RequestBody Menu menu) {
        System.out.println("----------动态修改菜品信息"+menu.getm_id());
        return menuServiceImpl.updateMenu(menu);
    }

    /*         给其它服务调用         */

    /**
     * 查询所有菜品：传空值
     * 查询推荐菜品：只传m_position == 2
     * 查询各类型菜品 ： 只传入 m_type == ?
     *
     * @param menu
     * @return
     */
    @RequestMapping("getAllMenu")
    List<Menu> getAllMenu(@RequestBody Menu menu) {
        return menuServiceImpl.queryAllMenu(menu);
    }
}
