package com.selfordersystem.deskservice.controller;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.deskservice.service.IDsekService;
import com.selfordersystem.deskservice.service.IOrderService;
import com.selfordersystem.deskservice.service.impl.DeskServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 餐桌管理服务
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description 餐桌管理服务 增删查改
 * @date 2019/3/30
 */
@RestController
public class DeskController {

    @Resource
    private IDsekService deskServiceImpl;

    @Resource
    private IOrderService orderService;

    /**
     * 餐桌登录
     * @param desk
     * @return
     */
    @RequestMapping(value = "/loginDesk",method = RequestMethod.POST)
    public Desk loginDesk(Desk desk){
       Desk newDesk = deskServiceImpl.loginDesk(desk);
       return newDesk;
    }

    /**
     * 根据餐桌id或名称 查询餐桌信息 以及所包含的订单信息
     * @param desk
     * @return
     */
    @RequestMapping(value = "/getDesk")
    public Desk getDeskMsg(@RequestBody Desk desk){
        System.out.println("+++++++++"+desk.getd_id());
        if(desk.getd_id() == null & desk.getd_name() == null){
            System.out.println("输入值不规范");
            return null;
        }
        System.out.println("根据餐桌id或名称 查询餐桌信息--------------------");
        Desk desk1 = deskServiceImpl.queryDesk(desk);
        return desk1;
    }

    /**
     * 获取所有餐桌信息
     * @return
     */
    @RequestMapping(value = "/getAllDesk",method = RequestMethod.GET)
    public List<Desk> getAllDesk(){
        System.out.println("查询所有餐桌");
        List<Desk> deskList = deskServiceImpl.queryAllDesk();
        System.out.println("++++++++"+deskList.get(0));
        return deskList;
    }

    /**
     * 根据餐桌名或id删除
     * @param desk
     * @return
     */
    @RequestMapping(value = "/deleteDesk")
    public boolean deleteDesk(@RequestBody Desk desk){
        System.out.println("根据餐桌名或id删除"+desk.getd_name());
        if(desk.getd_id() == null & desk.getd_name() == null){
            System.out.println("输入值不规范");
            return false;
        }
        desk.setd_position((long)3);
        boolean isD = deskServiceImpl.updateDesk(desk);
        if(!isD){
            System.out.println("删除失败");
            return false;
        }
        return true;
    }

    /**
     * 添加桌子
     * @param desk
     * @return
     */
    @RequestMapping(value = "/addDesk")
    public boolean addDesk(@RequestBody Desk desk){
        boolean isA = deskServiceImpl.addDesk(desk);
        return isA;
    }

    /**
     * 修改餐桌信息
     * @param desk
     * @return
     */
    @RequestMapping(value = "/updateDesk")
    public boolean updateDesk(@RequestBody Desk desk){
        boolean isU = deskServiceImpl.updateDesk(desk);
        return isU;
    }

      /**
     * 根据id查询桌面
     * @return
     */
    @RequestMapping("querytDeskById")
    public Orderitems querytDeskById(@RequestBody Desk desk){
        Desk d = deskServiceImpl.queryDesk(desk);
        // model.addAttribute("desk", desk);
        if(d.getd_position()==(long)1){
            //桌面状态为1则将信息找出来
            Orderitems order= orderService.queryOrderAndMenuMsgByDidAndPosition(desk.getd_id(), 1);
            System.out.println("----------------------------------");
            if(order!=null){
                //如果能找到这个桌子的订单则将信息传过去
                //model.addAttribute("size", order.getOiList().size());
                // model.addAttribute("order", order);
                // String d_name = desk.getd_name();
                // model.addAttribute("d_name", d_name);
                return order;
            }else {
                return null;
            }
        }//桌面为空跳至桌面管理
        return null;
    }

    /**
     * 根据修改桌子状态
     * @param d_id
     */
    @RequestMapping("updateDeskPositionByName")
    public boolean updateDeskPosition(@RequestParam("d_id") long d_id){
        System.out.println("根据桌名修改桌子状态"+d_id);
        Orderitems orderitems = orderService.queryOrderAndMenuMsgByDidAndPosition2(d_id,0);
        //修改桌子状态为0
        Desk desk = new Desk();
        desk.setd_id(d_id);
        desk.setd_position((long)0);
        boolean isD = deskServiceImpl.updateDesk(desk);
        System.out.println("_______"+isD);
        if (orderitems == null){
            if (isD){
                System.out.println("修改餐桌状态成功");
                return true;
            }
        }else {
            //修改状态为0
            orderService.updateOrderitemsPositionById(3,orderitems.getos_id());
            orderService.updateOrderitemPositionByOsid(3,orderitems.getos_id());
            if(isD){
                System.out.println("修改餐桌状态成功");
                return true;
            }
        }
        return false;
    }
}
