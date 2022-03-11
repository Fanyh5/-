package com.liang.controller;


import com.liang.service.impl.BlogUserServiceImpl;
import com.liang.vo.ErrorCode;
import com.liang.vo.Result;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Liang
 * @since 2022-01-30
 */
@RestController
public class BlogUserController {

    @Autowired
    private BlogUserServiceImpl blogUserService;

    //Java 图形验证码模块
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.clear(request);
        CaptchaUtil.out(request, response);
        //String captcha = (String)request.getSession().getAttribute("captcha");
        //System.out.println(captcha);
    }


    /**
     * 注册时邮箱验证
     *
     * @param email 邮箱号
     * @return Result对象
     */
    @RequestMapping("/sentemail")
    public Result emailSentemail(String email) {
        return blogUserService.emailSentemail(email);
    }


    /**
     * 注册
     *
     * @param name 昵称
     * @param username 用户名
     * @param password 密码
     * @param code 邮箱验证码
     * @return 对象列表
     */
    @PostMapping("/register")
    public Result UserRegister(String name,String username,String password,int code) {
        return blogUserService.UserRegister(name,username,password,code);
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param verCode 验证码
     * @return 对象列表
     */
    @PostMapping("/login")
    public Result UserLogin(String username,String password,String verCode,HttpServletRequest request) {
        if (!CaptchaUtil.ver(verCode, request)) {
            return Result.fail(ErrorCode.INCORRECT_VERIFICATION_CODE.getCode(),ErrorCode.INCORRECT_VERIFICATION_CODE.getMsg());
        }
        return blogUserService.UserLogin(username,password);
    }


    /**
     * 退出登录
     *
     * @return 对象列表
     */
    @GetMapping("/noLogin")
    public Result UserNoLogin() {
        return Result.success(0);
    }
}

