package com.ego.order.service.ServiceImpl;

import com.ego.commons.ResponseData.StatusData;
import com.ego.commons.utils.CookieUtils;
import com.ego.commons.utils.CreatIdUtil;
import com.ego.commons.utils.HttpClientUtils;
import com.ego.commons.utils.JsonUtils;
import com.ego.domain.*;
import com.ego.order.service.OrderService;
import com.ego.service.DubboOrderService;
import com.ego.service.DubboRedisManageService;
import com.ego.service.ListService;
import com.ego.order.domain.MyOrderParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class OrderServiceImpl implements OrderService {

    @DubboReference(interfaceClass = DubboRedisManageService.class, version = "1.0")
    private DubboRedisManageService dubboRedisManageService;

    @DubboReference(interfaceClass = ListService.class, version = "1.0")
    private ListService listService;

    @DubboReference(interfaceClass = DubboOrderService.class, version = "1.0")
    private DubboOrderService dubboOrderService;

    @Value("${cart.key}")
    private String cartKey;

    @Override
    public List<Cart> getCartList(List<Long> ids, HttpServletRequest request) {
        List<Cart> cartList;
        List<Cart> results = new ArrayList<>();
        String userKey = CookieUtils.getCookieValue(request, "TT_TOKEN");
        String username = JsonUtils.jsonToPojo(dubboRedisManageService.redisGetTbContentByKey(userKey), TbUser.class).getUsername();
        String cartKeyRedis = cartKey + ":" + username;
        if(dubboRedisManageService.redisExist(cartKeyRedis)){
            String cartListString = dubboRedisManageService.redisGetTbContentByKey(cartKeyRedis);
            if(cartListString != null && cartListString != ""){
                boolean itemIsExit = false;
                cartList = JsonUtils.jsonToList(cartListString, Cart.class);
                for (int i = 0; i < cartList.size(); i++) {
                    for (long id : ids) {
                        if(cartList.get(i).getId() == id){
                            if(listService.findTbItemById(id).getNum() >= cartList.get(i).getNum())
                                cartList.get(i).setEnough(true);
                            results.add(cartList.get(i));
                            break;
                        }
                    }
                }
            }
        }
        return results;
    }

    @Override
    public StatusData creatOrder(MyOrderParam myOrderParam, HttpServletRequest request) {
        List<TbOrderItem> items = myOrderParam.getOrderItems();
        TbOrderShipping shipping = myOrderParam.getOrderShipping();
        StatusData data = new StatusData();

        String orderId = CreatIdUtil.getId().toString();
        String userKey = CookieUtils.getCookieValue(request, "TT_TOKEN");
        Long userId = JsonUtils.jsonToPojo(dubboRedisManageService.redisGetTbContentByKey(userKey), TbUser.class).getId();
        String userName = JsonUtils.jsonToPojo(dubboRedisManageService.redisGetTbContentByKey(userKey), TbUser.class).getUsername();
        LocalDateTime date = LocalDateTime.now();

        TbOrder tbOrder = new TbOrder();
        tbOrder.setOrderId(orderId);
        tbOrder.setPayment(myOrderParam.getPayment());
        tbOrder.setPaymentType(myOrderParam.getPaymentType());
        tbOrder.setCreateTime(date);
        tbOrder.setUpdateTime(date);
        tbOrder.setUserId(userId);
        tbOrder.setBuyerNick(userName);
        tbOrder.setStatus(2);

        String id;
        for (TbOrderItem item : items) {
            id = CreatIdUtil.getId().toString();
            item.setOrderId(orderId);
            item.setId(id);
        }

        shipping.setOrderId(orderId);
        shipping.setCreated(date);
        shipping.setUpdated(date);

        if(dubboOrderService.creatOrder(items, shipping, tbOrder) == 1){
            data.setStatus(200);
            String cartKeyRedis = cartKey + ":" + userName;
            String cartListString = dubboRedisManageService.redisGetTbContentByKey(cartKeyRedis);

            if(cartListString != null && cartListString != "") {
                List<Cart> cartList = JsonUtils.jsonToList(cartListString, Cart.class);
                for (int i = 0; i < cartList.size(); i++) {
                    for (TbOrderItem item : items) {
                        if (cartList.get(i).getId() == Long.parseLong(item.getItemId()))
                            cartList.remove(i);
                    }
                }
                String carListJson = JsonUtils.objectToJson(cartList);
                dubboRedisManageService.redisSetTbContent(cartKeyRedis, carListJson);
            }
        }
        return  data;
    }

}
