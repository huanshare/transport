package com.ruoyi.transport.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.transport.mapper.TOrderVehicleDriverMapper;
import com.ruoyi.transport.domain.TOrderVehicleDriver;
import com.ruoyi.transport.service.ITOrderVehicleDriverService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单车辆司机Service业务层处理
 *
 * @author huanshare
 * @date 2019-12-06
 */
@Service
public class TOrderVehicleDriverServiceImpl implements ITOrderVehicleDriverService {
    @Autowired
    private TOrderVehicleDriverMapper tOrderVehicleDriverMapper;

    /**
     * 查询订单车辆司机
     *
     * @param id 订单车辆司机ID
     * @return 订单车辆司机
     */
    @Override
    public TOrderVehicleDriver selectTOrderVehicleDriverById(Long id) {
        return tOrderVehicleDriverMapper.selectTOrderVehicleDriverById(id);
    }

    /**
     * 查询订单车辆司机列表
     *
     * @param tOrderVehicleDriver 订单车辆司机
     * @return 订单车辆司机
     */
    @Override
    public List<TOrderVehicleDriver> selectTOrderVehicleDriverList(TOrderVehicleDriver tOrderVehicleDriver) {
        return tOrderVehicleDriverMapper.selectTOrderVehicleDriverList(tOrderVehicleDriver);
    }

    /**
     * 新增订单车辆司机
     *
     * @param tOrderVehicleDriver 订单车辆司机
     * @return 结果
     */
    @Override
    public int insertTOrderVehicleDriver(TOrderVehicleDriver tOrderVehicleDriver) {
        Date nowDate = DateUtils.getNowDate();
        tOrderVehicleDriver.setCreateTime(nowDate);
        tOrderVehicleDriver.setUpdateTime(nowDate);
        return tOrderVehicleDriverMapper.insertTOrderVehicleDriver(tOrderVehicleDriver);
    }

    /**
     * 修改订单车辆司机
     *
     * @param tOrderVehicleDriver 订单车辆司机
     * @return 结果
     */
    @Override
    public int updateTOrderVehicleDriver(TOrderVehicleDriver tOrderVehicleDriver) {
        tOrderVehicleDriver.setUpdateTime(DateUtils.getNowDate());
        return tOrderVehicleDriverMapper.updateTOrderVehicleDriver(tOrderVehicleDriver);
    }

    /**
     * 删除订单车辆司机对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTOrderVehicleDriverByIds(String ids, String updateBy) {
        return tOrderVehicleDriverMapper.deleteTOrderVehicleDriverByIds(Convert.toStrArray(ids), updateBy);
    }

    /**
     * 删除订单车辆司机信息
     *
     * @param id 订单车辆司机ID
     * @return 结果
     */
    @Override
    public int deleteTOrderVehicleDriverById(Long id, String updateBy) {
        return tOrderVehicleDriverMapper.deleteTOrderVehicleDriverById(id, updateBy);
    }
}
