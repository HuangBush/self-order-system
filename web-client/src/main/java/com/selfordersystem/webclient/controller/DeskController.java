package com.selfordersystem.webclient.controller;

import com.selfordersystem.webclient.client.DeskClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description 餐桌服务 增删查改
 * @date 2019/3/30
 */
@Controller
public class DeskController {

    @Autowired
    private DeskClient deskClient;

    /***
     * 查询所有餐桌
     * @param model
     * @return
     */
    @RequestMapping(value = "Desks",method = RequestMethod.GET)
    public String getAllDesk(Model model){
        model.addAttribute("list",deskClient.getAllDesk());
        return "service/index.jsp";
    }

    public String getDesk(Model model){
        return "";
    }
}
