/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanli_khach_san.hoadon;

import quanli_khach_san.Util.MyConvert;
import quanli_khach_san.datphong.DatPhong;
import quanli_khach_san.datphong.DatPhongDAO;
import quanli_khach_san.dichvu.DichVu;
import quanli_khach_san.dichvu.DichVuDAO;
import quanli_khach_san.dichvu.ThueDichVu;
import quanli_khach_san.khachhang.KhachHang;
import quanli_khach_san.khuyenmai.KhuyenMai;
import quanli_khach_san.khuyenmai.KhuyenMaiDAO;
import quanli_khach_san.khuyenmai.KhuyenMaiFrame;
import quanli_khach_san.phong.ChonPhong;
import quanli_khach_san.phong.Phong;
import quanli_khach_san.phong.PhongDAO;
import quanli_khach_san.phong.ThuePhong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author khanh
 */
public class ThongTinHD extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinHD
     */
    private Thread threadNhan;
    private Color colorPre = new Color(255, 255, 255);
    private JButton buttonTPIsSelected = new JButton();
    private JButton buttonTDVIsSelected = new JButton();
    private PhongDAO HDDAO = new PhongDAO();
    private DichVuDAO DVDAO = new DichVuDAO();
    private Thread threadGui;
    private HoaDon hoadon;
    private ArrayList<ThuePhong> listTPh;
    private ArrayList<ThuePhong> listTPIsSelected = new ArrayList<>();
    private ArrayList<ThueDichVu> listTDVIsSelected = new ArrayList<>();
    private ArrayList<ThueDichVu> listDv;
    private KhuyenMai khuyenmai;
    private KhuyenMaiDAO KMDAO= new KhuyenMaiDAO();


    public ThongTinHD() {
        initComponents();
    }

    @Override
    public void dispose() {
        synchronized (threadNhan) {
            threadNhan.notify();
        }
        super.dispose();
    }

    private void resetP() {
        jPanelP.removeAll();

        paintp();

    }

    private void resetDV() {

        jPanelDV.removeAll();

        paintdv();
    }

    private void paintKM()
    {
        if(khuyenmai!=null)btnKM.setText("Khuyến mãi: "+ khuyenmai.getMAKM());
    }


    private void paintp() {
        txtSP.setText(MyConvert.parseIntToString(listTPh.size()));
        for (ThuePhong p : listTPh) {
            JButton btnTemp = new javax.swing.JButton();
            btnTemp.setBackground(new java.awt.Color(255, 245, 245));
            btnTemp.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            btnTemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanli_khach_san/drawable/khthuong.png"))); // NOI18N
            btnTemp.setText("MAPH: " + p.getMAPH());
            btnTemp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            btnTemp.setIconTextGap(40);
            btnTemp.setMaximumSize(new java.awt.Dimension(115, 60));
            btnTemp.setMinimumSize(new java.awt.Dimension(115, 60));
            btnTemp.setPreferredSize(new java.awt.Dimension(115, 60));

            btnTemp.addActionListener(e -> {
                buttonTPIsSelected.setBackground(colorPre);
                colorPre = new Color(255, 245, 245);
                String[] words = btnTemp.getText().split("\\s");
                String StrTemp = words[1];
                listTPIsSelected.removeAll(listTPIsSelected);
                java.util.List<ThuePhong> imcomes1 = listTPh.stream().filter(i -> i.getMAPH().equals(StrTemp))
                        .collect(Collectors.toList());
                listTPIsSelected.add(imcomes1.get(0));

                buttonTPIsSelected = btnTemp;
                buttonTPIsSelected.setBackground(new java.awt.Color(0, 204, 255));
            });
            jPanelP.add(btnTemp);
        }
        jPanelP.revalidate();
    }

    private void paintdv() {
        txtSDV.setText(MyConvert.parseIntToString(listDv.size()));
        for (ThueDichVu p : listDv) {
            JButton btnTemp = new javax.swing.JButton();
            btnTemp.setBackground(new java.awt.Color(255, 245, 245));
            btnTemp.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            btnTemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanli_khach_san/drawable/khthuong.png"))); // NOI18N
            btnTemp.setText("MADV: " + p.getMADV());
            btnTemp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            btnTemp.setIconTextGap(40);
            btnTemp.setMaximumSize(new java.awt.Dimension(115, 60));
            btnTemp.setMinimumSize(new java.awt.Dimension(115, 60));
            btnTemp.setPreferredSize(new java.awt.Dimension(115, 60));

            btnTemp.addActionListener(e -> {
                buttonTDVIsSelected.setBackground(colorPre);
                colorPre = new Color(255, 245, 245);
                String[] words = btnTemp.getText().split("\\s");
                String StrTemp = words[1];
                listTDVIsSelected.removeAll(listTPIsSelected);
                java.util.List<ThueDichVu> imcomes1 = listDv.stream().filter(i -> i.getMADV().equals(StrTemp))
                        .collect(Collectors.toList());
                listTDVIsSelected.add(imcomes1.get(0));

                buttonTDVIsSelected = btnTemp;
                buttonTDVIsSelected.setBackground(new java.awt.Color(0, 204, 255));
            });
            jPanelDV.add(btnTemp);
        }
        jPanelDV.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTTHD = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSHD = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMAKH = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTKH = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSP = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSDV = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelP = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanelDV = new javax.swing.JPanel();
        btnTP = new javax.swing.JButton();
        btnTDV = new javax.swing.JButton();
        btnXDP = new javax.swing.JButton();
        btnXDDV = new javax.swing.JButton();
        btnKM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1483, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("SOHD:");

        txtSHD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("MAKH:");

        txtMAKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Tên khách hàng:");

        txtTKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Số phòng đặt:");

        txtSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Số dịch vụ");

        txtSDV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSP, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSDV, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSHD, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMAKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelP.setLayout(new java.awt.GridLayout(0, 1, 2, 3));
        jScrollPane2.setViewportView(jPanelP);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelDV.setLayout(new java.awt.GridLayout(0, 1, 2, 3));
        jScrollPane3.setViewportView(jPanelDV);

        btnTP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnTP.setText("Thêm phòng");
        btnTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTPActionPerformed(evt);
            }
        });

        btnTDV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnTDV.setText("Thêm dịch vụ");
        btnTDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTDVActionPerformed(evt);
            }
        });

        btnXDP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnXDP.setText("Xoá đặt phòng");
        btnXDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXDPActionPerformed(evt);
            }
        });

        btnXDDV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnXDDV.setText("Xoá đặt dịch vụ");
        btnXDDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXDDVActionPerformed(evt);
            }
        });

        btnKM.setBackground(new java.awt.Color(255, 153, 0));
        btnKM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnKM.setText("Khuyến mãi:");
        btnKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTTHDLayout = new javax.swing.GroupLayout(jPanelTTHD);
        jPanelTTHD.setLayout(jPanelTTHDLayout);
        jPanelTTHDLayout.setHorizontalGroup(
            jPanelTTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addGroup(jPanelTTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTDV, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTP, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXDP, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXDDV, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKM, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelTTHDLayout.createSequentialGroup()
                .addGroup(jPanelTTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelTTHDLayout.setVerticalGroup(
            jPanelTTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTHDLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelTTHDLayout.createSequentialGroup()
                        .addComponent(btnTP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTDV, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnXDP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelTTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTTHDLayout.createSequentialGroup()
                        .addComponent(btnXDDV, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKM, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setThreadNhan(Thread th, HoaDon hd)
    {
        threadNhan=th;
        hoadon=hd;
        btnKM.setText("Khuyến mãi: "+hoadon.getMAKH());
    }

    private ArrayList<Phong> listTemp = new ArrayList();

    private void btnTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTPActionPerformed
        // TODO add your handling code here:

        DatPhong child = new DatPhong();
        child.setVisible(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                {
                    synchronized (threadGui) {
                        // Pause
                        try { //code sau khi mở lại luồng chính
                            threadGui.wait();
                            listTPh = HDDAO.queryTPBySOHD(hoadon);
                            resetP();

                        } catch (InterruptedException e) {
                        }
                    }

                }
            }


        };

        threadGui = new Thread(runnable);
        child.setEdit(threadGui, hoadon);

        //từ đây trở lên là trước khi luồng chính bị đóng
        threadGui.start();
    }//GEN-LAST:event_btnTPActionPerformed

    private void btnTDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTDVActionPerformed

    private void btnXDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXDPActionPerformed

    private void btnXDDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXDDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXDDVActionPerformed

    private void btnKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKMActionPerformed
        // TODO add your handling code here:
        KhuyenMaiFrame child=new KhuyenMaiFrame();
        child.setVisible(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                {
                    synchronized (threadGui) {
                        // Pause
                        try { //code sau khi mở lại luồng chính
                            threadGui.wait();
                            khuyenmai=(child.getKhuyenMaiIsSelected());
                            paintKM();
                        } catch (InterruptedException e) {
                        }
                    }

                }
            }


        };

        threadGui = new Thread(runnable);
            child.setThreadNhan(threadGui);

        //từ đây trở lên là trước khi luồng chính bị đóng
        threadGui.start();

    }//GEN-LAST:event_btnKMActionPerformed


    public void setTheadTTHD(Thread th, HoaDon hd) {
        threadNhan = th;
        hoadon = hd;
        listTPh = HDDAO.queryTPBySOHD(hoadon);
        listDv = DVDAO.queryTDVBySOHD(hoadon);
        khuyenmai=KMDAO.queryByHD(hoadon);
        txtSHD.setText(hd.getSOHD());
        txtMAKH.setText(hd.getMAKH());
        resetP();
        resetDV();
        paintKM();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinHD().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKM;
    private javax.swing.JButton btnTDV;
    private javax.swing.JButton btnTP;
    private javax.swing.JButton btnXDDV;
    private javax.swing.JButton btnXDP;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDV;
    private javax.swing.JPanel jPanelP;
    private javax.swing.JPanel jPanelTTHD;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel txtMAKH;
    private javax.swing.JLabel txtSDV;
    private javax.swing.JLabel txtSHD;
    private javax.swing.JLabel txtSP;
    private javax.swing.JLabel txtTKH;
    // End of variables declaration//GEN-END:variables
}
