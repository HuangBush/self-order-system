package com.selfordersystem.loginservice.service;

import com.selfordersystem.common.entity.Desk;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/1
 */
public interface IDeskService {

    /***
     * 根据餐桌id和密码查找餐桌
     * @param desk
     * @return
     */
    Desk queryDeskByIdAndPassword(Desk desk);

    /***
     * 修改餐桌的状态根据餐桌id
     * @return
     * 3/1 黄逸峰
     */
    int updateDeskPositionByDid(long d_position,long d_id);
}
