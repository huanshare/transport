package com.ruoyi.transport.service.impl;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huans on 2019/12/8.
 */
@Service
public class CommonService {

    public String getOrderCode() {
        return "WLD" + new SimpleDateFormat("yyyMMddHHmmss").format(new Date()) + (int) ((Math.random() * 9 + 1) * 1000);
    }
}
