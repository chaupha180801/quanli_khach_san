package quanli_khach_san.khuyenmai;

import quanli_khach_san.database.Database;
import quanli_khach_san.hoadon.HoaDon;
import quanli_khach_san.khuyenmai.KhuyenMai;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class KhuyenMaiDAO {
    Connection connection=null;
    public ArrayList<KhuyenMai> queryAllkm() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sqlQuery = "SELECT * from KhuyenMai Order by MAKM";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String makm=rs.getString("MAKM");
                String tenkm =rs.getString("TENKM");
                String mota=rs.getString("MOTA");
                Float tile=rs.getFloat("TILE");
                Date ngaybd=rs.getDate("NGAYBD");
                Date ngaykt=rs.getDate("NGAYKT");
                

                list.add(new KhuyenMai(makm,tenkm,mota,tile,ngaybd,ngaykt));

            }
        } catch (SQLException e) {
        }
        return list;
    }
    public void remove(KhuyenMai km)
    {
        String SQL = "delete from KhuyenMai where MAKM=?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);
            ps.setString(1, km.getMAKM());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }


    }
    public void insert(KhuyenMai km)
    {
        String SQL = "insert into KhuyenMai( MAKM, TENKM, MOTA, TILE, NGAYBD,NGAYKT) values(?,?,?,?,?,?)";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);

            ps.setString(1, km.getMAKM());
            ps.setString(2, km.getTENKM());
            ps.setString(3, km.getMOTA());
            ps.setFloat(4, km.getTILE());

            ps.setDate(5,new java.sql.Date(km.getNGBD().getTime()));
            ps.setDate(6, new java.sql.Date(km.getNGKT().getTime()));

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
    public void update(KhuyenMai km) {
        String SQL = "update KhuyenMai set   TENKM=?, MOTA=?, TILE=?, NGAYBD=?, NGAYKT=? where MAKM = ?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);

            ps.setString(1, km.getMAKM());
            ps.setString(2, km.getTENKM());
            ps.setString(3, km.getMOTA());
            ps.setFloat(4, km.getTILE());

            ps.setDate(5,new java.sql.Date(km.getNGBD().getTime()));
            ps.setDate(6, new java.sql.Date(km.getNGKT().getTime()));

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public ArrayList<KhuyenMai> find(KhuyenMai km)
    {
        return new ArrayList<>();
    }


    public KhuyenMaiDAO() {
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
    public KhuyenMai queryByHD(HoaDon hd) {
       KhuyenMai khuyenmai = null;
        String sqlQuery = "SELECT * from KhuyenMai WHERE MAKM =? Order by MAKM";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setString(1,hd.getMAKM());
            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String makm=rs.getString("MAKM");
                String tenkm =rs.getString("TENKM");
                String mota=rs.getString("MOTA");
                Float tile=rs.getFloat("TILE");
                Date ngaybd=rs.getDate("NGAYBD");
                Date ngaykt=rs.getDate("NGAYKT");


                khuyenmai= new KhuyenMai(makm,tenkm,mota,tile,ngaybd,ngaykt);

            }
        } catch (SQLException e) {
        }
        return khuyenmai;
    }
}
