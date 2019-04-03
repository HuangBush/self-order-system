package com.selfordersystem.webclient.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.selfordersystem.common.entity.Orderitem;
import com.selfordersystem.common.entity.Orderitems;
import com.selfordersystem.common.utils.AlipayConfig;
import com.selfordersystem.webclient.client.PayClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@Controller
public class PayController {

    @Resource
    private PayClient payClient;

    /***
     * 支付宝支付接口
     * @return
     * @throws IOException
     */
    @RequestMapping("alipay.do")
    public void alipay(long os_id,  HttpServletResponse response) throws IOException {
        System.out.println("进入支付接口");
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
       // AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();
        String form = payClient.alipay(os_id);
         response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
         response.getWriter().write(form);//直接将完整的表单html输出到页面
         response.getWriter().flush();
        System.out.println("直接将完整的表单html输出到页面______________________________-");
         response.getWriter().close();
        System.out.println("完成支付--------------------------");
    }

    /**
     * 获取返回信息 完成支付
     * @return map
     * 0  当前订单详细
     * 1  判断 进入无加餐的页面
     * 2  原订单详细（加餐）
     * 3 判断 进入加餐页面 client/myMenu12.jsp
     * -1 错误
     * @throws Exception
     */
    @RequestMapping("returnMsg.do")
    public String returnMsg(HttpServletRequest request,HttpSession session, Model model) throws Exception {
        System.out.println("获取返回信息 完成支付");
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");

        if (verify_result) {//验证成功
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码
            //该页面可做页面美工编辑
            System.out.println("支付验证成功");


            Orderitems os1 = (Orderitems) session.getAttribute("os_pay");
            Map<Integer, Orderitems> map = new HashMap<Integer, Orderitems>();
            if (os1 == null) {
                Orderitems orderitems = new Orderitems();
                orderitems.setd_id((long) -1);
                map = payClient.returnMsg(orderitems, out_trade_no);
            } else {
                map = payClient.returnMsg(os1, out_trade_no);
            }
            Orderitems os = map.get(0);
            List<Orderitem> oiList = os.getOiList();
            model.addAttribute("os", os);//当前支付菜单的信息
            model.addAttribute("oiList", oiList);//当前支付菜单的信息
            //如果有键值为1 ，那么就是不加餐的页面
            if (map.containsKey(1)) {
                System.out.println("进入我的菜单1中");
                return "client/myMenu.jsp";
            } else if (map.containsKey(3)) {
                //3.清除掉加餐总订单的session
                session.removeAttribute("os_pay");
                session.removeAttribute("again");
                //4.将第一个订单的菜品信息传入页面
                Orderitems os2 = map.get(2);
                model.addAttribute("os", os);
                model.addAttribute("os1", os2);
                System.out.println("进入我的菜单2中");
                return "client/myMenu12.jsp";
            } else if (map.containsKey(-1)) {
                System.out.println("删除失败-----------------------");
                return "error.jsp";
            }
            return "error.jsp";
        } else {
            //该页面可做页面美工编辑
            System.out.println("验证失败------------------------------");
        }
        return "error.jsp";
    }

}
