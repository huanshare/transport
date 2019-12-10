package com.ruoyi.transport.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.transport.domain.TDriver;
import com.ruoyi.transport.domain.TOrder;
import com.ruoyi.transport.domain.TOrderVehicleDriver;
import com.ruoyi.transport.domain.TVehicle;
import com.ruoyi.transport.enums.BillStatusEnum;
import com.ruoyi.transport.enums.OrderStatusEnum;
import com.ruoyi.transport.enums.PayableStatus;
import com.ruoyi.transport.mapper.TDriverMapper;
import com.ruoyi.transport.mapper.TOrderMapper;
import com.ruoyi.transport.mapper.TOrderVehicleDriverMapper;
import com.ruoyi.transport.mapper.TVehicleMapper;
import com.ruoyi.transport.model.OrderInfoRequestModel;
import com.ruoyi.transport.model.OrderDetailModel;
import com.ruoyi.transport.service.ITOrderService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 订单Service业务层处理
 *
 * @author huanshare
 * @date 2019-12-06
 */
@Service
public class TOrderServiceImpl implements ITOrderService {
    @Autowired
    private TOrderMapper tOrderMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private TOrderVehicleDriverMapper tOrderVehicleDriverMapper;

    @Autowired
    private TDriverMapper tDriverMapper;

    @Autowired
    private TVehicleMapper tVehicleMapper;


    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public OrderDetailModel selectTOrderById(Long id) {
        return tOrderMapper.selectOrderInfoById(id);
    }

    /**
     * 查询订单列表
     *
     * @param tOrder 订单
     * @return 订单
     */
    @Override
    public List<OrderDetailModel> selectTOrderList(OrderInfoRequestModel tOrder) {
        return tOrderMapper.selectOrderInfoList(tOrder);
    }

    /**
     * 新增订单
     *
     * @param orderDetailModel 订单
     * @return 结果
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertTOrder(OrderDetailModel orderDetailModel) {
        orderDetailModel.setCreateTime(DateUtils.getNowDate());
        orderDetailModel.setUpdateTime(DateUtils.getNowDate());

        TOrder tOrder= new TOrder();
        BeanUtils.copyProperties(orderDetailModel,tOrder);
        tOrder.setOrderCode(commonService.getOrderCode());
        tOrder.setOrderStatus(OrderStatusEnum.UN_START.getKey());
        tOrder.setBillStatus(BillStatusEnum.UN_BILLING.getKey());
        tOrder.setPayableStatus(PayableStatus.UN_PAY.getKey());
        tOrder.setCreateTime(DateUtils.getNowDate());
        tOrder.setUpdateTime(DateUtils.getNowDate());
        tOrderMapper.insertTOrder(tOrder);
        orderDetailModel.setId(tOrder.getId());
        //保存其他信息
        saveOtherInfo(orderDetailModel,false);

        return 1;
    }



    /**
     * 修改订单
     *
     * @param orderDetailModel 订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateTOrder(OrderDetailModel orderDetailModel) {
        orderDetailModel.setUpdateTime(DateUtils.getNowDate());
        TOrder tOrder= new TOrder();
        BeanUtils.copyProperties(orderDetailModel,tOrder);
        tOrderMapper.updateTOrder(tOrder);

        //保存订单车辆司机表
        TOrderVehicleDriver orderVehicleDriver=new TOrderVehicleDriver();
        BeanUtils.copyProperties(orderDetailModel,orderVehicleDriver);
        tOrderVehicleDriverMapper.updateTOrderVehicleDriver(orderVehicleDriver);

        //保存其他信息
        saveOtherInfo(orderDetailModel,true);
        return 1;
    }

    /**
     * 删除订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTOrderByIds(String ids, String updateBy) {
        return tOrderMapper.deleteTOrderByIds(Convert.toStrArray(ids), updateBy);
    }

    /**
     * 删除订单信息
     *
     * @param id 订单ID
     * @return 结果
     */
    @Override
    public int deleteTOrderById(Long id, String updateBy) {
        return tOrderMapper.deleteTOrderById(id, updateBy);
    }

