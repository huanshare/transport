package com.ruoyi.transport.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.transport.mapper.TDriverMapper;
import com.ruoyi.transport.domain.TDriver;
import com.ruoyi.transport.service.ITDriverService;
import com.ruoyi.common.core.text.Convert;

/**
 * 司机Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-03
 */
@Service
public class TDriverServiceImpl implements ITDriverService 
{
    @Autowired
    private TDriverMapper tDriverMapper;

    /**
     * 查询司机
     * 
     * @param id 司机ID
     * @return 司机
     */
    @Override
    public TDriver selectTDriverById(Long id)
    {
        return tDriverMapper.selectTDriverById(id);
    }

    /**
     * 查询司机列表
     * 
     * @param tDriver 司机
     * @return 司机
     */
    @Override
    public List<TDriver> selectTDriverList(TDriver tDriver)
    {
        return tDriverMapper.selectTDriverList(tDriver);
    }

    /**
     * 新增司机
     * 
     * @param tDriver 司机
     * @return 结果
     */
    @Override
    public int insertTDriver(TDriver tDriver)
    {
                                                                            tDriver.setCreateTime(DateUtils.getNowDate());
                tDriver.setUpdateTime(DateUtils.getNowDate());
                            return tDriverMapper.insertTDriver(tDriver);
    }

    /**
     * 修改司机
     * 
     * @param tDriver 司机
     * @return 结果
     */
    @Override
    public int updateTDriver(TDriver tDriver)
    {
        tDriver.setUpdateTime(DateUtils.getNowDate());
        return tDriverMapper.updateTDriver(tDriver);
    }

    /**
     * 删除司机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTDriverByIds(String ids,String updateBy)
    {
        return tDriverMapper.deleteTDriverByIds(Convert.toStrArray(ids), updateBy);
    }

    /**
     * 删除司机信息
     * 
     * @param id 司机ID
     * @return 结果
     */
    @Override
    public int deleteTDriverById(Long id,String updateBy)
    {
        return tDriverMapper.deleteTDriverById(id,updateBy);
    }
}
