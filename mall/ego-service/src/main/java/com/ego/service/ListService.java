package com.ego.service;


import com.ego.commons.StatusData;
import com.ego.domain.TbItem;


import java.util.List;

public interface ListService {
    List<TbItem> findList(int page, int rows);

    StatusData updateStatus(String ids, int status);

}
