package com.liang.service;

import com.liang.entity.BlogMusic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liang.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liang
 * @since 2022-01-15
 */
public interface BlogMusicService extends IService<BlogMusic> {

    Result findAllMusic();
}
