package com.selfordersystem.deskservice.service.impl;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.deskservice.mapper.DeskMapper;
import com.selfordersystem.deskservice.service.IDsekService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  实现Desk接口
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/3/29
 */
@Service
public class DeskServiceImpl implements IDsekService{

    @Resource
    private DeskMapper deskMapper;

    /**
     * 餐桌登录
     * @param desk
     * @return 餐桌信息
     */
    public Desk loginDesk(Desk desk) {
        Desk newDesk = deskMapper.queryDeskByIdAndPassword(desk);
        if(newDesk == null ){
            System.out.println("登录失败");
            return null;
        }
        System.out.println("登录成功");
        return newDesk;
    }

    @Override
    public boolean addDesk(Desk desk) {
        //添加餐桌时，如果餐桌名已经存在，则不能添加
        Desk newDesk = deskMapper.queryDeskByName(desk);
        if(newDesk != null){
            System.out.println("添加桌子失败,桌子已存在");
            return false;
        }else{
            int i = deskMapper.addDesk(desk);
            if (i == 1){
                System.out.println("添加桌子成功");
                return true;
            }else{
                System.out.println("添加桌子失败");
                return false;
            }
        }
    }

    @Override
    public boolean deleteDesk(Desk desk) {
            int i = deskMapper.deleteDesk(desk);
            if (i == 1){
                System.out.println("删除桌子成功");
                return true;
            }else{
                System.out.println("删除桌子失败");
                return false;
            }
    }

    @Override
    public boolean updateDesk(Desk desk) {
        int i = deskMapper.updateDesk(desk);
        if(i == 1){
            System.out.println("修改成功");
            return true;
        }
        return false;
    }

    @Override
    public List<Desk> queryAllDesk() {
        return deskMapper.queryAllDesk();
    }

    @Override
    public Desk queryDesk(Desk desk) {
        Desk desk1 = deskMapper.queryDesk(desk);
        return desk1;
    }
}
