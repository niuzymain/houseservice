package mybatis.entity;

import java.util.Date;

public class TbAdminmsg {
    private Integer adminmsgId;

    private Date createTime;

    private String adminmsgDes;

    private Integer userId;

    private Integer servicerId;

    public Integer getAdminmsgId() {
        return adminmsgId;
    }

    public void setAdminmsgId(Integer adminmsgId) {
        this.adminmsgId = adminmsgId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAdminmsgDes() {
        return adminmsgDes;
    }

    public void setAdminmsgDes(String adminmsgDes) {
        this.adminmsgDes = adminmsgDes == null ? null : adminmsgDes.trim();
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
}