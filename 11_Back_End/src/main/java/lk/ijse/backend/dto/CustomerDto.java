package lk.ijse.backend.dto;

public class CustomerDto {
    private String cId;
    private String cName;
    private String cTel;

    public  CustomerDto(String cId,String cName,String cTel){
        this.cId=cId;
        this.cName=cName;
        this.cTel=cTel;

    }
    public String getcId() {
        return cId;
    }
    public String getcName() {
        return cName;
    }
    public String getcTel() {
        return cTel;
    }
    public void setcId(String cId) {
        this.cId = cId;

    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public void setcTel(String cTel) {
        this.cTel = cTel;
    }
}