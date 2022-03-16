package com.ego.order.cotroller;

import com.ego.commons.ResponseData.StatusData;
import com.ego.domain.Cart;
import com.ego.order.service.OrderService;
import com.ego.order.domain.MyOrderParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description：订单系统控制类
 * @modified By：
 * @version: $
 */
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/order/order-cart.html")
    public String showOrder(Model model, @RequestParam("id") List<Long> ids, HttpServletRequest request){
        List<Cart> cartList = orderService.getCartList(ids, request);
        model.addAttribute("cartList", cartList);
        return "order-cart";
    }

    @RequestMapping("/order/create.html")
    public String creatOrder(Model model, MyOrderParam myOrderParam, HttpServletRequest request){
        StatusData data = orderService.creatOrder(myOrderParam, request);
        if(data.getStatus() == 200)
            return "my-orders";
        else
            return "error/exception";
    }
}
