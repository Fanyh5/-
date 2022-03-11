package com.liang.vo;

public class BlogCategoryVo {

    //标签ID
    private Integer id;
    //标签名称
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BlogCategory{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
