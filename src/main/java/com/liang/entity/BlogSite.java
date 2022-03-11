package com.liang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liang
 * @since 2022-01-27
 */
@ApiModel(value="BlogSite对象", description="")
public class BlogSite implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "网站名称")
    @TableField("siteName")
    private String siteName;

    @ApiModelProperty(value = "网站地址")
    @TableField("siteUrl")
    private String siteUrl;

    @ApiModelProperty(value = "状态，0正常，1不可访问")
    @TableField("siteState")
    private Boolean siteState;

    @ApiModelProperty(value = "添加时间")
    @TableField("siteTime")
    private String siteTime;

    @ApiModelProperty(value = "网站类型")
    @TableField("siteType")
    private Integer siteType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public Boolean getSiteState() {
        return siteState;
    }

    public void setSiteState(Boolean siteState) {
        this.siteState = siteState;
    }

    public String getSiteTime() {
        return siteTime;
    }

    public void setSiteTime(String siteTime) {
        this.siteTime = siteTime;
    }

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    @Override
    public String toString() {
        return "BlogSite{" +
        "id=" + id +
        ", siteName=" + siteName +
        ", siteUrl=" + siteUrl +
        ", siteState=" + siteState +
        ", siteTime=" + siteTime +
        ", siteType=" + siteType +
        "}";
    }
}
