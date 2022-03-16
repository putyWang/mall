package com.ego.item.service;

import com.ego.domain.TbItem;
import com.ego.domain.TbItemDesc;

public interface ItemService {
    TbItem showItem(long id);

    String showItemDesc(long itemId);
}
