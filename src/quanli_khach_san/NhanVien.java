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
public class NhanVien extends javax.swing.JFrame {


    Border black_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
  
    
    public NhanVien() {
        initComponents();
        
        this.idTextField.setBorder(black_border);
        this.nameTextField.setBorder(black_border);      
        this.rollTextField.setBorder(black_border);
        this.salaryTextField.setBorder(black_border);
        this.phoneNumberTextField.setBorder(black_border);
        
        this.table.getTableHeader().setFont(new Font("Courier New",Font.PLAIN,15));
        this.table.getTableHeader().setOpaque(false);
        this.table.getTableHeader().setBackground(new Color(40,60,82));
        this.table.getTableHeader().setForeground(Color.WHITE);
        this.table.setRowHeight(25);
        
        this.pushDataToTable();
    }
    public void pushDataToTable(){
        Employee nv = new Employee();
        ArrayList<Employee> ListNV = nv.ListNV();
        
        String[] ColumnName = {"MANV","HOTEN","NGSINH","SDT",
            "CHUCVU","NGVL","LUONG"};
        Object[][] Rows = new Object[ListNV.size()][7];
        for(int i = 0; i < ListNV.size(); i ++){
            Rows[i][0] = ListNV.get(i).getMANV();
            Rows[i][1] = ListNV.get(i).getHOTEN();
            Rows[i][2] = ListNV.get(i).getNGSINH();
            Rows[i][3] = ListNV.get(i).getSDT();
            Rows[i][4] = ListNV.get(i).getCHUCVU();
            Rows[i][5] = ListNV.get(i).getNGVL();
            Rows[i][6]= ListNV.get(i).getLUONG();
        }
        DefaultTableModel model = new DefaultTableModel(Rows,ColumnName);
        this.table.setModel(model);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        startDateTextField = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        mainPanel = new javax.swing.JPanel();
        titilePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        informationPanel = new javax.swing.JPanel();
        salaryTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        phoneNumberTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        rollTextField = new javax.swing.JTextField();
        birthDateJDchoose = new com.toedter.calendar.JDateChooser();
        startDateJDchoose = new com.toedter.calendar.JDateChooser();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        birthDateLabel = new javax.swing.JLabel();
        rollLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        choosePanel = new javax.swing.JPanel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        addButton = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        editButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        removeButton = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        resetButton = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(30, 32767));
        searchButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jScrollPane1.setViewportView(jTree1);

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
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        startDateTextField.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        titilePanel.setBackground(new java.awt.Color(40, 60, 82));
        titilePanel.setMaximumSize(new java.awt.Dimension(32767, 60));
        titilePanel.setMinimumSize(new java.awt.Dimension(0, 60));
        titilePanel.setPreferredSize(new java.awt.Dimension(716, 60));
        titilePanel.setLayout(new javax.swing.BoxLayout(titilePanel, javax.swing.BoxLayout.LINE_AXIS));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("QUẢN LÍ THÔNG TIN NHÂN VIÊN");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleLabel.setMaximumSize(new java.awt.Dimension(32000, 100));
        titleLabel.setMinimumSize(new java.awt.Dimension(408, 32));
        titleLabel.setPreferredSize(new java.awt.Dimension(408, 32));
        titilePanel.add(titleLabel);

        mainPanel.add(titilePanel);

        informationPanel.setBackground(new java.awt.Color(255, 255, 255));
        informationPanel.setMaximumSize(new java.awt.Dimension(32767, 300));
        informationPanel.setMinimumSize(new java.awt.Dimension(200, 280));
        informationPanel.setPreferredSize(new java.awt.Dimension(200, 300));

        salaryTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salaryTextField.setMaximumSize(new java.awt.Dimension(2147483647, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 60, 82));
        jLabel2.setText("SĐT");

        phoneNumberTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        phoneNumberTextField.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        phoneNumberTextField.setMinimumSize(new java.awt.Dimension(7, 23));
        phoneNumberTextField.setPreferredSize(new java.awt.Dimension(7, 23));

        idTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idTextField.setFocusable(false);
        idTextField.setMaximumSize(new java.awt.Dimension(2147483647, 60));

        nameTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameTextField.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        nameTextField.setPreferredSize(new java.awt.Dimension(7, 28));

        rollTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rollTextField.setMaximumSize(new java.awt.Dimension(2147483647, 60));

        birthDateJDchoose.setBackground(new java.awt.Color(255, 255, 255));
        birthDateJDchoose.setForeground(new java.awt.Color(153, 153, 153));
        birthDateJDchoose.setDateFormatString("yyyy-MM-dd");
        birthDateJDchoose.setMinimumSize(new java.awt.Dimension(113, 28));
        birthDateJDchoose.setPreferredSize(new java.awt.Dimension(113, 28));

        startDateJDchoose.setBackground(new java.awt.Color(255, 255, 255));
        startDateJDchoose.setForeground(new java.awt.Color(153, 153, 153));
        startDateJDchoose.setDate(new java.util.Date(1622013189000L));
        startDateJDchoose.setDateFormatString("yyyy-MM-dd");

        idLabel.setBackground(new java.awt.Color(255, 255, 255));
        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        idLabel.setForeground(new java.awt.Color(40, 60, 82));
        idLabel.setText("MANV*");
        idLabel.setPreferredSize(new java.awt.Dimension(28, 14));

