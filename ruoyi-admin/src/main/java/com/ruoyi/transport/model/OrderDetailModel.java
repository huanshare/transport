package com.ruoyi.transport.model;

import com.ruoyi.transport.domain.TOrder;
import com.ruoyi.transport.domain.TOrderVehicleDriver;

import java.util.List;

/**
 * Created by huans on 2019/12/8.
 */
public class OrderDetailModel extends TOrder {

    private List<TOrderVehicleDriver> orderVehicleDriverList;

    public List<TOrderVehicleDriver> getOrderVehicleDriverList() {
        return orderVehicleDriverList;
    }

    public void setOrderVehicleDriverList(List<TOrderVehicleDriver> orderVehicleDriverList) {
        this.orderVehicleDriverList = orderVehicleDriverList;
    }
}
