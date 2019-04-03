package com.selfordersystem.loginservice.mapper;

import com.selfordersystem.common.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description 员工服务
 * @date 2019/3/31
 */
@Mapper
public interface EmployeeMapper {

    /***
     * 员工登录
     * @param employee
     * @return
     */
    @Select("select * from employee where e_tel = #{e_tel} and e_password = #{e_password} and e_position = 0")
    Employee EmployeeLogin(Employee employee);

}
