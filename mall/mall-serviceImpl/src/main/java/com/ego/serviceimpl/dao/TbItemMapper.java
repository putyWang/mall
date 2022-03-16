package com.ego.serviceimpl.dao;

import com.ego.domain.TbItem;

import java.util.List;

public interface TbItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectAll();

    List<TbItem> selectAllByStatus(int status);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    int updateStatusByPrimaryKey(long id, int status);

}
