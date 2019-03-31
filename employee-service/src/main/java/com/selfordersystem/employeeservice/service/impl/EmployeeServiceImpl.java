package com.selfordersystem.employeeservice.service.impl;

import com.selfordersystem.common.entity.Employee;
import com.selfordersystem.employeeservice.mapper.EmployeeMapper;
import com.selfordersystem.employeeservice.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/31
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Employee EmployeeLogin(Employee employee) {
        return employeeMapper.EmployeeLogin(employee);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        int i = employeeMapper.addEmployee(employee);
        if (i != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        //如果id为空 ，那么 不进行更新，返回失败
        if(employee.gete_id() == null ){
            return false;
        }
        int i = employeeMapper.updateEmployee(employee);
        if (i != 1){
            return  false;
        }
        return true;
    }

    @Override
    public List<Employee> queryAllEmployee(int e_position) {
        return employeeMapper.queryAllEmployee(e_position);
    }

    @Override
    public Employee queryEmployee(Employee employee) {
        //如果id和电话为空 则不进行查询
        if (employee.gete_id() == null && employee.gete_tel() == null){
            return null;
        }
        return employeeMapper.queryEmployee(employee);
    }

    @Override
    public List<Employee> queryEmployeePage(int before, int after) {
        return employeeMapper.queryEmployeePage(before,after);
    }

    @Override
    public int count() {
        return employeeMapper.count();
    }
}
