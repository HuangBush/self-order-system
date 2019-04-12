package com.selfordersystem.webclient.controller;

import com.selfordersystem.common.entity.*;
import com.selfordersystem.webclient.client.DeskClient;
import com.selfordersystem.webclient.client.LoginClient;
import com.selfordersystem.webclient.client.MenuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;
import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@Controller
public class LoginController {

    @Autowired
    private LoginClient loginClient;
    @Autowired
    private DeskClient deskClient;
    @Autowired
    private MenuClient menuClient;

    /***
     * 后台登陆
     * @return map
     * 0 管理员成功  "countDesk.action";
     * 1 员工成功  "countDesk.action";
     * null失败 "service/login.jsp";
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String Login(Model model,HttpSession session, String username, String password, String role) {
        System.out.println("员工登录"+role);
        Map map = loginClient.AdminAndEmployeelogin(username, password, role);
        if (map == null){
            System.out.println("登录失败");
            return "redirect:service/login.jsp";
        }else if(map.containsKey(0)){
            System.out.println("管理员登录成功");
            //取出值 存入Session
            Object e  = new Admin();
            e =  map.get(0);
            session.setAttribute("admin", e);
            session.removeAttribute("emp");
            //进入主页
           // model.addAttribute("list",deskClient.getAllDesk());
            return "redirect:Desks";
        }else if(map.containsKey(1)){
            System.out.println("员工登录成功");
            //取出值 存入Session
            Object e  = new Employee();
            e =map.get(1);
            System.out.println("_______"+e.toString());
            session.setAttribute("emp", e);
            session.removeAttribute("admin");
            //进入主页
            model.addAttribute("list",deskClient.getAllDesk());
            return "redirect:Desks";
        }else {
            System.out.println("登录失败++++");
            return "redirect:service/login.jsp";
        }
    }

    /***
     * 退出
     * @param session
     * @return
     */
    @RequestMapping(value = "loginOut",method = RequestMethod.GET)
    public String loginOut(HttpSession session){
        System.out.println("退出管理系统——————————————————--");
        session.invalidate();
        return "redirect:service/login.jsp";
    }

    /***
     * 餐桌登录
     * @param desk
     * @return Map<Integer , Desk>
     * null 表示登录失败
     * 0 表示进入空闲点餐模式 "redirect:queryRecommendMenu.do";
     * 1  进入加餐模式 "redirect:client/isMydesk.jsp";   要再存一个again
     * 2 有未付款的订单 "redirect:client/isMydesk1.jsp";
     *
     */
    @RequestMapping(value = "clientLogin",method = RequestMethod.GET)
    public String LoginDesk(Desk desk , HttpSession session,Model model) {
        System.out.println("餐桌登录---------"+desk.getd_password());
        //登录的时候 清除掉为again的session
        session.removeAttribute("again"); //--------------------
        Map map = loginClient.LoginDesk(desk);
        if(map == null){
            System.out.println("登录失败");
        }else if (map.containsKey(0)){
            System.out.println("登录成功——-——进入空闲点餐模式");
            Desk d = (Desk) map.get(0);
            session.setAttribute("desk",d);
            System.out.println("1-------------------------------------");
            //获取所有推荐菜品信息
            Menu menu = new Menu();
            menu.setm_position((long) 2);
            List<Menu> menuList = menuClient.getAllMenu(menu);
            //存入到model
            model.addAttribute("menu",menuList);
            return "client/orderFood.jsp";
        }else if (map.containsKey(1)){
            System.out.println("登录成功——-——进入加餐模式");
            Desk d = (Desk) map.get(1);
            session.setAttribute("desk",d);
            session.setAttribute("again","again");
            System.out.println("1-------------------------------------");
            return "redirect:client/isMydesk.jsp";
        }else if (map.containsKey(2)){
            System.out.println("登录成功——-——有未付款订单");
            Desk d = (Desk) map.get(2);
            session.setAttribute("desk",d);
            System.out.println("1-------------------------------------");
            return "redirect:client/isMydesk1.jsp";
        }
        return null;
    }

