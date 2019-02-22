package mybatis.entity;

public class TbSuperadmin {
    private Integer superadminId;

    private String accountName;

    private String passWord;

    public Integer getSuperadminId() {
        return superadminId;
    }

    public void setSuperadminId(Integer superadminId) {
        this.superadminId = superadminId;
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
}