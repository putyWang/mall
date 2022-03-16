package com.ego.service;


import com.ego.commons.ResponseData.StatusData;
import com.ego.domain.TbItem;
import com.ego.domain.TbItemCat;
import com.ego.domain.TbItemDesc;


import java.util.List;

public interface ListService {
    List<TbItem> findList(int page, int rows);

    List<TbItem> findListByStatus(int status);

    StatusData updateStatus(String ids, int status);

    StatusData SaveItem(TbItem tbItem, String desc, String itemParams);

    TbItemDesc findTbItemDescById(long id);

    TbItemCat findTbItemCatById(long id);

    TbItem findTbItemById(long id);
}
