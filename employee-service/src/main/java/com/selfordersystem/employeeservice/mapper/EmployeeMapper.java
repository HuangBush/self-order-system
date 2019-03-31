package com.selfordersystem.employeeservice.mapper;

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


    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Insert("insert into employee (e_name,e_password,e_job,e_tel,e_address,e_regdate,e_salary) " +
            "values(#{e_name},#{e_password},#{e_job},#{e_tel},#{e_address},#{e_regdate},#{e_salary})")
    int addEmployee(Employee employee);


    /***
     * 动态修改员工信息
     * 把需要的修改的值传入
     * @param employee
     * @return
     */
    @Update("<script>"+
            "update employee"+
            "<set>"+
            "<if test='e_name != null '>"+
            "e_name = #{e_name},"+
            "</if>"+
            "<if test='e_password != null '>"+
            "e_password = #{e_password},"+
            "</if>"+
            "<if test='e_tel != null '>"+
            "e_tel = #{e_tel},"+
            "</if>"+
            "<if test='e_address != null '>"+
            "e_address = #{e_address},"+
            "</if>"+
            "<if test='e_regdate != null'>"+
            "e_regdate = #{e_regdate},"+
            "</if>"+
            "</if>"+
            "<if test='e_job != null'>"+
            "e_job = #{e_job},"+
            "</if>"+
            "</if>"+
            "<if test='e_salary != null'>"+
            "e_salary = #{e_salary},"+
            "</if>"+
            "<if test='e_position != null'>"+
            "e_position = #{e_position},"+
            "</if>"+
            "</set>"+
            "<where>" +
            "<if test='e_id != null'>" +
            "e_id = #{e_id}" +
            "</if>" +
            "</where>"+
            "</script>")
    int updateEmployee(Employee employee);

    /***
     * 查询所有员工信息或者按状态查询
     * e_position 等于 -1时 表示查询所有员工
     * @return
     */
    @Select("<script> select * from employee where 1=1" +
            "<if test='e_position != -1'>" +
            "and e_position = #{e_position}" +
            "</if></script>")
    List<Employee> queryAllEmployee(@Param("e_position")int e_position);

    /**
     * 动态查询员工信息（id、tel）
     * @param employee
     * @return
     */
    @Select({"<script>" +
            "select * from employee where" +
            "<if test='e_id != null'>"+
            "e_id = #{e_id}"+
            "</if>",
            "<if test='e_tel != null'>"+
            "e_tel = #{e_tel}" +
            "</if>"+
            "</script>"})
    Employee queryEmployee(Employee employee);

    /***
     * 按照分页获取内容
     * @param before
     * @param after
     * @return
     */
    @Select("select * from employee limit #{before},#{after} ")
    public List<Employee> queryEmployeePage(@Param("before") int before,@Param("after") int after);

    /***
     * 计算有多少条数据
     * @return
     */
    @Select("select count(*) from employee")
    public int count();
}
