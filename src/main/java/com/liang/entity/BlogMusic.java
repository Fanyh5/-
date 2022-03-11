package com.liang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liang
 * @since 2022-01-15
 */
@ApiModel(value="BlogMusic对象", description="")
public class BlogMusic implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "音乐ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "音乐名")
    private String name;

    @ApiModelProperty(value = "作家")
    private String artist;

    @ApiModelProperty(value = "音乐链接")
    private String url;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "歌词")
    private String lrc;


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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    @Override
    public String toString() {
        return "BlogMusic{" +
        "id=" + id +
        ", name=" + name +
        ", artist=" + artist +
        ", url=" + url +
        ", cover=" + cover +
        ", lrc=" + lrc +
        "}";
    }
}
