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
public class Employee {
    private String MANV;
    private String HOTEN;
    private Date NGSINH;
    private int SDT;
    private String CHUCVU;
    private Date NGVL;
    private int LUONG;
    
    public Employee(){}

    public Employee(String MANV, String HOTEN, Date NGSINH, int SDT, String CHUCVU, Date NGVL, int LUONG) {
        this.MANV = MANV;
        this.HOTEN = HOTEN;
        this.NGSINH = NGSINH;
        this.SDT = SDT;
        this.CHUCVU = CHUCVU;
        this.NGVL = NGVL;
        this.LUONG = LUONG;
    }

    public Employee(String HOTEN, Date NGSINH, int SDT, String CHUCVU, Date NGVL, int LUONG) {
        this.HOTEN = HOTEN;
        this.NGSINH = NGSINH;
        this.SDT = SDT;
        this.CHUCVU = CHUCVU;
        this.NGVL = NGVL;
        this.LUONG = LUONG;
    }

    public String getMANV() {
        return MANV;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public Date getNGSINH() {
        return NGSINH;
    }

    public int getSDT() {
        return SDT;
    }

    public String getCHUCVU() {
        return CHUCVU;
    }

    public Date getNGVL() {
        return NGVL;
    }

    public int getLUONG() {
        return LUONG;
    }

    public boolean insert(Employee nv){
        PreparedStatement ps;

            try {
                String insquery = "INSERT INTO NHANVIEN(HOTEN,NGSINH, SDT, CHUCVU,NGVL,LUONG)"
                        + " VALUES (?,TO_DATE(?,'YYYY/MM/DD'),?,?,TO_DATE(?,'YYYY/MM/DD'),?)";
                ps=Database.connection().prepareStatement(insquery); 
                ps.setString(1, nv.getHOTEN());
                ps.setString(2, nv.getNGSINH().toString());
                ps.setInt(3, nv.getSDT());
                ps.setString(4, nv.getCHUCVU());
                ps.setString(5,nv.getNGVL().toString());
                ps.setInt(6, nv.getLUONG());
                return (ps.executeUpdate()>0);
               
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
           
        }

      
   public boolean update(Employee nv) {
            try {
                String query = "UPDATE NHANVIEN SET HOTEN = ? ,"
                        +"NGSINH = TO_DATE(?,'YYYY/MM/DD'),SDT = ?, CHUCVU = ?,"
                        + " NGVL = TO_DATE(?,'YYYY/MM/DD'), LUONG = ?"
                        + " WHERE MANV =?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, nv.getHOTEN());
                ps.setString(2, nv.getNGSINH().toString());
                ps.setInt(3, nv.getSDT());
                ps.setString(4, nv.getCHUCVU());
                ps.setString(5,nv.getNGVL().toString());
                ps.setInt(6, nv.getLUONG()); 
                ps.setString(7, nv.getMANV());
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
        
    public boolean delete(Employee nv){
            try {
                String query = "DELETE FROM NHANVIEN WHERE MANV =?";
                        
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, nv.getMANV());
                
                return (ps.executeUpdate()>0);
            } catch (SQLException ex) {
                System.out.println(ex);
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
           

 
  public ArrayList<Employee> ListNV() {
    ArrayList<Employee> list = new ArrayList<>();
   
    String query = "Select * from NHANVIEN "
            + "Order by MANV";
            
   
    try {
        Statement st = Database.connection().createStatement();
        ResultSet rs = st.executeQuery(query);
        Employee nv;
           
        while (rs.next()) {
            nv = new Employee(rs.getString(1), rs.getString(2),
                    rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getDate(6),rs.getInt(7));
            list.add(nv);
        }
          
    } catch (SQLException ex) {
        Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return list;
    
  }
 public ArrayList<Employee> ListName(String ValToSearch)
    {
        ArrayList<Employee> List = new ArrayList<Employee>();

        PreparedStatement st;
        ResultSet rs;
        try{
            String searchQuery = "SELECT * FROM NHANVIEN WHERE upper(HOTEN) LIKE upper(?)";
            st = Database.connection().prepareStatement(searchQuery);

            st.setString(1, "%" + ValToSearch + "%");
           
            rs = st.executeQuery();

            Employee nv;
            
            while(rs.next())
            {
                nv = new Employee(rs.getString(1), rs.getString(2),
                    rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getDate(6),rs.getInt(7));
                List.add(nv);
            }
          
            
        }catch(Exception ex){
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return List;
    } 
}
