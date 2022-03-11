package com.liang.controller;

import com.liang.entity.BlogArticle;
import com.liang.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Liang
 * @since 2022-01-11
 */
@RestController
@RequestMapping("/blog-article")
@CrossOrigin
public class BlogArticleController {

    /**
     * 服务对象
     */
    @Autowired
    private BlogArticleService blogArticleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/article/{id}")
    public Map<String, Object> selectOne(@PathVariable Integer id) {
        Map<String, Object> objectMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("data", this.blogArticleService.queryById(id));
        objectMap.put("result", dataMap);
        objectMap.put("status", 0);
        return objectMap;
    }

    /**
     * 文章点赞
     *
     * @param id 主键
     * @return 单条数据
     */
    @PutMapping("/like/{id}")
    public Map<String, Object> articleLike(@PathVariable Integer id) {
        Map<String, Object> objectMap = new HashMap<>();
        blogArticleService.updateArticleStarNum(id);
        objectMap.put("code", 200);
        return objectMap;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @GetMapping("/allByLimit")
    public List<BlogArticle> findAllByLimit(int offset, int limit) {
        return this.blogArticleService.queryAllByLimit(offset, limit);
    }

    /**
     * 按时间查询
     * @return 对象列表
     */
    @GetMapping("/timeLine")
    public Map<String, Object> timeLine() {
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("result",blogArticleService.timeLine());
        objectMap.put("status",0);
        return objectMap;
    }

    /**
     * 分页查询
     *
     * @param currentPage 页数，当前页
     * @param pageSize    页面大小
     * @param articleType 文章类型
     * @return 对象列表
     */
    //http://localhost:8082/blog-article/queryPage?pageSize=5&currentPage=1
    @RequestMapping("/queryPage")
    public Map<String, Object> queryPage(int pageSize, int currentPage, @RequestParam(required = false, defaultValue = "0") int articleType) {
        //System.out.println(articleType);
        Map<String, Object> objectMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        if (articleType != 0) {
            dataMap.put("data", blogArticleService.queryPage(currentPage, pageSize, articleType));
        } else {
            dataMap.put("data", blogArticleService.queryPage(currentPage, pageSize));
        }
        objectMap.put("result", dataMap);
        objectMap.put("status", 0);
        return objectMap;
    }

    /**
     * 分页查询
     *
     * @param currentPage 页数，当前页
     * @param pageSize    页面大小
     * @return 对象列表
     */
    @GetMapping("/recommend")
    public Map<String, Object> recommend(int pageSize, int currentPage) {
        Map<String, Object> objectMap = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("data",blogArticleService.recommend(currentPage,pageSize));
        objectMap.put("result", dataMap);
        objectMap.put("status", 0);
        return objectMap;
    }

    /**
     * 查询全部数据
     *
     * @return 全部数据
     */
    @GetMapping("/all")
    public List<BlogArticle> findAll() {
        System.out.println("请求all");
        //使用json的转换工具将对象转换成json格式字符串在返回
        //ObjectMapper objectMapper = new ObjectMapper();
        return this.blogArticleService.queryAllByLimit(0, 0);
    }

}

