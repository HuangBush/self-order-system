package com.selfordersystem.loginservice.controller;

import com.selfordersystem.common.entity.*;
import com.selfordersystem.loginservice.service.IAdminService;
import com.selfordersystem.loginservice.service.IDeskService;
import com.selfordersystem.loginservice.service.IEmployeeService;
import com.selfordersystem.loginservice.service.IOrderService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.internal.crypto.Des;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description 登录服务
 * @date 2019/4/1
 */
@RestController
public class LoginController {

    @Resource
    private IAdminService adminServiceImpl;

    @Resource
    private IEmployeeService employeeServiceImpl;

    @Resource
    private IDeskService deskServiceImpl;

    @Resource
    private IOrderService orderService;

    /**
     * 员工登录
     * @param employee
     * @return
     */
    @RequestMapping("employeeLogin")
    public Employee employeeLogin(@RequestBody Employee employee){
        System.out.println("员工登录"+employee.gete_password());
        return employeeServiceImpl.EmployeeLogin(employee);
    }

    /**
     * 管理员
     * @return
     */
    @RequestMapping("adminLogin")
    public Admin adminLogin(@RequestParam("a_name") String a_name,@RequestParam("a_password") String a_password){
        System.out.println("管理员登录"+a_name);
        return adminServiceImpl.Adminlogin(a_name,a_password);
    }

