package com.ruoyi.transport.service;

import com.ruoyi.transport.domain.TOrderTime;
import java.util.List;

/**
 * 订单时间Service接口
 * 
 * @author huannshare
 * @date 2019-12-21
 */
public interface ITOrderTimeService 
{
    /**
     * 查询订单时间
     * 
     * @param id 订单时间ID
     * @return 订单时间
     */
    public TOrderTime selectTOrderTimeById(Long id);

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
     * 批量删除订单时间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTOrderTimeByIds(String ids, String updateBy);

    /**
     * 删除订单时间信息
     * 
     * @param id 订单时间ID
     * @return 结果
     */
    public int deleteTOrderTimeById(Long id, String updateBy);
}
