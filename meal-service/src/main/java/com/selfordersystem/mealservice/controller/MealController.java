package com.selfordersystem.mealservice.controller;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.mealservice.service.IMenuService;
import com.selfordersystem.mealservice.service.IOrderService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@RestController
public class MealController {

    @Resource
    private IMenuService menuServiceImpl;

    @Resource
    private IOrderService orderServiceImpl;

    /**
     * 按照菜单类别获取菜品
     * @param menu
     * @return map
     * 0 返回 mList
     */
    @RequestMapping("getClassMenu")
    public Map<Integer,Object> getClassMenu(@RequestParam("d_id") long d_id, @RequestBody Menu menu){
        System.out.println(d_id+"按照菜单类别获取菜品-----------"+menu.getm_type());
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        //查询所有菜单
        List<Menu> mList = menuServiceImpl.getClassMenu(menu);
        //model.addAttribute("menu", mList);
        map.put(0,mList);
        //查询该餐桌是否有状态为0的总订单
        Orderitems orderitems = orderServiceImpl.getOrderAllMsg(d_id,0);
        //System.out.println("查询该餐桌是否有状态为0的总订单------"+orderitems.toString());
        //如果没有总订单，则直接返回
        if(orderitems == null){
            System.out.println("获取所有推荐菜品:如果没有总订单，则直接返回");
            return  map;
        }else {
            //那么获取所有子订单信息
            List<Orderitem> oiList = orderitems.getOiList();
            //如果没有子订单
            if (oiList.size() == 0){
                System.out.println("没有子订单------");
                //存入徽章数 为0
                Integer bageNum = 0;
                map.put(1,bageNum);
                return map;
            }else {
                System.out.println("如果有子订单，那么获取徽章数------");
                //如果有子订单，那么获取徽章数
                System.out.println("//那么获取所有子订单信息"+oiList.get(0).getoi_id());
                //将用户选择的菜品数量 装入到menu类的number属性中
                long bageNum = 0;//计算该总订单各个子订单菜品的总数量
                for (Orderitem orderitem : oiList) {
                    bageNum = orderitem.getoi_num()+bageNum;
                    for (Menu menu1 : mList) {
                        if(menu1.getm_id().equals(orderitem.getMenu().getm_id())){
                            menu1.setM_number(orderitem.getoi_num());
                        }
                    }
                }
                System.out.println("如果有子订单，那么获取徽章数+++++"+bageNum);
                map.put(1,bageNum);
                return map;
            }
        }
    }

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
    public Orderitems mydesk(@RequestParam("d_id")long d_id){
        System.out.println("获取我的餐桌信息");
        //查询该餐桌是否有状态为0的总订单
        Orderitems orderitems = orderServiceImpl.getOrderAllMsg(d_id,0);
        if(orderitems != null){
            //获取总订单中的子订单 （子订单中要包含菜品的信息）
           // List<Orderitem> oiList =orderitems.getOiList();
            //orderitems.setos_id(oiList.get(0).getos_id());
            //计算该总订单各个子订单菜品的总数量
            //model.addAttribute("bageNum", bageNum);
            //存入总订单和子订单信息
            //model.addAttribute("oiList", oiList);
           // map.put(1,oiList);
            //model.addAttribute("os", osList.get(0));
            //return "client/mydesk.jsp";
            return  orderitems;

        }else{
            System.out.println("我的餐桌没有任何总订单");
            //return "redirect:client/mydesk.jsp";
            return  null;
        }
    }

    /***
     * 加入我的菜单
     * @param m_id
     * @return
     */
    @RequestMapping(value="/addMenu",produces="text/plain;charset=utf-8")
    public String addMenu(@RequestParam("m_id") long m_id,@RequestParam("d_id")long d_id){
        //根据菜品id获取菜品信息
        Menu menu = menuServiceImpl.queryMenuById(m_id);
        //查询该餐桌是否有状态为0的总订单
        Orderitems orderitems = orderServiceImpl.queryOrderAndMenuMsgByDidAndPosition2(d_id,0);
        //System.out.println("bbbbbbbb"+osList.get(0).getos_regtime());
        //如果没有则 创建一个该餐桌的总订单
        if(orderitems == null){
            Orderitems os = new Orderitems();
            os.setd_id(d_id);
            boolean isA = orderServiceImpl.addOrderitems(os);
            if(isA){
                System.out.println("成功创建一个该餐桌的总订单----获取到返回的os_id"+os.getos_id());
                //根据菜品信息创建一个子订单
                Orderitem oi = new Orderitem(os.getos_id(),menu.getm_id(),(long)1,menu.getm_price());
                boolean isAdd = orderServiceImpl.addOrderitem(oi);
                if(isAdd){
                    System.out.println("成功：根据菜品信息创建一个子订单");
                    return "1";
                }else{
                    System.out.println("失败：根据菜品信息创建一个子订单");
                    return "0";
                }
            }else{
                System.out.println("失败：创建一个该餐桌的总订单-----------");
                return "0";
            }
        } else{
            long os_id = 0;
            if( orderitems.getos_id() == null){
                System.out.println("____________"+orderitems.getos_id());
                os_id = orderitems.getOiList().get(0).getos_id();
            }else {
                os_id = orderitems.getos_id();
            }
            System.out.println("如果有，则获取该总订单信息----------"+os_id+orderitems.getd_id());
            //根据菜品id查找总订单中的子订单（总订单中不能存在相同菜品的子订单）
            Orderitem oi1 = orderServiceImpl.queryOrderitemByMidAndOsid(menu.getm_id(), os_id);
            //如果为null  则根据菜品信息创建一个子订单
            if(oi1 == null){
                Orderitem oi2 = new Orderitem(os_id,menu.getm_id(),(long)1,menu.getm_price());
                boolean isA = orderServiceImpl.addOrderitem(oi2);
                if(isA){
                    System.out.println("成功：如果为null  则根据菜品信息创建一个子订单");
                    return "1";
                }else{
                    System.out.println("失败：如果为null  则根据菜品信息创建一个子订单");
                    return "0";
                }
            }else{
                //如果存在 则直接修改子订单信息信息
                int l = orderServiceImpl.updateOrderitemAdd(oi1);
                if(l ==1 ){
                    System.out.println("成功：如果存在 则直接修改菜品信息"+oi1.getoi_id());
                    return "1";
                }else{
                    System.out.println("失败：如果存在 则直接修改菜品信息");
                    return "0";
                }
            }
        }
    }