    /***
     * 后台登陆
     * @return map
     * 0 管理员成功  "countDesk.action";
     * 1 员工成功  "countDesk.action";
     * null失败 "service/login.jsp";
     */
    @RequestMapping("login")
    public Map<Integer,Object> AdminAndEmployeelogin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role){
        System.out.println("-----------------------"+username);
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        Admin admin = null;
        Employee emp = null;
        if(role.equals("admin")){
            admin = adminServiceImpl.Adminlogin(username, password);
            //不存入Session，先放入map中
            //session.setAttribute("admin", admin);
            //session.removeAttribute("emp");
        }else if(role.equals("employee")){
            long etel = Long.parseLong(username);
            Employee employee = new Employee();
            employee.sete_tel(etel);
            employee.sete_password(password);
            emp = employeeServiceImpl.EmployeeLogin(employee);
            //session.setAttribute("emp", emp);
            //session.removeAttribute("admin");
        }
        if(admin != null){
            map.put(0,admin);
            System.out.println("登录中——————————管理员————————————");
            return map;
        }else if(emp != null){
            System.out.println("登录中———————————员工———————————");
            map.put(1,emp);
            return map;
        }else {
            //model.addAttribute("erroe", "登录失败！用户名或密码错误。。。");
            return null;
        }
    }



    /***
     * 餐桌登录
     * @param desk
     * @return Map<Integer,Desk>
     * null 表示登录失败
     * 0 表示进入空闲点餐模式 "redirect:queryRecommendMenu.do";
     * 1  进入加餐模式 "redirect:client/isMydesk.jsp";   要再存一个again
     * 2 有未付款的订单 "redirect:client/isMydesk1.jsp";
     *
     */
    @RequestMapping("clientLogin")
    public Map<Integer,Desk> LoginDesk(@RequestBody Desk desk){
        Map<Integer, Desk> map = new HashMap<Integer, Desk>();
        System.out.println("餐桌登录---------"+desk.getd_password());
        //登录的时候 清除掉为again的session
        //session.removeAttribute("again"); //--------------------
        Desk d = deskServiceImpl.queryDeskByIdAndPassword(desk);
        //查询是否存在未付款的订单
        Orderitems orderitems1 = new Orderitems();
        orderitems1.setos_position((long) 0);
        orderitems1.setd_id(desk.getd_id());
        List<Orderitems> osList = orderService.queryAllOrderitems(orderitems1);
        //查询是否存在已付款的订单
        Orderitems orderitems2 = new Orderitems();
        orderitems2.setos_position((long) 1);
        orderitems2.setd_id(desk.getd_id());
        List<Orderitems> osList1 = orderService.queryAllOrderitems(orderitems2);
        if(d == null){
            //登录失败
            //model.addAttribute("msg","抱歉，此二维码已失效，请联系前台服务员。");
            return null;
        }else{
            if(d.getd_position() == 1){
                //当餐桌显示有客时 但实际上没有客人 我们先查询是否有状态为0的总订单 且 总订单中要有子订单
                if(osList.size() > 0  ){
                    //查询总订单中是否有子订单的存在
                    List<Orderitem> oiList = orderService.queryItemByOsid(osList.get(0).getos_id());//未付款总订单
                    if(oiList != null){
                        //存在子订单
                        //有，那么进入到选择页面
                      //  session.setAttribute("desk", d);
                        System.out.println("当餐桌显示有客时 但实际上没有客人 我们先查询是否有状态为0的总订单--------有");
                        map.put(2,d);
                        return map;
                    }else{
                        //不存在状态为0的子订单 那么就进入到空闲点餐模式 同时删除这个总订单
                        orderService.deleteOrderitems(osList.get(0).getos_id());
                        System.out.println("不存在状态为0的子订单 那么就进入到空闲点餐模式 同时删除这个总订单");
                        //session.setAttribute("desk", d);
                        map.put(0,d);
                        return map;
                    }
                }else if(osList1.size() > 0){
                    //查询总订单中是否有子订单的存在
                    List<Orderitem> oiList1 = orderService.queryItemByOsid(osList1.get(0).getos_id());//已付款总订单
                    if(oiList1.size() > 0){
                        //存在子订单
                        //没有状态为0的总订 但有状态为1的  我们就进入到加餐页面
                        //当餐桌有客人时 进入是否加餐页面,如果确认进入加餐，那么也能查看到正在进行的的订单信息
                       // session.setAttribute("desk", d);
                       // session.setAttribute("again", "again"); --------------
                        map.put(1,d);
                        return map;
                    }else{
                        //不存在状态为1的子订单 那么就进入到空闲点餐模式 同时删除这个总订单
                        orderService.deleteOrderitems(osList1.get(0).getos_id());
                        System.out.println("不存在状态为1的子订单 那么就进入到空闲点餐模式 同时删除这个总订单");
                       // session.setAttribute("desk", d);
                        map.put(0,d);
                        return map;
                    }
                }else{
                    //没有状态为0或1的订单 但餐桌是有人状态  那么直接进入到空闲点餐模式
                    //或者有总订单为0 或1 但没有任何子订单信息 那么直接进入到空闲点餐模式
                    System.out.println("没有状态为0或1的订单 但餐桌是有人状态  那么直接进入到空闲点餐模式//或者有总订单为0 或1 但没有任何子订单信息 那么直接进入到空闲点餐模式");
                    //session.setAttribute("desk", d);
                    map.put(0,d);
                    return map;
                }
            }
            else if(d.getd_position() == 0){
                //当无客人时  正常点餐,并修改餐桌状态为1 有人
                //session.setAttribute("desk", d);
                deskServiceImpl.updateDeskPositionByDid(1, desk.getd_id());
                System.out.println("登录成功，正常点餐");
                map.put(0,d);
                return map;
            }
            else{
                //登录失败
                //model.addAttribute("msg","抱歉，暂无法使用，请联系前台服务员。");
                return null;
            }
        }
    }

    /***
     * 我的餐桌继续加餐
     * @param desk
     * @return
     */
    @RequestMapping("addOrder")
    Orderitems addOrder(@RequestBody Desk desk) {
        //根据餐桌信息获取餐桌di 并查询状态为1 已付款的订单  信息
        Orderitems os = orderService.queryOrderAndMenuMsgByDidAndPosition(desk.getd_id(),1);
        return os;
    }

    /**
     * 不小心退出继续点餐
     * @param desk
     * @return
     */
    @RequestMapping("continueOrder")
    Orderitems continueOrder(@RequestBody Desk desk){
        System.out.println("不小心退出继续点餐");
        //根据餐桌信息获取餐桌di 并查询状态为0 未付款的订单  信息
        Orderitems os = orderService.queryOrderAndMenuMsgByDidAndPosition(desk.getd_id(),0);
        System.out.println("____________"+os.toString());
        return os;
    }

    /**
     * 清空未付款订单
     * @param desk
     * @return boolean
     */
    @RequestMapping("cleanNoPayMenu")
    public boolean cleanNoPayMenu(@RequestBody Desk desk){
        boolean isD = false;
        //获取未付款的总订单
        Orderitems os = orderService.queryOrderAndMenuMsgByDidAndPosition(desk.getd_id(),0);
        //获取总订单id
        long os_id = os.getOiList().get(0).getos_id();
        //获取其中的所有子订单
        List<Orderitem> oiList = os.getOiList();
        if(os != null){
            System.out.println("查询到需要清空的付尾款的菜单");
            //修改所有未付款的子订单信息
            int k = orderService.updateOrderitemPositionByOsid(3,os_id);
            if (k == 1){
                System.out.println("已将所有子订单信息修改为状态 3------------");
                //继续修改总订单状态
                isD = orderService.deleteOrderitems(os_id);
                if (isD){
                    System.out.println("总订单状态修改成功");
                    //返回页面
                    return isD;
                }else {
                    System.out.println("总订单状态修改失败");
                    return isD;
                }
            }else{
                System.out.println("子订单信息修改失败---------------");
                return isD;
            }
        }
        System.out.println("为查询到总订单信息------清除未付款");
        return isD;
    }

    /***
     * 结束用餐
     * @return
     */
    @RequestMapping("leaveDesk")
    public boolean leaveDesk(@RequestBody Desk desk){
        //获取总订单信息 并将其状态修改为2 历史订单
        Orderitems os = orderService.queryOrderAndMenuMsgByDidAndPosition(desk.getd_id(), 1);
        //获取总订单id
        long os_id = os.getOiList().get(0).getos_id();
        boolean isU = orderService.updateOrderitemsPositionById(2,os_id);
        //如果总订单修改成功
        if(isU){
            //获取所有子订单的信息，并将其状态修改为2 历史订单
            List<Orderitem> oiList = os.getOiList();
            int k = orderService.updateOrderitemPositionByOsid(2,os_id);
            if(k ==1){
                System.out.println("子订单状态修改为2 成功---------");
                //将餐桌状态修改为0 空闲
                int j = deskServiceImpl.updateDeskPositionByDid(0, desk.getd_id());
                if(j == 1){
                    System.out.println("餐桌状态修改成功++++++++++++++====");
                    //当所有删除订单信息删除成功后，再将desk的session删除
                    //session.removeAttribute("desk");//-----------------------
                    //session.removeAttribute("again");
                    return true;
                }else{
                    System.out.println("餐桌状态修改失败---------------------");
                    return false;
                }
            }else{
                System.out.println("子订单状态修改为2  失败——————————————————————————");
                return false;
            }
        }else{
            System.out.println("修改总订单失败");
            return false;
        }
    }
}
