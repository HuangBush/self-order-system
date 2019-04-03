package com.selfordersystem.loginservice.service.impl;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.loginservice.mapper.DeskMapper;
import com.selfordersystem.loginservice.service.IDeskService;
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
public class DeskServiceImpl implements IDeskService {

    @Resource
    private DeskMapper deskMapper;

    @Override
    public Desk queryDeskByIdAndPassword(Desk desk) {
        return deskMapper.queryDeskByIdAndPassword(desk);
    }

    @Override
    public int updateDeskPositionByDid(long d_position, long d_id) {
        return deskMapper.updateDeskPositionByDid(d_position,d_id);
    }
}
