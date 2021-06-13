package quanli_khach_san.datphong;

import quanli_khach_san.Util.MyConvert;
import quanli_khach_san.database.Database;
import quanli_khach_san.dichvu.DichVu;
import quanli_khach_san.dichvu.ThueDichVu;
import quanli_khach_san.hoadon.HoaDon;
import quanli_khach_san.khachhang.KhachHang;
import quanli_khach_san.khuyenmai.KhuyenMai;
import quanli_khach_san.nhanvien.NhanVien;
import quanli_khach_san.phong.Phong;
import quanli_khach_san.phong.ThuePhong;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatPhongDAO {
    Connection connection = null;

    public Integer insertKHintoPhong(KhachHang khachHang, NhanVien nhanvien, ArrayList<Phong> listPhong, Date startDate, Date endDate, KhuyenMai khuyenmai) {
        //1 là chạy đúng, 0 là chạy sai
        Integer resultCode = 1;

        CallableStatement cstmt = null;
        for (Phong p : listPhong)
            try {
                cstmt = connection.prepareCall("{CALL proc_insert_datphong(?,?,?,?,?,?)}");


                cstmt.setString(1, khachHang.getMAKH());
                cstmt.setString(2, "NV0001");
                cstmt.setString(3, p.getMAPH());

                cstmt.setDate(4, new java.sql.Date(startDate.getTime()));

                cstmt.setDate(5, new java.sql.Date(endDate.getTime()));
                cstmt.setString(6, khuyenmai == null ? "" : khuyenmai.getMAKM());
                cstmt.executeQuery();

                resultCode = 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        return resultCode;
    }



    public DatPhongDAO() {
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