    /***
     * 减少一分操作
     * @param m_id
     * @return
     */
    @RequestMapping(value="/decMenu.do",produces="text/plain;charset=utf-8")
    public  String decMenu(@RequestParam("m_id") long m_id,@RequestParam("d_id")long d_id){
        //根据菜品id获取菜品信息
        Menu menu = menuServiceImpl.queryMenuById(m_id);
        //查询该餐桌是否有状态为0的总订单
        Orderitems orderitems = orderServiceImpl.getOrderAllMsg(d_id,0);
        //没有
        if(orderitems== null){
            System.out.println("失败：查询该餐桌是否有状态为0的总订单---");
            return "0";
        }else{
            long os_id = 0;
            if( orderitems.getos_id() == null){
                os_id = orderitems.getOiList().get(0).getos_id();
            }else {
                os_id = orderitems.getos_id();
            }
            //根据菜品id查找总订单中的子订单（总订单中不能存在相同菜品的子订单）
            Orderitem oi1 = orderServiceImpl.queryOrderitemByMidAndOsid(menu.getm_id(), os_id);
            if(oi1 == null){
                System.out.println("失败：根据菜品id查找总订单中的子订单");
                return "0";
            }else{

                int l = orderServiceImpl.updateOrderitemDec(oi1);
                if(l ==1 ){
                    //查询子订单信息
                    Orderitem oi2 = orderServiceImpl.queryOrderitemByMidAndOsid(oi1.getm_id(), oi1.getos_id());
                    if(oi2.getoi_num() == 0){
                        //如果数量等于0，那么彻底删除这个子订单
                        orderServiceImpl.deleteOrderitemByOiid(oi1.getoi_id());
                        System.out.println("成功：如果数量等于0，那么彻底删除这个子订单");
                        return "1";
                    }else{
                        System.out.println("成功：如果存在 则直接修改菜品信息"+oi1.getoi_id());
                        return "1";
                    }
                }else{
                    System.out.println("失败：如果存在 则直接修改菜品信息");
                    return "0";
                }
            }
        }
    }

    /***
     * 清空餐桌
     * @param os_id
     * @return
     */
    @RequestMapping("isEmpty")
    public boolean isEmpty(@RequestParam("os_id") long os_id){
        System.out.println("清空餐桌----------"+os_id);
        if(os_id == 0){
            return true;
        }else{
            //查找总订单
            Orderitems os = orderServiceImpl.queryOrderitsmByOsid(os_id);
            //查找所有子订单，并修改状态为3
            List<Orderitem> oiList = os.getOiList();
            int j = 0;
            for (Orderitem oi : oiList) {
                int i = orderServiceImpl.updateOrderitemPositionByOiid(3,oi.getoi_id());
                if(i == 0){
                    System.out.println("清空餐桌-----删除子菜单时失败！"+oi.getoi_id());
                    break;
                }else{
                    System.out.println("清空餐桌-----删除子菜单时成功！"+oi.getoi_id());
                    j++;
                }
            }
            //当把所有子订单都清空是，再清空总订单
            if(j == oiList.size()){
                int i = orderServiceImpl.updateOrderitemsPositionByOsid(3,os_id);
                if(i == 1){
                    System.out.println("清空餐桌-----删除总订单成功！"+os.getos_id());
                    return true;
                }else{
                    System.out.println("清空餐桌-----删除总订单失败！"+os.getos_id());
                    return false;
                }
            }else{
                System.out.println("子订单未完全清空");
                return false;
            }
        }
    }
}
