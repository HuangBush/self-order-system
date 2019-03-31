package com.selfordersystem.employeeservice.service;

import com.selfordersystem.common.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/31
 */
public interface IEmployeeService {

    /**
     * 员工登录
     * @param employee
     * @return 员工信息
     */
    Employee EmployeeLogin(Employee employee);

    /**
     * 添加员工
     * @param employee
     * @return boolean
     */
    boolean addEmployee(Employee employee);

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    boolean updateEmployee(Employee employee);

    /**
     查询所有员工信息或者按状态查询
     * e_position 等于 -1时 表示查询所有员工
     * @return
     */
    List<Employee> queryAllEmployee(int e_position);

    /**
     * 动态查询员工信息（id、tel）
     * @param employee
     * @return
     */
    Employee queryEmployee(Employee employee);

    /***
     * 按照分页获取内容
     * @param before
     * @param after
     * @return
     */
    public List<Employee> queryEmployeePage(int before,int after);

    /***
     * 计算有多少条数据
     * @return
     */
    public int count();
}
