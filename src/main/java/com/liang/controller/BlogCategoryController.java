package com.liang.controller;

import com.liang.service.BlogCategoryService;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liang
 * @since 2022-01-15
 */
@RestController
@RequestMapping("/blog-category")
public class BlogCategoryController {

    @Autowired
    private BlogCategoryService blogCategoryService;

    /**
     * 标签列表
     *
     * @return 对象列表
     */
    @GetMapping("/searchTag")
    public Result queryAllByCategory() {
        return blogCategoryService.queryAllByCategory();
    }

}

