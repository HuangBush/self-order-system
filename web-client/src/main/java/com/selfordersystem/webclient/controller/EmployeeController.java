package com.selfordersystem.webclient.controller;

import com.selfordersystem.common.entity.EmpTableModel;
import com.selfordersystem.common.entity.Employee;
import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.webclient.client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description 餐桌服务 前端
 * @date 2019/3/31
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeClient employeeClient;

    /**
     * 获取分页员工信息
     * @param page
     * @return
     */
    @RequestMapping(value = "/allEmployee")
    public @ResponseBody Layui getAllEmployee( PageUtils page){
        System.out.println("进入到分页查询员工"+page.getCurr());
        Layui layui = employeeClient.getAllEmployee(page);
        return layui;
    }

    /**
     * 获取员工信息（id/tel）
     * @param employee
     * @param model
     * @return
     */
    @RequestMapping(value = "employee",method = RequestMethod.GET)
    public String getEmployee(Employee employee, Model model){
        System.out.println("获取员工信息（id/tel）"+employee.gete_id());
        Employee emp = employeeClient.getEmployee(employee);
        model.addAttribute("emp", emp);
        return "service/updateEmployeeMsg.jsp";
    }

    /**
     * 修改员工信息
     * @param model
     * @param employee
     * @return
     */
    @RequestMapping(value = "employee",method = RequestMethod.PUT)
    public @ResponseBody String updateEmployee(Model model, Employee employee){
        System.out.println("----------------"+employee.gete_id());
        boolean isU = employeeClient.updateEmployee(employee);
        if(isU){
            return "success";
        }else{
            model.addAttribute("error", "修改出现错误！请重试。。。");
            return "error";
        }
    }

    /**
     * 添加员工
     * @param model
     * @param employee
     * @return
     */
    @RequestMapping(value = "employee",method = RequestMethod.POST)
    public @ResponseBody String addEmployeeMsg(Model model,@RequestBody Employee employee){
        System.out.println("employee-------"+employee.gete_regdate());
        boolean isA = employeeClient.addEmployee(employee);
        if(isA){
            System.out.println("添加员工成功：client");
            return "成功";
        }else{
            model.addAttribute("error", "添加失败！请重试。。。");
            return "失败";
        }
    }

    /**
     * 切换类型进行查询
     *
     */
    @RequestMapping(value = "employees",method = RequestMethod.GET)
    public @ResponseBody
    EmpTableModel queryEmployeeMsgByIDorTel(Model model, @RequestParam("keyWord") String keyWord, @RequestParam("keyType") String keyType){
        System.out.println("进行切换查找-----"+keyType);
        EmpTableModel em = employeeClient.getEmployeeTable(keyWord,keyType);
        return em;

    }
}
