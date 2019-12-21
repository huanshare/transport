package com.ruoyi.transport.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 订单时间对象 t_order_time
 * 
 * @author huannshare
 * @date 2019-12-21
 */
public class TOrderTime extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 订单ID */
    private Long orderId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderCode;

    /** 订单开始时间 */
    @Excel(name = "订单开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderStartTime;

    /** 订单到达时间 */
    @Excel(name = "订单到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderArriveTime;

    /** 订单开票时间 */
    @Excel(name = "订单开票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderBillTime;

    /** 订单付款时间 */
    @Excel(name = "订单付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderPayTime;

    /** 删除标志（0代表存在 2代表删除） */
    private Integer delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setOrderCode(String orderCode) 
    {
        this.orderCode = orderCode;
    }

    public String getOrderCode() 
    {
        return orderCode;
    }
    public void setOrderStartTime(Date orderStartTime) 
    {
        this.orderStartTime = orderStartTime;
    }

    public Date getOrderStartTime() 
    {
        return orderStartTime;
    }
    public void setOrderArriveTime(Date orderArriveTime) 
    {
        this.orderArriveTime = orderArriveTime;
    }

    public Date getOrderArriveTime() 
    {
        return orderArriveTime;
    }
    public void setOrderBillTime(Date orderBillTime) 
    {
        this.orderBillTime = orderBillTime;
    }

    public Date getOrderBillTime() 
    {
        return orderBillTime;
    }
    public void setOrderPayTime(Date orderPayTime) 
    {
        this.orderPayTime = orderPayTime;
    }

    public Date getOrderPayTime() 
    {
        return orderPayTime;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("orderCode", getOrderCode())
            .append("orderStartTime", getOrderStartTime())
            .append("orderArriveTime", getOrderArriveTime())
            .append("orderBillTime", getOrderBillTime())
            .append("orderPayTime", getOrderPayTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
