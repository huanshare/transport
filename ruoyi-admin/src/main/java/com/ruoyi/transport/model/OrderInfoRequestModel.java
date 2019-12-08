package com.ruoyi.transport.model;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.transport.domain.TOrder;

/**
 * Created by huans on 2019/12/8.
 */
public class OrderInfoRequestModel extends TOrder {
    /**
     * 订单车辆关系表
     */
    private Long orderVehicleDriverId;
    /**
     * 调度人
     */
    @Excel(name = "调度人")
    private String dispatcher;

    /**
     * 外调车
     */
    @Excel(name = "外调车")
    private String outsideCar;

    /**
     * 车牌号
     */
    @Excel(name = "车牌号")
    private String vehicleNumber;

    /**
     * 司机姓名
     */
    @Excel(name = "司机姓名")
    private String driverName;

    /**
     * 司机手机号
     */
    @Excel(name = "司机手机号")
    private String driverTelephone;

    /**
     * 司机身份证号
     */
    @Excel(name = "司机身份证号")
    private String driverIdentityCard;

    public Long getOrderVehicleDriverId() {
        return orderVehicleDriverId;
    }

    public void setOrderVehicleDriverId(Long orderVehicleDriverId) {
        this.orderVehicleDriverId = orderVehicleDriverId;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getOutsideCar() {
        return outsideCar;
    }

    public void setOutsideCar(String outsideCar) {
        this.outsideCar = outsideCar;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverTelephone() {
        return driverTelephone;
    }

    public void setDriverTelephone(String driverTelephone) {
        this.driverTelephone = driverTelephone;
    }

    public String getDriverIdentityCard() {
        return driverIdentityCard;
    }

    public void setDriverIdentityCard(String driverIdentityCard) {
        this.driverIdentityCard = driverIdentityCard;
    }
}
