package com.selfordersystem.webclient.controller;

import com.alipay.api.domain.OrderItem;
import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.webclient.client.MealClient;
import javafx.beans.binding.When;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@Controller
public class MealController {

    @Resource
    private MealClient mealClient;

    /**
     * 按照菜单类别获取菜品
     * @param menu
     * @return map
     * 0 返回 mList
     */
    @RequestMapping("getClassMenu")
    public String getClassMenu(HttpSession session, Menu menu,Model model){
        System.out.println("按照菜单类别获取菜品"+menu.getm_type());
        Desk desk = (Desk) session.getAttribute("desk");
        Map<Integer,Object> map = mealClient.getClassMenu(desk.getd_id(),menu);
        //Map<Integer,Object> map = mealClient.getClassMenu(1002,menu);
        if(map.containsKey(1)){
            Integer bageNum = (Integer) map.get(1);
            System.out.println("获得徽章数量"+bageNum);
            model.addAttribute("bageNum", bageNum);
        }
        Object o = new Menu();
        o = map.get(0);
        model.addAttribute("menu",o);
        return choiceMenu(menu.getm_type());
    }

    /**
     * 选择菜品页面
     * @param m_type
     * @return
     */
    public static String choiceMenu(String m_type){
        if(m_type == null) {
           return "client/orderFood.jsp";
        }
        else if(m_type.equals("酒水饮料")){
            return "client/drink.jsp";
        }
        else if(m_type.equals("精致小炒")){
            return "client/food1.jsp";
        }
        else if(m_type.equals("美味大餐")){
            return "client/food2.jsp";
        }
        else if(m_type.equals("招牌干锅")){
            return "client/food3.jsp";
        }
        else if(m_type.equals("营养靓汤")){
            return "client/food4.jsp";
        }else {
            return "error.jsp";
        }
    }

    /**
     * 获取我的餐桌信息
     * @return map
     * null  我的餐桌为空
     * 0,bageNum
     * 1,oiList
     * 2,os
     */
    @RequestMapping("mydesk")
    public String mydesk(HttpSession session,Model model){
        System.out.println("按照菜单类别获取菜品");
        Desk desk = (Desk) session.getAttribute("desk");
        Orderitems orderitems = mealClient.mydesk(desk.getd_id());
        //Map<Integer,Object> map = mealClient.mydesk(1002);
        if(orderitems == null){
            return "redirect:client/mydesk.jsp";
        }else if(orderitems.getos_allprice() == 0){
            return "redirect:client/mydesk.jsp";
        }else {
            List<Orderitem> oiList = orderitems.getOiList();
            orderitems.setos_id(oiList.get(0).getos_id());
           // System.out.println("总订单id"+orderitems.getos_id());
            long bageNum = 0;
            for (Orderitem orderitem : oiList) {
                bageNum = orderitem.getoi_num()+bageNum;
            }
            //System.out.println("徽章数"+bageNum+"----总订单信息"+os+"-------子订单信息"+orderItemList.get(0).toString());
            model.addAttribute("bageNum", bageNum);
            model.addAttribute("oiList", oiList);
            model.addAttribute("os", orderitems);
            return "client/mydesk.jsp";
        }
    }

    /***
     * 加入我的菜单
     * @param m_id
     * @return
     */
    @RequestMapping(value = "/addMenu.do", produces = "text/plain;charset=utf-8")
    public @ResponseBody  String addMenu(long m_id, HttpSession session) {
        System.out.println("加入我的菜单"+m_id);
        Desk desk = (Desk) session.getAttribute("desk");
        return mealClient.addMenu(m_id,desk.getd_id());
    }

    /***
     * 减少一分操作
     * @param m_id
     * @return
     */
    @RequestMapping(value = "/decMenu.do", produces = "text/plain;charset=utf-8")
    public @ResponseBody String decMenu(long m_id, HttpSession session) {
        System.out.println("减少一分操作");
        Desk desk = (Desk) session.getAttribute("desk");
        return mealClient.decMenu(m_id,desk.getd_id());
    }

    /***
     * 清空餐桌
     * @param os_id
     * @return
     */
    @RequestMapping("isEmpty")
    public String isEmpty(long os_id) {
        boolean isI = mealClient.isEmpty(os_id);
        if (isI){
            return "redirect:mydesk";
        }else {
            return "error.jsp";
        }
    }
}
