package com.ruoyi.transport.domain;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.net.Inet4Address;
import java.util.Date;

/**
 * 订单对象 t_order
 *
 * @author huanshare
 * @date 2019-12-06
 */
public class TOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * null
     */
    private Long id;

    /**
     * 订单编号
     */
    @Excel(name = "订单编号")
    private String orderCode;

    /**
     * 客户名
     */
    @Excel(name = "客户名")
    private String userName;

    /**
     * 客户手机号
     */
    @Excel(name = "客户手机号")
    private String userTelephone;

    /**
     * 客户公司名称
     */
    @Excel(name = "客户公司名称")
    private String companyName;

    /**
     * 起始地
     */
    @Excel(name = "起始地")
    private String startArea;

    /**
     * 目的地
     */
    @Excel(name = "目的地")
    private String endArea;

    /**
     * 订单状态（100未开始，110运输中，120已完成）
     */
    @Excel(name = "订单状态", readConverterExp = "1=00未开始，110运输中，120已完成")
    private Integer orderStatus;

    /**
     * 开票状态（0未开票，1开票中，2已开票）
     */
    @Excel(name = "开票状态", readConverterExp = "0=未开票，1开票中，2已开票")
    private Integer billStatus;
    /**
     * 开票状态（1专票，2普票）
     */
    @Excel(name = "开票类型", readConverterExp = "1专票，2普票")
    private Integer billType;
    /**
     * 开票状态（0未开票，1开票中，2已开票）
     */
    @Excel(name = "开票金额")
    private Double billExpense;

    /**
     * 结算状态（0未结算，1结算中，2已结算）
     */
    @Excel(name = "结算状态", readConverterExp = "0=未结算，1结算中，2已结算")
    private Integer payableStatus;

    /**
     * 预计费用
     */
    @Excel(name = "预计费用")
    private Double expectExpense;

    /**
     * 预计出发时间
     */
    @Excel(name = "预计出发时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectStartTime;

    /**
     * 预计到达时间
     */
    @Excel(name = "预计到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectArrivalTime;

    /**
     * 实际费用
     */
    @Excel(name = "实际费用")
    private Double actualExpense;

    /**
     * 高速费
     */
    private Double hignSpeedExpense;

    /**
     * 停车费
     */
    private Double parkingExpense;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private Integer delFlag;

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Double getBillExpense() {
        return billExpense;
    }

    public void setBillExpense(Double billExpense) {
        this.billExpense = billExpense;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setStartArea(String startArea) {
        this.startArea = startArea;
    }

    public String getStartArea() {
        return startArea;
    }

    public void setEndArea(String endArea) {
        this.endArea = endArea;
    }

    public String getEndArea() {
        return endArea;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Integer getPayableStatus() {
        return payableStatus;
    }

    public void setPayableStatus(Integer payableStatus) {
        this.payableStatus = payableStatus;
    }

    public void setExpectExpense(Double expectExpense) {
        this.expectExpense = expectExpense;
    }

    public Double getExpectExpense() {
        return expectExpense;
    }

    public void setExpectStartTime(Date expectStartTime) {
        this.expectStartTime = expectStartTime;
    }

    public Date getExpectStartTime() {
        return expectStartTime;
    }

    public void setExpectArrivalTime(Date expectArrivalTime) {
        this.expectArrivalTime = expectArrivalTime;
    }

    public Date getExpectArrivalTime() {
        return expectArrivalTime;
    }

    public void setActualExpense(Double actualExpense) {
        this.actualExpense = actualExpense;
    }

    public Double getActualExpense() {
        return actualExpense;
    }

    public void setHignSpeedExpense(Double hignSpeedExpense) {
        this.hignSpeedExpense = hignSpeedExpense;
    }

    public Double getHignSpeedExpense() {
        return hignSpeedExpense;
    }

    public void setParkingExpense(Double parkingExpense) {
        this.parkingExpense = parkingExpense;
    }

    public Double getParkingExpense() {
        return parkingExpense;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderCode", getOrderCode())
                .append("userName", getUserName())
                .append("userTelephone", getUserTelephone())
                .append("companyName", getCompanyName())
                .append("startArea", getStartArea())
                .append("endArea", getEndArea())
                .append("orderStatus", getOrderStatus())
                .append("billStatus", getBillStatus())
                .append("payableStatus", getPayableStatus())
                .append("expectExpense", getExpectExpense())
                .append("expectStartTime", getExpectStartTime())
                .append("expectArrivalTime", getExpectArrivalTime())
                .append("actualExpense", getActualExpense())
                .append("hignSpeedExpense", getHignSpeedExpense())
                .append("parkingExpense", getParkingExpense())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
