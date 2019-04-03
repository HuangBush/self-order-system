package com.selfordersystem.loginservice.service;

import com.selfordersystem.common.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
public interface IEmployeeService {

    /**
     * 员工登录
     * @param employee
     * @return 员工信息
     */
    Employee EmployeeLogin(Employee employee);

}
