package com.liang.controller;


import com.liang.service.BlogMusicService;
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
@RequestMapping("/music")
public class BlogMusicController {

    @Autowired
    private BlogMusicService blogMusicService;

    @GetMapping("/list")
    public Result findAllMusic() {
        return blogMusicService.findAllMusic();
    }
}

