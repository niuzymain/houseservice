package mybatis.entity;

import java.util.Date;

public class TbHeadimg {
    private Integer headimgId;

    private String headimgTitle;

    private String headimgDetails;

    private String headimgUrl;

    private Integer priority;

    private Integer enableStatus;

    private Date createTime;

    private Date lasteditTime;

    public Integer getHeadimgId() {
        return headimgId;
    }

    public void setHeadimgId(Integer headimgId) {
        this.headimgId = headimgId;
    }

    public String getHeadimgTitle() {
        return headimgTitle;
    }

    public void setHeadimgTitle(String headimgTitle) {
        this.headimgTitle = headimgTitle == null ? null : headimgTitle.trim();
    }

    public String getHeadimgDetails() {
        return headimgDetails;
    }

    public void setHeadimgDetails(String headimgDetails) {
        this.headimgDetails = headimgDetails == null ? null : headimgDetails.trim();
    }

    public String getHeadimgUrl() {
        return headimgUrl;
    }

    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl == null ? null : headimgUrl.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLasteditTime() {
        return lasteditTime;
    }

    public void setLasteditTime(Date lasteditTime) {
        this.lasteditTime = lasteditTime;
    }
}