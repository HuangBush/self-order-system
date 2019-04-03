package com.selfordersystem.loginservice.mapper;

import com.selfordersystem.common.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
@Mapper
public interface AdminMapper {

    /***
     * 管理员登录
     * @return
     */
    @Select("select * from admin where a_name = #{a_name} and a_password = #{a_password}")
    Admin Adminlogin(@Param("a_name")String a_name, @Param("a_password")String a_password);

}
