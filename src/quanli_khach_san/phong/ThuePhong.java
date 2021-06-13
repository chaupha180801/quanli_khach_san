package quanli_khach_san.phong;

import java.util.Date;

public class ThuePhong {
  private String MAPH;
  private String MAPHIEUTP;

    public java.lang.String SONGUOITHUE;
    /** @pdOid d7a8f0d8-835a-461d-807f-b59eacb0229d */
    public Float PHUTHU;
    /** @pdOid c6801259-a0ce-4824-98f2-4f5070f00feb */
    public java.util.Date NGBD;
    /** @pdOid d99e8fb7-f0a7-4114-950d-f4c96819e3ce */
    public java.util.Date NGKT;

    public String getMAPH() {
        return MAPH;
    }

    public void setMAPH(String MAPH) {
        this.MAPH = MAPH;
    }

    public String getMAPHIEUTP() {
        return MAPHIEUTP;
    }

    public void setMAPHIEUTP(String MAPHIEUTP) {
        this.MAPHIEUTP = MAPHIEUTP;
    }

    public String getSONGUOITHUE() {
        return SONGUOITHUE;
    }

    public void setSONGUOITHUE(String SONGUOITHUE) {
        this.SONGUOITHUE = SONGUOITHUE;
    }

    public Float getPHUTHU() {
        return PHUTHU;
    }

    public void setPHUTHU(Float PHUTHU) {
        this.PHUTHU = PHUTHU;
    }

    public Date getNGBD() {
        return NGBD;
    }

    public void setNGBD(Date NGBD) {
        this.NGBD = NGBD;
    }

    public Date getNGKT() {
        return NGKT;
    }

    public void setNGKT(Date NGKT) {
        this.NGKT = NGKT;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }

    public Integer getTIEN() {
        return TIEN;
    }

    public void setTIEN(Integer TIEN) {
        this.TIEN = TIEN;
    }

    @Override
    public String toString() {
        return "PhieuThuePhong{" +
                "MAPH='" + MAPH + '\'' +
                ", MAPHIEUTP='" + MAPHIEUTP + '\'' +
                ", SONGUOITHUE='" + SONGUOITHUE + '\'' +
                ", PHUTHU=" + PHUTHU +
                ", NGBD=" + NGBD +
                ", NGKT=" + NGKT +
                ", GHICHU='" + GHICHU + '\'' +
                ", TIEN=" + TIEN +
                '}';
    }

    public ThuePhong() {
    }

    /** @pdOid f04e66a5-c02b-4ee0-b53b-41d6f69f4467 */
    public java.lang.String GHICHU;
    /** @pdOid 22fa66e0-7dc0-48d5-8098-2a5992a7b58c */
    public Integer TIEN;

    public ThuePhong(String MAPH, String MAPHIEUTP, String SONGUOITHUE, Float PHUTHU, Date NGBD, Date NGKT, String GHICHU, Integer TIEN) {
        this.MAPH = MAPH;
        this.MAPHIEUTP = MAPHIEUTP;
        this.SONGUOITHUE = SONGUOITHUE;
        this.PHUTHU = PHUTHU;
        this.NGBD = NGBD;
        this.NGKT = NGKT;
        this.GHICHU = GHICHU;
        this.TIEN = TIEN;
    }
}
