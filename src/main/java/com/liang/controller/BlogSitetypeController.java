package com.liang.controller;


import com.liang.service.impl.BlogSitetypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liang
 * @since 2022-01-27
 */
@RestController
@RequestMapping("/sitetype")
public class BlogSitetypeController {
    /**
     * 服务对象
     */
    @Autowired
    private BlogSitetypeServiceImpl blogSitetypeService;

}

