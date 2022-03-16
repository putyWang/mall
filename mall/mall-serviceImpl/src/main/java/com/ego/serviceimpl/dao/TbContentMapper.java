package com.ego.serviceimpl.dao;

import com.ego.domain.TbContent;

import java.util.List;


public interface TbContentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    List<TbContent> selectByCategoryId(Long categoryId);

    List<TbContent> selectAll();

    List<TbContent> selectAllInSort(String orderByClause);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKey(TbContent record);

}
