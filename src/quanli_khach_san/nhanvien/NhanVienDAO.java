package quanli_khach_san.nhanvien;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienDAO {

    Connection connection=null;
    public ArrayList<NhanVien> queryAllNV() {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sqlQuery = "SELECT * from NHANVIEN Order by MANV";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String manv = rs.getString("MANV");
                String maql = rs.getString("MAQL");

                String tennv = rs.getString("HOTEN");

                String gioitinh = rs.getString("GIOITINH");
                String dc = rs.getString("DCHI");
                String sdt = rs.getString("SODT");
                Date ngsinh=rs.getDate("NGSINH");
                Date ngvl=rs.getDate("NGVL");
                Integer luong =rs.getInt("LUONG");
                NhanVien nv = new NhanVien(manv,maql, tennv, gioitinh, dc,sdt, ngsinh,ngvl,luong);
                list.add(nv);

            }
        } catch (SQLException e) {
        }


        return list;
    }

    public NhanVien queryNVbyHD(HoaDon hoadon) {

        String sqlQuery = "SELECT * from NHANVIEN WHERE MANV =?";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setString(1,hoadon.getMANV());
            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String manv = rs.getString("MANV");
                String maql = rs.getString("MAQL");

                String tennv = rs.getString("HOTEN");

                String gioitinh = rs.getString("GIOITINH");
                String dc = rs.getString("DCHI");
                String sdt = rs.getString("SODT");
                Date ngsinh=rs.getDate("NGSINH");
                Date ngvl=rs.getDate("NGVL");
                Integer luong =rs.getInt("LUONG");
                return new NhanVien(manv,maql, tennv, gioitinh, dc,sdt, ngsinh,ngvl,luong);

            }
        } catch (SQLException e) {
        }


        return new NhanVien();
    }
    public void insert(NhanVien nv)
    {
        String SQL = "insert into NHANVIEN( HOTEN, MAQL ,GIOITINH , DCHI, SODT,NGSINH, NGVL, LUONG) values(?,?,?,?,?,?,?,?)";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);

            ps.setString(1, nv.getHOTEN());
            ps.setString(2, nv.getMAQL());
            ps.setString(3, nv.getGIOITINH());
            ps.setString(4, nv.getDCHI());
            ps.setString(5, nv.getSODT());

            ps.setDate(6,new java.sql.Date(nv.getNGSINH().getTime()));
            ps.setDate(7,new java.sql.Date(nv.getNGVL().getTime()));
            ps.setInt(8,nv.getLUONG());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
    public void update(NhanVien nv) {
        String SQL = "update NHANVIEN set  HOTEN=?, MAQL=?, GIOITINH=?,  DCHI=?, SDT=?, NGSINH=?, NGVL=?, LUONG=? where MANV = ?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);


            ps.setString(1, nv.getMAQL());
            ps.setString(2, nv.getGIOITINH());
            ps.setString(3, nv.getDCHI());
            ps.setString(4, nv.getSODT());

            ps.setDate(5,new java.sql.Date(nv.getNGSINH().getTime()));
            ps.setDate(6,new java.sql.Date(nv.getNGVL().getTime()));
            ps.setInt(7,nv.getLUONG());
            ps.setString(8, nv.getHOTEN());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean deleteDatabase(NhanVien nv) {

        try {
            String query = "DELETE FROM NHANVIEN WHERE MANV =?";

            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1, nv.getMANV());

            return (ps.executeUpdate()>0);
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(DichVu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

   //public boolean updateDatabase(DichVu dv) {
 /*       try {
            System.out.println(dv.toString());
            String query = "UPDATE DICHVU SET ";

            if (!(dv.getTENDV().isEmpty())) query +="TENDV = '"+dv.getTENDV()+"' ";
            if (dv.getGIADV()!=null) query +=",GIADV = "+dv.getGIADV().toString()+" ";
            query+= " WHERE MADV =?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1,dv.getMADV());
            return (ps.executeUpdate() > 0);

        } catch (SQLException ex) {
            Logger.getLogger(DichVu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }*/
     //   return insertDatabase(dv);
   // }

    public ArrayList<NhanVien> queryByNV(NhanVien nv) {

        boolean preNode=false;
        ArrayList<NhanVien> list=new ArrayList<>();
        /*String sqlQuery =
                "SELECT * from DICHVU " +
                        "where ";

        if (dv.getMADV()!=null) {
            sqlQuery += "MADV = " + String.valueOf(dv.getMADV()) + " ";
            preNode = true;
        }
        if (!dv.getTENDV().isEmpty()) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += " TENDV LIKE ('%'||'" + dv.getTENDV() + "'||'%') ";
            preNode = true;
        }
        if (dv.getGIADV()!=null) {
            if (preNode==true) sqlQuery+=" AND ";
            sqlQuery += "GIADV = " + String.valueOf(dv.getGIADV()) + " ";
            preNode = true;
        }
        sqlQuery+="ORDER BY MADV";
        try {
            PreparedStatement preparedStatementShow = connection.prepareStatement(sqlQuery);


            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String madv = rs.getString("MADV");
                String tendv = rs.getString("TENDV");
                Integer giadv = rs.getInt("GIADV");
                DichVu dvTemp = new DichVu(madv, tendv, giadv);
                list.add(dvTemp);

            }
        } catch (SQLException e) {
        }*/
        return list;


    }


    public NhanVienDAO() {
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
