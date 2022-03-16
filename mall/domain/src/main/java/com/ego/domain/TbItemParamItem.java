package com.ego.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品规格和商品的关系表
 * @TableName tb_item_param_item
 */
public class TbItemParamItem implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long itemId;

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
     * 商品ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 商品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
        TbItemParamItem other = (TbItemParamItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getParamData() == null ? other.getParamData() == null : this.getParamData().equals(other.getParamData()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getUpdated() == null ? other.getUpdated() == null : this.getUpdated().equals(other.getUpdated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
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
        sb.append(", itemId=").append(itemId);
        sb.append(", paramData=").append(paramData);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}