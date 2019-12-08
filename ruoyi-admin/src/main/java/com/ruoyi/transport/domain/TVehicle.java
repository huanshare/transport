package com.ruoyi.transport.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆对象 t_vehicle
 *
 * @author huanshare
 * @date 2019-12-06
 */
public class TVehicle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 车牌号
     */
    @Excel(name = "车牌号")
    private String vehicleNumber;

    /**
     * 车辆运输号
     */
    @Excel(name = "车辆运输号")
    private String roadTransportNumber;

    /**
     * 车辆运输行驶证
     */
    @Excel(name = "车辆运输行驶证")
    private String roadTransportImage;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private Integer delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setRoadTransportNumber(String roadTransportNumber) {
        this.roadTransportNumber = roadTransportNumber;
    }

    public String getRoadTransportNumber() {
        return roadTransportNumber;
    }

    public void setRoadTransportImage(String roadTransportImage) {
        this.roadTransportImage = roadTransportImage;
    }

    public String getRoadTransportImage() {
        return roadTransportImage;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("vehicleNumber", getVehicleNumber())
                .append("roadTransportNumber", getRoadTransportNumber())
                .append("roadTransportImage", getRoadTransportImage())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
