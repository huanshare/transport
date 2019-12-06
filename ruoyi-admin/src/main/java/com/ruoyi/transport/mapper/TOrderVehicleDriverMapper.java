package com.ruoyi.transport.mapper;

import com.ruoyi.transport.domain.TOrderVehicleDriver;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 订单车辆司机Mapper接口
 * 
 * @author huanshare
 * @date 2019-12-06
 */
public interface TOrderVehicleDriverMapper 
{
    /**
     * 查询订单车辆司机
     * 
     * @param id 订单车辆司机ID
     * @return 订单车辆司机
     */
    public TOrderVehicleDriver selectTOrderVehicleDriverById(Long id);

    /**
     * 查询订单车辆司机列表
     * 
     * @param tOrderVehicleDriver 订单车辆司机
     * @return 订单车辆司机集合
     */
    public List<TOrderVehicleDriver> selectTOrderVehicleDriverList(TOrderVehicleDriver tOrderVehicleDriver);

    /**
     * 新增订单车辆司机
     * 
     * @param tOrderVehicleDriver 订单车辆司机
     * @return 结果
     */
    public int insertTOrderVehicleDriver(TOrderVehicleDriver tOrderVehicleDriver);

    /**
     * 修改订单车辆司机
     * 
     * @param tOrderVehicleDriver 订单车辆司机
     * @return 结果
     */
    public int updateTOrderVehicleDriver(TOrderVehicleDriver tOrderVehicleDriver);

    /**
     * 删除订单车辆司机
     * 
     * @param id 订单车辆司机ID
     * @return 结果
     */
    public int deleteTOrderVehicleDriverById(@Param("id") Long id, @Param("updateBy") String updateBy);

    /**
     * 批量删除订单车辆司机
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTOrderVehicleDriverByIds(@Param("ids") String[] ids, @Param("updateBy") String updateBy);
}
