package com.liang.service.impl;

import com.liang.entity.BlogCategory;
import com.liang.mapper.BlogCategoryMapper;
import com.liang.service.BlogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liang
 * @since 2022-01-15
 */
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    @Override
    public Result queryAllByCategory() {
        List<String> blogCategorieList = new ArrayList<>();
        List<BlogCategory> blogCategories = blogCategoryMapper.selectList(null);
        for (BlogCategory blogCategory : blogCategories) {
            blogCategorieList.add(blogCategory.getName());
        }
        return Result.success(blogCategorieList);
    }
}
