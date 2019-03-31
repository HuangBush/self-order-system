package com.selfordersystem.deskservice.service;

import com.selfordersystem.common.entity.Desk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 餐桌 业务逻辑接口
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/29
 */
public interface IDsekService {

    /**
     * 餐桌登录
     * @param desk
     * @return
     */
    Desk loginDesk (Desk desk);

    /***
     * 添加餐桌
     * @param desk
     * @return
     */
    boolean addDesk(Desk desk);

    /***
     * 删除餐桌
     * @param desk
     * @return
     */
    boolean deleteDesk(Desk desk);

    /**
     * 修改餐桌
     * @param desk
     * @return
     */
    boolean updateDesk(Desk desk);

    /**
     * 查询所有餐桌
     * @return
     */
    List<Desk> queryAllDesk();

    /**
     * 查询特定的餐桌
     * @param desk
     * @return
     */
    Desk queryDesk(Desk desk);
}
