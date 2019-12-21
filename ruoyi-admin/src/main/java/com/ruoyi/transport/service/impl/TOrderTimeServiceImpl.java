package com.ruoyi.transport.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.transport.mapper.TOrderTimeMapper;
import com.ruoyi.transport.domain.TOrderTime;
import com.ruoyi.transport.service.ITOrderTimeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单时间Service业务层处理
 * 
 * @author huannshare
 * @date 2019-12-21
 */
@Service
public class TOrderTimeServiceImpl implements ITOrderTimeService 
{
    @Autowired
    private TOrderTimeMapper tOrderTimeMapper;

    /**
     * 查询订单时间
     * 
     * @param id 订单时间ID
     * @return 订单时间
     */
    @Override
    public TOrderTime selectTOrderTimeById(Long id)
    {
        return tOrderTimeMapper.selectTOrderTimeById(id);
    }

    /**
     * 查询订单时间列表
     * 
     * @param tOrderTime 订单时间
     * @return 订单时间
     */
    @Override
    public List<TOrderTime> selectTOrderTimeList(TOrderTime tOrderTime)
    {
        return tOrderTimeMapper.selectTOrderTimeList(tOrderTime);
    }

    /**
     * 新增订单时间
     * 
     * @param tOrderTime 订单时间
     * @return 结果
     */
    @Override
    public int insertTOrderTime(TOrderTime tOrderTime)
    {
    tOrderTime.setCreateTime(DateUtils.getNowDate());
    tOrderTime.setUpdateTime(DateUtils.getNowDate());
        return tOrderTimeMapper.insertTOrderTime(tOrderTime);
    }

    /**
     * 修改订单时间
     * 
     * @param tOrderTime 订单时间
     * @return 结果
     */
    @Override
    public int updateTOrderTime(TOrderTime tOrderTime)
    {
        tOrderTime.setUpdateTime(DateUtils.getNowDate());
        return tOrderTimeMapper.updateTOrderTime(tOrderTime);
    }

    /**
     * 删除订单时间对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTOrderTimeByIds(String ids,String updateBy)
    {
        return tOrderTimeMapper.deleteTOrderTimeByIds(Convert.toStrArray(ids), updateBy);
    }

    /**
     * 删除订单时间信息
     * 
     * @param id 订单时间ID
     * @return 结果
     */
    @Override
    public int deleteTOrderTimeById(Long id,String updateBy)
    {
        return tOrderTimeMapper.deleteTOrderTimeById(id,updateBy);
    }
}
