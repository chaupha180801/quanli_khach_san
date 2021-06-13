package quanli_khach_san.phong;

import quanli_khach_san.database.Database;
import quanli_khach_san.khachhang.KhachHang;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DanhSachPhongDAO {
    Connection connection=null;
    public ArrayList<DanhSachPhong> queryAllDSP() {
        ArrayList<DanhSachPhong> list = new ArrayList<>();
        String sqlQuery = "SELECT * from DANHSACHPHONG Order by MALOAIPH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String maphoaiph=rs.getString("MALOAIPH");
                String tenloaiph =rs.getString("TENLOAIPH");
                Integer soluongph=rs.getInt("SOLUONGPH");
                Integer dongia=rs.getInt("DONGIA");
                Integer songuoi=rs.getInt("SONGUOI");
                String ghichu=rs.getString("GHICHU");



                list.add(new DanhSachPhong(maphoaiph,tenloaiph,soluongph,dongia,songuoi,ghichu));

            }
        } catch (SQLException e) {
        }
       //System.out.println(list.toString());
        return list;
    }
    public void remove(DanhSachPhong dsp)
    {
        String SQL = "delete from DANHSACHPHONG where MAPHOAIPH=?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);
            ps.setString(1, dsp.getMALOAIPH());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }


    }
    public void insert(DanhSachPhong dsp)
    {
        String SQL = "insert into DANHSACHPHONG( MALOAIPH, TENLOAIPH, SOLUONGPH, DONGIA, SONGUOI,GHICHU) values(?,?,?,?,?,?)";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);

            ps.setString(1, dsp.getMALOAIPH());
            ps.setString(2, dsp.getTENLOAIPH());
            ps.setInt(3, dsp.getSOLUONGPH());
            ps.setInt(4, dsp.getDONGIA());

            ps.setInt(5,dsp.getSONGUOI());
            ps.setString(6, dsp.getGHICHU());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
    public void update(DanhSachPhong dsp) {
        String SQL = "update DANHSACHPHONG set   TENLOAIPH=?, SOLUONGPH=?, DONGIA=?, SONGUOI=?, GHICHU=? where MAPHOAIPH = ?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);

            ps.setString(1, dsp.getTENLOAIPH());
            ps.setInt(2, dsp.getSOLUONGPH());
            ps.setInt(3, dsp.getDONGIA());

            ps.setInt(4, dsp.getSONGUOI());
            ps.setString(5, dsp.getGHICHU());
            ps.setString(6, dsp.getMALOAIPH());


            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



public ArrayList<DanhSachPhong> find(DanhSachPhong dsp)
{
    return new ArrayList<>();
}


    public DanhSachPhongDAO() {
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
