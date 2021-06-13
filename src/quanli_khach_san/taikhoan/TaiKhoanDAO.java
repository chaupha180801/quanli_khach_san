package quanli_khach_san.taikhoan;

import quanli_khach_san.database.Database;
import quanli_khach_san.taikhoan.TaiKhoan;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TaiKhoanDAO {
    Connection connection=null;
    public ArrayList<TaiKhoan> queryAlltk() {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        String sqlQuery = "SELECT * from TaiKhoan Order by USERNAME";
        try {
            PreparedStatement preparedStatementShow = this.connection.prepareStatement(sqlQuery);

            ResultSet rs = preparedStatementShow.executeQuery();

            while (rs.next()) {

                String username=rs.getString("USERNAME");
                String manv =rs.getString("MANV");
                String password=rs.getString("PASSWORD");
                String trangthai=rs.getString("TRANGTHAI");


                list.add(new TaiKhoan(username,manv,password,trangthai));

            }
        } catch (SQLException e) {
        }
        return list;
    }
    public void remove(TaiKhoan tk)
    {
        String SQL = "delete from TaiKhoan where USERNAME=?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);
            ps.setString(1, tk.getUSERNAME());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }


    }
    public void insert(TaiKhoan tk)
    {
        String SQL = "insert into TaiKhoan( USERNAME, MANV, PASSWORD, TRANGTHAI) values(?,?,?,?)";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);

            ps.setString(1, tk.getUSERNAME());
            ps.setString(2, tk.getMANV());
            ps.setString(3, tk.getPASSWORD());
            ps.setString(4, tk.getTRANGTHAI());


            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
    public void update(TaiKhoan tk) {
        String SQL = "update TaiKhoan set   MANV=?, PASSWORD=?, TILE=?, NGAYBD=?, NGAYKT=? where USERNAME = ?";


        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL);

            ps.setString(1, tk.getUSERNAME());
            ps.setString(2, tk.getMANV());
            ps.setString(3, tk.getPASSWORD());
            ps.setString(4, tk.getTRANGTHAI());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public ArrayList<TaiKhoan> find(TaiKhoan tk)
    {
        return new ArrayList<>();
    }


    public TaiKhoanDAO() {
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
