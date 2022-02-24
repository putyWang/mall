package com.ego.serviceimpl.dao;

import com.ego.domain.TbContentCategory;




public interface TbContentCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    TbContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);

}
