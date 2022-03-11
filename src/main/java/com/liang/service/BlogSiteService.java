package com.liang.service;

import com.liang.entity.BlogSite;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liang.vo.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liang
 * @since 2022-01-27
 */
public interface BlogSiteService extends IService<BlogSite> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogSite queryById(Integer id);

    /**
     * 查询全部数据
     * @return 对象列表
     */
    List<BlogSite> queryAll();

    /**
     * 新增数据
     *
     * @param blogSite 实例对象
     * @return 实例对象
     */
    BlogSite insert(BlogSite blogSite);

    /**
     * 修改数据
     *
     * @param blogSite 实例对象
     * @return 实例对象
     */
    BlogSite update(BlogSite blogSite);

    /**
     * 按类型查找
     *
     * @return 实例对象
     */
    Result findAllByType();

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
