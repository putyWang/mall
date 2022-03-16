package com.ego.service;

import com.ego.commons.ResponseData.StatusData;
import com.ego.domain.TbItemParam;

import java.util.List;

public interface ItemParamListService {
    List<TbItemParam> findList(int page, int rows);
    
    
    StatusData deleteParam(String ids) throws RuntimeException;


    StatusData getStatusData(long id);

}
