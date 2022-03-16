package com.ego.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName tb_content
 */
public class TbContent implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 内容类目ID
     */
    private Long categoryId;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 子标题
     */
    private String subTitle;

    /**
     * 标题描述
     */
    private String titleDesc;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片绝对路径
     */
    private String pic;

    /**
     * 图片2
     */
    private String pic2;

    /**
     * 内容
     */
    private String content;

    /**
     * 
     */
    private LocalDateTime created;

    /**
     * 
     */
    private LocalDateTime updated;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 内容类目ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 内容类目ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 内容标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 内容标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 子标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 子标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * 标题描述
     */
    public String getTitleDesc() {
        return titleDesc;
    }

    /**
     * 标题描述
     */
    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    /**
     * 链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 图片绝对路径
     */
    public String getPic() {
        return pic;
    }

    /**
     * 图片绝对路径
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 图片2
     */
    public String getPic2() {
        return pic2;
    }

    /**
     * 图片2
     */
    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    /**
     * 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /**
     * 
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * 
     */
    public LocalDateTime getUpdated() {
        return updated;
    }

    /**
     * 
     */
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbContent other = (TbContent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSubTitle() == null ? other.getSubTitle() == null : this.getSubTitle().equals(other.getSubTitle()))
            && (this.getTitleDesc() == null ? other.getTitleDesc() == null : this.getTitleDesc().equals(other.getTitleDesc()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getPic2() == null ? other.getPic2() == null : this.getPic2().equals(other.getPic2()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSubTitle() == null) ? 0 : getSubTitle().hashCode());
        result = prime * result + ((getTitleDesc() == null) ? 0 : getTitleDesc().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getPic2() == null) ? 0 : getPic2().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getUpdated() == null) ? 0 : getUpdated().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", title=").append(title);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", titleDesc=").append(titleDesc);
        sb.append(", url=").append(url);
        sb.append(", pic=").append(pic);
        sb.append(", pic2=").append(pic2);
        sb.append(", content=").append(content);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}