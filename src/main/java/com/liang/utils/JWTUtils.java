package com.liang.utils;


import com.liang.entity.BlogUser;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author admin
 */
public class JWTUtils {

    //token有效时间
    private static long time = 1000*60*60*24;
    //签名信息
    private static String signature = "liangfan";

    /**
     * 获取token
     * @param u BlogUser
     * @return token
     */
    public static String getToken(BlogUser u) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim("username",u.getUsername())
                .claim("password",u.getPassword())
                .setSubject("liang-fan")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(u.getId().toString())
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return jwtToken;
    }

    /**
     * 解析token是否有效
     * @param token String
     * @return boolean
     */
    public static boolean checkToken(String token) {
        if(StringUtils.isEmpty(token)) return false;
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

