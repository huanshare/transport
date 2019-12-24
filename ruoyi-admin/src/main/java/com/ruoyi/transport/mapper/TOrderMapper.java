package com.ruoyi.transport.mapper;

import com.ruoyi.transport.domain.TOrder;
import com.ruoyi.transport.model.OrderCountDetail;
import com.ruoyi.transport.model.OrderDetailModel;
import com.ruoyi.transport.model.OrderInfoRequestModel;
import com.ruoyi.transport.model.OrderStatusCount;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 订单Mapper接口
 *
 * @author huanshare
 * @date 2019-12-06
 */
public interface TOrderMapper {
    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    public TOrder selectTOrderById(Long id);

    /**
     * 查询订单列表
     *
     * @param tOrder 订单
     * @return 订单集合
     */
    public List<TOrder> selectTOrderList(TOrder tOrder);

    /**
     * 查询订单列表
     *
     * @param tOrder 订单
     * @return 订单集合
     */
    public List<OrderDetailModel> selectOrderInfoList(OrderInfoRequestModel tOrder);


    /**
     * 查询订单详情
     *
     * @param id id
     * @return 订单集合
     */
    public OrderDetailModel selectOrderInfoById(Long id);

    /**
     * 新增订单
     *
     * @param tOrder 订单
     * @return 结果
     */
    public int insertTOrder(TOrder tOrder);

    /**
     * 修改订单
     *
     * @param tOrder 订单
     * @return 结果
     */
    public int updateTOrder(TOrder tOrder);

    /**
     * 删除订单
     *
     * @param id 订单ID
     * @return 结果
     */
    public int deleteTOrderById(@Param("id") Long id, @Param("updateBy") String updateBy);

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTOrderByIds(@Param("ids") String[] ids, @Param("updateBy") String updateBy);

    /**
     * 修改订单状态
     *
     * @param id tOrder
     * @return 结果
     */
    public int updateTOrderStatus(@Param("id") Long id,
                                  @Param("orderStatus")Integer orderStatus,
                                  @Param("billStatus")Integer billStatus,
                                  @Param("payableStatus")Integer payableStatus,
                                  @Param("updateBy") String updateBy);

    public List<OrderStatusCount> selectOrderStatusCount();

    public OrderCountDetail selectOrderExpenseCount(@Param("startTime")Date startTime,
                                                    @Param("endTime")Date endTime);


}
