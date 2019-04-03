package com.selfordersystem.loginservice.service.impl;

import com.selfordersystem.common.entity.Employee;
import com.selfordersystem.loginservice.mapper.EmployeeMapper;
import com.selfordersystem.loginservice.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Employee EmployeeLogin(Employee employee) {
        return employeeMapper.EmployeeLogin(employee);
    }
}
