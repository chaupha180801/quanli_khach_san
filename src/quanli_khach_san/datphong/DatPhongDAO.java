package quanli_khach_san.datphong;

import quanli_khach_san.database.Database;
import quanli_khach_san.dichvu.DichVu;
import quanli_khach_san.dichvu.ThueDichVu;
import quanli_khach_san.hoadon.HoaDon;
import quanli_khach_san.khachhang.KhachHang;
import quanli_khach_san.nhanvien.NhanVien;
import quanli_khach_san.phong.Phong;
import quanli_khach_san.phong.ThuePhong;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatPhongDAO {
    Connection connection=null;
    public Integer insertKHintoPhong(KhachHang khachHang, NhanVien nhanvien, ArrayList<Phong> listPhong, Date startDate, Date endDate)
    {
        //1 là chạy đúng, 0 là chạy sai
        Integer resultCode=1;
        CallableStatement cstmt = null;
        try {
            cstmt = connection.prepareCall("{CALL proc_insert_datphong(?,?,?,?,?)}");

            for (Phong p: listPhong) {


                cstmt.setString(1, khachHang.getMAKH());
                cstmt.setString(2, nhanvien.getMANV());
                cstmt.setString(3, p.getMAPH());

                cstmt.setDate(4, new java.sql.Date(startDate.getTime()));

                cstmt.setDate(5,  new java.sql.Date(endDate.getTime()));
                cstmt.executeQuery();

                 resultCode = 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultCode;
    }
 public Integer insertPintoHD(ArrayList<Phong> list, HoaDon hd, Date startDate ,Date endDate) {

     String query = "insert into THUE_PHONG( MAPH, MAPHIEUTP, SONGUOITHUE, PHUTHU, NGBD, NGKT, GHICHU, TIEN) " +
             "values(?,?,?,?,?,?,?,?)";


     PreparedStatement ps = null;
     try {
         for (Phong p : list) {
             ps = connection.prepareStatement(query);
             ps.setString(1, p.getMAPH());
             ps.setString(2, hd.getMAPHIEUTP());
             ps.setString(3, "0");
             ps.setFloat(4, 1);
             ps.setDate(5, new java.sql.Date(startDate.getTime()));
             ps.setDate(6, new java.sql.Date(endDate.getTime()));
             ps.setString(7, "");
             ps.setInt(8, 0);
             return ps.executeUpdate();
         }
     } catch (SQLException ex) {
         Logger.getLogger(DichVu.class.getName()).log(Level.SEVERE, null, ex);
         return 0;
     }
     return 0;
 }




    public DatPhongDAO() {
        setConnection();
    }

    public boolean setConnection()
    {
        this.connection= Database.getConnection();
        if (connection==null) {
            JOptionPane.showMessageDialog(null, "Can not connect to database.");
            System.exit(1);
            return false;
        }
        return true;
    }
}
