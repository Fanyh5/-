package com.liang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
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
@ApiModel(value="BlogSitetype对象", description="")
public class BlogSitetype implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "类型ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "网站类型名")
    @TableField("sitetypeName")
    private String sitetypeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSitetypeName() {
        return sitetypeName;
    }

    public void setSitetypeName(String sitetypeName) {
        this.sitetypeName = sitetypeName;
    }

    @Override
    public String toString() {
        return "BlogSitetype{" +
        "id=" + id +
        ", sitetypeName=" + sitetypeName +
        "}";
    }
}
