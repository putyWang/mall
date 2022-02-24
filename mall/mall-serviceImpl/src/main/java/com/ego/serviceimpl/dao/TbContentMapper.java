package com.ego.serviceimpl.dao;

import com.ego.domain.TbContent;


public interface TbContentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKey(TbContent record);

}
