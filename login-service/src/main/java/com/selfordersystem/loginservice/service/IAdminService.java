package com.selfordersystem.loginservice.service;

import com.selfordersystem.common.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
public interface IAdminService {

    /***
     * 管理员登录
     * @return
     */
    Admin Adminlogin(String a_name,String a_password);
}
