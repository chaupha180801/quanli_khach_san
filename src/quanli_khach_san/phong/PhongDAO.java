package quanli_khach_san.phong;

import quanli_khach_san.Util.MyConvert;
import quanli_khach_san.database.Database;
import quanli_khach_san.dichvu.DichVu;
import quanli_khach_san.hoadon.HoaDon;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhongDAO {
    Connection connection=null;
    public ArrayList<Phong> queryAllPhong() {
        ArrayList<Phong> list = new ArrayList<>();
        String sqlQuery = "SELECT DISTINCT * from PHONG Order by MAPH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String maph = rs.getString("MAPH");

                String maloaiph = rs.getString("MALOAIPH");
                String tinhtrang = rs.getString("TINHTRANG");
                String ghichu = rs.getString("GHICHU");

                //Date ngayhd = rs.getDate("NGAYHD");


                list.add(new Phong(maph,maloaiph,tinhtrang,ghichu));

            }
        } catch (SQLException e) {
        }

        return list;
    }
    public ArrayList<Phong> queryAllPhongFullByStEd(Date startDate, Date endDate) {

        java.sql.Date date1 =new java.sql.Date(startDate.getTime());
        java.sql.Date date2 =new java.sql.Date(endDate.getTime());

        ArrayList<Phong> list = new ArrayList<>();
        String sqlQuery = "SELECT DISTINCT * FROM PHONG WHERE MAPH IN("+
                "SELECT PHONG.MAPH from PHONG JOIN THUE_PHONG ON PHONG.MAPH=THUE_PHONG.MAPH " +
                "WHERE NGBD <= ? " +
                "AND NGKT >= ?)"+
                "Order by PHONG.MAPH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setDate(1,date2);
            preparedStatementShow.setDate(2,date1);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String maph = rs.getString("MAPH");
                String maphoaiph = rs.getString("MALOAIPH");
                String tinhtrang = rs.getString("TINHTRANG");
                String ghichu = rs.getString("GHICHU");

                //Date ngayhd = rs.getDate("NGAYHD");


                list.add(new Phong(maph,maphoaiph,tinhtrang,ghichu));

            }
        } catch (SQLException e) {
        }

        return list;
    }
    public ArrayList<Phong> queryAllPhongEmptyStEd(Date startDate, Date endDate)
    {
        java.sql.Date date1 =new java.sql.Date(startDate.getTime());
        java.sql.Date date2 =new java.sql.Date(endDate.getTime());

        ArrayList<Phong> list = new ArrayList<>();
        String sqlQuery = "SELECT DISTINCT * FROM PHONG WHERE MAPH NOT IN("+
                "SELECT PHONG.MAPH from PHONG JOIN THUE_PHONG ON PHONG.MAPH=THUE_PHONG.MAPH " +
                "WHERE NGBD <= ? " +
                "AND NGKT >= ?)"+
                "Order by PHONG.MAPH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setDate(1,date2);
            preparedStatementShow.setDate(2,date1);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String maph = rs.getString("MAPH");
                String maphoaiph = rs.getString("MALOAIPH");
                String tinhtrang = rs.getString("TINHTRANG");
                String ghichu = rs.getString("GHICHU");

                //Date ngayhd = rs.getDate("NGAYHD");


                list.add(new Phong(maph,maphoaiph,tinhtrang,ghichu));

            }
        } catch (SQLException e) {
        }


        return list;
    }

    public ArrayList<ThuePhong> queryTPBySOHD(HoaDon hoadon) {
        ArrayList<ThuePhong> list = new ArrayList<>();
        String sqlQuery = "SELECT DISTINCT * FROM THUE_PHONG WHERE MAPHIEUTP IN("+
                "SELECT MAPHIEUTP from HOADON WHERE SOHD =?) " +
                "Order by MAPH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setString(1,hoadon.getSOHD());
            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String maph = rs.getString("MAPH");

                String maphieutp = rs.getString("MAPHIEUTP");
                Integer songuoithue = rs.getInt("SONGUOITHUE");
                Float phuthu = rs.getFloat("PHUTHU");
                Date ngbd=rs.getDate("NGBD");
                Date ngkt=rs.getDate("NGKT");
                String ghichu = rs.getString("GHICHU");
                Integer tien=rs.getInt("TIEN");

                //Date ngayhd = rs.getDate("NGAYHD");


                list.add(new ThuePhong(maph,maphieutp,songuoithue,phuthu,ngbd,ngkt,ghichu,tien));

            }
        } catch (SQLException e) {
        }

        return list;
    }

    public Integer querySoNgayThueByTP(ThuePhong tp) {

        String sqlQuery = "SELECT NGBD-NGKT SONGAY FROM THUE_PHONG WHERE MAPH = ?  AND MAPHIEUTP =? " +
                " Order by MAPH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setString(1,tp.getMAPH());
            preparedStatementShow.setString(2,tp.getMAPHIEUTP());
            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                return MyConvert.parseStringToInt(rs.getString("SONGAY")+1);

            }
        } catch (SQLException e) {
        }

        return Integer.MIN_VALUE;
    }

    public Integer queryTongTienTPByHD(HoaDon hd) {

        String sqlQuery = "SELECT TIENTP FROM PHIEUTHUEPHONG WHERE MAPHIEUTP =? " ;
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setString(1,hd.getSOHD());

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                return rs.getInt("TIENTP");

            }
        } catch (SQLException e) {
        }

        return Integer.MIN_VALUE;
    }
    public boolean deleteTP(ArrayList<ThuePhong> list) {
        PreparedStatement ps = null;

        for (ThuePhong p:list) {
            try {
                String query = "DELETE FROM THUE_PHONG WHERE MAPH =? AND MAPHIEUTP =?";
                ps = connection.prepareStatement(query);
                ps.setString(1, p.getMAPH());
                ps.setString(2, p.getMAPHIEUTP());

                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }

        return true;

    }





    public PhongDAO() {
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
