/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanli_khach_san;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class QuanLi_Khach_San {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database.initialize("orcl123", "hotelmanager", "qlks");
        Database.connect();

        if (Database.is_connected() == false){
            JOptionPane.showMessageDialog(null,"Can not connect to database.");
            System.exit(1);
        }

        //KHACH_HANG kh = new KHACH_HANG();
        //kh.show();
        //NhanVien nv = new NhanVien();
        //nv.show();
        KhuyenMai km = new KhuyenMai();
        km.show();
    }
    
}
