package com.ego.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品规则参数
 * @TableName tb_item_param
 */
public class TbItemParam implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 商品类目ID
     */
    private Long itemCatId;

    /**
     * 类目名称
     */
    private String itemCatName;

    /**
     * 参数数据，格式为json格式
     */
    private String paramData;

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
     * 商品类目ID
     */
    public Long getItemCatId() {
        return itemCatId;
    }

    /**
     * 商品类目ID
     */
    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    /**
     * 参数数据，格式为json格式
     */
    public String getParamData() {
        return paramData;
    }

    /**
     * 参数数据，格式为json格式
     */
    public void setParamData(String paramData) {
        this.paramData = paramData;
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

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
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
        TbItemParam other = (TbItemParam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getItemCatId() == null ? other.getItemCatId() == null : this.getItemCatId().equals(other.getItemCatId()))
            && (this.getParamData() == null ? other.getParamData() == null : this.getParamData().equals(other.getParamData()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemCatId() == null) ? 0 : getItemCatId().hashCode());
        result = prime * result + ((getParamData() == null) ? 0 : getParamData().hashCode());
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
        sb.append(", itemCatId=").append(itemCatId);
        sb.append(", paramData=").append(paramData);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}