package com.ruoyi.transport.enums;

/**
 * Created by huans on 2019/12/8.
 */
public enum PayableStatus {
    UN_PAY(0, "未结算"), //
    PAYING(1, "结算中"),
    HAS_PAYED(2, "已结算");

    private int key;

    private String value;

    PayableStatus(int key, String value) {
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
