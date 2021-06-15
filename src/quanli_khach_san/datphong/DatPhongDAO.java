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
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DatPhongDAO {
    Connection connection = null;

    public Integer insertKHintoPhong(KhachHang khachHang, NhanVien nhanvien, ArrayList<Phong> listPhong,ArrayList<ThuePhong> listThueP, Date startDate, Date endDate, KhuyenMai khuyenmai) {
        //1 là chạy đúng, 0 là chạy sai
        Integer resultCode = 1;
        Integer songuoithue=0;

        CallableStatement cstmt = null;
        for (Phong p : listPhong){
            songuoithue=0;
            List<ThuePhong> tpSelected =  listThueP.stream().filter(it -> it.getMAPH().toString().contains(p.getMAPH())).collect(Collectors.toList());
            if (!(tpSelected.isEmpty()) && songuoithue>=0) songuoithue=tpSelected.get(0).getSONGUOITHUE();
            try {
                cstmt = connection.prepareCall("{CALL proc_insert_datphong(?,?,?,?,?,?,?)}");


                cstmt.setString(1, khachHang.getMAKH());
                cstmt.setString(2, "NV0001");
                cstmt.setString(3, p.getMAPH());
                cstmt.setInt(4, songuoithue);
                cstmt.setDate(5, new java.sql.Date(startDate.getTime()));

                cstmt.setDate(6, new java.sql.Date(endDate.getTime()));
                cstmt.setString(7, khuyenmai == null ? "" : khuyenmai.getMAKM());
                cstmt.executeQuery();

                resultCode = 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }


        return resultCode;
    }
    public Integer insertDVintoHD(HoaDon hd, ArrayList<DichVu> list, Date startDate, Date endDate) {
        //1 là chạy đúng, 0 là chạy sai
        Integer resultCode = 1;

        CallableStatement cstmt = null;
        for (DichVu p : list)
            try {
                cstmt = connection.prepareCall("{CALL proc_insert_dichvu(?,?,?,?)}");


                cstmt.setString(1, hd.getSOHD());
                cstmt.setString(2, p.getMADV());

                cstmt.setDate(3, new java.sql.Date(startDate.getTime()));

                cstmt.setDate(4, new java.sql.Date(endDate.getTime()));
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
