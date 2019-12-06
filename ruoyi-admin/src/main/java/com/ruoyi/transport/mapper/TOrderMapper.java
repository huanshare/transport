package com.ruoyi.transport.mapper;

import com.ruoyi.transport.domain.TOrder;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 订单Mapper接口
 * 
 * @author huanshare
 * @date 2019-12-06
 */
public interface TOrderMapper 
{
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
}
