package quanli_khach_san.taikhoan;

public class TaiKhoan {
    private String USERNAME;
    private String MANV;
    private String PASSWORD;
    private String TRANGTHAI;

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "USERNAME='" + USERNAME + '\'' +
                ", MANV='" + MANV + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", TRANGTHAI='" + TRANGTHAI + '\'' +
                '}';
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public TaiKhoan(String USERNAME, String MANV, String PASSWORD, String TRANGTHAI) {
        this.USERNAME = USERNAME;
        this.MANV = MANV;
        this.PASSWORD = PASSWORD;
        this.TRANGTHAI = TRANGTHAI;
    }

    public TaiKhoan() {
    }
}
