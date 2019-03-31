package com.selfordersystem.deskservice.controller;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.deskservice.service.IDsekService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private IDsekService dsekServiceImpl;

    /**
     * 餐桌登录
     * @param desk
     * @return
     */
    @RequestMapping(value = "/loginDesk",method = RequestMethod.POST)
    public Desk loginDesk(Desk desk){
       Desk newDesk = dsekServiceImpl.loginDesk(desk);
       return newDesk;
    }

    /**
     * 根据餐桌id或名称 查询餐桌信息
     * @param desk
     * @return
     */
    @RequestMapping(value = "/getDesk")
    public Desk getDeskMsg(Desk desk){
        if(desk.getd_id() == null && (desk.getd_name() == null || desk.getd_name() == "")){
            System.out.println("输入值不规范");
            return null;
        }
        System.out.println("根据餐桌id或名称 查询餐桌信息--------------------");
        Desk desk1 = dsekServiceImpl.queryDesk(desk);
        return desk1;
    }

    /**
     * 获取所有餐桌信息
     * @return
     */
    @RequestMapping(value = "/getAllDesk",method = RequestMethod.GET)
    public List<Desk> getAllDesk(){
        List<Desk> deskList = dsekServiceImpl.queryAllDesk();
        return deskList;
    }

    /**
     * 根据餐桌名或id删除
     * @param desk
     * @return
     */
    @RequestMapping(value = "/deleteDesk")
    public boolean deleteDesk(Desk desk){
        if(desk.getd_id() == null && (desk.getd_name() == null || desk.getd_name() == "")){
            System.out.println("输入值不规范");
            return false;
        }
        boolean isD = dsekServiceImpl.deleteDesk(desk);
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
    public boolean addDesk(Desk desk){
        boolean isA = dsekServiceImpl.addDesk(desk);
        return isA;
    }

    /**
     * 修改餐桌信息
     * @param desk
     * @return
     */
    @RequestMapping(value = "/updateDesk")
    public boolean updateDesk(Desk desk){
        boolean isU = dsekServiceImpl.updateDesk(desk);
        return isU;
    }
}
