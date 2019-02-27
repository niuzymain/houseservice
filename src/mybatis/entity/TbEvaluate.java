package mybatis.entity;

import java.util.Date;

public class TbEvaluate {
    private Integer evaluateId;

    private String evaluateDes;

    private Integer evaluateScore;

    private Date createTime;

    private Integer userId;

    private Integer servicerId;

    private Integer enableStatus;

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getEvaluateDes() {
        return evaluateDes;
    }

    public void setEvaluateDes(String evaluateDes) {
        this.evaluateDes = evaluateDes == null ? null : evaluateDes.trim();
    }

    public Integer getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(Integer evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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