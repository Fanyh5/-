package com.liang.controller;

import com.liang.service.impl.BlogSiteServiceImpl;
import com.liang.service.impl.BlogSitetypeServiceImpl;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liang
 * @since 2022-01-27
 */
@RestController
@RequestMapping("/site")
public class BlogSiteController {

    @Autowired
    private BlogSiteServiceImpl blogSiteService;

    @Autowired
    private BlogSitetypeServiceImpl blogSitetypeService;

    /**
     * 全部网站
     *
     * return 网站列表
     * @author Liang
     * @since 2022-01-27
     */
    @GetMapping("/all")
    public Result findAll() {
        return blogSiteService.findAllByType();
    }
}

