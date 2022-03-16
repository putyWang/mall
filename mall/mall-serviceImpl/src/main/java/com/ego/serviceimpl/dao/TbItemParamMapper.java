package com.ego.serviceimpl.dao;

import com.ego.domain.TbItemParam;

import java.util.List;

public interface TbItemParamMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    TbItemParam selectByPrimaryKey(Long id);

    TbItemParam selectByCId(Long CId);

    List<TbItemParam> selectAll();

    int updateByPrimaryKeySelective(TbItemParam record);

    int updateByPrimaryKey(TbItemParam record);

}
