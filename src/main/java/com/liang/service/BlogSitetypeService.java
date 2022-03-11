package com.liang.service;

import com.liang.entity.BlogSitetype;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liang
 * @since 2022-01-27
 */
public interface BlogSitetypeService extends IService<BlogSitetype> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogSitetype queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BlogSitetype> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param blogSitetype 实例对象
     * @return 实例对象
     */
    BlogSitetype insert(BlogSitetype blogSitetype);

    /**
     * 修改数据
     *
     * @param blogSitetype 实例对象
     * @return 实例对象
     */
    BlogSitetype update(BlogSitetype blogSitetype);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<BlogSitetype> findAll();
}
