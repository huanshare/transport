package com.ruoyi.transport.enums;

/**
 * Created by huans on 2019/12/8.
 */
public enum OrderStatusEnum {
    UN_START(100, "未开始"), //
    IN_TRANSIT(110, "运输中"),
    TRANSPORT_COMPLETED(120, "已完成");

    private int key;

    private String value;

    OrderStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
