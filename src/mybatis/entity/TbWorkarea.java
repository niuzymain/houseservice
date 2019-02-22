package mybatis.entity;

import java.util.Date;

public class TbWorkarea {
    private Integer workareaId;

    private String workareaName;

    private Integer priority;

    private Date createTime;

    private Date lasteditTime;

    private Integer parentareaId;

    public Integer getWorkareaId() {
        return workareaId;
    }

    public void setWorkareaId(Integer workareaId) {
        this.workareaId = workareaId;
    }

    public String getWorkareaName() {
        return workareaName;
    }

    public void setWorkareaName(String workareaName) {
        this.workareaName = workareaName == null ? null : workareaName.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Integer getParentareaId() {
        return parentareaId;
    }

    public void setParentareaId(Integer parentareaId) {
        this.parentareaId = parentareaId;
    }
}