package quanli_khach_san.khachhang;

import quanli_khach_san.database.Database;
import quanli_khach_san.dichvu.DichVu;
import quanli_khach_san.hoadon.HoaDon;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/*
"MAKH=" + MAKH +
                ", TENKH='" + TENKH + '\'' +
                ", CMND='" + CMND + '\'' +
                ", QUOCTICH='" + QUOCTICH + '\'' +
                ", NGSINH=" + NGSINH +
                ", SDT='" + SDT + '\'' +
                ", DIACHI='" + DIACHI + '\'' +
                ", LOAIKH=
 */
public class KhachHangDAO {
    Connection connection = null;

    public ArrayList<KhachHang> queryAllKhachHang() {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sqlQuery = "SELECT  * from KHACHHANG Order by MAKH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String makh = rs.getString("MAKH");
                String tenkh = rs.getString("TENKH");
                String cmnd = rs.getString("CMND");
                String quoctich = rs.getString("QUOCTICH");
                Date ngsinh = rs.getDate("NGSINH");
                String sdt = rs.getString("SDT");
                String diachi = rs.getString("DIACHI");
                String loaikh = rs.getString("LOAIKH");


                list.add(new KhachHang(makh, tenkh, cmnd, quoctich, ngsinh, sdt, diachi, loaikh));

            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<KhachHang> queryAllKHMember() {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sqlQuery = "SELECT DISTINCT* from KHACHHANG WHERE LOAIKH='thanhvien' Order by MAKH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();
            while (rs.next()) {

                String makh = rs.getString("MAKH");
                String tenkh = rs.getString("TENKH");
                String cmnd = rs.getString("CMND");
                String quoctich = rs.getString("QUOCTICH");
                Date ngsinh = rs.getDate("NGSINH");
                String sdt = rs.getString("SDT");
                String diachi = rs.getString("DIACHI");
                String loaikh = rs.getString("LOAIKH");


                list.add(new KhachHang(makh, tenkh, cmnd, quoctich, ngsinh, sdt, diachi, loaikh));

            }
        } catch (SQLException e) {
        }

        return list;
    }

