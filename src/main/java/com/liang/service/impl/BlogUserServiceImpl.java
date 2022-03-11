package com.liang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liang.entity.BlogUser;
import com.liang.mapper.BlogUserMapper;
import com.liang.service.BlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liang.utils.HostAddressUtils;
import com.liang.utils.JWTUtils;
import com.liang.utils.MD5Utils;
import com.liang.utils.RandomCodeUtils;
import com.liang.vo.BlogUserVo;
import com.liang.vo.ErrorCode;
import com.liang.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liang
 * @since 2022-01-30
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements BlogUserService {

    @Value("${spring.mail.username}")
    private String sender;// 发送者

    @Autowired
    private JavaMailSender javaMailSender;//注入发送邮件的bean

    @Autowired
    private BlogUserMapper blogUserMapper;

    @Value("${server.port}")
    private int port;

    @Override
    public Result UserRegister(String name, String username, String password, int code) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        if(blogUserMapper.selectList(queryWrapper).size()>=1){
            return Result.fail(ErrorCode.USER_ALREADY_EXISTS.getCode(),ErrorCode.USER_ALREADY_EXISTS.getMsg());
        }
        if(code!=1234) {
            return Result.fail(ErrorCode.VERIFICATION_CODE_ERROR.getCode(),ErrorCode.VERIFICATION_CODE_ERROR.getMsg());
        }
        BlogUser blogUser = new BlogUser();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        blogUser.setCreateTime(sdf.format(new Date()));
        blogUser.setHeadPic("/picture/default.jpg");
        blogUser.setNickname(name);
        blogUser.setUsername(username);
        blogUser.setPassword(MD5Utils.stringToMD5(password));
        int insert = blogUserMapper.insert(blogUser);
        if(insert>0) {
            return Result.success(insert);
        }
        return Result.fail(ErrorCode.REGISTRATION_FAILED.getCode(),ErrorCode.REGISTRATION_FAILED.getMsg());

    }

    @Override
    public Result UserLogin(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        if(blogUserMapper.selectList(queryWrapper).size()<=0) {
            return Result.fail(ErrorCode.USER_DOES_NOT_EXIST.getCode(),ErrorCode.USER_DOES_NOT_EXIST.getMsg());
        }
        queryWrapper.eq("password",MD5Utils.stringToMD5(password));
        if(blogUserMapper.selectList(queryWrapper).size()<=0) {
            return Result.fail(ErrorCode.WRONG_PASSWORD.getCode(),ErrorCode.WRONG_PASSWORD.getMsg());
        }
        BlogUser blogUser = (BlogUser) blogUserMapper.selectList(queryWrapper).get(0);
        BlogUserVo blogUserVo = copyBloguser(blogUser);
        return Result.success(blogUserVo);
    }


    //邮箱验证
    @Override
    public Result emailSentemail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        String code = RandomCodeUtils.VerifyCode(6);    //随机数生成6位验证码
        message.setFrom(sender);//设置发件qq邮箱
        message.setTo(email);//设置收件人
        message.setSubject("博客系统");// 标题
        message.setText("【博客系统】你的验证码为："+code+"，有效时间为5分钟(若不是本人操作，可忽略该条邮件)");// 内容
        try {
            javaMailSender.send(message);
            return Result.success("文本邮件发送成功！");
        }catch (MailSendException e){
            return Result.fail(ErrorCode.DESTINATION_MAILBOX_DOES_NOT_EXIST.getCode(),ErrorCode.DESTINATION_MAILBOX_DOES_NOT_EXIST.getMsg());
        } catch (Exception e) {
            return Result.fail(ErrorCode.TEXT_EMAIL_SENDING_EXCEPTION.getCode(),ErrorCode.TEXT_EMAIL_SENDING_EXCEPTION.getMsg());
        }
    }

    //实体转VO
    private BlogUserVo copyBloguser(BlogUser blogUser) {
        BlogUserVo blogUserVo = new BlogUserVo();
        BeanUtils.copyProperties(blogUser,blogUserVo);
        blogUserVo.setPassword("");
        blogUserVo.setToken(JWTUtils.getToken(blogUser));
        //HostAddressUtils.getHostAddress()获取本机IP端口号
        blogUserVo.setHeadPic(HostAddressUtils.getHostAddress(port)+blogUser.getHeadPic());
        return blogUserVo;
    }
}
