package com.ego.serviceimpl.dao;

import com.ego.domain.TbOrderItem;

public interface TbOrderItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    TbOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);

}
