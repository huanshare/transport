package com.ruoyi.transport.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.transport.mapper.TVehicleMapper;
import com.ruoyi.transport.domain.TVehicle;
import com.ruoyi.transport.service.ITVehicleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 车辆Service业务层处理
 * 
 * @author huanshare
 * @date 2019-12-06
 */
@Service
public class TVehicleServiceImpl implements ITVehicleService 
{
    @Autowired
    private TVehicleMapper tVehicleMapper;

    /**
     * 查询车辆
     * 
     * @param id 车辆ID
     * @return 车辆
     */
    @Override
    public TVehicle selectTVehicleById(Long id)
    {
        return tVehicleMapper.selectTVehicleById(id);
    }

    /**
     * 查询车辆列表
     * 
     * @param tVehicle 车辆
     * @return 车辆
     */
    @Override
    public List<TVehicle> selectTVehicleList(TVehicle tVehicle)
    {
        return tVehicleMapper.selectTVehicleList(tVehicle);
    }

    /**
     * 新增车辆
     * 
     * @param tVehicle 车辆
     * @return 结果
     */
    @Override
    public int insertTVehicle(TVehicle tVehicle)
    {
    tVehicle.setCreateTime(DateUtils.getNowDate());
    tVehicle.setUpdateTime(DateUtils.getNowDate());
        return tVehicleMapper.insertTVehicle(tVehicle);
    }

    /**
     * 修改车辆
     * 
     * @param tVehicle 车辆
     * @return 结果
     */
    @Override
    public int updateTVehicle(TVehicle tVehicle)
    {
        tVehicle.setUpdateTime(DateUtils.getNowDate());
        return tVehicleMapper.updateTVehicle(tVehicle);
    }

    /**
     * 删除车辆对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTVehicleByIds(String ids,String updateBy)
    {
        return tVehicleMapper.deleteTVehicleByIds(Convert.toStrArray(ids), updateBy);
    }

    /**
     * 删除车辆信息
     * 
     * @param id 车辆ID
     * @return 结果
     */
    @Override
    public int deleteTVehicleById(Long id,String updateBy)
    {
        return tVehicleMapper.deleteTVehicleById(id,updateBy);
    }
}
