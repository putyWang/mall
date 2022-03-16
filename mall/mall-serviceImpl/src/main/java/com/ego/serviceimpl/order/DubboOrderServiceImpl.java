package com.ego.serviceimpl.order;

import com.ego.commons.utils.CreatIdUtil;
import com.ego.domain.TbItem;
import com.ego.domain.TbOrder;
import com.ego.domain.TbOrderItem;
import com.ego.domain.TbOrderShipping;
import com.ego.service.DubboOrderService;
import com.ego.serviceimpl.dao.*;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/9 22:52
 * @description：订单服务类
 * @modified By：
 * @version: $
 */
@DubboService(interfaceClass = DubboOrderService.class, version = "1.0", timeout = 5000)
public class DubboOrderServiceImpl implements DubboOrderService {

    @Resource
    private TbOrderMapper tbOrderMapper;

    @Resource
    private TbOrderItemMapper tbOrderItemMapper;

    @Resource
    private TbOrderShippingMapper tbOrderShippingMapper;

    @Resource
    private TbUserMapper tbUserMapper;

    @Resource
    private TbItemMapper tbItemMapper;

    @Override
    @Transactional
    public int creatOrder(List<TbOrderItem> items, TbOrderShipping shipping, TbOrder tbOrder) throws RuntimeException{

        int count = 0;
        count += tbOrderMapper.insert(tbOrder);
        TbItem tbItem;

        for (TbOrderItem item : items) {
            count += tbOrderItemMapper.insert(item);
            tbItem = tbItemMapper.selectByPrimaryKey(Long.parseLong(item.getItemId()));
            tbItem.setNum(tbItem.getNum() - item.getNum());
            count += tbItemMapper.updateByPrimaryKey(tbItem);
        }

        count += tbOrderShippingMapper.insert(shipping);

        if(count == 2 + items.size() * 2)
            return 1;
        else
            throw new RuntimeException("创建订单失败");
    }
}
