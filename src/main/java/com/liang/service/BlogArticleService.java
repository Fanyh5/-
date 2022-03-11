package com.liang.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.entity.BlogArticle;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类接口
 * </p>
 *
 * @author Liang
 * @since 2022-01-11
 */
public interface BlogArticleService extends IService<BlogArticle> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogArticle queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BlogArticle> queryAllByLimit(int offset, int limit);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size  每页多少条数据
     * @param articleType  文章类型
     * @return IPage对象列表
     */
    Map<String ,Object> queryPage(long current, long size,int articleType);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size  每页多少条数据
     * @return IPage对象列表
     */
    Map<String ,Object> queryPage(long current, long size);

    /**
     * 推荐
     *
     * @param current 当前页
     * @param size  每页多少条数据
     * @return IPage对象列表
     */
    Map<String ,Object> recommend(long current, long size);


    /**
     * 查询每年的数据并分类
     * @return IPage对象列表
     */
    public Map<String, Object> timeLine();

    /**
     * 新增数据
     *
     * @param blogArticle 实例对象
     * @return 实例对象
     */
    BlogArticle insert(BlogArticle blogArticle);

    /**
     * 修改数据
     *
     * @param blogArticle 实例对象
     * @return 实例对象
     */
    BlogArticle update(BlogArticle blogArticle);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 条件查询
     *
     * @param wrapper QueryWrapper对象
     * @return 对象列表
     */
    public List<BlogArticle> selectList(QueryWrapper<BlogArticle> wrapper);


    /**
     * 通过id修改对于的数据
     * 文章点赞数
     */
    void updateArticleStarNum(int id);
}
