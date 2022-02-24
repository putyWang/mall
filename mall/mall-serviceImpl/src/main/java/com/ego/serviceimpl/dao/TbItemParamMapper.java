package com.ego.serviceimpl.dao;

import com.ego.domain.TbItemParam;

public interface TbItemParamMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    TbItemParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemParam record);

    int updateByPrimaryKey(TbItemParam record);

}
