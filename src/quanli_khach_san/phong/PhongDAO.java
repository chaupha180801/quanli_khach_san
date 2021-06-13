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
        String sqlQuery = "SELECT * from PHONG Order by MAPH";
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
        String sqlQuery = "SELECT * from PHONG JOIN THUE_PHONG ON PHONG.MAPH=THUE_PHONG.MAPH " +
                "WHERE NGBD <= ? " +
                "AND NGKT >= ?"+
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
        ArrayList<Phong> listAll=queryAllPhong();
        ArrayList<Phong> listFull =queryAllPhongFullByStEd( startDate,  endDate);
        listAll.removeAll(listFull);
  //      System.out.println(listAll.toString());
        return listAll;
    }

    public ArrayList<ThuePhong> queryTPBySOHD(HoaDon hoadon) {
        ArrayList<ThuePhong> list = new ArrayList<>();
        String sqlQuery = "SELECT * from HOADON JOIN THUE_PHONG ON HOADON.MAPHIEUTP=THUE_PHONG.MAPHIEUTP" +
                " WHERE HOADON.SOHD= ? " +
                "Order by MAPH";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);
            preparedStatementShow.setString(1,hoadon.getSOHD());
            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String maph = rs.getString("MAPH");

                String maphieutp = rs.getString("MAPHIEUTP");
                String songuoithue = rs.getString("SONGUOITHUE");
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
