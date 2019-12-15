package com.ruoyi.transport.model;

import java.math.BigDecimal;

/**
 * Created by huans on 2019/12/15.
 */
public class OrderCountDetail {
    //本月
    private Integer unStartCount;
    private Integer inTransitCount;
    private Integer transportCompletedCount;

    //全部
    private BigDecimal unPayCount;
    private BigDecimal hasPayCount;

    private BigDecimal unPaySum;
    private BigDecimal hasPauSum;

    public BigDecimal getUnPayCount() {
        return unPayCount;
    }

    public void setUnPayCount(BigDecimal unPayCount) {
        this.unPayCount = unPayCount;
    }

    public BigDecimal getHasPayCount() {
        return hasPayCount;
    }

    public void setHasPayCount(BigDecimal hasPayCount) {
        this.hasPayCount = hasPayCount;
    }

    public BigDecimal getUnPaySum() {
        return unPaySum;
    }

    public void setUnPaySum(BigDecimal unPaySum) {
        this.unPaySum = unPaySum;
    }

    public BigDecimal getHasPauSum() {
        return hasPauSum;
    }

    public void setHasPauSum(BigDecimal hasPauSum) {
        this.hasPauSum = hasPauSum;
    }

    public Integer getUnStartCount() {
        return unStartCount;
    }

    public void setUnStartCount(Integer unStartCount) {
        this.unStartCount = unStartCount;
    }

    public Integer getInTransitCount() {
        return inTransitCount;
    }

    public void setInTransitCount(Integer inTransitCount) {
        this.inTransitCount = inTransitCount;
    }

    public Integer getTransportCompletedCount() {
        return transportCompletedCount;
    }

    public void setTransportCompletedCount(Integer transportCompletedCount) {
        this.transportCompletedCount = transportCompletedCount;
    }
}
