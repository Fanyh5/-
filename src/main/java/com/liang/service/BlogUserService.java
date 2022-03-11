package com.liang.service;

import com.liang.entity.BlogUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liang.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liang
 * @since 2022-01-30
 */
public interface BlogUserService extends IService<BlogUser> {
    //注册
    Result UserRegister(String name, String username, String password, int code);

    //登录
    Result UserLogin(String username, String password);

    //邮箱注册
    Result emailSentemail(String email);
}
