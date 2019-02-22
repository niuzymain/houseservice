package mybatis.entity;

import java.util.Date;

public class TbServicer {
    private Integer servicerId;

    private String servicerIdnum;

    private String servicerName;

    private Integer servicerAge;

    private Integer servicerSex;

    private String servicerPhone;

    private String servicerImg;

    private Integer servicerExperience;

    private Integer servicerScore;

    private String servicerPrice;

    private String servicerDes;

    private String servicerFile;

    private Integer cityId;

    private Integer localId;

    private Date createTime;

    private Date lasteditTime;

    private Integer enableStatus;

    private Integer checkStatus;

    private String accountName;

    private String passWord;

    private Integer degreeId;

    private Integer servicetypeId;

    public Integer getServicerId() {
        return servicerId;
    }

    public void setServicerId(Integer servicerId) {
        this.servicerId = servicerId;
    }

    public String getServicerIdnum() {
        return servicerIdnum;
    }

    public void setServicerIdnum(String servicerIdnum) {
        this.servicerIdnum = servicerIdnum == null ? null : servicerIdnum.trim();
    }

    public String getServicerName() {
        return servicerName;
    }

    public void setServicerName(String servicerName) {
        this.servicerName = servicerName == null ? null : servicerName.trim();
    }

    public Integer getServicerAge() {
        return servicerAge;
    }

    public void setServicerAge(Integer servicerAge) {
        this.servicerAge = servicerAge;
    }

    public Integer getServicerSex() {
        return servicerSex;
    }

    public void setServicerSex(Integer servicerSex) {
        this.servicerSex = servicerSex;
    }

    public String getServicerPhone() {
        return servicerPhone;
    }

    public void setServicerPhone(String servicerPhone) {
        this.servicerPhone = servicerPhone == null ? null : servicerPhone.trim();
    }

    public String getServicerImg() {
        return servicerImg;
    }

    public void setServicerImg(String servicerImg) {
        this.servicerImg = servicerImg == null ? null : servicerImg.trim();
    }

    public Integer getServicerExperience() {
        return servicerExperience;
    }

    public void setServicerExperience(Integer servicerExperience) {
        this.servicerExperience = servicerExperience;
    }

    public Integer getServicerScore() {
        return servicerScore;
    }

    public void setServicerScore(Integer servicerScore) {
        this.servicerScore = servicerScore;
    }

    public String getServicerPrice() {
        return servicerPrice;
    }

    public void setServicerPrice(String servicerPrice) {
        this.servicerPrice = servicerPrice == null ? null : servicerPrice.trim();
    }

    public String getServicerDes() {
        return servicerDes;
    }

    public void setServicerDes(String servicerDes) {
        this.servicerDes = servicerDes == null ? null : servicerDes.trim();
    }

    public String getServicerFile() {
        return servicerFile;
    }

    public void setServicerFile(String servicerFile) {
        this.servicerFile = servicerFile == null ? null : servicerFile.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
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

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public Integer getServicetypeId() {
        return servicetypeId;
    }

    public void setServicetypeId(Integer servicetypeId) {
        this.servicetypeId = servicetypeId;
    }
}