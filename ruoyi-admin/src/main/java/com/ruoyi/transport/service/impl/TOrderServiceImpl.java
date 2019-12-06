package com.ruoyi.transport.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.transport.mapper.TOrderMapper;
import com.ruoyi.transport.domain.TOrder;
import com.ruoyi.transport.service.ITOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单Service业务层处理
 * 
 * @author huanshare
 * @date 2019-12-06
 */
@Service
public class TOrderServiceImpl implements ITOrderService 
{
    @Autowired
    private TOrderMapper tOrderMapper;

    /**
     * 查询订单
     * 
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public TOrder selectTOrderById(Long id)
    {
        return tOrderMapper.selectTOrderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param tOrder 订单
     * @return 订单
     */
    @Override
    public List<TOrder> selectTOrderList(TOrder tOrder)
    {
        return tOrderMapper.selectTOrderList(tOrder);
    }

    /**
     * 新增订单
     * 
     * @param tOrder 订单
     * @return 结果
     */
    @Override
    public int insertTOrder(TOrder tOrder)
    {
    tOrder.setCreateTime(DateUtils.getNowDate());
    tOrder.setUpdateTime(DateUtils.getNowDate());
        return tOrderMapper.insertTOrder(tOrder);
    }

    /**
     * 修改订单
     * 
     * @param tOrder 订单
     * @return 结果
     */
    @Override
    public int updateTOrder(TOrder tOrder)
    {
        tOrder.setUpdateTime(DateUtils.getNowDate());
        return tOrderMapper.updateTOrder(tOrder);
    }

    /**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTOrderByIds(String ids,String updateBy)
    {
        return tOrderMapper.deleteTOrderByIds(Convert.toStrArray(ids), updateBy);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单ID
     * @return 结果
     */
    @Override
    public int deleteTOrderById(Long id,String updateBy)
    {
        return tOrderMapper.deleteTOrderById(id,updateBy);
    }
}
