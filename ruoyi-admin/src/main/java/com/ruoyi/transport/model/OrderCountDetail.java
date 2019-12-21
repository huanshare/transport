package com.ruoyi.transport.model;

import java.math.BigDecimal;

/**
 * Created by huans on 2019/12/15.
 */
public class OrderCountDetail {

    private Integer unStartCount = 0;
    private Integer inTransitCount = 0;
    private Integer transportCompletedCount = 0;
    private Integer hasPayedCount = 0;
    //全部
    private Integer totalCount = 0;

    private Integer currentMonthCount = 0;

    private BigDecimal totalExpense = new BigDecimal(0.00);

    private BigDecimal currentMonthExpense = new BigDecimal(0.00);

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

    public Integer getHasPayedCount() {
        return hasPayedCount;
    }

    public void setHasPayedCount(Integer hasPayedCount) {
        this.hasPayedCount = hasPayedCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentMonthCount() {
        return currentMonthCount;
    }

    public void setCurrentMonthCount(Integer currentMonthCount) {
        this.currentMonthCount = currentMonthCount;
    }

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    public BigDecimal getCurrentMonthExpense() {
        return currentMonthExpense;
    }

    public void setCurrentMonthExpense(BigDecimal currentMonthExpense) {
        this.currentMonthExpense = currentMonthExpense;
    }
}
