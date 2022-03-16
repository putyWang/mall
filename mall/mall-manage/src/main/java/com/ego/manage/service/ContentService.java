package com.ego.manage.service;

import com.ego.commons.ResponseData.EasyUIDataGrid;
import com.ego.commons.ResponseData.EasyUiTree;
import com.ego.commons.ResponseData.StatusData;
import com.ego.domain.TbContent;
import com.ego.domain.TbContentCategory;

import java.util.List;

public interface ContentService {

    List<EasyUiTree> showContentCategory(long pid);
    StatusData updateContentCategory(TbContentCategory tbContentCategory);
    StatusData createContentCategory(TbContentCategory tbContentCategory);
    StatusData deleteContentCategory(long id);
    EasyUIDataGrid contentQueryList(long categoryId, int page, int rows);
    StatusData contentSave(TbContent tbContent);
    StatusData contentUpdate(TbContent tbContent);
}
