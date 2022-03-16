package com.ego.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName tb_order
 */
public class TbOrder implements Serializable {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    private String payment;

    /**
     * 支付类型，1、在线支付，2、货到付款
     */
    private Integer paymentType;

    /**
     * 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    private String postFee;

    /**
     * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 付款时间
     */
    private LocalDateTime paymentTime;

    /**
     * 发货时间
     */
    private LocalDateTime consignTime;

    /**
     * 交易完成时间
     */
    private LocalDateTime endTime;

    /**
     * 交易关闭时间
     */
    private LocalDateTime closeTime;

    /**
     * 物流名称
     */
    private String shippingName;

    /**
     * 物流单号
     */
    private String shippingCode;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 买家留言
     */
    private String buyerMessage;

    /**
     * 买家昵称
     */
    private String buyerNick;

    /**
     * 买家是否已经评价
     */
    private Integer buyerRate;

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public String getPayment() {
        return payment;
    }

    /**
     * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * 支付类型，1、在线支付，2、货到付款
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 支付类型，1、在线支付，2、货到付款
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public String getPostFee() {
        return postFee;
    }

    /**
     * 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    /**
     * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 订单创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 订单创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 订单更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 订单更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 付款时间
     */
    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    /**
     * 付款时间
     */
    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 发货时间
     */
    public LocalDateTime getConsignTime() {
        return consignTime;
    }

    /**
     * 发货时间
     */
    public void setConsignTime(LocalDateTime consignTime) {
        this.consignTime = consignTime;
    }

    /**
     * 交易完成时间
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * 交易完成时间
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * 交易关闭时间
     */
    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    /**
     * 交易关闭时间
     */
    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 物流名称
     */
    public String getShippingName() {
        return shippingName;
    }

    /**
     * 物流名称
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    /**
     * 物流单号
     */
    public String getShippingCode() {
        return shippingCode;
    }

    /**
     * 物流单号
     */
    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    /**
     * 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 买家留言
     */
    public String getBuyerMessage() {
        return buyerMessage;
    }

    /**
     * 买家留言
     */
    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    /**
     * 买家昵称
     */
    public String getBuyerNick() {
        return buyerNick;
    }

    /**
     * 买家昵称
     */
    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    /**
     * 买家是否已经评价
     */
    public Integer getBuyerRate() {
        return buyerRate;
    }

    /**
     * 买家是否已经评价
     */
    public void setBuyerRate(Integer buyerRate) {
        this.buyerRate = buyerRate;
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
        TbOrder other = (TbOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPayment() == null ? other.getPayment() == null : this.getPayment().equals(other.getPayment()))
            && (this.getPaymentType() == null ? other.getPaymentType() == null : this.getPaymentType().equals(other.getPaymentType()))
            && (this.getPostFee() == null ? other.getPostFee() == null : this.getPostFee().equals(other.getPostFee()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPaymentTime() == null ? other.getPaymentTime() == null : this.getPaymentTime().equals(other.getPaymentTime()))
            && (this.getConsignTime() == null ? other.getConsignTime() == null : this.getConsignTime().equals(other.getConsignTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCloseTime() == null ? other.getCloseTime() == null : this.getCloseTime().equals(other.getCloseTime()))
            && (this.getShippingName() == null ? other.getShippingName() == null : this.getShippingName().equals(other.getShippingName()))
            && (this.getShippingCode() == null ? other.getShippingCode() == null : this.getShippingCode().equals(other.getShippingCode()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBuyerMessage() == null ? other.getBuyerMessage() == null : this.getBuyerMessage().equals(other.getBuyerMessage()))
            && (this.getBuyerNick() == null ? other.getBuyerNick() == null : this.getBuyerNick().equals(other.getBuyerNick()))
            && (this.getBuyerRate() == null ? other.getBuyerRate() == null : this.getBuyerRate().equals(other.getBuyerRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPayment() == null) ? 0 : getPayment().hashCode());
        result = prime * result + ((getPaymentType() == null) ? 0 : getPaymentType().hashCode());
        result = prime * result + ((getPostFee() == null) ? 0 : getPostFee().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPaymentTime() == null) ? 0 : getPaymentTime().hashCode());
        result = prime * result + ((getConsignTime() == null) ? 0 : getConsignTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCloseTime() == null) ? 0 : getCloseTime().hashCode());
        result = prime * result + ((getShippingName() == null) ? 0 : getShippingName().hashCode());
        result = prime * result + ((getShippingCode() == null) ? 0 : getShippingCode().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBuyerMessage() == null) ? 0 : getBuyerMessage().hashCode());
        result = prime * result + ((getBuyerNick() == null) ? 0 : getBuyerNick().hashCode());
        result = prime * result + ((getBuyerRate() == null) ? 0 : getBuyerRate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", payment=").append(payment);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", postFee=").append(postFee);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", consignTime=").append(consignTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append(", shippingName=").append(shippingName);
        sb.append(", shippingCode=").append(shippingCode);
        sb.append(", userId=").append(userId);
        sb.append(", buyerMessage=").append(buyerMessage);
        sb.append(", buyerNick=").append(buyerNick);
        sb.append(", buyerRate=").append(buyerRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}