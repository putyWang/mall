package com.ego.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品类目
 * @TableName tb_item_cat
 */
public class TbItemCat implements Serializable {
    /**
     * 类目ID
     */
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    private Integer status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    private Integer isParent;

    /**
     * 创建时间
     */
    private LocalDateTime created;

    /**
     * 创建时间
     */
    private LocalDateTime updated;

    private static final long serialVersionUID = 1L;

    /**
     * 类目ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 类目ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 类目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 类目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    public Integer getIsParent() {
        return isParent;
    }

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /**
     * 创建时间
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getUpdated() {
        return updated;
    }

    /**
     * 创建时间
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
        TbItemCat other = (TbItemCat) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSortOrder() == null ? other.getSortOrder() == null : this.getSortOrder().equals(other.getSortOrder()))
            && (this.getIsParent() == null ? other.getIsParent() == null : this.getIsParent().equals(other.getIsParent()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSortOrder() == null) ? 0 : getSortOrder().hashCode());
        result = prime * result + ((getIsParent() == null) ? 0 : getIsParent().hashCode());
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
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isParent=").append(isParent);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}