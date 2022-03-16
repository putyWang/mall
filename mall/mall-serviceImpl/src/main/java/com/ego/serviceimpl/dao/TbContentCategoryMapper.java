package com.ego.serviceimpl.dao;

import com.ego.domain.TbContentCategory;

import java.util.List;


public interface TbContentCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    TbContentCategory selectByPrimaryKey(Long id);

    List<TbContentCategory> selectByPid(Long pid);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);

}
