package com.selfordersystem.payservice.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.selfordersystem.common.entity.Menu;
import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.utils.AlipayConfig;
import com.selfordersystem.payservice.service.IMenuService;
import com.selfordersystem.payservice.service.IOrderService;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author huangyifeng.test@hand-china.com
 * @version 1.0
 * @name 自助点餐系统 --- 微服务
 * @description
 * @date 2019/4/3
 */
@RestController
public class PayController {

    @Resource
    private IOrderService orderServiceImpl;

    @Resource
    private IMenuService menuServiceImpl;

    /***
     * 支付宝支付接口
     * @return
     * @throws IOException
     */
    @RequestMapping("alipay.do")
    public String alipay( @RequestParam("os_id") long os_id) throws IOException {
        System.out.println("进入支付环节"+os_id);

        //获取总订单信息，以便于获取总价
        Orderitems os = orderServiceImpl.queryOrderitsmByOsid(os_id);

        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = os.getos_id().toString();
        // 订单名称，必填
        String subject = "自助餐厅自助订单";
        System.out.println(subject);
        // 付款金额，必填
        String total_amount=os.getos_allprice().toString();
        // 商品描述，可空
        String body = "欢迎光临";
        // 超时时间 可空
        String timeout_express="2m";
        // 销售产品码 必填
        String product_code="QUICK_WAP_WAY";
        /**********************/
        // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
        //调用RSA签名方式
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();

        // 封装请求支付信息
        AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
        model.setOutTradeNo(out_trade_no);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setBody(body);
        model.setTimeoutExpress(timeout_express);
        model.setProductCode(product_code);
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(AlipayConfig.notify_url);
        // 设置同步地址
        alipay_request.setReturnUrl(AlipayConfig.return_url);
        System.out.println("调用SDK生成表单-------------------------");
        // form表单生产
        String form = "";
        try {
            // 调用SDK生成表单
            form = client.pageExecute(alipay_request).getBody();
           // response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
           // response.getWriter().write(form);//直接将完整的表单html输出到页面
           // response.getWriter().flush();
            System.out.println("直接将完整的表单html输出到页面______________________________-");
           // response.getWriter().close();
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  form;
    }

    /**
     * 获取返回信息 完成支付
     * @param os1
     * @return map
     * 0  当前订单详细
     * 1  判断 进入无加餐的页面
     * 2  原订单详细（加餐）
     * 3 判断 进入加餐页面 client/myMenu12.jsp
     * -1 错误
     *
     * @throws Exception
     */
    @RequestMapping("returnMsg.do")
    public Map<Integer,Orderitems> returnMsg(@RequestBody Orderitems os1,@RequestParam("out_trade_no") String out_trade_no) throws Exception{
        System.out.println("获取返回信息 完成支付");
        Map<Integer,Orderitems> map = new HashMap<Integer, Orderitems>();
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
            //将改总订单和子订单状态改为1
            //总订单号
            long os_id = Long.parseLong(out_trade_no);
            Orderitems os = orderServiceImpl.queryOrderitsmByOsid(os_id);
            //查找所有子订单(子订单中需要包含菜品信息)，并修改状态为1
            List<Orderitem> oiList = orderServiceImpl.queryItemByOsid(os_id);
            int j = 0;
            for (Orderitem oi : oiList) {
                int i = orderServiceImpl.updateOrderitemPositionByOiid(1,oi.getoi_id());
                if(i == 0){
                    System.out.println("支付成功-----删除子菜单时失败！"+oi.getoi_id());
                    break;
                }else{
                    //子订单修改成功后再将菜品销量+1
                    //1、获取菜品信息
                    System.out.println(oi.getMenu().toString()+"+++++++++++++++"+oi.getoi_num());
                    Menu menu = oi.getMenu();
                    //2、再将该菜品的选择的数量 临时存入 菜品属性number中
                    menu.setM_number(oi.getoi_num());
                    menuServiceImpl.updateMenuNumByMid(menu);
                    System.out.println("支付成功-----删除子菜单时成功！"+oi.getoi_id());
                    j++;
                }
            }
            //当把所有子订单都修改后，再修改总订单
            if(j == oiList.size()){
                int i = orderServiceImpl.updateOrderitemsPositionByOsid(1,os_id);
                if(i == 1){
                    System.out.println("支付成功-----删除总订单成功！"+os.getos_id());
                    //子订单和总订单先后修改完后，再跳转到订单页面，并发送订单信息
                    //model.addAttribute("os", os);//当前支付菜单的信息
                    //model.addAttribute("oiList", oiList);//当前支付菜单的信息
                    os.setOiList(oiList);
                    map.put(0,os);
                    //并将此加餐的总订单的子订单信息转移到该客人第一个订单中
                    //1.获取存入Session的第一个总订单的信息
                   //------------ Orderitems os1 = (Orderitems) session.getAttribute("os_pay"); 到前端获取
                    //System.out.println("获取存入Session的第一个总订单的信息---------"+os1.getOiList().get(0).getos_id());
                    //1.1 如果session 没有值则不进行修改
                    if(os1 == null || os1.equals("") || os1.getd_id() == -1){
						/*//当所有删除订单信息删除成功后，再将desk的session删除
						session.removeAttribute("desk");*/
                       // return "client/myMenu.jsp";
                        System.out.println("进入无加餐的模式");
                        map.put(1,os);
                        return map;
                    }else{
                        //1.2 如果有值 则修改
                        int k = 0;
                        //2.批量修改加餐子订单的总订单id，                //如果加餐子订单的与第一个总订单的子订单的菜品一样，则直接修改子订单数量
                        for (Orderitem oi : oiList) {
                            System.out.println(os1.getOiList().get(0).getos_id()+"//2.批量修改加餐子订单的总订单id，---------"+oi.getoi_id());
                            System.out.println("打印总订单id-------------"+os1.getOiList().get(0).getos_id());
                            k = orderServiceImpl.updateOrderitemOsidByOiid(os1.getOiList().get(0).getos_id(), oi.getoi_id());
                            //并修改所有子订单的状态为1
                            orderServiceImpl.updateOrderitemPositionByOiid(1, oi.getoi_id());
                            k++;
                            //2.1 同时修改总订单价格,如果有多个数量
                            float total = (oi.getoi_price()*oi.getoi_num());
                            orderServiceImpl.updateOrderitemsPriceByOsid(total, os1.getOiList().get(0).getos_id());
                        }
                        System.out.println("修改了"+k+"条数据----------------------");
                        if(k != 0){
                            //3.清除掉加餐总订单的session
                            //session.removeAttribute("os_pay");
                            //session.removeAttribute("again");
                            //4.将第一个订单的菜品信息传入页面
                           // model.addAttribute("os1", os1);
                            map.put(2,os1);

                            //5.将加餐的总订单彻底删除掉
                            int i1 = orderServiceImpl.deleteOrderitemsByOsid(os_id);
                            System.out.println(os_id+"将加餐的总订单彻底删除掉--------"+i1);

                            if( i1 == 0){
                                System.out.println("彻底删除失败-------------");
                                map.put(-1,os);
                                return map;
                            }
							/*//当所有删除订单信息删除成功后，再将desk的session删除
							session.removeAttribute("desk");*/
							//加餐
                            map.put(3,os1);
                            return map;
                        }else{
                            System.out.println("删除失败-----------------------");
                            map.put(-1,os);
                            return map;
                        }
                    }
                }else{
                    //System.out.println("支付成功-----删除总订单失败！"+os.getos_id());
                    map.put(-1,os);
                    return map;
                }
            }else{
                System.out.println("子订单未完全清空");
                map.put(-1,os);
                return map;
            }
    }
}
