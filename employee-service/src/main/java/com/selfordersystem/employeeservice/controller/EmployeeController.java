package com.selfordersystem.employeeservice.controller;

import com.selfordersystem.common.entity.EmpTableModel;
import com.selfordersystem.common.entity.Employee;
import com.selfordersystem.employeeservice.service.IEmployeeService;
import com.selfordersystem.employeeservice.service.impl.EmployeeServiceImpl;
import org.apache.ibatis.annotations.ResultMap;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeServiceImpl;

    /**
     * 获取所有员工或者按照状态
     * 其中为-1时获取所有员工
     * @param e_position
     * @return
     */
    @RequestMapping("getAllEmployee")
    public List<Employee> getAllEmployee(int e_position){
        if(e_position < -1 && e_position >1){
            return null;
        }
        return employeeServiceImpl.queryAllEmployee(e_position);
    }

    /**
     * 按照id或者tel获取员工信息
     * @param employee
     * @return
     */
    @RequestMapping("getEmployee")
    public Employee getEmployee(Employee employee){
        return employeeServiceImpl.queryEmployee(employee);
    }

    /**
     * 根据id修改员工信息
     * @param employee
     * @return
     */
    @RequestMapping("updateEmployee")
    public boolean updateEmployee(Employee employee){
        return employeeServiceImpl.updateEmployee(employee);
    }

    /**
     * 增加员工
     * @param employee
     * @return
     */
    public boolean addEmployee(Employee employee){
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
    @RequestMapping("queryEmployeeMsgByIDorTel.action")
    public EmpTableModel queryEmployeeMsgByIDorTel( String keyWord, String keyType){
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

