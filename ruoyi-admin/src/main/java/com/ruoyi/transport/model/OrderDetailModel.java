package com.ruoyi.transport.model;

import com.ruoyi.transport.domain.TOrder;
import com.ruoyi.transport.domain.TOrderVehicleDriver;

import java.util.Date;
import java.util.List;

/**
 * Created by huans on 2019/12/8.
 */
public class OrderDetailModel extends TOrder {

    private List<TOrderVehicleDriver> orderVehicleDriverList;


    /** 订单开始时间 */
    private Date orderStartTime;
    
    /** 订单到达时间 */
    private Date orderArriveTime;

    /** 订单开票时间 */
    private Date orderBillTime;

    /** 订单付款时间 */
    private Date orderPayTime;

    public List<TOrderVehicleDriver> getOrderVehicleDriverList() {
        return orderVehicleDriverList;
    }

    public void setOrderVehicleDriverList(List<TOrderVehicleDriver> orderVehicleDriverList) {
        this.orderVehicleDriverList = orderVehicleDriverList;
    }

    public Date getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Date orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    public Date getOrderArriveTime() {
        return orderArriveTime;
    }

    public void setOrderArriveTime(Date orderArriveTime) {
        this.orderArriveTime = orderArriveTime;
    }

    public Date getOrderBillTime() {
        return orderBillTime;
    }

    public void setOrderBillTime(Date orderBillTime) {
        this.orderBillTime = orderBillTime;
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }
}