        nameLabel.setBackground(new java.awt.Color(255, 255, 255));
        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(40, 60, 82));
        nameLabel.setText("HOTEN");
        nameLabel.setPreferredSize(new java.awt.Dimension(35, 14));

        birthDateLabel.setBackground(new java.awt.Color(255, 255, 255));
        birthDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        birthDateLabel.setForeground(new java.awt.Color(40, 60, 82));
        birthDateLabel.setText("NGSINH");
        birthDateLabel.setPreferredSize(new java.awt.Dimension(38, 14));

        rollLabel.setBackground(new java.awt.Color(255, 255, 255));
        rollLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        rollLabel.setForeground(new java.awt.Color(40, 60, 82));
        rollLabel.setText("CHUCVU");
        rollLabel.setPreferredSize(new java.awt.Dimension(42, 14));

        startDateLabel.setBackground(new java.awt.Color(255, 255, 255));
        startDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        startDateLabel.setForeground(new java.awt.Color(40, 60, 82));
        startDateLabel.setText("NGVL");
        startDateLabel.setPreferredSize(new java.awt.Dimension(26, 14));

        salaryLabel.setBackground(new java.awt.Color(255, 255, 255));
        salaryLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        salaryLabel.setForeground(new java.awt.Color(40, 60, 82));
        salaryLabel.setText("LUONG");
        salaryLabel.setPreferredSize(new java.awt.Dimension(35, 14));

        choosePanel.setBackground(new java.awt.Color(255, 255, 255));
        choosePanel.setLayout(new javax.swing.BoxLayout(choosePanel, javax.swing.BoxLayout.PAGE_AXIS));
        choosePanel.add(filler6);

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\add.png")); // NOI18N
        addButton.setBorder(null);
        addButton.setMaximumSize(new java.awt.Dimension(100, 33));
        addButton.setMinimumSize(new java.awt.Dimension(33, 33));
        addButton.setPreferredSize(new java.awt.Dimension(33, 33));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        choosePanel.add(addButton);
        choosePanel.add(filler3);

        editButton.setBackground(new java.awt.Color(255, 255, 255));
        editButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\edit (1).png")); // NOI18N
        editButton.setBorder(null);
        editButton.setMaximumSize(new java.awt.Dimension(100, 31));
        editButton.setMinimumSize(new java.awt.Dimension(32, 32));
        editButton.setPreferredSize(new java.awt.Dimension(32, 32));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        choosePanel.add(editButton);
        choosePanel.add(filler4);

        removeButton.setBackground(new java.awt.Color(255, 255, 255));
        removeButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\001-bin.png")); // NOI18N
        removeButton.setBorder(null);
        removeButton.setMaximumSize(new java.awt.Dimension(100, 31));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        choosePanel.add(removeButton);
        choosePanel.add(filler5);

        resetButton.setBackground(new java.awt.Color(255, 255, 255));
        resetButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\loop.png")); // NOI18N
        resetButton.setBorder(null);
        resetButton.setMaximumSize(new java.awt.Dimension(100, 31));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        choosePanel.add(resetButton);
        choosePanel.add(filler7);

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 50, 10, 50));
        searchPanel.setLayout(new javax.swing.BoxLayout(searchPanel, javax.swing.BoxLayout.LINE_AXIS));

        searchTextField.setFont(new java.awt.Font("Courier New", 2, 14)); // NOI18N
        searchTextField.setText("Nhập thông tin cần tìm vào đây.");
        searchTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 60, 82)));
        searchTextField.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        searchTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        searchTextField.setPreferredSize(new java.awt.Dimension(120, 30));
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusLost(evt);
            }
        });
        searchPanel.add(searchTextField);
        searchPanel.add(filler1);

        searchButton.setBackground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\loupe.png")); // NOI18N
        searchButton.setBorder(null);
        searchButton.setMaximumSize(new java.awt.Dimension(33, 33));
        searchButton.setMinimumSize(new java.awt.Dimension(33, 33));
        searchButton.setPreferredSize(new java.awt.Dimension(33, 33));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchPanel.add(searchButton);

        org.jdesktop.layout.GroupLayout informationPanelLayout = new org.jdesktop.layout.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, informationPanelLayout.createSequentialGroup()
                .add(54, 54, 54)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(informationPanelLayout.createSequentialGroup()
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, phoneNumberTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, nameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, idTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, birthDateJDchoose, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, birthDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(informationPanelLayout.createSequentialGroup()
                                .add(72, 72, 72)
                                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(rollTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 231, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(startDateJDchoose, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 231, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(rollLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(startDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(informationPanelLayout.createSequentialGroup()
                                .add(75, 75, 75)
                                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, salaryTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(salaryLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(choosePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
            .add(searchPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(informationPanelLayout.createSequentialGroup()
                .add(searchPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(informationPanelLayout.createSequentialGroup()
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(rollLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(idTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(rollTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(startDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(startDateJDchoose, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(nameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(birthDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(salaryLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, salaryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(birthDateJDchoose, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(phoneNumberTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(29, 29, 29))
                    .add(informationPanelLayout.createSequentialGroup()
                        .add(choosePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        mainPanel.add(informationPanel);

        getContentPane().add(mainPanel);

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(null);
        tablePanel.setMinimumSize(new java.awt.Dimension(23, 23));
        tablePanel.setPreferredSize(new java.awt.Dimension(452, 402));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MANV", "HOTEN", "NGSINH", "SĐT", "CHUCVU", "NGVL", "LUONG"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        tablePanel.setViewportView(table);

        getContentPane().add(tablePanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            String hoten = this.nameTextField.getText();
            String birthdate = dateFormat.format(birthDateJDchoose.getDate());
            Date ngsinh = dateFormat.parse(birthdate);
            java.sql.Date sqlngsinh = new java.sql.Date(ngsinh.getTime());             
            String chucvu = this.rollTextField.getText();
            String startdate = dateFormat.format(startDateJDchoose.getDate());
            Date ngvl = dateFormat.parse(startdate);
            java.sql.Date sqlngvl = new java.sql.Date(ngvl.getTime());
            int luong = Integer.valueOf(this.salaryTextField.getText());
            int sdt = Integer.valueOf(this.phoneNumberTextField.getText());
 
            Employee nhanvien = new Employee(hoten, sqlngsinh, sdt, chucvu, sqlngvl, luong);
            int thong_bao = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn thêm dữ liệu này không? ","Thêm",JOptionPane.YES_NO_OPTION);
            if(thong_bao == JOptionPane.YES_OPTION){
                if(hoten.isEmpty()||chucvu.isEmpty() ||this.rollTextField.getText().isEmpty()
                      ||this.salaryTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nhập thông tin khách hàng.","Bạn chưa nhập đầy đủ thông tin.",2);
                }
                if (nhanvien.insert(nhanvien)){
                     JOptionPane.showMessageDialog(null,"Dữ liệu đã được thêm.","Thêm",1);
                }
                else{
                     JOptionPane.showMessageDialog(null,"Dữ liệu không thêm được.","Thêm",2);
                }
              }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage() + "Nhập thông tin khách hàng muốn thêm."," Thông báo.",1);
        }
            pushDataToTable();
    }//GEN-LAST:event_addButtonActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        try{
            int row = this.table.getSelectedRow();
            this.idTextField.setText(table.getValueAt(row,0).toString());
            this.nameTextField.setText(table.getValueAt(row,1).toString());      
            Date birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(row, 2).toString());
            birthDateJDchoose.setDate(birthdate);
            this.phoneNumberTextField.setText(table.getValueAt(row,3).toString());
            this.rollTextField.setText(table.getValueAt(row,4).toString());
            Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(row, 5).toString());
            startDateJDchoose.setDate(startdate);
            this.salaryTextField.setText(table.getValueAt(row,6).toString());
        }catch (ParseException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            String id = this.idTextField.getText();
            String hoten = this.nameTextField.getText();
            String birthdate = dateFormat.format(birthDateJDchoose.getDate());
            Date ngsinh = dateFormat.parse(birthdate);
            java.sql.Date sqlngsinh = new java.sql.Date(ngsinh.getTime());             
            String chucvu = this.rollTextField.getText();
            String startdate = dateFormat.format(startDateJDchoose.getDate());
            Date ngvl = dateFormat.parse(startdate);
            java.sql.Date sqlngvl = new java.sql.Date(ngvl.getTime());
            int luong = Integer.valueOf(this.salaryTextField.getText());
            int sdt = Integer.valueOf(this.phoneNumberTextField.getText());
            Employee nhanvien = new Employee(id, hoten, sqlngsinh,sdt, chucvu, sqlngvl, luong);
            int thong_bao = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn cập nhật dữ liệu này không? ","Cập nhật",JOptionPane.YES_NO_OPTION);
            if(thong_bao == JOptionPane.YES_OPTION){
                if(hoten.isEmpty()||chucvu.isEmpty() ||this.rollTextField.getText().isEmpty()
                      ||this.salaryTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nhập thông tin khách hàng.","Bạn chưa nhập đầy đủ thông tin.",2);
                }
                if (nhanvien.update(nhanvien)){
                     JOptionPane.showMessageDialog(null,"Dữ liệu đã được cập nhật","Cập nhật",1);
                }
                else{
                     JOptionPane.showMessageDialog(null,"Dữ liệu không được cập nhật","Cập nhật",2);
                }
              }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage() + "Nhập thông tin khách hàng muốn cập nhật."," Thông báo.",1);
        }
            pushDataToTable();
    }//GEN-LAST:event_editButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            String id = this.idTextField.getText();
            String hoten = this.nameTextField.getText();
            String birthdate = dateFormat.format(birthDateJDchoose.getDate());
            Date ngsinh = dateFormat.parse(birthdate);
            java.sql.Date sqlngsinh = new java.sql.Date(ngsinh.getTime()); 
            int sdt = Integer.valueOf(this.phoneNumberTextField.getText());            
            String chucvu = this.rollTextField.getText();
            String startdate = dateFormat.format(startDateJDchoose.getDate());
            Date ngvl = dateFormat.parse(startdate);
            java.sql.Date sqlngvl = new java.sql.Date(ngvl.getTime());
            int luong = Integer.valueOf(this.salaryTextField.getText());
           
            int thong_bao = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa " +
                    hoten + " dữ liệu này không? ","Xóa",JOptionPane.YES_NO_OPTION);
            Employee nhanvien = new Employee(id, hoten, sqlngsinh, sdt, chucvu, sqlngvl, luong);
            if(thong_bao == JOptionPane.YES_OPTION){
                if (nhanvien.delete(nhanvien)){
                     JOptionPane.showMessageDialog(null,"Dữ liệu đã được xóa","Xóa",1);     
                }
                else{
                     JOptionPane.showMessageDialog(null,"Dữ liệu không xóa được","Xóa",2);
                }
              }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage() + "Chọn thông tin khách hàng muốn xóa."," Thông báo.",1);
        }
        
        pushDataToTable();
           
    }//GEN-LAST:event_removeButtonActionPerformed

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
        // TODO add your handling code here:
        if(searchTextField.getText().equals("Nhập thông tin cần tìm vào đây.")){
            searchTextField.setText("");
        }
    }//GEN-LAST:event_searchTextFieldFocusGained

    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusLost
        // TODO add your handling code here:
        if(searchTextField.getText().equals("")){
            searchTextField.setText("Nhập thông tin cần tìm vào đây.");
        }
    }//GEN-LAST:event_searchTextFieldFocusLost

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        Employee nv = new Employee();
        String input = this.searchTextField.getText();
        
        ArrayList<Employee> ListName = nv.ListName(input);
        if(!this.searchTextField.getText().equals("")){
            String[] ColumnName = {"MANV","HOTEN","NGSINH","SDT",
            "CHUCVU","NGVL","LUONG"};
        // 8 la số cột
            Object[][] Rows = new Object[ListName.size()][7];
            //thêm dữ liệu từ KHList sang các cột
            for(int i = 0; i < ListName.size(); i ++){
                Rows[i][0] = ListName.get(i).getMANV();
                Rows[i][1] = ListName.get(i).getHOTEN();
                Rows[i][2] = ListName.get(i).getNGSINH();
                Rows[i][3] = ListName.get(i).getSDT();
                Rows[i][4] = ListName.get(i).getCHUCVU();
                Rows[i][5] = ListName.get(i).getNGVL();
                Rows[i][6]= ListName.get(i).getLUONG();
            }
            DefaultTableModel model = new DefaultTableModel(Rows,ColumnName);
            this.table.setModel(model);
            int rows = table.getRowCount();
            if(rows == 0){
                JOptionPane.showMessageDialog(null,"Không tìm thấy dữ liệu cần tìm.","Thông báo",1);
            }
 
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        try{
            if(!this.idTextField.getText().equals("")
                    || !this.nameTextField.getText().equals("")
                    || !this.searchTextField.getText().equals("Nhập thông tin cần kiếm vào đây.")
                    || !this.rollTextField.getText().equals("")
                    || !this.salaryTextField.getText().equals("")
                    || !this.phoneNumberTextField.getText().equals("")){     
                this.idTextField.setText("");
                this.nameTextField.setText("");
                this.rollTextField.setText("");
                this.salaryTextField.setText("");
                this.phoneNumberTextField.setText("");
                this.searchTextField.setText("Nhập thông tin cần tìm vào đây.");
                String today = "2021-05-26";
                Date birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(today);
                birthDateJDchoose.setDate(birthdate);
                Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(today);
                startDateJDchoose.setDate(startdate);

                pushDataToTable();
            }
        }catch (ParseException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_resetButtonActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private com.toedter.calendar.JDateChooser birthDateJDchoose;
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JPanel choosePanel;
    private javax.swing.JButton editButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTree jTree1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel rollLabel;
    private javax.swing.JTextField rollTextField;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JTextField salaryTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private com.toedter.calendar.JDateChooser startDateJDchoose;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JPanel titilePanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
