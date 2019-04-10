package com.selfordersystem.webclient.controller;

import com.selfordersystem.common.entity.Desk;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.utils.QUcodeUtil;
import com.selfordersystem.webclient.client.DeskClient;
import com.selfordersystem.webclient.client.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description 餐桌服务 增删查改
 * @date 2019/3/30
 */
@Controller
public class DeskController {

    @Autowired
    private LoginClient loginClient;
    @Autowired
    private DeskClient deskClient;

    /***
     * 查询所有餐桌
     * @param model
     * @return
     *//*
    @RequestMapping(value = "Desks",method = RequestMethod.GET)
    public String getAllDesk(Model model){
        model.addAttribute("list",deskClient.getAllDesk());
        return "service/index.jsp";
    }
*/
    /***
     * 消台
     * @return
     */
    @RequestMapping(value = "desks",method = RequestMethod.DELETE)
    public @ResponseBody void leaveDesk( Desk desk){
        System.out.println("结束用餐"+desk.getd_id());
       /* Desk desk = new Desk();
        desk.setd_id(d_id);*/
        Desk d = deskClient.getDesk(desk);
        boolean isL = loginClient.leaveDesk(d);
        if(isL){
            System.out.println("餐桌状态修改成功++++++++++++++====");
            //session.removeAttribute("again");
            System.out.println("修改成功了");
        }else {
            System.out.println("修改失败");
        }
    }

    public String getDesk(Model model){
        return "";
    }

    /**
     * 根据桌面id查询桌面及订单的信息
     *
     * @return
     */
    @RequestMapping(value = "desk",method = RequestMethod.GET)
    public String querytDeskById(Desk desk,Model model) {
        System.out.println("根据桌面id查询桌面及订单的信息");
        Orderitems order = deskClient.querytDeskById(desk);
        //获取餐桌的信息
        Desk d = deskClient.getDesk(desk);
        model.addAttribute("desk", d);
        if (order == null){
            //桌面为空或者订单为空跳至桌面管理
            return "service/deskManager0.jsp";
        }else {
            //如果能找到这个桌子的订单则将信息传过去
            model.addAttribute("size", order.getOiList().size());
            model.addAttribute("order", order);
            String d_name = d.getd_name();
           // model.addAttribute("d_name", d_name);
            return "service/deskManager.jsp";
        }
    }

    /**
     * 根据桌号删除桌子
     * @param desk
     */
    @RequestMapping(value = "desk",method = RequestMethod.DELETE)
    public @ResponseBody void deleteDesk(Desk desk){
        System.out.println("根据桌号删除桌子"+desk.getd_name());
        //根据桌号删除桌子
        deskClient.deleteDesk(desk);
    }

    /**
     * 根据桌id修改桌子状态并将订单修改为3
     * @param d_id
     */
    @RequestMapping(value = "desk",method = RequestMethod.PUT)
    public @ResponseBody String updateDeskPositionByName(long d_id){
        System.out.println("根据桌id修改桌子状态"+d_id);
        boolean isU = deskClient.updateDeskPosition(d_id);
        if(isU){
            return "成功";
        }
        return "失败";
    }

    /**
     * 添加桌子
     * @param desk
     */
    @RequestMapping(value = "desk",method = RequestMethod.POST)
    public @ResponseBody void addDesk(Desk desk){
        System.out.println("添加桌子"+desk.getd_name());
        //添加桌子
        deskClient.addDesk(desk);
    }

    /***
     * 生成二维码
     * 只需要传入餐桌id
     * 然后返回二维码地址
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "createQRcode",method = RequestMethod.POST)
    public @ResponseBody
    String createQRcode(long d_id, HttpServletRequest request) throws Exception{
        System.out.println("生成二维码"+d_id);
        Desk d1 = new Desk();
        d1.setd_id(d_id);
        Desk desk = deskClient.getDesk(d1);
        System.out.println("_____________"+desk.getd_name());

        String text = "http://192.168.43.112:8082/food/clientLogin.action?d_id="+desk.getd_id()+"&d_password="+desk.getd_password(); //一号桌登录
        System.out.println("随机码： " + text);
        int width = 500; // 二维码图片的宽
        int height = 500; // 二维码图片的高
        String format = "png"; // 二维码图片的格式

        //创建生成路径及文件名
        String newName = desk.getd_id()+"password"+desk.getd_password();
        //文件存储的相对路径
        String path = "/upload/code";
        //获取需要存储的路径的绝对路径
        String realPath = request.getServletContext().getRealPath(path);
        //判断文件夹是否存在，如果不存在则创建目录
        File dayFile = new File(realPath);
        if(!dayFile.exists()){
            dayFile.mkdirs();
        }
        //上传文件到服务器
        String newFileName = realPath +"/"+ newName+".png";
        String newFileNameRes = path+"/"+newName+".png";
        // 生成二维码图片，并返回图片路径
        String pathName = QUcodeUtil.generateQRCode(text, width, height, format, newFileName);
        System.out.println("生成二维码的图片路径： " + pathName);

        String content = QUcodeUtil.parseQRCode(pathName);
        System.out.println(newFileName+"解析出二维码的图片的内容为： " + content);
        return newFileNameRes;
    }
}
