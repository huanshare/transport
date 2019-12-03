package com.ruoyi.transport.mapper;

import com.ruoyi.transport.domain.TDriver;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 司机Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-03
 */
public interface TDriverMapper 
{
    /**
     * 查询司机
     * 
     * @param id 司机ID
     * @return 司机
     */
    public TDriver selectTDriverById(Long id);

    /**
     * 查询司机列表
     * 
     * @param tDriver 司机
     * @return 司机集合
     */
    public List<TDriver> selectTDriverList(TDriver tDriver);

    /**
     * 新增司机
     * 
     * @param tDriver 司机
     * @return 结果
     */
    public int insertTDriver(TDriver tDriver);

    /**
     * 修改司机
     * 
     * @param tDriver 司机
     * @return 结果
     */
    public int updateTDriver(TDriver tDriver);

    /**
     * 删除司机
     * 
     * @param id 司机ID
     * @return 结果
     */
    public int deleteTDriverById(@Param("id") Long id, @Param("updateBy") String updateBy);

    /**
     * 批量删除司机
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTDriverByIds(@Param("ids") String[] ids, @Param("updateBy") String updateBy);
}
