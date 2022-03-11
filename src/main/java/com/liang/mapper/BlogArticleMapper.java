package com.liang.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liang.entity.BlogArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liang
 * @since 2022-01-11
 */
@Repository
public interface BlogArticleMapper extends BaseMapper<BlogArticle> {

    /**
     * 通过id修改对于的数据
     * 文章阅读量
     */
    @Select("update `blog_article` set `articleReadCount` = `articleReadCount`+1 WHERE `id` = ${id}")
    void updateArticleReadCount(@Param("id") int id);

    /**
     * 通过id修改对于的数据
     * 文章点赞数
     */
    @Select("update `blog_article` set `articleStarNum` = `articleStarNum`+1 WHERE `id` = ${id}")
    void updateArticleStarNum(@Param("id") int id);
}
