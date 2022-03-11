package com.liang.service.impl;

import com.liang.entity.BlogSitetype;
import com.liang.mapper.BlogSitetypeMapper;
import com.liang.service.BlogSitetypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liang
 * @since 2022-01-27
 */
@Service
public class BlogSitetypeServiceImpl extends ServiceImpl<BlogSitetypeMapper, BlogSitetype> implements BlogSitetypeService {

    @Autowired
    private BlogSitetypeMapper blogSitetypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogSitetype queryById(Integer id) {
        return this.blogSitetypeMapper.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BlogSitetype> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param blogSitetype 实例对象
     * @return 实例对象
     */
    @Override
    public BlogSitetype insert(BlogSitetype blogSitetype) {
        this.blogSitetypeMapper.insert(blogSitetype);
        return blogSitetype;
    }

    /**
     * 修改数据
     *
     * @param blogSitetype 实例对象
     * @return 实例对象
     */
    @Override
    public BlogSitetype update(BlogSitetype blogSitetype) {
        this.blogSitetypeMapper.update(blogSitetype,null);
        return this.queryById(blogSitetype.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogSitetypeMapper.deleteById(id) > 0;
    }

    @Override
    public List<BlogSitetype> findAll() {
        return blogSitetypeMapper.selectList(null);
    }
}
