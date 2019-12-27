package com.ruoyi.transport.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单车辆司机对象 t_order_vehicle_driver
 * 
 * @author huanshare
 * @date 2019-12-27
 */
public class TOrderVehicleDriver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 调度人 */
    @Excel(name = "调度人")
    private String dispatcher;

    /** 外调车 */
    @Excel(name = "外调车")
    private String outsideCar;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String vehicleNumber;

    /** 司机姓名 */
    @Excel(name = "司机姓名")
    private String driverName;

    /** 司机手机号 */
    @Excel(name = "司机手机号")
    private String driverTelephone;

    /** 司机身份证号 */
    @Excel(name = "司机身份证号")
    private String driverIdentityCard;

    /** 高速费 */
    @Excel(name = "高速费")
    private Double highSpeedFee;

    /** 停车费 */
    @Excel(name = "停车费")
    private Double parkingFee;

    /** etc收费 */
    @Excel(name = "etc收费")
    private Double etcFee;

    /** 加油费 */
    @Excel(name = "加油费")
    private Double fuelFee;

    /** 结账费用 */
    @Excel(name = "结账费用")
    private Double billFee;

    /** 删除标志（0代表存在 2代表删除） */
    private Integer delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setDispatcher(String dispatcher) 
    {
        this.dispatcher = dispatcher;
    }

    public String getDispatcher() 
    {
        return dispatcher;
    }
    public void setOutsideCar(String outsideCar) 
    {
        this.outsideCar = outsideCar;
    }

    public String getOutsideCar() 
    {
        return outsideCar;
    }
    public void setVehicleNumber(String vehicleNumber) 
    {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() 
    {
        return vehicleNumber;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setDriverTelephone(String driverTelephone) 
    {
        this.driverTelephone = driverTelephone;
    }

    public String getDriverTelephone() 
    {
        return driverTelephone;
    }
    public void setDriverIdentityCard(String driverIdentityCard) 
    {
        this.driverIdentityCard = driverIdentityCard;
    }

    public String getDriverIdentityCard() 
    {
        return driverIdentityCard;
    }
    public void setHighSpeedFee(Double highSpeedFee) 
    {
        this.highSpeedFee = highSpeedFee;
    }

    public Double getHighSpeedFee() 
    {
        return highSpeedFee;
    }
    public void setParkingFee(Double parkingFee) 
    {
        this.parkingFee = parkingFee;
    }

    public Double getParkingFee() 
    {
        return parkingFee;
    }
    public void setEtcFee(Double etcFee) 
    {
        this.etcFee = etcFee;
    }

    public Double getEtcFee() 
    {
        return etcFee;
    }
    public void setFuelFee(Double fuelFee) 
    {
        this.fuelFee = fuelFee;
    }

    public Double getFuelFee() 
    {
        return fuelFee;
    }
    public void setBillFee(Double billFee) 
    {
        this.billFee = billFee;
    }

    public Double getBillFee() 
    {
        return billFee;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("dispatcher", getDispatcher())
            .append("outsideCar", getOutsideCar())
            .append("vehicleNumber", getVehicleNumber())
            .append("driverName", getDriverName())
            .append("driverTelephone", getDriverTelephone())
            .append("driverIdentityCard", getDriverIdentityCard())
            .append("highSpeedFee", getHighSpeedFee())
            .append("parkingFee", getParkingFee())
            .append("etcFee", getEtcFee())
            .append("fuelFee", getFuelFee())
            .append("billFee", getBillFee())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }

    public static void main(String[] args) {

    }
}
