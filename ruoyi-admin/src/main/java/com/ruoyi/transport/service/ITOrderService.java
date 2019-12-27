package com.ruoyi.transport.service;

import com.ruoyi.transport.model.OrderCountDetail;
import com.ruoyi.transport.model.OrderInfoRequestModel;
import com.ruoyi.transport.model.OrderDetailModel;

import java.util.List;

/**
 * 订单Service接口
 *
 * @author huanshare
 * @date 2019-12-06
 */
public interface ITOrderService {
    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    public OrderDetailModel selectTOrderById(Long id);

    /**
     * 查询订单列表
     *
     * @param orderIdList 订单
     * @return 订单集合
     */
    public List<OrderDetailModel> selectTOrderList(List<Long> orderIdList);

    /**
     * 查询订单列表
     *
     * @param tOrder 订单
     * @return 订单集合
     */
    public List<Long> selectTOrderIdList(OrderInfoRequestModel tOrder);

    /**
     * 新增订单
     *
     * @param tOrder 订单
     * @return 结果
     */
    public int insertTOrder(OrderDetailModel tOrder);

    /**
     * 修改订单
     *
     * @param orderDetailModel 订单
     * @return 结果
     */
    public int updateTOrder(OrderDetailModel orderDetailModel);

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTOrderByIds(String ids, String updateBy);

    /**
     * 删除订单信息
     *
     * @param id 订单ID
     * @return 结果
     */
    public int deleteTOrderById(Long id, String updateBy);

    /**
     * 修改订单状态
     * @param id
     * @param orderStatus 订单状态
     * @param billStatus  开票状态
     * @param payableStatus 付款状态
     * @param updateBy 修改人
     * @return
     */
    public int updateTOrderStatus( Long id,
                                  Integer orderStatus,
                                  Integer billStatus,
                                  Integer payableStatus,
                                  String updateBy);


    public OrderCountDetail getOrderSumData();

}
