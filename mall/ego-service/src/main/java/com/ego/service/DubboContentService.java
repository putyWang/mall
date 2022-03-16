package com.ego.service;

import com.ego.domain.TbContent;
import com.ego.domain.TbContentCategory;

import java.util.List;

public interface DubboContentService {

    TbContentCategory findContentCategoryById(long id);

    List<TbContentCategory> showContentCategory(long pid);

    int insertContentCategory(TbContentCategory tbContentCategory);

    int updateContentCategory(TbContentCategory tbContentCategory);

    int deleteContentCategory(long id);

    List<TbContent> showTbCotent(long categoryId);

    int saveContent(TbContent tbContent);

    int updateContent(TbContent tbContent);

    List<TbContent> showTbCotentByCount(int count, boolean isSort);

}