    /**
     *
     * @param orderDetailModel
     * @param isUpdate 是否是更新
     */
    private void saveOtherInfo(OrderDetailModel orderDetailModel, Boolean isUpdate){
        List<TOrderVehicleDriver> orderVehicleDriverList = orderDetailModel.getOrderVehicleDriverList();
        if(isUpdate) {
            //删除原有车辆信息
            tOrderVehicleDriverMapper.deleteTOrderVehicleDriverByOrderId(orderDetailModel.getId(), orderDetailModel.getUpdateBy());
        }
        if(CollectionUtils.isNotEmpty(orderVehicleDriverList)){
            orderVehicleDriverList.forEach(item->{
                //保存订单车辆司机表
                TOrderVehicleDriver orderVehicleDriver=new TOrderVehicleDriver();
                BeanUtils.copyProperties(item,orderVehicleDriver);
                orderVehicleDriver.setOrderId(orderDetailModel.getId());
                Date nowDate = DateUtils.getNowDate();
                orderVehicleDriver.setCreateTime(nowDate);
                orderVehicleDriver.setUpdateTime(nowDate);
                orderVehicleDriver.setCreateBy(orderDetailModel.getUpdateBy());
                orderVehicleDriver.setUpdateBy(orderDetailModel.getUpdateBy());
                tOrderVehicleDriverMapper.insertTOrderVehicleDriver(orderVehicleDriver);

                //完善司机表
                if(StringUtils.isNotEmpty(item.getDriverTelephone())){
                    TDriver params=new TDriver();
                    params.setDriverTelephone(item.getDriverTelephone());
                    List<TDriver> tDriverList = tDriverMapper.selectTDriverList(params);
                    if(CollectionUtils.isEmpty(tDriverList)){
                        TDriver tDriver=new TDriver();
                        BeanUtils.copyProperties(item,tDriver);
                        tDriver.setCreateTime(nowDate);
                        tDriver.setUpdateTime(nowDate);
                        tDriver.setCreateBy(orderDetailModel.getUpdateBy());
                        tDriver.setUpdateBy(orderDetailModel.getUpdateBy());
                        tDriverMapper.insertTDriver(tDriver);
                    }
                }

                //完善车辆表
                if(StringUtils.isNotEmpty(item.getVehicleNumber())){
                    TVehicle params=new TVehicle();
                    params.setVehicleNumber(item.getVehicleNumber());
                    List<TVehicle> tDriverList = tVehicleMapper.selectTVehicleList(params);
                    if(CollectionUtils.isEmpty(tDriverList)){
                        TVehicle tVehicle=new TVehicle();
                        BeanUtils.copyProperties(item,tVehicle);
                        tVehicle.setCreateTime(nowDate);
                        tVehicle.setUpdateTime(nowDate);
                        tVehicle.setCreateBy(orderDetailModel.getUpdateBy());
                        tVehicle.setUpdateBy(orderDetailModel.getUpdateBy());
                        tVehicleMapper.insertTVehicle(tVehicle);
                    }
                }
            });
        }

    }

    /**
     * 修改订单状态
     * @param id
     * @param orderStatus 订单状态
     * @param billStatus  开票状态
     * @param payableStatus 付款状态
     * @param updateBy 修改人
     * @return
     */
    @Override
    public int updateTOrderStatus( Long id, Integer orderStatus, Integer billStatus, Integer payableStatus, String updateBy){
        TOrder tOrder = tOrderMapper.selectTOrderById(id);
        if(null==tOrder){
            throw new BusinessException("修改失败：订单不存在");
        }
        if(OrderStatusEnum.TRANSPORT_COMPLETED.getKey()>tOrder.getOrderStatus()){
            if(null!=billStatus){
                throw new BusinessException("订单未运输完成，不能修改开票状态");
            }
            if(null!=payableStatus){
                throw new BusinessException("订单未运输完成，不能修改结算状态");
            }
        }
        return tOrderMapper.updateTOrderStatus(id,orderStatus,billStatus,payableStatus,updateBy);
    }
}
