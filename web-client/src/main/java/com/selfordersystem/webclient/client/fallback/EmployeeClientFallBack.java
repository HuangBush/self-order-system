package com.selfordersystem.webclient.client.fallback;

import com.selfordersystem.common.entity.EmpTableModel;
import com.selfordersystem.common.entity.Employee;
import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.webclient.client.EmployeeClient;
import org.springframework.stereotype.Component;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/12
 */
@Component
public class EmployeeClientFallBack implements EmployeeClient {
    @Override
    public Layui getAllEmployee(PageUtils page) {
        System.out.println("错误返回");
        return null;
    }

    @Override
    public Employee getEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    @Override
    public EmpTableModel getEmployeeTable(String keyWord, String keyType) {
        return null;
    }
}