    public ArrayList<KhachHang> queryAllKHNormal() {
        ArrayList<KhachHang> listMember = queryAllKHMember();

       /* String sqlQuery = "SELECT * from KHACHHANG WHERE LOAIKH='thuong' Order by MAKH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();
            while (rs.next()) {

                String makh = rs.getString("MAKH");
                String tenkh = rs.getString("TENKH");
                String cmnd = rs.getString("CMND");
                String quoctich = rs.getString("QUOCTICH");
                Date ngsinh = rs.getDate("NGSINH");
                String sdt = rs.getString("SDT");
                String diachi = rs.getString("DIACHI");
                String loaikh = rs.getString("LOAIKH");


                list.add(new KhachHang(makh, tenkh, cmnd, quoctich, ngsinh, sdt, diachi, loaikh));

            }
        } catch (SQLException e) {
        }*/
        ArrayList<KhachHang> listAll = queryAllKhachHang();

        listAll.removeAll(listMember);

        return listAll;
    }
    public ArrayList<KhachHang> queryByKH(KhachHang kh) {


        boolean preNode=false;
        ArrayList<KhachHang> list=new ArrayList<>();
        String sqlQuery =
                "SELECT * from KHACHHANG " +
                        "where ";

        if (kh.getMAKH()!=null) {
            sqlQuery += "MAKH LIKE ('%'||'" + String.valueOf(kh.getMAKH()) + "'||'%') ";
            preNode = true;
        }
        if (kh.getTENKH()!=null && !kh.getTENKH().isEmpty()) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += " TENkh LIKE ('%'||'" + kh.getTENKH() + "'||'%') ";
            preNode = true;
        }
        if (kh.getCMND()!=null && !kh.getCMND().isEmpty()) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += " CMND LIKE ('%'||'" + kh.getCMND() + "'||'%') ";
            preNode = true;
        }
        if (kh.getQUOCTICH()!=null && !kh.getQUOCTICH().isEmpty()) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += " QUOCTICH LIKE ('%'||'" + kh.getQUOCTICH() + "'||'%') ";
            preNode = true;
        }
        String sysdate = new java.sql.Date(new Date(System.currentTimeMillis()).getTime()).toString();


        String inputdate = new java.sql.Date(kh.getNGSINH().getTime()).toString();

        if (kh.getNGSINH()!=null && !sysdate.equals(inputdate) ) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += " NGAYSINH = TO_DATE('" + new java.sql.Date(kh.getNGSINH().getTime()).toString() + "','yyyy,mm,dd') ";
            preNode = true;
        }
        if (kh.getDIACHI()!=null && !kh.getDIACHI().isEmpty()) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += " DIACHI LIKE ('%'||'" + kh.getDIACHI() + "'||'%') ";
            preNode = true;
        }
        if (kh.getSDT()!=null && !kh.getSDT().isEmpty()) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += " SDT LIKE ('%'||'" + kh.getSDT() + "'||'%') ";
            preNode = true;
        }
        if (kh.getLOAIKH()!=null && !kh.getSDT().isEmpty()) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += " LOAIKH LIKE ('%'||'" + kh.getLOAIKH() + "'||'%') ";
            preNode = true;
        }
        sqlQuery+=" ORDER BY MAkh";

        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();
            while (rs.next()) {

                String makh = rs.getString("MAKH");
                String tenkh = rs.getString("TENKH");
                String cmnd = rs.getString("CMND");
                String quoctich = rs.getString("QUOCTICH");
                Date ngsinh = rs.getDate("NGSINH");
                String sdt = rs.getString("SDT");
                String diachi = rs.getString("DIACHI");
                String loaikh = rs.getString("LOAIKH");


                list.add(new KhachHang(makh, tenkh, cmnd, quoctich, ngsinh, sdt, diachi, loaikh));

            }
        } catch (SQLException e) {
        }


        return list;
    }

    public void removeKH(KhachHang khachhang) {
        String SQL = "delete from KHACHHANG where MAKH=?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);
            ps.setString(1, khachhang.getMAKH());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    public void insertKH(KhachHang khachhang) {
        String SQL = "insert into KHACHHANG(TENKH, CMND, QUOCTICH, NGSINH, SDT, DIACHI,LOAIKH) values(?,?,?,?,?,?,?)";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);


            ps.setString(1, khachhang.getTENKH());
            ps.setString(2, khachhang.getCMND());
            ps.setString(3, khachhang.getQUOCTICH());
            ps.setDate(4, new java.sql.Date(khachhang.getNGSINH().getTime()));
            ps.setString(5, khachhang.getSDT());
            ps.setString(6, khachhang.getDIACHI());
            ps.setString(7, khachhang.getLOAIKH());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public void updateKH(KhachHang khachhang) {
        String SQL = "update KHACHHANG set  TENKH=?, CMND=?, QUOCTICH=?, NGSINH=?, SDT=?, DIACHI=?,LOAIKH=? where MAKH = ?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);
            ps.setString(1, khachhang.getTENKH());
            ps.setString(2, khachhang.getCMND());
            ps.setString(3, khachhang.getQUOCTICH());
            ps.setDate(4, new java.sql.Date(khachhang.getNGSINH().getTime()));
            ps.setString(5, khachhang.getSDT());
            ps.setString(6, khachhang.getDIACHI());
            ps.setString(7, khachhang.getLOAIKH());
            ps.setString(8, khachhang.getMAKH());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public KhachHang queryKHbyHD(HoaDon hd) {
        String sqlQuery = "SELECT DISTINCT * from KHACHHANG WHERE MAKH IN ( " +
                "SELECT MAKH FROM HOADON WHERE SOHD = ? ) ";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setString(1, hd.getSOHD());
            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String makh = rs.getString("MAKH");
                String tenkh = rs.getString("TENKH");
                String cmnd = rs.getString("CMND");
                String quoctich = rs.getString("QUOCTICH");
                Date ngsinh = rs.getDate("NGSINH");
                String sdt = rs.getString("SDT");
                String diachi = rs.getString("DIACHI");
                String loaikh = rs.getString("LOAIKH");


                return new KhachHang(makh, tenkh, cmnd, quoctich, ngsinh, sdt, diachi, loaikh);

            }
        } catch (SQLException e) {
        }
        return new KhachHang();
    }


    public KhachHangDAO() {
        setConnection();
    }

    public boolean setConnection() {
        this.connection = Database.getConnection();
        if (connection == null) {
            JOptionPane.showMessageDialog(null, "Can not connect to database.");
            System.exit(1);
            return false;
        }
        return true;
    }
}
