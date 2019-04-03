package com.selfordersystem.loginservice.service.impl;

import com.selfordersystem.common.entity.Admin;
import com.selfordersystem.loginservice.mapper.AdminMapper;
import com.selfordersystem.loginservice.service.IAdminService;
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
public class AdminServiceImpl implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin Adminlogin(String a_name, String a_password) {
        return adminMapper.Adminlogin(a_name,a_password);
    }
}
