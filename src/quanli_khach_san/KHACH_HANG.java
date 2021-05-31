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
import java.util.logging.Logger;
import java.util.logging.Level;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.table.JTableHeader;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JComponent;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
//import com.toedter.calendar.IDateEditor;
//import com.toedter.calendar.JDateChooser;



public class KHACH_HANG extends javax.swing.JFrame {
    
    Border gray_border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(102,102,102));
    Border black_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
    
    public KHACH_HANG() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.jTextField_Makh.setBorder(black_border);
        this.jTextField_TenKH.setBorder(black_border);      
        this.jTextField_Cmnd.setBorder(black_border);
        this.jTextField_quoctich.setBorder(black_border);
        this.jTextField_sdt.setBorder(black_border);
        this.jTextField_LoaiKh.setBorder(black_border);
        this.jTextField_DiaChi.setBorder(black_border);
        
        
        this.jTable2.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
        this.jTable2.getTableHeader().setOpaque(false);
        this.jTable2.getTableHeader().setBackground(new Color(40,60,82));
        this.jTable2.getTableHeader().setForeground(Color.WHITE);
        this.jTable2.setRowHeight(25);
        
        pushDataToTable();
    }
    public void pushDataToTable(){
        Customer khachhang = new Customer();
        ArrayList<Customer> KHList = khachhang.KHList();
        
        String[] ColumnName = {"MAKH","TENKH","CMND",
            "QUOCTICH","NGSINH","SDT","DIACHI","LOAIKH"};
        // 8 la số cột
        Object[][] Rows = new Object[KHList.size()][8];
        //thêm dữ liệu từ KHList sang các cột
        for(int i = 0; i < KHList.size(); i ++){
            Rows[i][0] = KHList.get(i).getMAKH();
            Rows[i][1] = KHList.get(i).getTENKH();
            Rows[i][2] = KHList.get(i).getCMND();
            Rows[i][3] = KHList.get(i).getQUOCTICH();
            Rows[i][4] = KHList.get(i).getNGSINH();
            Rows[i][5] = KHList.get(i).getSDT();
            Rows[i][6] = KHList.get(i).getDIACHI();
            Rows[i][7] = KHList.get(i).getLOAIKH();
           
        }
        DefaultTableModel model = new DefaultTableModel(Rows,ColumnName);
        this.jTable2.setModel(model);
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        mainPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        jTextField_search = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        jButton_search = new javax.swing.JButton();
        interactionPanel = new javax.swing.JPanel();
        inputPanel = new javax.swing.JPanel();
        jTextField_Makh = new javax.swing.JTextField();
        jTextField_TenKH = new javax.swing.JTextField();
        jTextField_LoaiKh = new javax.swing.JTextField();
        jTextField_Cmnd = new javax.swing.JTextField();
        jTextField_quoctich = new javax.swing.JTextField();
        jTextField_sdt = new javax.swing.JTextField();
        jTextField_DiaChi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        buttonPanel = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jButton_add = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        jButton_edit = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        jButton_remove = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        jButton_clear = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        tablePanel = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        titlePanel.setBackground(new java.awt.Color(40, 60, 82));
        titlePanel.setMaximumSize(new java.awt.Dimension(32767, 80));
        titlePanel.setMinimumSize(new java.awt.Dimension(0, 60));
        titlePanel.setPreferredSize(new java.awt.Dimension(716, 60));
        titlePanel.setLayout(new javax.swing.BoxLayout(titlePanel, javax.swing.BoxLayout.LINE_AXIS));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("QUẢN LÍ THÔNG TIN KHÁCH HÀNG");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleLabel.setMaximumSize(new java.awt.Dimension(3200000, 100));
        titlePanel.add(titleLabel);

        mainPanel.add(titlePanel);

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 50, 10, 50));
        searchPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchPanel.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        searchPanel.setMinimumSize(new java.awt.Dimension(184, 60));
        searchPanel.setPreferredSize(new java.awt.Dimension(716, 60));
        searchPanel.setLayout(new javax.swing.BoxLayout(searchPanel, javax.swing.BoxLayout.LINE_AXIS));

        jTextField_search.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jTextField_search.setForeground(new java.awt.Color(102, 102, 102));
        jTextField_search.setText("Nhập thông tin cần tìm.");
        jTextField_search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 60, 82)));
        jTextField_search.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        jTextField_search.setMinimumSize(new java.awt.Dimension(100, 30));
        jTextField_search.setPreferredSize(new java.awt.Dimension(120, 20));
        jTextField_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_searchFocusLost(evt);
            }
        });
        jTextField_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_searchActionPerformed(evt);
            }
        });
        searchPanel.add(jTextField_search);
        searchPanel.add(filler1);

        jButton_search.setBackground(new java.awt.Color(255, 255, 255));
        jButton_search.setForeground(new java.awt.Color(255, 255, 255));
        jButton_search.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\loupe.png")); // NOI18N
        jButton_search.setBorder(null);
        jButton_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });
        searchPanel.add(jButton_search);

        mainPanel.add(searchPanel);

        interactionPanel.setLayout(new javax.swing.BoxLayout(interactionPanel, javax.swing.BoxLayout.LINE_AXIS));

        inputPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTextField_Makh.setEditable(false);
        jTextField_Makh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_Makh.setToolTipText("");
        jTextField_Makh.setFocusable(false);
        jTextField_Makh.setOpaque(false);

        jTextField_TenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_TenKH.setOpaque(false);

        jTextField_LoaiKh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_LoaiKh.setOpaque(false);

        jTextField_Cmnd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_Cmnd.setOpaque(false);

        jTextField_quoctich.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_quoctich.setOpaque(false);

        jTextField_sdt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_sdt.setOpaque(false);

        jTextField_DiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_DiaChi.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 60, 82));
        jLabel2.setText("MAKH*");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 60, 82));
        jLabel3.setText("TENKH");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(40, 60, 82));
        jLabel4.setText("DIACHI");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(40, 60, 82));
        jLabel5.setText("CMND");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(40, 60, 82));
        jLabel6.setText("SDT");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(40, 60, 82));
        jLabel7.setText("LOAIKH");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(40, 60, 82));
        jLabel8.setText("NGSINH");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(40, 60, 82));
        jLabel9.setText("QUOCTICH");

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setToolTipText("");
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N

        org.jdesktop.layout.GroupLayout inputPanelLayout = new org.jdesktop.layout.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(inputPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jTextField_TenKH, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .add(jTextField_Makh)
                        .add(jTextField_Cmnd)
                        .add(jTextField_DiaChi))
                    .add(jLabel5)
                    .add(jLabel4)
                    .add(jLabel3)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9)
                    .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField_quoctich)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jDateChooser1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel6)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel7)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel8)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField_sdt)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField_LoaiKh)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(inputPanelLayout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jTextField_sdt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel7))
                    .add(inputPanelLayout.createSequentialGroup()
                        .add(jTextField_Makh)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTextField_LoaiKh)
                    .add(jTextField_TenKH, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel8)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jTextField_DiaChi)
                    .add(jDateChooser1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jLabel9))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(inputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_Cmnd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField_quoctich))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        interactionPanel.add(inputPanel);

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonPanel.setMaximumSize(new java.awt.Dimension(300, 65720));
        buttonPanel.setPreferredSize(new java.awt.Dimension(100, 203));
        buttonPanel.setLayout(new javax.swing.BoxLayout(buttonPanel, javax.swing.BoxLayout.PAGE_AXIS));
        buttonPanel.add(filler4);

        jButton_add.setBackground(new java.awt.Color(255, 255, 255));
        jButton_add.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jButton_add.setForeground(new java.awt.Color(255, 255, 255));
        jButton_add.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\add.png")); // NOI18N
        jButton_add.setToolTipText("");
        jButton_add.setBorder(null);
        jButton_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add.setMaximumSize(new java.awt.Dimension(100, 31));
        jButton_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_addMouseEntered(evt);
            }
        });
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton_add);
        buttonPanel.add(filler2);

        jButton_edit.setBackground(new java.awt.Color(255, 255, 255));
        jButton_edit.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jButton_edit.setForeground(new java.awt.Color(255, 255, 255));
        jButton_edit.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\edit (1).png")); // NOI18N
        jButton_edit.setBorder(null);
        jButton_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_edit.setMaximumSize(new java.awt.Dimension(100, 31));
        jButton_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_editMouseEntered(evt);
            }
        });
        jButton_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton_edit);
        buttonPanel.add(filler3);

        jButton_remove.setBackground(new java.awt.Color(255, 255, 255));
        jButton_remove.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jButton_remove.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\001-bin.png")); // NOI18N
        jButton_remove.setBorder(null);
        jButton_remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_remove.setMaximumSize(new java.awt.Dimension(100, 31));
        jButton_remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_removeMouseEntered(evt);
            }
        });
        jButton_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton_remove);
        buttonPanel.add(filler5);

        jButton_clear.setBackground(new java.awt.Color(255, 255, 255));
        jButton_clear.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jButton_clear.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\loop.png")); // NOI18N
        jButton_clear.setBorder(null);
        jButton_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_clear.setMaximumSize(new java.awt.Dimension(100, 31));
        jButton_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_clearMouseEntered(evt);
            }
        });
        jButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton_clear);
        buttonPanel.add(filler6);

        interactionPanel.add(buttonPanel);

        mainPanel.add(interactionPanel);

        getContentPane().add(mainPanel);

        jTable2.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MAKH", "TENKH", "CMND", "QUOCTICH", "NGSINH", "SDT", "LOAIKH", "DIACHI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        tablePanel.setViewportView(jTable2);

        getContentPane().add(tablePanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//
    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            String tenkh = this.jTextField_TenKH.getText();
            String loaikh = this.jTextField_LoaiKh.getText();
            String date = dateFormat.format(jDateChooser1.getDate());
            Date ngsinh = dateFormat.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(ngsinh.getTime());             
            String diachi = this.jTextField_DiaChi.getText();
            String quoctich = this.jTextField_quoctich.getText();
            int sdt = Integer.valueOf(this.jTextField_sdt.getText());
            int cmnd = Integer.valueOf(this.jTextField_Cmnd.getText());
            Customer khach_hang = new Customer(tenkh, cmnd, quoctich, sqlDate, sdt, diachi, loaikh);
            int thong_bao = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm dữ liệu này không? ","Thêm",JOptionPane.YES_NO_OPTION);
            if(thong_bao == JOptionPane.YES_OPTION){
            if(!tenkh.trim().equals("")){
              if (khach_hang.ExecuteQuery("Thêm khách hàng",khach_hang)){
                 JOptionPane.showMessageDialog(null,"Dữ liệu đã được thêm.","Thêm",1);
                }
              else{
                 JOptionPane.showMessageDialog(null,"Dữ liệu không thêm được.","Thêm",2);
                }
            }
            else 
                JOptionPane.showMessageDialog(null,"Nhập thông tin khách hàng.","Bạn chưa nhập đầy đủ thông tin.",2);
            }
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage() + "Nhập thông tin khách hàng muốn thêm."," Thông báo.",1);
        }
            pushDataToTable();
    }//GEN-LAST:event_jButton_addActionPerformed

    private void jButton_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addMouseEntered
        // TODO add your handling code here:
        this.jButton_add.setToolTipText("Thêm mới khách hàng.");
    }//GEN-LAST:event_jButton_addMouseEntered

    private void jButton_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_editMouseEntered
        // TODO add your handling code here:
        this.jButton_edit.setToolTipText("Sửa thông tin khách hàng.");
    }//GEN-LAST:event_jButton_editMouseEntered

    private void jButton_removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_removeMouseEntered
        // TODO add your handling code here:
        this.jButton_remove.setToolTipText("Xóa thông tin khách hàng.");
    }//GEN-LAST:event_jButton_removeMouseEntered

    private void jButton_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editActionPerformed
        // TODO add your handling code here:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try{
                String makh = this.jTextField_Makh.getText();
                String tenkh = this.jTextField_TenKH.getText();
                String loaikh = this.jTextField_LoaiKh.getText();
                String date = dateFormat.format(jDateChooser1.getDate());
                Date ngsinh = dateFormat.parse(date);
                java.sql.Date sqlDate = new java.sql.Date(ngsinh.getTime());
                String diachi = this.jTextField_DiaChi.getText();
                String quoctich = this.jTextField_quoctich.getText();
                int sdt = Integer.valueOf(this.jTextField_sdt.getText());
                int cmnd = Integer.valueOf(this.jTextField_Cmnd.getText());
                Customer khach_hang = new Customer(makh, tenkh, cmnd, quoctich, sqlDate, sdt, diachi, loaikh);
                int thong_bao = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn sửa dữ liệu này không? ","Sửa",JOptionPane.YES_NO_OPTION);
                if(thong_bao == JOptionPane.YES_OPTION){
                if(!tenkh.trim().equals("")){
                  if (khach_hang.ExecuteQuery("Sửa khách hàng",khach_hang)){
                     JOptionPane.showMessageDialog(null,"Dữ liệu đã được cập nhật.","Thêm",1);
                    }
                  else{
                     JOptionPane.showMessageDialog(null,"Dữ liệu không sửa được.","Thêm",2);
                    }
                }
                else 
                    JOptionPane.showMessageDialog(null,"Nhập thông tin khách hàng muốn sửa.","Bạn chưa nhập đầy đủ thông tin.",2);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage() + "Nhập thông tin khách hàng muốn sửa."," Thông báo.",1);
            }
            
            pushDataToTable();
    }//GEN-LAST:event_jButton_editActionPerformed

    private void jButton_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_removeActionPerformed
        // TODO add your handling code here:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try{
                String makh = this.jTextField_Makh.getText();
                String tenkh = this.jTextField_TenKH.getText();
                String loaikh = this.jTextField_LoaiKh.getText();
                String date = dateFormat.format(jDateChooser1.getDate());
                Date ngsinh = dateFormat.parse(date);
                java.sql.Date sqlDate = new java.sql.Date(ngsinh.getTime());
                String diachi = this.jTextField_DiaChi.getText();
                String quoctich = this.jTextField_quoctich.getText();
                int sdt = Integer.valueOf(this.jTextField_sdt.getText());
                int cmnd = Integer.valueOf(this.jTextField_Cmnd.getText());
                int thong_bao = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa dữ liệu này không? ","Xóa",JOptionPane.YES_NO_OPTION);
                if(thong_bao == JOptionPane.YES_OPTION){

                Customer khach_hang = new Customer(makh, tenkh, cmnd, quoctich, sqlDate, sdt, diachi, loaikh);
                if(!this.jTextField_Makh.getText().equals("")){
                  if (khach_hang.ExecuteQuery("Xóa khách hàng",khach_hang)){
                     JOptionPane.showMessageDialog(null,"Dữ liệu đã được xóa.","Sửa thông tin",1);
                    }
                  else{
                     JOptionPane.showMessageDialog(null,"Dữ liệu không xóa được.","Sửa thông tin",2);
                    }
                }
                else 
                    JOptionPane.showMessageDialog(null,"Nhập thông tin khách hàng muốn xóa.","Bạn chưa nhập đầy đủ thông tin.",2);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage() + "Nhập thông tin khách hàng muốn xóa."," Thông báo.",1);
            }
            pushDataToTable();
    }//GEN-LAST:event_jButton_removeActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        try{
            int row = this.jTable2.getSelectedRow();
            this.jTextField_Makh.setText(jTable2.getValueAt(row,0).toString());
            this.jTextField_TenKH.setText(jTable2.getValueAt(row,1).toString());      
            this.jTextField_Cmnd.setText(jTable2.getValueAt(row,2).toString());
            this.jTextField_quoctich.setText(jTable2.getValueAt(row,3).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(jTable2.getValueAt(row, 4).toString());
            jDateChooser1.setDate(date);
            this.jTextField_sdt.setText(jTable2.getValueAt(row,5).toString());
            this.jTextField_LoaiKh.setText(jTable2.getValueAt(row,7).toString());
            this.jTextField_DiaChi.setText(jTable2.getValueAt(row,6).toString());
        }catch (ParseException ex) {
            Logger.getLogger(KHACH_HANG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton_clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_clearMouseEntered
        // TODO add your handling code here:
        this.jButton_clear.setToolTipText("Làm mới.");
    }//GEN-LAST:event_jButton_clearMouseEntered

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        // TODO add your handling code here:
        try{
        if(!this.jTextField_Makh.getText().equals("") 
                || !this.jTextField_TenKH.getText().equals("")
                || !this.jTextField_search.getText().equals("Nhập thông tin cần tìm vào đây.")){     
            this.jTextField_Makh.setText("");
            this.jTextField_TenKH.setText("");
            this.jTextField_Cmnd.setText("");
            this.jTextField_quoctich.setText("");        
            this.jTextField_sdt.setText("");
            this.jTextField_LoaiKh.setText("");
            this.jTextField_DiaChi.setText("");
            this.jTextField_search.setText("Nhập thông tin cần tìm vào đây.");
            String ngsinh = "2021-05-19";
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngsinh);
            jDateChooser1.setDate(date);
            
            pushDataToTable();
        }
        }catch (ParseException ex) {
            Logger.getLogger(KHACH_HANG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jTextField_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_searchFocusGained
        // TODO add your handling code here:
        if(jTextField_search.getText().equals("Nhập thông tin cần tìm vào đây.")){
            jTextField_search.setText("");
        }
        jTextField_search.setForeground(new Color(128,128,128));
       
    }//GEN-LAST:event_jTextField_searchFocusGained

    private void jTextField_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_searchFocusLost
        // TODO add your handling code here:
        if(jTextField_search.getText().equals("")) {
            jTextField_search.setText("Nhập thông tin cần tìm vào đây.");
        }
        jTextField_search.setForeground(new Color(102,102,102));
        
        
    }//GEN-LAST:event_jTextField_searchFocusLost

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        // TODO add your handling code here:
        
        Customer kh = new Customer();
        String input = this.jTextField_search.getText();
        
        ArrayList<Customer> ListName = kh.ListName(input);
        if(!this.jTextField_search.getText().equals("")){
            String[] ColumnName = {"MAKH","TENKH","CMND",
                "QUOCTICH","NGSINH","SDT","DIACHI","LOAIKH"};
            // 8 la số cột
            Object[][] Rows = new Object[ListName.size()][8];
            //thêm dữ liệu từ KHList sang các cột
            for(int i = 0; i < ListName.size(); i ++){
                Rows[i][0] = ListName.get(i).getMAKH();
                Rows[i][1] = ListName.get(i).getTENKH();
                Rows[i][2] = ListName.get(i).getCMND();
                Rows[i][3] = ListName.get(i).getQUOCTICH();
                Rows[i][4] = ListName.get(i).getNGSINH();
                Rows[i][5] = ListName.get(i).getSDT();
                Rows[i][6] = ListName.get(i).getDIACHI();
                Rows[i][7] = ListName.get(i).getLOAIKH();
               
            }
            DefaultTableModel model = new DefaultTableModel(Rows,ColumnName);
            this.jTable2.setModel(model);
            int rows = jTable2.getRowCount();
            if(rows == 0){
                JOptionPane.showMessageDialog(null,"Không tìm thấy dữ liệu cần tìm.","Thông báo",1);
            }
           
        
        }

    }//GEN-LAST:event_jButton_searchActionPerformed

    private void jTextField_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JPanel interactionPanel;
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JButton jButton_remove;
    private javax.swing.JButton jButton_search;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField_Cmnd;
    private javax.swing.JTextField jTextField_DiaChi;
    private javax.swing.JTextField jTextField_LoaiKh;
    private javax.swing.JTextField jTextField_Makh;
    private javax.swing.JTextField jTextField_TenKH;
    private javax.swing.JTextField jTextField_quoctich;
    private javax.swing.JTextField jTextField_sdt;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

}
