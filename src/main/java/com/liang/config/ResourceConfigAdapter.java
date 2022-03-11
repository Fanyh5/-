package com.liang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class ResourceConfigAdapter extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径 work_project代表项目工程名 需要更改
        //获取文件的真实路径
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\articleImg\\";
        String path1 = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\cover\\";
        String headportrait = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\headportrait\\";
        String music = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\music\\";
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/picture/**").
                    addResourceLocations("file:"+path).
                    addResourceLocations("file:"+path1).
                    addResourceLocations("file:"+headportrait).
                    addResourceLocations("file:"+music);
        }else{//linux和mac系统 可以根据逻辑再做处理
            registry.addResourceHandler("/picture/**").
                    addResourceLocations("file:"+path);
        }
        super.addResourceHandlers(registry);
    }
}
