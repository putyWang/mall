package com.ego.serviceimpl.dao;

import com.ego.domain.TbItemCat;

import java.util.List;

public interface TbItemCatMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    List<TbItemCat> selectByTbItemCat(TbItemCat tbItemCat);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);

}
