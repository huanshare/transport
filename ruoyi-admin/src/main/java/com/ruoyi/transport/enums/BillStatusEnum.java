package com.ruoyi.transport.enums;

/**
 * Created by huans on 2019/12/8.
 */
//0未开票，1开票中，2已开票
public enum BillStatusEnum {
    UN_BILLING(0, "未开票"), //
    BILLING(1, "开票中"),
    HAS_BILLED(2, "已开票");

    private int key;

    private String value;

    BillStatusEnum(int key, String value) {
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
