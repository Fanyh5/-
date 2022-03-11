package com.liang.service.impl;

import com.liang.entity.BlogMusic;
import com.liang.mapper.BlogMusicMapper;
import com.liang.service.BlogMusicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liang.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liang
 * @since 2022-01-15
 */
@Service
public class BlogMusicServiceImpl extends ServiceImpl<BlogMusicMapper, BlogMusic> implements BlogMusicService {

    //音乐服务器地址
    private String MUSIC_SERVER_ADDRESS = "http://localhost:8082";


    @Autowired
    private BlogMusicMapper blogMusicMapper;

    @Override
    public Result findAllMusic() {
        List<BlogMusic> blogMusics = blogMusicMapper.selectList(null);
        for (BlogMusic blogMusic : blogMusics) {
            blogMusic.setCover(MUSIC_SERVER_ADDRESS+blogMusic.getCover());
            blogMusic.setUrl(MUSIC_SERVER_ADDRESS+blogMusic.getUrl());
        }
        return  Result.success(blogMusics);
    }
}
