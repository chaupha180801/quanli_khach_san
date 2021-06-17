/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanli_khach_san.hoadon;

import quanli_khach_san.Util.MyConvert;
import quanli_khach_san.Util.MyPrinter;
import quanli_khach_san.dichvu.DichVuDAO;
import quanli_khach_san.dichvu.ThueDichVu;
import quanli_khach_san.khachhang.KhachHangDAO;
import quanli_khach_san.khuyenmai.KhuyenMai;
import quanli_khach_san.khuyenmai.KhuyenMaiDAO;
import quanli_khach_san.khuyenmai.KhuyenMaiFrame;
import quanli_khach_san.phong.DanhSachPhongDAO;
import quanli_khach_san.phong.PhongDAO;
import quanli_khach_san.phong.ThuePhong;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

/**
 *
 * @author khanh
 */
public class ThongTinTT extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinTT
     */
    private Thread threadNhan;
    private Color colorPre = new Color(255, 255, 255);
    private JButton buttonTPIsSelected = new JButton();
    private JButton buttonTDVIsSelected = new JButton();
    private PhongDAO PDAO = new PhongDAO();
    private DichVuDAO DVDAO = new DichVuDAO();
    private Thread threadGui;
    private HoaDon hoadon;
    private ArrayList<ThuePhong> listTPh;
    private ArrayList<ThuePhong> listTPIsSelected = new ArrayList<>();
    private ArrayList<ThueDichVu> listTDVIsSelected = new ArrayList<>();
    private ArrayList<ThueDichVu> listDv;
    private KhuyenMai khuyenmai;
    private KhuyenMaiDAO KMDAO = new KhuyenMaiDAO();
    private HoaDonDAO HDDAO =new HoaDonDAO();


    public ThongTinTT() {
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
        jPanelP.repaint();
        listTPIsSelected.removeAll(listTPIsSelected);
        paintp();

    }

    private void resetDV() {

        jPanelDV.removeAll();
        jPanelDV.repaint();
        listTDVIsSelected.removeAll(listTPIsSelected);
        paintdv();
    }

    private void paintKM() {
        if (khuyenmai != null) btnKM.setText("Khuyến mãi: " + khuyenmai.getMAKM());
    }


    private void paintp() {
        txtSP.setText(MyConvert.parseIntToString(listTPh.size()));
        for (ThuePhong p : listTPh) {
            JButton btnTemp = new javax.swing.JButton();
            btnTemp.setBackground(new java.awt.Color(255, 245, 245));
            btnTemp.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            btnTemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanli_khach_san/drawable/khthuong.png"))); // NOI18N
            btnTemp.setText("MAPH: " + p.getMAPH()+ "|Số người thuê: "+p.getSONGUOITHUE()+"  | ĐƠn giá: "+(new DanhSachPhongDAO().queryDSPbyTP(p)).getDONGIA()+"   | Số ngày thuê:  "+ PDAO.querySoNgayThueByTP(p)+ "  | Tiền phòng: "+p.getTIEN());
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
            btnTemp.setText("MADV: " + p.getMADV()+ "| Tên dịch vụ: "+DVDAO.queryDVByTDV(p).getTENDV()+"  | ĐƠn giá: "+DVDAO.queryDVByTDV(p).getGIADV()+"   | Số ngày thuê:  "+ DVDAO.soNgayThueDVbyTDV(p)+ "  | Tiền dịch vụ: "+p.getTIEN());
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTTTT = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        dateHD = new javax.swing.JLabel();
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
        btnIHD = new javax.swing.JButton();
        btnKM = new javax.swing.JButton();
        btnTT = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbTP = new javax.swing.JLabel();
        lnDV = new javax.swing.JLabel();
        lbTT = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1483, 100));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("Ngày hoá đơn:");

        dateHD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateHD, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        btnIHD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnIHD.setText("In hoá đơn");
        btnIHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIHDActionPerformed(evt);
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

        btnTT.setBackground(new java.awt.Color(204, 204, 255));
        btnTT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTT.setText("Hoàn tất");
        btnTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Thành tiền:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Tiền phòng:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Tiền dịch vụ:");

        lbTP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lnDV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lbTT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanelTTTTLayout = new javax.swing.GroupLayout(jPanelTTTT);
        jPanelTTTT.setLayout(jPanelTTTTLayout);
        jPanelTTTTLayout.setHorizontalGroup(
            jPanelTTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTTTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addGroup(jPanelTTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnIHD, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addComponent(btnKM, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addComponent(btnTT, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel13)
                        .addComponent(jLabel11)
                        .addComponent(lbTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lnDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, Short.MAX_VALUE)
        );
        jPanelTTTTLayout.setVerticalGroup(
            jPanelTTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTTTLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelTTTTLayout.createSequentialGroup()
                        .addComponent(btnKM, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIHD, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelTTTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelTTTTLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lnDV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTTTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTActionPerformed
        // TODO add your handling code here:
            Object[] options = {"Có", "Không"};
            int result = JOptionPane.showOptionDialog(this,
                    "Bạn chắc chắn muốn thanh toán ?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (result == JOptionPane.YES_OPTION) {
                HDDAO.thanhToan(hoadon);
                dispose();
            }else return;

    }//GEN-LAST:event_btnTTActionPerformed

    private void btnIHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIHDActionPerformed
        // TODO add your handling code here:

       //
        new MyPrinter().printMyContent(hoadon,listTPh,listDv);
        dispose();

    }//GEN-LAST:event_btnIHDActionPerformed

    private void btnKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKMActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Chọn lại", "Xoá", "Thoát"};
        if (khuyenmai != null) {
            int result = JOptionPane.showOptionDialog(this,
                    "Bạn có muốn chọn lại hay xoá chọn khuyến mãi này?",
                    "Chi tiết",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);

            if (result == JOptionPane.NO_OPTION) {
                khuyenmai = null;
                btnKM.setText("");

                return;
            }else if (result==JOptionPane.CANCEL_OPTION) return;
            else if (result==JOptionPane.DEFAULT_OPTION) return;
        }
        KhuyenMaiFrame child = new KhuyenMaiFrame();
        child.setVisible(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                {
                    synchronized (threadGui) {
                        // Pause
                        try { //code sau khi mở lại luồng chính
                            threadGui.wait();
                            khuyenmai = (child.getKhuyenMaiIsSelected());
                            if (khuyenmai != null) btnKM.setText(khuyenmai.getMAKM());
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


    public void setTheadTTTT(Thread th, HoaDon hd) {
        threadNhan = th;
        hoadon = hd;
        listTPh = PDAO.queryTPBySOHD(hoadon);
        listDv = DVDAO.queryTDVBySOHD(hoadon);
        Date date = new Date(System.currentTimeMillis());
        dateHD.setText(date.toString());
        khuyenmai = KMDAO.queryByHD(hoadon);
        txtSHD.setText(hd.getSOHD());
        btnKM.setText("Khuyến mãi: "+hd.getMAKH());

        lbTT.setText(MyConvert.parseObjToString(hoadon.getTHANHTIEN()));
        lnDV.setText(MyConvert.parseObjToString(PDAO.queryTongTienTPByHD(hoadon)));
        lbTP.setText(MyConvert.parseObjToString(DVDAO.queryTongTienDVByHD(hoadon)));
        txtTKH.setText((new KhachHangDAO().queryKHbyHD(hd)).getTENKH());
        resetP();
        resetDV();
        paintKM();
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongTinTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinTT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIHD;
    private javax.swing.JButton btnKM;
    private javax.swing.JButton btnTT;
    private javax.swing.JLabel dateHD;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDV;
    private javax.swing.JPanel jPanelP;
    private javax.swing.JPanel jPanelTTTT;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbTP;
    private javax.swing.JLabel lbTT;
    private javax.swing.JLabel lnDV;
    private javax.swing.JLabel txtMAKH;
    private javax.swing.JLabel txtSDV;
    private javax.swing.JLabel txtSHD;
    private javax.swing.JLabel txtSP;
    private javax.swing.JLabel txtTKH;
    // End of variables declaration//GEN-END:variables
}
