package com.ego.serviceimpl.itemCatServiceImpl;

import com.ego.domain.TbContent;
import com.ego.domain.TbContentCategory;
import com.ego.service.DubboContentService;
import com.ego.serviceimpl.dao.TbContentCategoryMapper;
import com.ego.serviceimpl.dao.TbContentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

@DubboService(interfaceClass = DubboContentService.class, version = "1.0", timeout = 5000)
public class DubboContentServiceImpl implements DubboContentService {

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContentCategory> showContentCategory(long pid) {
        return tbContentCategoryMapper.selectByPid(pid);
    }


    @Override
    public int insertContentCategory(TbContentCategory tbContentCategory) {
        return tbContentCategoryMapper.insert(tbContentCategory);
    }

    @Override
    public int updateContentCategory(TbContentCategory tbContentCategory) {
        return tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
    }

    @Override
    public TbContentCategory findContentCategoryById(long id) {
        return tbContentCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteContentCategory(long id) {
        return tbContentCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TbContent> showTbCotent(long categoryId) {
        if(categoryId == 0)
            return tbContentMapper.selectAll();
        else
            return tbContentMapper.selectByCategoryId(categoryId);
    }

    @Override
    public int saveContent(TbContent tbContent) {
        return tbContentMapper.insert(tbContent);
    }

    @Override
    public int updateContent(TbContent tbContent) {
        return tbContentMapper.updateByPrimaryKeySelective(tbContent);
    }

    @Override
    public List<TbContent> showTbCotentByCount(int count, boolean isSort) {
        if(isSort == true){
            PageHelper.startPage(1, count);
            List<TbContent> list = tbContentMapper.selectAllInSort("updated");
            PageInfo<TbContent> pageInfo = new PageInfo<>(list);
            return pageInfo.getList();
        }
        return tbContentMapper.selectAllInSort("updated");
    }
}
