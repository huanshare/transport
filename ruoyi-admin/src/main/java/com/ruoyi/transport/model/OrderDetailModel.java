package com.ruoyi.transport.model;

import com.alibaba.fastjson.JSON;
import com.ruoyi.transport.domain.TOrder;
import com.ruoyi.transport.domain.TOrderVehicleDriver;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        OrderDetailModel tOrder=new OrderDetailModel();
        tOrder.setOrderCode("123");
        tOrder.setCompanyName("234");
        tOrder.setUserName("23456");
        tOrder.setUserTelephone("234234345");

        List<TOrderVehicleDriver> orderVehicleDriverList=new ArrayList<>();
        for(int i=0;i<2;i++){
            TOrderVehicleDriver item=new TOrderVehicleDriver();
            item.setDispatcher("w54"+i);
            item.setDriverIdentityCard("w35r4"+i);
            item.setVehicleNumber("354434"+i);
            item.setDriverTelephone("w45"+i);
            item.setDriverName("2435"+i);
            orderVehicleDriverList.add(item);
        }
        tOrder.setOrderVehicleDriverList(orderVehicleDriverList);
        System.out.println(JSON.toJSONString(tOrder));
    }
}
