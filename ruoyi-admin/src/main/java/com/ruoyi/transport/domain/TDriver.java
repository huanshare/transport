package com.ruoyi.transport.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 司机对象 t_driver
 *
 * @author ruoyi
 * @date 2019-12-03
 */
public class TDriver extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 司机姓名
     */
    @Excel(name = "司机姓名")
    private String driverName;

    /**
     * 司机手机号
     */
    @Excel(name = "司机手机号")
    private String driverTelephone;

    /**
     * 司机身份证号
     */
    @Excel(name = "司机身份证号")
    private String driverIdentityCard;

    /**
     * 司机驾驶证照片
     */
    @Excel(name = "司机驾驶证照片")
    private String drivingLicenseImage;

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

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverTelephone(String driverTelephone) {
        this.driverTelephone = driverTelephone;
    }

    public String getDriverTelephone() {
        return driverTelephone;
    }

    public void setDriverIdentityCard(String driverIdentityCard) {
        this.driverIdentityCard = driverIdentityCard;
    }

    public String getDriverIdentityCard() {
        return driverIdentityCard;
    }

    public void setDrivingLicenseImage(String drivingLicenseImage) {
        this.drivingLicenseImage = drivingLicenseImage;
    }

    public String getDrivingLicenseImage() {
        return drivingLicenseImage;
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
                .append("driverName", getDriverName())
                .append("driverTelephone", getDriverTelephone())
                .append("driverIdentityCard", getDriverIdentityCard())
                .append("drivingLicenseImage", getDrivingLicenseImage())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
