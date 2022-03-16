package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.service.saleService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class saleServiceImpl implements saleService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;
    @Override
//    @Transactional(
//////          设置事务传播级别（默认设置Propagation.REQUIRED，可以省略）
////            propagation = Propagation.REQUIRED,
//////          设置隔离级别（默认设置Isolation.DEFAULT，可以省略）
////            isolation = Isolation.DEFAULT,
//////          设置是否为只读（默认设置false，可以省略）
////            readOnly = false,
//////          表示发生指定异常时，肯定回滚（默认设置运行时异常，可以省略）
//            rollbackFor = {
//                  NullPointerException.class
//            }
//    )
    public void buy(Goods good) {

    }
}
