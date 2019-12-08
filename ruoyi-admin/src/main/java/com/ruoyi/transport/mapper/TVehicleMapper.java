package com.ruoyi.transport.mapper;

import com.ruoyi.transport.domain.TVehicle;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 车辆Mapper接口
 *
 * @author huanshare
 * @date 2019-12-06
 */
public interface TVehicleMapper {
    /**
     * 查询车辆
     *
     * @param id 车辆ID
     * @return 车辆
     */
    public TVehicle selectTVehicleById(Long id);

    /**
     * 查询车辆列表
     *
     * @param tVehicle 车辆
     * @return 车辆集合
     */
    public List<TVehicle> selectTVehicleList(TVehicle tVehicle);

    /**
     * 新增车辆
     *
     * @param tVehicle 车辆
     * @return 结果
     */
    public int insertTVehicle(TVehicle tVehicle);

    /**
     * 修改车辆
     *
     * @param tVehicle 车辆
     * @return 结果
     */
    public int updateTVehicle(TVehicle tVehicle);

    /**
     * 删除车辆
     *
     * @param id 车辆ID
     * @return 结果
     */
    public int deleteTVehicleById(@Param("id") Long id, @Param("updateBy") String updateBy);

    /**
     * 批量删除车辆
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTVehicleByIds(@Param("ids") String[] ids, @Param("updateBy") String updateBy);
}
