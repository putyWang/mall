package com.ego.serviceimpl.dao;

import com.ego.domain.TbItemParamItem;

public interface TbItemParamItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamItem record);

    int insertSelective(TbItemParamItem record);

    TbItemParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemParamItem record);

    int updateByPrimaryKey(TbItemParamItem record);

}
