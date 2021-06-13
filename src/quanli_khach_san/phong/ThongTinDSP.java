/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanli_khach_san.phong;

import quanli_khach_san.Util.MyConvert;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author khanh
 */
public class ThongTinDSP extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinDSP
     */
    private Integer isInstance = 0;
    private Thread threadNhan;
    DanhSachPhongDAO DSPDAO = new DanhSachPhongDAO();
    DanhSachPhong dsp;

    public ThongTinDSP() {
        initComponents();

    }
    @Override
    public void dispose() {
        synchronized(threadNhan) {
            threadNhan.notify();
        }
        super.dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTTDSP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTENLP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSLP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDG = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnL = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        txtSN = new javax.swing.JTextField();
        txtMALP = new javax.swing.JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN DANH SÁCH PHÒNG");

        jLabel2.setBackground(new java.awt.Color(153, 153, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanli_khach_san/drawable/member.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mã loại phòng");

        txtTENLP.setToolTipText("Mã khách hàng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Tên loại phòng");

        txtSLP.setToolTipText("Mã khách hàng");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Số lượng phòng");

        txtDG.setToolTipText("Mã khách hàng");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Đơn giá ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Số người");

        txtGC.setToolTipText("Mã khách hàng");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Ghi chú");

        btnL.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnL.setText("Chấp nhận");
        btnL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLActionPerformed(evt);
            }
        });

        btnT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnT.setText("Thoát");
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        txtSN.setToolTipText("Mã khách hàng");

        javax.swing.GroupLayout jPanelTTDSPLayout = new javax.swing.GroupLayout(jPanelTTDSP);
        jPanelTTDSP.setLayout(jPanelTTDSPLayout);
        jPanelTTDSPLayout.setHorizontalGroup(
                jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTTDSPLayout.createSequentialGroup()
                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                                .addGap(112, 112, 112)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26))
                                        .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(txtMALP, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtTENLP, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtSLP, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtDG, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelTTDSPLayout.createSequentialGroup()
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtSN, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtGC, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                .addGap(199, 199, 199)
                                                .addComponent(btnL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTTDSPLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(201, 201, 201))
        );
        jPanelTTDSPLayout.setVerticalGroup(
                jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelTTDSPLayout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtTENLP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtSLP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtDG, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMALP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(jPanelTTDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnL, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelTTDSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelTTDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creatDSP() {
        dsp = new DanhSachPhong();
        dsp.setMALOAIPH(txtMALP.getText());
        dsp.setTENLOAIPH(txtTENLP.getText());
        dsp.setSOLUONGPH(MyConvert.parseStringToInt(txtSLP.getText()));
        dsp.setSONGUOI(MyConvert.parseStringToInt(txtSN.getText()));
        dsp.setDONGIA(MyConvert.parseStringToInt(txtDG.getText()));
        dsp.setGHICHU(txtGC.getText());
        System.out.println(dsp.toString());
    }

    private void paint() {
        txtMALP.setText(dsp.getMALOAIPH());
        txtTENLP.setText(dsp.getTENLOAIPH());
        txtSLP.setText(MyConvert.parseIntToString(dsp.getSOLUONGPH()));
        txtSN.setText(MyConvert.parseIntToString(dsp.getSONGUOI()));
        txtDG.setText(MyConvert.parseIntToString(dsp.getDONGIA()));
        txtGC.setText(dsp.getGHICHU());
    }

    private void btnLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLActionPerformed
        // TODO add your handling code here:

        creatDSP();
        if (dsp.getMALOAIPH().isEmpty())
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Mã loại phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else {
            switch (isInstance) {
                case 1: {
                    creatDSP();
                    DSPDAO.insert(dsp);
                }
                break;
                case 2: {
                    DSPDAO.remove(dsp);
                }
                break;
                case 3: {
                    creatDSP();
                    DSPDAO.update(dsp);
                }
                break;
                case 4: {
                    creatDSP();
                    DSPDAO.find(dsp);
                }
                break;

            }

            dispose();
        }


    }//GEN-LAST:event_btnLActionPerformed


    public void setThem(Thread a) {
        isInstance = DanhSachPhongFrame.IS_ADD;
        threadNhan = a;
    }


    public void setXoa(Thread a) {
        isInstance = DanhSachPhongFrame.IS_DELETE;
        threadNhan = a;
    }


    public void setSua(Thread a, DanhSachPhong danhSachPhong) {
        isInstance = DanhSachPhongFrame.IS_EDIT;
        threadNhan = a;
        dsp = danhSachPhong;
        if(danhSachPhong!=null)
            paint();
    }


    public void setTimKiemNC(Thread a) {
        isInstance = DanhSachPhongFrame.IS_FIND;
        threadNhan = a;
    }

    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTActionPerformed
        // TODO add your handling code here:

        dispose();
    }//GEN-LAST:event_btnTActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ThongTinDSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinDSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinDSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinDSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinDSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnL;
    private javax.swing.JButton btnT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelTTDSP;
    private javax.swing.JTextField txtDG;
    private javax.swing.JTextField txtGC;
    private javax.swing.JTextField txtMALP;
    private javax.swing.JTextField txtSLP;
    private javax.swing.JTextField txtSN;
    private javax.swing.JTextField txtTENLP;
    // End of variables declaration//GEN-END:variables
}
