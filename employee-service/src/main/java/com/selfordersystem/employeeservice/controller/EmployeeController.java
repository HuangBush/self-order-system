package com.selfordersystem.employeeservice.controller;

import com.selfordersystem.common.entity.EmpTableModel;
import com.selfordersystem.common.entity.Employee;
import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.employeeservice.service.IEmployeeService;
import com.selfordersystem.employeeservice.service.impl.EmployeeServiceImpl;
import org.apache.ibatis.annotations.ResultMap;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @description
 * @date 2019/3/31
 */
@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeServiceImpl;

    /**
     * 获取分页中的所有员工信息
     * @param page 分页工具类
     * @return
     */
    @RequestMapping(value = "getAllEmployee")
    public Layui getAllEmployee(@RequestBody PageUtils page){
        System.out.println("服务提供者----员工---查询所有员工信息--分页"+page.getCurr());
        //获取分页员工信息
        List<Employee> employeeList = employeeServiceImpl.queryEmployeePage(page.before1(),page.after());
        System.out.println("-------------"+employeeList.get(0).gete_password());
        int count = employeeServiceImpl.count();
        Layui layui2 = new Layui();
        layui2.setCount(count);
        layui2.setData(employeeList);
        return layui2;
    }

    /**
     * 按照id或者tel获取员工信息
     * @param employee
     * @return
     */
    @RequestMapping("getEmployee")
    public Employee getEmployee(@RequestBody Employee employee){
        return employeeServiceImpl.queryEmployee(employee);
    }

    /**
     * 根据id修改员工信息
     * @param employee
     * @return
     */
    @RequestMapping("updateEmployee")
    public boolean updateEmployee(@RequestBody Employee employee){
        System.out.println("根据id修改员工信息-----------------"+employee.gete_id());
        return employeeServiceImpl.updateEmployee(employee);
    }

    /**
     * 增加员工
     * @param employee
     * @return
     */
    @RequestMapping("addEmployee")
    public boolean addEmployee(@RequestBody Employee employee){
        if(employee == null){
            return false;
        }
        return employeeServiceImpl.addEmployee(employee);
    }

    /**
     * 切换类型进行查询员工
     * @param keyWord 关键词
     * @param keyType 类型
     * @return
     */
    @RequestMapping("getEmployeeTable")
    public EmpTableModel getEmployeeTable( String keyWord, String keyType){
        List<Employee> list = new ArrayList<Employee>();
        Employee emp = new Employee();
        Employee emp1 = new Employee();
        if(keyType.equals("e_id")){
            long eid = Long.parseLong(keyWord);
            emp1.sete_id(eid);
            emp = employeeServiceImpl.queryEmployee(emp1);
        }else if(keyType.equals("e_tel")){
            long etel = Long.parseLong(keyWord);
            emp1.sete_tel(etel);
            emp = employeeServiceImpl.queryEmployee(emp1);
        }
        list.add(emp);
        EmpTableModel em = new EmpTableModel();
        em.setCode(0);
        em.setCount(1000);
        em.setData(list);
        return em;

    }
}

