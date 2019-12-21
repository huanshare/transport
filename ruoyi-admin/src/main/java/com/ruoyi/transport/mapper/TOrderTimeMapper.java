package com.ruoyi.transport.mapper;

import com.ruoyi.transport.domain.TOrderTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 订单时间Mapper接口
 * 
 * @author huannshare
 * @date 2019-12-21
 */
public interface TOrderTimeMapper 
{
    /**
     * 查询订单时间
     * 
     * @param id 订单时间ID
     * @return 订单时间
     */
    public TOrderTime selectTOrderTimeById(Long id);


    public TOrderTime selectTOrderTimeByOrderId(Long orderId);

    /**
     * 查询订单时间列表
     * 
     * @param tOrderTime 订单时间
     * @return 订单时间集合
     */
    public List<TOrderTime> selectTOrderTimeList(TOrderTime tOrderTime);

    /**
     * 新增订单时间
     * 
     * @param tOrderTime 订单时间
     * @return 结果
     */
    public int insertTOrderTime(TOrderTime tOrderTime);

    /**
     * 修改订单时间
     * 
     * @param tOrderTime 订单时间
     * @return 结果
     */
    public int updateTOrderTime(TOrderTime tOrderTime);

    /**
     * 删除订单时间
     * 
     * @param id 订单时间ID
     * @return 结果
     */
    public int deleteTOrderTimeById(@Param("id") Long id, @Param("updateBy") String updateBy);

    /**
     * 批量删除订单时间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTOrderTimeByIds(@Param("ids") String[] ids, @Param("updateBy") String updateBy);
}
