package com.ego.serviceimpl.dao;

import com.ego.domain.TbItemDesc;

public interface TbItemDescMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbItemDesc record);

    int insertSelective(TbItemDesc record);

    TbItemDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemDesc record);

    int updateByPrimaryKey(TbItemDesc record);

}
