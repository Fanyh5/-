package com.liang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liang
 * @since 2022-01-11
 */
@ApiModel(value="BlogArticle对象", description="")
public class BlogArticle implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "文章封面")
    @TableField("articleHeadPic")
    private String articleHeadPic;

    @ApiModelProperty(value = "文章名称")
    @TableField("articleName")
    private String articleName;

    @ApiModelProperty(value = "文章标签")
    @TableField("articleTag")
    private String articleTag;

    @ApiModelProperty(value = "文章简介")
    @TableField("articleRemark")
    private String articleRemark;

    @ApiModelProperty(value = "文章阅读量")
    @TableField("articleReadCount")
    private Integer articleReadCount;

    @ApiModelProperty(value = "文章状态")
    @TableField("articleState")
    private Integer articleState;

    @ApiModelProperty(value = "作者ID")
    @TableField("managerId")
    private Integer managerId;

    @ApiModelProperty(value = "作者名称")
    @TableField("managerName")
    private String managerName;

    @ApiModelProperty(value = "文章内容")
    @TableField("articleContent")
    private String articleContent;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "文章类型")
    @TableField("articleType")
    private Integer articleType;

    @ApiModelProperty(value = "文章点赞数")
    @TableField("articleStarNum")
    private Integer articleStarNum;

    @ApiModelProperty(value = "文章评论数")
    @TableField("articleConNum")
    private Integer articleConNum;

    private String enclosure;

    @ApiModelProperty(value = "标签列表")
    @TableField("tags")
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleHeadPic() {
        return articleHeadPic;
    }

    public void setArticleHeadPic(String articleHeadPic) {
        this.articleHeadPic = articleHeadPic;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = articleTag;
    }

    public String getArticleRemark() {
        return articleRemark;
    }

    public void setArticleRemark(String articleRemark) {
        this.articleRemark = articleRemark;
    }

    public Integer getArticleReadCount() {
        return articleReadCount;
    }

    public void setArticleReadCount(Integer articleReadCount) {
        this.articleReadCount = articleReadCount;
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getArticleStarNum() {
        return articleStarNum;
    }

    public void setArticleStarNum(Integer articleStarNum) {
        this.articleStarNum = articleStarNum;
    }

    public Integer getArticleConNum() {
        return articleConNum;
    }

    public void setArticleConNum(Integer articleConNum) {
        this.articleConNum = articleConNum;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    @Override
    public String toString() {
        return "BlogArticle{" +
                "id=" + id +
                ", articleHeadPic='" + articleHeadPic + '\'' +
                ", articleName='" + articleName + '\'' +
                ", articleTag='" + articleTag + '\'' +
                ", articleRemark='" + articleRemark + '\'' +
                ", articleReadCount=" + articleReadCount +
                ", articleState=" + articleState +
                ", managerId=" + managerId +
                ", managerName='" + managerName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", createTime='" + createTime + '\'' +
                ", articleType=" + articleType +
                ", articleStarNum=" + articleStarNum +
                ", articleConNum=" + articleConNum +
                ", enclosure='" + enclosure + '\'' +
                ", tags=" + tags +
                '}';
    }
}
