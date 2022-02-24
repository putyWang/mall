package com.ego.serviceimpl.dao;

import com.ego.domain.TbOrderShipping;

public interface TbOrderShippingMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);

    TbOrderShipping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbOrderShipping record);

    int updateByPrimaryKey(TbOrderShipping record);

}
