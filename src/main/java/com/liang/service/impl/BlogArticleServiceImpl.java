package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liang.entity.BlogArticle;
import com.liang.mapper.BlogArticleMapper;
import com.liang.service.BlogArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liang
 * @since 2022-01-11
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {

    /**
     * 文章类型
     */
    private int[] timingtype = {1000,1001,1002};
    private int type = 1000;

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    //秒   分   时     日   月   周几
    //0 * * * * MON-FRI
    //注意cron表达式的用法；
    //每天凌晨1点触发；
    @Scheduled(cron = "0 0 1 * * ?")
    public void hello(){
        System.out.println(new Date().toString()+"执行一次");
        int ran2 = (int) (Math.random()*(timingtype.length-0)+0);
        type = timingtype[ran2];
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogArticle queryById(Integer id) {
        //文章阅读量
        blogArticleMapper.updateArticleReadCount(id);
        return blogArticleMapper.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BlogArticle> queryAllByLimit(int offset, int limit) {
        return blogArticleMapper.selectList(null);
    }

    /**
     * 分页查询
     *
     * @param current 页数，当前页
     * @param size  页面大小
     * @param articleType  文章类型
     * @return 对象列表
     */
    @Override
    public Map<String ,Object> queryPage(long current, long size,int articleType) {
        Map<String ,Object> objectMap = new HashMap<>();
        Page<BlogArticle> mapPage = new Page<>(current , size);
        //创建对象
        QueryWrapper<BlogArticle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("articleType",articleType);
        IPage<BlogArticle> blogArticleIPage = blogArticleMapper.selectPage(mapPage, queryWrapper);
        List<BlogArticle> blogArticleList = blogArticleIPage.getRecords();
        List<String> tags =null;
        for (BlogArticle blogArticle : blogArticleList) {
            tags = new ArrayList<>();
            String[] split = blogArticle.getArticleTag().split(",");
            for (String s : split) {
                if(!s.equals("")) {
                    tags.add(s);
                }
            }
            blogArticle.setTags(tags);
        }
        long pages = blogArticleIPage.getPages();
        objectMap.put("pageNum",current);//当前页
        objectMap.put("pageSize",size);//页面大小
        objectMap.put("size",size);//大小
        objectMap.put("startRow",size*(current-1)+1);//当前页第一条数据
        objectMap.put("endRow",current*size);//当前页最后一条数据
        objectMap.put("total",blogArticleIPage.getTotal());//总记录数
        objectMap.put("pages",pages);//页面数
        objectMap.put("list",blogArticleList);//当前页的数据
        objectMap.put("prePage",current-1);//当前页的前一页
        objectMap.put("nextPage",current+1);//当前页的下一页
        objectMap.put("isFirstPage",current==1);//是否是第一页
        objectMap.put("isLastPage",current==pages);//是否是第最后一页
        objectMap.put("hasPreviousPage",current!=1);//是否有上一页
        objectMap.put("hasNextPage",current!=pages);//是否有下一页
        return objectMap;
    }

    @Override
    public Map<String, Object> queryPage(long current, long size) {
        Map<String ,Object> objectMap = new HashMap<>();
        Page<BlogArticle> mapPage = new Page<>(current , size);
        IPage<BlogArticle> blogArticleIPage = blogArticleMapper.selectPage(mapPage, null);
        List<BlogArticle> blogArticleList = blogArticleIPage.getRecords();
        List<String> tags =null;
        for (BlogArticle blogArticle : blogArticleList) {
            tags = new ArrayList<>();
            String[] split = blogArticle.getArticleTag().split(",");
            for (String s : split) {
                if(!s.equals("")) {
                    tags.add(s);
                }
            }
            blogArticle.setTags(tags);
        }
        long pages = blogArticleIPage.getPages();
        objectMap.put("pageNum",current);//当前页
        objectMap.put("pageSize",size);//页面大小
        objectMap.put("size",size);//大小
        objectMap.put("startRow",size*(current-1)+1);//当前页第一条数据
        objectMap.put("endRow",current*size);//当前页最后一条数据
        objectMap.put("total",blogArticleIPage.getTotal());//总记录数
        objectMap.put("pages",pages);//页面数
        objectMap.put("list",blogArticleList);//当前页的数据
        objectMap.put("prePage",current-1);//当前页的前一页
        objectMap.put("nextPage",current+1);//当前页的下一页
        objectMap.put("isFirstPage",current==1);//是否是第一页
        objectMap.put("isLastPage",current==pages);//是否是第最后一页
        objectMap.put("hasPreviousPage",current!=1);//是否有上一页
        objectMap.put("hasNextPage",current!=pages);//是否有下一页
        return objectMap;
    }

    /**
     * 推荐
     *
     * @param current 当前页
     * @param size  每页多少条数据
     * @return IPage对象列表
     */
    @Override
    public Map<String, Object> recommend(long current, long size) {
        //Map<String, Object> objectMap = queryPage(current, size, type);
        return queryPage(current, size, type);
    }

    @Override
    public Map<String, Object> timeLine() {
        QueryWrapper<BlogArticle> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("createTime");
        wrapper.isNotNull("createTime");
        List<BlogArticle> blogArticles = blogArticleMapper.selectList(wrapper);

        List<BlogArticle> objectList_2019 = new ArrayList<>();
        List<BlogArticle> objectList_2020 = new ArrayList<>();
        List<BlogArticle> objectList_2021 = new ArrayList<>();
        List<BlogArticle> objectList_2022 = new ArrayList<>();
        Map<String, Object> objectMap_2019 = new HashMap<>();
        Map<String, Object> objectMap_2020 = new HashMap<>();
        Map<String, Object> objectMap_2021 = new HashMap<>();
        Map<String, Object> objectMap_2022 = new HashMap<>();

        for (BlogArticle blogArticle : blogArticles) {
            String substring = blogArticle.getCreateTime().substring(0, 4);
            if("2019".equals(substring)) {
                objectList_2019.add(blogArticle);
            }
            if("2020".equals(substring)) {
                objectList_2020.add(blogArticle);
            }
            if("2021".equals(substring)) {
                objectList_2021.add(blogArticle);
            }
            if("2022".equals(substring)) {
                objectList_2022.add(blogArticle);
            }
        }
        objectMap_2019.put("year","2019");
        objectMap_2019.put("article",objectList_2019);
        objectMap_2020.put("year","2020");
        objectMap_2020.put("article",objectList_2020);
        objectMap_2021.put("year","2021");
        objectMap_2021.put("article",objectList_2021);
        objectMap_2022.put("year","2022");
        objectMap_2022.put("article",objectList_2022);

        Map<String, Object> map = new HashMap<>();
        List<Object> objectList = new ArrayList<>();
        objectList.add(objectMap_2022);
        objectList.add(objectMap_2021);
        objectList.add(objectMap_2020);
        objectList.add(objectMap_2019);
        map.put("data",objectList);

        return map;
    }

    /**
     * 新增数据
     *
     * @param blogArticle 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticle insert(BlogArticle blogArticle) {
        this.blogArticleMapper.insert(blogArticle);
        return blogArticle;
    }

    /**
     * 修改数据
     *
     * @param blogArticle 实例对象
     * @return 实例对象
     */
    @Override
    public BlogArticle update(BlogArticle blogArticle) {
        blogArticleMapper.updateById(blogArticle);
        return this.queryById(blogArticle.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogArticleMapper.deleteById(id) > 0;
    }


    /**
     * 条件查询
     *
     * @param wrapper QueryWrapper对象
     * @return 对象列表
     */
    @Override
    public List<BlogArticle> selectList(QueryWrapper<BlogArticle> wrapper) {
        List<BlogArticle> blogArticles = blogArticleMapper.selectList(wrapper);
        return blogArticles;
    }

    @Override
    public void updateArticleStarNum(int id) {
        blogArticleMapper.updateArticleStarNum(id);
    }
}
