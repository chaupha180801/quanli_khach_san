package quanli_khach_san.dichvu;

import quanli_khach_san.Util.MyConvert;
import quanli_khach_san.database.Database;
import quanli_khach_san.hoadon.HoaDon;
import quanli_khach_san.phong.ThuePhong;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DichVuDAO {

    Connection connection=null;
    public ArrayList<DichVu> queryAllDichVu() {
        ArrayList<DichVu> list = new ArrayList<>();
        String sqlQuery = "SELECT * from DICHVU Order by MADV";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String madv = rs.getString("MADV");
                String tendv = rs.getString("TENDV");
                Integer giadv = rs.getInt("GIADV");
                DichVu dv = new DichVu(madv, tendv, giadv);
                list.add(dv);

            }
        } catch (SQLException e) {
        }
        return list;
    }

    public boolean insertDatabase(DichVu dv) {

        String query ="insert into DichVu( TENDV, GIADV) values(?,?)";



        PreparedStatement ps = null;
        try {


            ps = connection.prepareStatement(query);
            ps.setString(1, dv.getTENDV());
            ps.setInt(2, dv.getGIADV());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DichVu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean deleteDatabase(DichVu dv) {

            try {
                String query = "DELETE FROM DICHVU WHERE MADV =?";

                PreparedStatement ps=connection.prepareStatement(query);
                ps.setString(1, dv.getMADV());

                return (ps.executeUpdate()>0);
            } catch (SQLException ex) {
                System.out.println(ex);
                Logger.getLogger(DichVu.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

    }
    public ArrayList<ThueDichVu> queryTDVBySOHD(HoaDon hoadon)
    {
        ArrayList<ThueDichVu> list = new ArrayList<>();
        String sqlQuery = "SELECT * from HOADON JOIN THUE_DICH_VU ON HOADON.MAPHIEUTDV=THUE_DICH_VU.MAPHIEUTDV" +
                " WHERE HOADON.SOHD = ? " +
                "Order by MADV";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setString(1,hoadon.getSOHD());
            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String madv = rs.getString("MADV");

                String maphieutdv = rs.getString("MAPHIEUTDV");
                Date ngbd=rs.getDate("NGAYBD");
                Date ngkt=rs.getDate("NGAYKT");
                String ghichu = rs.getString("GHICHU");
                Integer tien=rs.getInt("TIEN");

                //Date ngayhd = rs.getDate("NGAYHD");

                list.add(new ThueDichVu(madv,maphieutdv,ngbd,ngkt,ghichu,tien));

            }
        } catch (SQLException e) {
        }

        return list;
    }

    public boolean updateDatabase(DichVu dv) {
        try {

            String query = "UPDATE DICHVU SET TENDV =?, GIADV =? ";

            query+= " WHERE MADV =?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1,dv.getTENDV());
            ps.setInt(2,dv.getGIADV());
            ps.setString(3,dv.getMADV());
            return (ps.executeUpdate() > 0);

        } catch (SQLException ex) {
            Logger.getLogger(DichVu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<DichVu> queryByDichVu(DichVu dv) {

        System.out.println(dv.toString());
        boolean preNode=false;
        ArrayList<DichVu> list=new ArrayList<>();
        String sqlQuery =
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
        }
        return list;
    }


    public DichVuDAO() {
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
