package com.liang.service;

import com.liang.entity.BlogCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liang.vo.Result;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liang
 * @since 2022-01-15
 */
public interface BlogCategoryService extends IService<BlogCategory> {

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    Result queryAllByCategory();

}
