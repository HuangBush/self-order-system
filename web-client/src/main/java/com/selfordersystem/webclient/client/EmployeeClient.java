package com.selfordersystem.webclient.client;

import com.selfordersystem.common.entity.EmpTableModel;
import com.selfordersystem.common.entity.Employee;
import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/31
 */
@FeignClient("service-zuul/api-employee/")
public interface EmployeeClient {

    /**
     * 获取分页中的所有员工信息
     * @param page
     * @return
     */
    @RequestMapping(value = "/getAllEmployee")
    Layui getAllEmployee(PageUtils page);

    /**
     * 按照id或者tel获取员工信息
     * @param employee
     * @return
     *
     * 其中 @RequestMapping（）也可以用
     */
    @GetMapping("getEmployee")
     Employee getEmployee(Employee employee);

    /**
     * 根据id修改员工信息
     * @param employee
     * @return
     */
    @GetMapping("updateEmployee")
     boolean updateEmployee(Employee employee);

    /**
     * 增加员工
     * @param employee
     * @return
     */
    @GetMapping("addEmployee")
     boolean addEmployee(Employee employee);

    /**
     * 切换类型进行查询员工
     * @param keyWord 关键词
     * @param keyType 类型
     * @return
     */
    @GetMapping("getEmployeeTable")
     EmpTableModel getEmployeeTable(@RequestParam("keyWord") String keyWord,@RequestParam("keyType") String keyType);

}
