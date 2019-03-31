package com.selfordersystem.webclient.controller;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.utils.FileUploadUtil;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.webclient.client.MenuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description  菜品服务
 * @date 2019/3/31
 */
@Controller
public class MenuController {

    @Autowired
    private MenuClient menuClient;

    /**
     * 分页查询菜品
     * @param model
     * @param pageUtils
     * @return
     */
    @RequestMapping(value = "menus",method = RequestMethod.GET)
    public @ResponseBody Layui getMenuPage(Model model, PageUtils pageUtils){
        System.out.println("进入到菜品的分页查询"+pageUtils.getCurr());
        return menuClient.getMenuPage(pageUtils);
    }

    /**
     * 修改菜品状态
     * @param menu
     */
    @RequestMapping(value = "menu",method = RequestMethod.PUT)
    public @ResponseBody void updateMenu(Menu menu){
        System.out.println("修改菜品状态"+menu.getm_id());
        menuClient.updateMenu(menu);
    }

    /**
     * 根据菜品编号查询菜品
     * @param m_id
     */
    @RequestMapping(value = "menu",method = RequestMethod.GET)
    public String getMenu(Model model,int m_id){
        System.out.println("根据菜品编号查询菜品"+m_id);
        model.addAttribute("menu",menuClient.getMenu(m_id));
        return "service/updateMenu.jsp";
    }

    /**
     * 新菜品上传图片后返回路径
     * @param file
     */
    @RequestMapping("uploadPicture")
    public @ResponseBody Layui updateImg(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
        //获取照片上传
        System.out.println("上传照片+++++++++++++++="+file.toString());
        String filePath = FileUploadUtil.upload(file, request);
        System.out.println("上传照片2222---------"+filePath);
        Layui lay = new Layui();
        lay.setPath(filePath);
        return lay;
    }

    /**
     * 添加新菜品
     * @param menu
     */
    @RequestMapping(value = "menu",method = RequestMethod.POST)
    public String addNewMenu(Menu menu){
        menuClient.addMenu(menu);
        return "redirect:service/menuManager.jsp";
    }

}
