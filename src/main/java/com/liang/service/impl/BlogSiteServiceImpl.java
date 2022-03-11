package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.entity.BlogSite;
import com.liang.entity.BlogSitetype;
import com.liang.mapper.BlogSiteMapper;
import com.liang.mapper.BlogSitetypeMapper;
import com.liang.service.BlogSiteService;
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
 * @since 2022-01-27
 */
@Service
public class BlogSiteServiceImpl extends ServiceImpl<BlogSiteMapper, BlogSite> implements BlogSiteService {

    @Autowired
    private BlogSiteMapper blogSiteMapper;

    @Autowired
    private BlogSitetypeMapper  blogSitetypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogSite queryById(Integer id) {
        return this.blogSiteMapper.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<BlogSite> queryAll() {
        return blogSiteMapper.selectList(null);
    }

    /**
     * 新增数据
     *
     * @param blogSite 实例对象
     * @return 实例对象
     */
    @Override
    public BlogSite insert(BlogSite blogSite) {
        this.blogSiteMapper.insert(blogSite);
        return blogSite;
    }

    /**
     * 修改数据
     *
     * @param blogSite 实例对象
     * @return 实例对象
     */
    @Override
    public BlogSite update(BlogSite blogSite) {
        this.blogSiteMapper.update(blogSite,null);
        return this.queryById(blogSite.getId());
    }

    @Override
    public Result findAllByType() {
        List<Object> objectList = new ArrayList<>();
        Map<String, Object> siteMap ;
        List<BlogSite> blogSites;
        QueryWrapper queryWrapper ;
        List<BlogSitetype> sitetypeList = blogSitetypeMapper.selectList(null);
        for (BlogSitetype blogSitetype : sitetypeList) {
            siteMap = new HashMap<>();blogSites = new ArrayList<>();
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("siteType",blogSitetype.getId());
            blogSites.addAll(blogSiteMapper.selectList(queryWrapper));
            siteMap.put("type",blogSitetype.getSitetypeName());
            siteMap.put("site",blogSites);
            objectList.add(siteMap);
        }
        return Result.success(objectList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogSiteMapper.deleteById(id) > 0;
    }

}
