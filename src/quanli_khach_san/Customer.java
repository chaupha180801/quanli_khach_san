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
public class Customer {
    private String MAKH;
    private String TENKH;
    private int CMND;
    private String QUOCTICH;
    private String LOAIKH;
    private String DIACHI;
    private Date NGSINH;
    private int SDT;
    public String getMAKH(){
        return this.MAKH;
    }
    public int getCMND(){
        return this.CMND;
    }
    public int getSDT(){
        return this.SDT;
    }
    public String getTENKH(){
        return this.TENKH;
    }
    public String getLOAIKH(){
        return this.LOAIKH;
    }
    public Date getNGSINH(){
        return this.NGSINH;
    }
    public String getQUOCTICH(){
        return this.QUOCTICH;
    }
    public String getDIACHI(){
        return this.DIACHI;
    }
    
    public Customer(){}

    public Customer(String MAKH, String TENKH, int CMND, String QUOCTICH, Date NGSINH,int SDT, String DIACHI,String LOAIKH) {
        this.MAKH = MAKH;
        this.TENKH = TENKH;
        this.CMND = CMND;
        this.QUOCTICH = QUOCTICH;
        this.NGSINH = NGSINH;
        this.SDT = SDT;
        this.DIACHI = DIACHI;
        this.LOAIKH = LOAIKH;
    }
   
  
    public Customer(String tenkh,
            int cmnd,
            String quoctich, Date ngsinh,
            int sdt,String DiaChi, String loaikh){
       
        this.TENKH = tenkh;
        this.CMND = cmnd;
        this.SDT = sdt;
        this.QUOCTICH = quoctich;
        this.NGSINH = ngsinh;
        this.LOAIKH = loaikh;
        this.DIACHI = DiaChi;
        this.NGSINH = ngsinh;
        
    }
    
    public boolean ExecuteQuery(String Query, Customer kh){
        PreparedStatement ps;
        
        // add a new type
        if(Query.equals("Thêm khách hàng")){
            try {
                String insquery = "INSERT INTO KHACHHANG(TENKH,CMND,QUOCTICH,NGSINH,SDT,DIACHI,LOAIKH)"
                        + " VALUES (?,?,?,TO_DATE(?,'YYYY/MM/DD'),?,?,?)";
                ps=Database.connection().prepareStatement(insquery); 
                ps.setString(1, kh.getTENKH());
                ps.setInt(2, kh.getCMND());
                ps.setString(3, kh.getQUOCTICH());
                ps.setString(4, kh.getNGSINH().toString());
                ps.setInt(5, kh.getSDT());
                ps.setString(6, kh.getDIACHI());
                ps.setString(7, kh.getLOAIKH());
                return (ps.executeUpdate()>0);
               
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
           
        }
      
        else if(Query.equals("Sửa khách hàng")){
            try {
                String query = "UPDATE KHACHHANG SET TENKH = ? ,"
                        + "CMND = ?,QUOCTICH = ?,"
                        + "SDT = ?,"
                        + "DIACHI = ?,LOAIKH = ? WHERE MAKH =?";
                ps=Database.connection().prepareStatement(query);
                ps.setString(1, kh.getTENKH());           
                ps.setInt(2, kh.getCMND());
                ps.setString(3,kh.getQUOCTICH());
                ps.setInt(4, kh.getSDT());
                ps.setString(5, kh.getDIACHI());
                ps.setString(6, kh.getLOAIKH());
                ps.setString(7, kh.getMAKH());
                
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
        
        else if(Query.equals("Xóa khách hàng")){
            try {
                String query = "DELETE FROM KHACHHANG WHERE MAKH =?";
                        
                ps=Database.connection().prepareStatement(query);
                ps.setString(1, kh.getMAKH());
                
                return (ps.executeUpdate()>0);
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
           
              
        
        else{
            JOptionPane.showMessageDialog(
                    null,
                    "Thao tác dữ liệu chưa đúng.",
                    "Loi thao tac.",
                    2
            );
            return false;
        }
        
    }
 
public ArrayList<Customer> KHList() {
    ArrayList<Customer> list = new ArrayList<>();
   
    String query = "Select * from KHACHHANG "
            + "Order by MAKH";
            
   
    try {
        Statement st = Database.connection().createStatement();
        ResultSet rs = st.executeQuery(query);
        Customer kh;
           
        while (rs.next()) {
            kh = new Customer(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getDate(5)
            ,rs.getInt(6),rs.getString(7),rs.getString(8));
            list.add(kh);
        }
          
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return list;
    
  }
 public ArrayList<Customer> ListName(String ValToSearch)
    {
        ArrayList<Customer> customerList = new ArrayList<Customer>();

        PreparedStatement st;
        ResultSet rs;
        try{
            String searchQuery = "SELECT * FROM KHACHHANG WHERE upper(TENKH) LIKE upper(?)";
            st = Database.connection().prepareStatement(searchQuery);

            st.setString(1, "%" + ValToSearch + "%");
           
            rs = st.executeQuery();

            Customer kh;
            
            while(rs.next())
            {
                kh = new Customer(
                                 rs.getString(1),rs.getString(2),rs.getInt(3),
                                 rs.getString(4),rs.getDate(5),
                                 rs.getInt(6),rs.getString(7),rs.getString(8)
                                );
                customerList.add(kh);
            }
          
            
        }catch(Exception ex){
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return customerList;
    } 
 
}

