package com.selfordersystem.webclient.client.fallback;

import com.selfordersystem.common.entity.Layui;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.utils.PageUtils;
import com.selfordersystem.webclient.client.MenuClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/12
 */
@Component
public class MenuClientFallBack implements MenuClient {
    @Override
    public Layui getMenuPage(PageUtils pageUtils) {
        return null;
    }

    @Override
    public Menu getMenu(int m_id) {
        return null;
    }

    @Override
    public boolean addMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean updateMenu(Menu menu) {
        return false;
    }

    @Override
    public List<Menu> getAllMenu(Menu menu) {
        return null;
    }
}