    /***
     * 我的餐桌继续加餐
     * @return
     */
    @RequestMapping("addOrder")
    public String addOrder(HttpSession session,Model model){
        Desk desk = (Desk) session.getAttribute("desk");
        Orderitems os = loginClient.addOrder(desk);
        if (os == null){
            System.out.println("查询到了多个正在进行的总订单。请联系前台服务员");
            model.addAttribute("msg", "查询到了多个正在进行的总订单。请联系前台服务员");
            return "error.jsp";
        }else {
            System.out.println("查找这个餐桌之前的一个已付款总订单---------"+os.getOiList().get(0).getos_id());
            model.addAttribute("os1", os);
            session.setAttribute("os_pay", os);
            session.setAttribute("again", "again");
            System.out.println("我的餐桌继续加餐-------------"+os.getOiList().get(0).getos_id());
            return "client/againFood.jsp";
        }
    }

    /**
     * 不小心退出继续点餐
     * @return
     */
    @RequestMapping("continueOrder")
    public String continueOrder(HttpSession session,Model model){
        System.out.println("获取我的餐桌信息");
        Desk desk = (Desk) session.getAttribute("desk");
        Orderitems os = loginClient.continueOrder(desk);
        System.out.println("++++++++++++++"+os.toString());
        if (os == null) {
            System.out.println("未查询到总订单。请联系前台服务员");
            model.addAttribute("msg", "未查询到总订单。请联系前台服务员");
            return "redirect:error.jsp";
        }else {
            //获取总订单中的子订单 （子订单中要包含菜品的信息）
            List<Orderitem> oiList = os.getOiList();
            if(oiList == null || oiList.size() == 0){
                return "client/mydesk.jsp";
            }else {
                os.setos_id(oiList.get(0).getos_id());
                //计算该总订单各个子订单菜品的总数量
                long bageNum = 0;
                for (Orderitem orderitem : oiList) {
                    bageNum = orderitem.getoi_num()+bageNum;
                }
                model.addAttribute("bageNum", bageNum);
                //存入总订单和子订单信息
                model.addAttribute("oiList", oiList);
                model.addAttribute("os", os);
                return "client/mydesk.jsp";
            }
        }
    }

    /**
     * 清空未付款订单
     * @return boolean
     */
    @RequestMapping("cleanNoPayMenu")
    public String cleanNoPayMenu(HttpSession session,Model model) {
        System.out.println("清空未付款订单");
        Desk desk = (Desk) session.getAttribute("desk");
        boolean isD = loginClient.cleanNoPayMenu(desk);
        if(isD){
            //获取所有推荐菜品信息
            Menu menu = new Menu();
            menu.setm_position((long) 2);
            List<Menu> menuList = menuClient.getAllMenu(menu);
            //存入到model
            model.addAttribute("menu",menuList);
            return "client/orderFood.jsp";
        }else {
            System.out.println("未查询到总订单信息------清除未付款");
            return "error.jsp";
        }
    }

    /**
     * 获取推荐菜品信息
     * @param model
     * @return
     *//*
    public  String getMenu2(Model model){
        //获取所有推荐菜品信息
        Menu menu = new Menu();
        menu.setm_position((long) 2);
        List<Menu> menuList = menuClient.getAllMenu(menu);
        //存入到model
        model.addAttribute("menu",menuList);
        return "client/orderFood.jsp";
    }*/

    /***
     * 结束用餐
     * @return
     */
    @RequestMapping("leaveDesk")
    public String leaveDesk(HttpSession session){
        System.out.println("结束用餐");
        Desk desk = (Desk) session.getAttribute("desk");
        boolean isL = loginClient.leaveDesk(desk);
        if(isL){
            System.out.println("餐桌状态修改成功++++++++++++++====");
            //当所有删除订单信息删除成功后，再将desk的session删除
            session.removeAttribute("desk");
            //session.removeAttribute("again");
            return "redirect:leaveDesk.jsp";
        }else {
            System.out.println("修改失败");
            return "error.jsp";
        }
    }
}