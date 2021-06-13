/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanli_khach_san;

/**
 *
 * @author DELL
 */
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.*;
public class Discount {
    private String MAKM;
    private String TENKM;
    private Date NgayBD;
    private Date NgayKT;

    public String getMAKM() {
        return MAKM;
    }

    public String getTENKM() {
        return TENKM;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }
    public Discount(){}

    public Discount(String MAKM, String TENKM, Date NgayBD, Date NgayKT) {
        this.MAKM = MAKM;
        this.TENKM = TENKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
    }

    public Discount(String TENKM, Date NgayBD, Date NgayKT) {
        this.TENKM = TENKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
    }
    
    public boolean insert(Discount km){
        PreparedStatement ps;

            try {
                String insquery = "INSERT INTO KHUYENMAI(TENKM,NGAYBD,NGAYKT)"
                        + " VALUES (?,TO_DATE(?,'YYYY/MM/DD'),TO_DATE(?,'YYYY/MM/DD'))";
                ps=Database.connection().prepareStatement(insquery); 
                ps.setString(1, km.getTENKM());
                ps.setString(2, km.getNgayBD().toString());
                ps.setString(3, km.getNgayKT().toString());
                return (ps.executeUpdate()>0);
               
            } catch (SQLException ex) {
                Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
           
        }

   public boolean update(Discount km) {
            try {
                String query = "UPDATE KHUYENMAI SET TENKM = ?,"
                        +"NGAYBD = TO_DATE(?,'YYYY/MM/DD'), "
                        + "NGAYKT = TO_DATE(?,'YYYY/MM/DD')"
                        + " WHERE MAKM  = ?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, km.getTENKM());           
                ps.setString(2, km.getNgayBD().toString());
                ps.setString(3, km.getNgayKT().toString());
                ps.setString(4, km.getMAKM());
                
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
        
    public boolean delete(Discount km){
            try {
                String query = "DELETE FROM KHUYENMAI WHERE MAKM =?";
                        
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, km.getMAKM());
                
                return (ps.executeUpdate()>0);
            } catch (SQLException ex) {
                Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
           

 
  public ArrayList<Discount> ListKM() {
    ArrayList<Discount> list = new ArrayList<>();
   
    String query = "Select * from KHUYENMAI "
            + "Order by MAKM";

    try {
        Statement st = Database.connection().createStatement();
        ResultSet rs = st.executeQuery(query);
        Discount km;
           
        while (rs.next()) {
            km = new Discount(rs.getString(1), rs.getString(2),rs.getDate(3),rs.getDate(4));
            list.add(km);
        }
          
    } catch (SQLException ex) {
        Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return list;
    
  }
 public ArrayList<Discount> ListName(String ValToSearch)
    {
        ArrayList<Discount> List = new ArrayList<Discount>();

        PreparedStatement st;
        ResultSet rs;
        try{
            String searchQuery = "SELECT * FROM KHUYENMAI WHERE upper(TENKM) LIKE upper(?)";
            st = Database.connection().prepareStatement(searchQuery);

            st.setString(1, "%" + ValToSearch + "%");
           
            rs = st.executeQuery();

            Discount km;
            
            while(rs.next())
            {
                km = new Discount(rs.getString(1), rs.getString(2),rs.getDate(3),rs.getDate(4));
                List.add(km);
            }
   
        }catch(Exception ex){
            Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return List;
    } 
 
    
}
