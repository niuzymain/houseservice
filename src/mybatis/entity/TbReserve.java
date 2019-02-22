package mybatis.entity;

import java.util.Date;

public class TbReserve {
    private Integer reserveId;

    private Date createTime;

    private String reserveAddr;

    private String reserveDes;

    private String reservePhone;

    private String reserveMeg;

    private Integer userId;

    private Integer servicerId;

    private Integer enableStatus;

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReserveAddr() {
        return reserveAddr;
    }

    public void setReserveAddr(String reserveAddr) {
        this.reserveAddr = reserveAddr == null ? null : reserveAddr.trim();
    }

    public String getReserveDes() {
        return reserveDes;
    }

    public void setReserveDes(String reserveDes) {
        this.reserveDes = reserveDes == null ? null : reserveDes.trim();
    }

    public String getReservePhone() {
        return reservePhone;
    }

    public void setReservePhone(String reservePhone) {
        this.reservePhone = reservePhone == null ? null : reservePhone.trim();
    }

    public String getReserveMeg() {
        return reserveMeg;
    }

    public void setReserveMeg(String reserveMeg) {
        this.reserveMeg = reserveMeg == null ? null : reserveMeg.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getServicerId() {
        return servicerId;
    }

    public void setServicerId(Integer servicerId) {
        this.servicerId = servicerId;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }
}