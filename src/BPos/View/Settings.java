/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import BPos.DB.CRetunItems;
import BPos.DB.CReturns;
import BPos.DB.Customer;
import BPos.DB.Discount;
import BPos.DB.InvoiceItem;
import BPos.DB.PaymentType;
import BPos.DB.Products;
import BPos.DB.QtyType;
import BPos.DB.SReturnItems;
import BPos.DB.Supplier;
import BPos.DB.User;
import BPos.DB.UserLogin;
import BPos.DB.UserType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Umesh
 */
public class Settings extends javax.swing.JFrame {

    /**
     * Creates new form Settings
     */
    String SelectesValue;
    Customer _Customer;
    Supplier _Supplier;

    public Settings() {
        initComponents();
        loadTyps();
        String[] s = {"ww", "sd"};
        loadUserType();
        String sa[] = {"fname", "lname", "email", "mobile"};
        for (String s1 : sa) {
            Search_By.addItem(s1);
        }
        loadUsers();
        loadDiscount();
        loadTyps();
        _LoadCustomerDebitHistory();
        LoadSReturns();
        Load_SUPLIER_Debit();
        loadpaymenttype();
        LoadInvoice();
        LoadSupplierPaymentHistory();
        updateStock();
        LoadCUSDebit();
        _LoadGRN();
        LoadReturns();
        _BTN_totpay.setVisible(false);
        _BTN_totpay1.setVisible(false);
        BTN_DELETE.setEnabled(false);
        BTN_UPDATE.setEnabled(false);
    }

    public void loadUsers() {

        Vector v1 = new Vector();
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.UserLogin.class);
        List<BPos.DB.UserLogin> l = cr.list();
        dt.setRowCount(0);
        for (UserLogin l1 : l) {
            if (!l1.getStatus().equals(3)) {
                Vector v = new Vector();
                v.add(l1.getUser().getIdUser());
                v.add(l1.getUser().getFname());
                v.add(l1.getUser().getLname());
                v.add(l1.getUser().getMobile());
                v.add(l1.getUserType().getTypeName());
                v.add(l1.getUser().getEmail());
                v1.add(v);
            }
        }
        for (int i = 0; i < v1.size(); i++) {
            Vector elementAt = (Vector) v1.elementAt(i);
            dt.addRow(elementAt);
        }
        ses.close();
    }

    public void loadUserType() {
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.UserType.class);
            List<BPos.DB.UserType> l = cr.list();
            for (UserType l1 : l) {
                COMBO_USER_TYPE.addItem(l1.getTypeName() + "_" + l1.getIdUserType());
            }
            ses.close();
        } catch (Exception e) {
        }
    }

    public static boolean isExits_Payment(String val) {
        boolean b = false;
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.PaymentType.class);
            cr.add(Restrictions.eq("typename", val));
            List<BPos.DB.PaymentType> l = cr.list();
            if (l.isEmpty()) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean isExits_Discount(int val) {
        boolean b = false;
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.Discount.class);
            cr.add(Restrictions.eq("value", val));
            List<BPos.DB.Discount> l = cr.list();
            if (l.isEmpty()) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean isExits_Pro_Type(String val) {
        boolean b = false;
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.QtyType.class);
            cr.add(Restrictions.eq("typeName", val));
            List<BPos.DB.QtyType> l = cr.list();
            if (l.isEmpty()) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        SettingPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        BTN_PTYPE = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        EDIT_PRO_TYPE = new javax.swing.JTextField();
        TEXT_DISCOUNT_VAL = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        BTN_DISCOUNT = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        COMBO_DISCOUNT = new javax.swing.JComboBox();
        BTN_DIS_EDIt = new javax.swing.JButton();
        EDIT_DIS = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        COMBO_PAYMENT = new javax.swing.JComboBox();
        jButton11 = new javax.swing.JButton();
        EDIT_PAYMENT_TYPE = new javax.swing.JTextField();
        TEXT_PAYMENT = new javax.swing.JTextField();
        PAY_ACTIVATE = new javax.swing.JRadioButton();
        PAY_DEACTIVATE = new javax.swing.JRadioButton();
        DIS_DEACTIVE = new javax.swing.JRadioButton();
        DIS_ACTIVE = new javax.swing.JRadioButton();
        Pro_Type_Deative = new javax.swing.JRadioButton();
        Pro_Type_Active = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        BTN_PRO_EDIT = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TEXT_FNAME = new javax.swing.JTextField();
        TEXT_LASTNAME = new javax.swing.JTextField();
        TEXT_EMAIL = new javax.swing.JTextField();
        _SEARCH_TXT = new javax.swing.JTextField();
        TEXT_LAN = new javax.swing.JTextField();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BTN_SAVE = new javax.swing.JButton();
        BTN_UPDATE = new javax.swing.JButton();
        BTN_DELETE = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Active = new javax.swing.JRadioButton();
        Deactive = new javax.swing.JRadioButton();
        COMBO_USER_TYPE = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        TEXT_MOBILE = new javax.swing.JTextField();
        TEXT_PASSWORD = new javax.swing.JPasswordField();
        TEXT_USERNAME1 = new javax.swing.JTextField();
        Search_By = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        form = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        to = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        updatedtb = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        Ito1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        Iform1 = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Sto = new com.toedter.calendar.JDateChooser();
        jLabel39 = new javax.swing.JLabel();
        Sform = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        STable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        to3 = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        form3 = new com.toedter.calendar.JDateChooser();
        jScrollPane6 = new javax.swing.JScrollPane();
        Invo_Tbl = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        to4 = new com.toedter.calendar.JDateChooser();
        jLabel44 = new javax.swing.JLabel();
        form4 = new com.toedter.calendar.JDateChooser();
        jScrollPane7 = new javax.swing.JScrollPane();
        grn_Tbl = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        _Cus_Debit = new javax.swing.JTable();
        jLabel48 = new javax.swing.JLabel();
        _SEARCH_TEXT = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        _duetot = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        _BTN_totpay = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        _SEARCH_TEXT1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        _Sup_DebitTBL = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        _BTN_totpay1 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        _duetot1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Invo_Tbl1 = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        form5 = new com.toedter.calendar.JDateChooser();
        jButton13 = new javax.swing.JButton();
        to5 = new com.toedter.calendar.JDateChooser();
        jButton14 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Invo_Tbl2 = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        to6 = new com.toedter.calendar.JDateChooser();
        jLabel57 = new javax.swing.JLabel();
        form6 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SettingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Add Product Qty Type");

        jLabel2.setText("Name :");

        BTN_PTYPE.setText("Add");
        BTN_PTYPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PTYPEActionPerformed(evt);
            }
        });

        jLabel3.setText("Product Types :");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Add Discount");

        jLabel19.setText("%");

        BTN_DISCOUNT.setText("Add");
        BTN_DISCOUNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_DISCOUNTActionPerformed(evt);
            }
        });

        jLabel20.setText("Discount :");

        COMBO_DISCOUNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COMBO_DISCOUNTActionPerformed(evt);
            }
        });

        BTN_DIS_EDIt.setText("Edit");
        BTN_DIS_EDIt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_DIS_EDItActionPerformed(evt);
            }
        });

        jLabel21.setText("%");

        jPanel6.setBackground(new java.awt.Color(102, 153, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(3, 100));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(102, 153, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(3, 100));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Add Payment Type");

        jLabel23.setText("Name :");

        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel24.setText("Payment Types :");

        COMBO_PAYMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COMBO_PAYMENTActionPerformed(evt);
            }
        });

        jButton11.setText("Edit");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        buttonGroup5.add(PAY_ACTIVATE);
        PAY_ACTIVATE.setText("Active");

        buttonGroup5.add(PAY_DEACTIVATE);
        PAY_DEACTIVATE.setText("Deactive");

        buttonGroup4.add(DIS_DEACTIVE);
        DIS_DEACTIVE.setText("Deactive");

        buttonGroup4.add(DIS_ACTIVE);
        DIS_ACTIVE.setText("Active");

        buttonGroup3.add(Pro_Type_Deative);
        Pro_Type_Deative.setText("Deactive");

        buttonGroup3.add(Pro_Type_Active);
        Pro_Type_Active.setText("Active");

        jLabel26.setText("Name :");

        jLabel27.setText("Name :");

        BTN_PRO_EDIT.setText("Edit");
        BTN_PRO_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PRO_EDITActionPerformed(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(0, 0, 255));
        jLabel28.setText("Edit");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        jLabel29.setForeground(new java.awt.Color(0, 0, 255));
        jLabel29.setText("Edit");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(0, 0, 255));
        jLabel30.setText("Edit");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(EDIT_PRO_TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Name)
                                            .addComponent(jComboBox1, 0, 160, Short.MAX_VALUE)))
                                    .addComponent(BTN_PTYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BTN_PRO_EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Pro_Type_Active)
                                .addGap(18, 18, 18)
                                .addComponent(Pro_Type_Deative)))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(BTN_DIS_EDIt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(EDIT_DIS, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TEXT_DISCOUNT_VAL)
                                    .addComponent(COMBO_DISCOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BTN_DISCOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DIS_ACTIVE)
                                .addGap(18, 18, 18)
                                .addComponent(DIS_DEACTIVE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TEXT_PAYMENT)
                                    .addComponent(COMBO_PAYMENT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EDIT_PAYMENT_TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(PAY_ACTIVATE)
                                .addGap(18, 18, 18)
                                .addComponent(PAY_DEACTIVATE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(TEXT_DISCOUNT_VAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(BTN_DISCOUNT)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(COMBO_DISCOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EDIT_DIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DIS_ACTIVE)
                                    .addComponent(DIS_DEACTIVE))
                                .addGap(18, 18, 18)
                                .addComponent(BTN_DIS_EDIt)
                                .addGap(186, 186, 186))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(BTN_PTYPE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EDIT_PRO_TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Pro_Type_Active)
                                    .addComponent(Pro_Type_Deative))
                                .addGap(18, 18, 18)
                                .addComponent(BTN_PRO_EDIT))))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(TEXT_PAYMENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(COMBO_PAYMENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EDIT_PAYMENT_TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PAY_ACTIVATE)
                    .addComponent(PAY_DEACTIVATE))
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Product", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Add New User");

        jLabel5.setText("First Name :");

        jLabel6.setText("Last Name :");

        jLabel7.setText("Email :");

        jLabel8.setText("User Name :");

        jLabel9.setText("Lan No :");

        jLabel10.setText("Gender :");

        jLabel11.setText("Password :");

        jLabel12.setText("Mobile :");

        _SEARCH_TXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _SEARCH_TXTActionPerformed(evt);
            }
        });
        _SEARCH_TXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                _SEARCH_TXTKeyReleased(evt);
            }
        });

        TEXT_LAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TEXT_LANKeyTyped(evt);
            }
        });

        buttonGroup1.add(Male);
        Male.setText("Male");

        buttonGroup1.add(Female);
        Female.setText("Female");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Fname", "Lname", "Mobile", "Type", "Email"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BTN_SAVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BPos/Img/btn/data-recovery-64.png"))); // NOI18N
        BTN_SAVE.setText("Insert");
        BTN_SAVE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        BTN_SAVE.setContentAreaFilled(false);
        BTN_SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SAVEActionPerformed(evt);
            }
        });

        BTN_UPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BPos/Img/btn/updateL.png"))); // NOI18N
        BTN_UPDATE.setText("Update");
        BTN_UPDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        BTN_UPDATE.setContentAreaFilled(false);
        BTN_UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_UPDATEActionPerformed(evt);
            }
        });

        BTN_DELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BPos/Img/btn/Delete DB L.png"))); // NOI18N
        BTN_DELETE.setText("Delete");
        BTN_DELETE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        BTN_DELETE.setContentAreaFilled(false);
        BTN_DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_DELETEActionPerformed(evt);
            }
        });

        jLabel13.setText("Status :");

        buttonGroup2.add(Active);
        Active.setText("Active");

        buttonGroup2.add(Deactive);
        Deactive.setText("Deactive");
        Deactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeactiveActionPerformed(evt);
            }
        });

        jLabel25.setText("User Type :");

        TEXT_MOBILE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TEXT_MOBILEKeyTyped(evt);
            }
        });

        jLabel35.setText("Search By :");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BPos/Img/btn/Reset S.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(COMBO_USER_TYPE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TEXT_FNAME)
                            .addComponent(TEXT_LASTNAME)
                            .addComponent(TEXT_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Male)
                                .addGap(18, 18, 18)
                                .addComponent(Female)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TEXT_USERNAME1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(TEXT_LAN))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel12))
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TEXT_MOBILE)
                                    .addComponent(TEXT_PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(Active)
                                .addGap(18, 18, 18)
                                .addComponent(Deactive)))
                        .addGap(106, 106, 106))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(130, 905, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(Search_By, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_SEARCH_TXT, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(Search_By, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(_SEARCH_TXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(TEXT_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(TEXT_LASTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(TEXT_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(TEXT_USERNAME1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(TEXT_LAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(Male)
                                    .addComponent(Female))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BTN_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BTN_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BTN_UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(COMBO_USER_TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TEXT_PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(TEXT_MOBILE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(Active)
                            .addComponent(Deactive))))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("User Management", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("Form :");

        jLabel15.setText("To :");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Customer Name", "Total Amount", "Profit"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Total :");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("Profit :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel15)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Summary", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        updatedtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StockID", "Product Name", "Reason", "Date Time"
            }
        ));
        jScrollPane3.setViewportView(updatedtb);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Updated Stock", jPanel5);

        jLabel36.setText("To :");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel37.setText("Form :");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Date", "Reson", "Qty", "Product Name"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Customer Returns");

        jButton7.setText("Load All");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel37)
                                .addGap(18, 18, 18)
                                .addComponent(Iform1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel36)
                                .addGap(18, 18, 18)
                                .addComponent(Ito1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)))
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton7))
                    .addComponent(jLabel36)
                    .addComponent(Ito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(Iform1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer Return Items", jPanel7);

        jLabel38.setText("To :");

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel39.setText("Form :");

        STable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Date", "Reson", "Qty", "Product Name"
            }
        ));
        jScrollPane5.setViewportView(STable);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Supplier Returns");

        jButton8.setText("Load All");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel17))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel39)
                                .addGap(18, 18, 18)
                                .addComponent(Sform, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel38)
                                .addGap(18, 18, 18)
                                .addComponent(Sto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8)))
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton8))
                    .addComponent(jLabel38)
                    .addComponent(Sto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(Sform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Supplier Return Items", jPanel3);

        jLabel40.setText("To :");

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel41.setText("Form :");

        Invo_Tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Customer", "Date", "Total", "Payment Type", "Discount"
            }
        ));
        jScrollPane6.setViewportView(Invo_Tbl);
        if (Invo_Tbl.getColumnModel().getColumnCount() > 0) {
            Invo_Tbl.getColumnModel().getColumn(4).setHeaderValue("Payment Type");
            Invo_Tbl.getColumnModel().getColumn(5).setHeaderValue("Discount");
        }

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Invoice Details");

        jButton9.setText("Load All");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel42))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel41)
                                .addGap(18, 18, 18)
                                .addComponent(form3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(to3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9)))
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton9))
                    .addComponent(jLabel40)
                    .addComponent(to3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(form3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Invoice Details", jPanel9);

        jLabel43.setText("To :");

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel44.setText("Form :");

        grn_Tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Name", "Date", "Total Amount", "Payment Type"
            }
        ));
        jScrollPane7.setViewportView(grn_Tbl);
        if (grn_Tbl.getColumnModel().getColumnCount() > 0) {
            grn_Tbl.getColumnModel().getColumn(4).setHeaderValue("Payment Type");
        }

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("GRN Details");

        jButton12.setText("Load All");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel45))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel44)
                                .addGap(18, 18, 18)
                                .addComponent(form4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addComponent(to4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12)))
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addGap(9, 9, 9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton12))
                    .addComponent(jLabel43)
                    .addComponent(to4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(form4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("GRN Details", jPanel10);

        _Cus_Debit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Name", "Total", "Due Amount"
            }
        ));
        _Cus_Debit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _Cus_DebitMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(_Cus_Debit);
        if (_Cus_Debit.getColumnModel().getColumnCount() > 0) {
            _Cus_Debit.getColumnModel().getColumn(0).setHeaderValue("Invoice ID");
            _Cus_Debit.getColumnModel().getColumn(1).setHeaderValue("Name");
            _Cus_Debit.getColumnModel().getColumn(2).setHeaderValue("Total");
            _Cus_Debit.getColumnModel().getColumn(3).setHeaderValue("Due Amount");
        }

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Customer Debit");

        _SEARCH_TEXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                _SEARCH_TEXTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                _SEARCH_TEXTKeyTyped(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel46.setText("Total Due :");

        _duetot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel49.setText("Search via (User Name, Mobile , Lan , Email)");

        _BTN_totpay.setText("Pay Total");
        _BTN_totpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _BTN_totpayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(_SEARCH_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(_duetot, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(_BTN_totpay)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addGap(1, 1, 1)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_SEARCH_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(_duetot, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel46)
                        .addComponent(_BTN_totpay)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer Debit", jPanel11);

        _SEARCH_TEXT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                _SEARCH_TEXT1KeyReleased(evt);
            }
        });

        jLabel50.setText("Search via (User Name, Mobile , Lan , Email)");

        _Sup_DebitTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Name", "Total", "Due Amount"
            }
        ));
        _Sup_DebitTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _Sup_DebitTBLMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(_Sup_DebitTBL);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("Customer Debit");

        _BTN_totpay1.setText("Pay Total");
        _BTN_totpay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _BTN_totpay1ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setText("Total Due :");

        _duetot1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel51)
                                .addComponent(_SEARCH_TEXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(_duetot1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(_BTN_totpay1)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addGap(1, 1, 1)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_SEARCH_TEXT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(_duetot1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel47)
                        .addComponent(_BTN_totpay1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Suplier Debit", jPanel12);

        Invo_Tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer", "Date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(Invo_Tbl1);

        jLabel52.setText("Form :");

        jButton13.setText("Load All");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Search");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel53.setText("To :");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("Customer Debit Payment History");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel54))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel52)
                                .addGap(18, 18, 18)
                                .addComponent(form5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel53)
                                .addGap(18, 18, 18)
                                .addComponent(to5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton14)
                                .addGap(18, 18, 18)
                                .addComponent(jButton13)))
                        .addGap(0, 78, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addGap(9, 9, 9)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton14)
                        .addComponent(jButton13))
                    .addComponent(jLabel53)
                    .addComponent(to5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(form5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Customer", jPanel14);

        jButton15.setText("Search");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel55.setText("To :");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("Supplier Debit Payment History");

        Invo_Tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer", "Date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(Invo_Tbl2);

        jButton16.setText("Load All");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel57.setText("Form :");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel56))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel57)
                                .addGap(18, 18, 18)
                                .addComponent(form6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel55)
                                .addGap(18, 18, 18)
                                .addComponent(to6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton15)
                                .addGap(18, 18, 18)
                                .addComponent(jButton16)))
                        .addGap(0, 78, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addGap(9, 9, 9)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton15)
                        .addComponent(jButton16))
                    .addComponent(jLabel55)
                    .addComponent(to6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(form6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Supplier", jPanel15);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Debit Payment History", jPanel13);

        javax.swing.GroupLayout SettingPanelLayout = new javax.swing.GroupLayout(SettingPanel);
        SettingPanel.setLayout(SettingPanelLayout);
        SettingPanelLayout.setHorizontalGroup(
            SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        SettingPanelLayout.setVerticalGroup(
            SettingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingPanelLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SettingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SettingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        try {
            if (COMBO_PAYMENT.getSelectedItem().toString() != null) {
                Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(BPos.DB.PaymentType.class);
                String[] s = COMBO_PAYMENT.getSelectedItem().toString().split("_");
                cr.add(Restrictions.eq("typename", s[0]));
                BPos.DB.PaymentType pt = (BPos.DB.PaymentType) cr.uniqueResult();
                EDIT_PAYMENT_TYPE.setText(pt.getTypename());
                if (pt.getStatus() == 0) {
                    PAY_DEACTIVATE.setSelected(true);
                } else {
                    PAY_ACTIVATE.setSelected(true);
                }
                ses.close();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        try {
            if (COMBO_DISCOUNT.getSelectedItem().toString() != null) {
                Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(BPos.DB.Discount.class);
                String[] s = COMBO_DISCOUNT.getSelectedItem().toString().split("_");
                cr.add(Restrictions.eq("value", Integer.parseInt(s[0])));
                BPos.DB.Discount pt = (BPos.DB.Discount) cr.uniqueResult();
                EDIT_DIS.setText(pt.getValue() + "");
                if (pt.getStatus() == 0) {
                    DIS_DEACTIVE.setSelected(true);
                } else {
                    DIS_ACTIVE.setSelected(true);
                }
                ses.close();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        try {
            if (jComboBox1.getSelectedItem().toString() != null) {
                Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(BPos.DB.QtyType.class);
                String[] s = jComboBox1.getSelectedItem().toString().split("_");
                cr.add(Restrictions.eq("typeName", s[0]));
                BPos.DB.QtyType pt = (BPos.DB.QtyType) cr.uniqueResult();
                EDIT_PRO_TYPE.setText(pt.getTypeName());
                if (pt.getStatus() == 0) {
                    Pro_Type_Active.setSelected(true);
                } else {
                    Pro_Type_Deative.setSelected(true);
                }
                ses.close();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel28MouseClicked

    private void BTN_PRO_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PRO_EDITActionPerformed
        try {
            if (!EDIT_PRO_TYPE.getText().toString().equals("")) {
                if (isExits_Pro_Type(EDIT_PRO_TYPE.getText())) {
                    Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                    Transaction tr = ses.beginTransaction();
                    BPos.DB.QtyType pt = new QtyType();
                    String[] s = jComboBox1.getSelectedItem().toString().split("_");
                    pt.setIdQtyType(Integer.parseInt(s[1]));
                    pt.setTypeName(EDIT_PRO_TYPE.getText());
                    ses.update(pt);
                    tr.commit();
                    ses.flush();
                    ses.close();
                    loadTyps();
                    EDIT_PRO_TYPE.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Product type is already exits!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Field is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_PRO_EDITActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            if (!EDIT_PAYMENT_TYPE.getText().toString().equals("")) {
                if (isExits_Pro_Type(EDIT_PAYMENT_TYPE.getText())) {
                    Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                    Transaction tr = ses.beginTransaction();
                    BPos.DB.PaymentType pt = new PaymentType();
                    String[] s = COMBO_DISCOUNT.getSelectedItem().toString().split("_");
                    pt.setIdPaymentType(Integer.parseInt(s[1]));
                    pt.setTypename(EDIT_PAYMENT_TYPE.getText());
                    int status = 0;
                    if (PAY_ACTIVATE.isSelected()) {
                        status = 1;
                    }
                    pt.setStatus(status);
                    ses.update(pt);
                    tr.commit();
                    ses.flush();
                    ses.close();
                    loadpaymenttype();
                    EDIT_PAYMENT_TYPE.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Product type is already exits!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Field is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void COMBO_PAYMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMBO_PAYMENTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COMBO_PAYMENTActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            try {
                if (!TEXT_PAYMENT.getText().equals("")) {
                    if (isExits_Payment(TEXT_PAYMENT.getText())) {
                        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                        Transaction tr = ses.beginTransaction();
                        BPos.DB.PaymentType pt = new PaymentType();
                        pt.setTypename(TEXT_PAYMENT.getText());
                        pt.setStatus(1);
                        ses.save(pt);
                        tr.commit();
                        ses.flush();
                        ses.close();
                        loadpaymenttype();
                        TEXT_PAYMENT.setText("");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "payment type is already exits!");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "payment type is empty");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void BTN_DIS_EDItActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DIS_EDItActionPerformed
        try {
            if (!EDIT_DIS.getText().toString().equals("")) {
                if (isExits_Pro_Type(EDIT_DIS.getText())) {
                    Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                    Transaction tr = ses.beginTransaction();
                    BPos.DB.Discount pt = new Discount();
                    String[] s = COMBO_DISCOUNT.getSelectedItem().toString().split("_");
                    System.out.println(s[1]);
                    pt.setIdDiscount(Integer.parseInt(s[1]));
                    pt.setValue(Integer.parseInt(EDIT_DIS.getText()));
                    int status = 0;
                    if (DIS_ACTIVE.isSelected()) {
                        status = 1;
                    }
                    pt.setStatus(status);
                    ses.update(pt);
                    tr.commit();
                    ses.flush();
                    ses.close();
                    loadDiscount();
                    EDIT_DIS.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Product type is already exits!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Field is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_DIS_EDItActionPerformed

    private void COMBO_DISCOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMBO_DISCOUNTActionPerformed

    }//GEN-LAST:event_COMBO_DISCOUNTActionPerformed

    private void BTN_DISCOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DISCOUNTActionPerformed
        try {
            if (!TEXT_DISCOUNT_VAL.getText().toString().equals("")) {
                if (isExits_Discount(Integer.parseInt(TEXT_DISCOUNT_VAL.getText()))) {
                    Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                    Transaction tr = ses.beginTransaction();
                    BPos.DB.Discount pt = new Discount();
                    pt.setValue(Integer.parseInt(TEXT_DISCOUNT_VAL.getText()));
                    pt.setStatus(1);
                    ses.save(pt);
                    tr.commit();
                    ses.flush();
                    ses.close();
                    loadDiscount();
                    TEXT_DISCOUNT_VAL.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Discount is already exits!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Field is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_DISCOUNTActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void BTN_PTYPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PTYPEActionPerformed
        try {
            if (!Name.getText().toString().equals("")) {
                if (isExits_Pro_Type(Name.getText())) {
                    Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                    Transaction tr = ses.beginTransaction();
                    BPos.DB.QtyType pt = new QtyType();
                    pt.setTypeName(Name.getText());
                    ses.save(pt);
                    tr.commit();
                    ses.flush();
                    ses.close();
                    loadTyps();
                    Name.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Product type is already exits!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Field is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_PTYPEActionPerformed

    private void DeactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeactiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeactiveActionPerformed

    private void BTN_UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_UPDATEActionPerformed

        try {

            if (!TEXT_FNAME.getText().equals("") & 2 < TEXT_FNAME.getText().length()) {
                if (!TEXT_LASTNAME.getText().equals("") & 2 < TEXT_LASTNAME.getText().length()) {
                    if (!TEXT_USERNAME1.getText().equals("") & 2 < TEXT_USERNAME1.getText().length()) {
                        if (!TEXT_EMAIL.getText().equals("") & 2 < TEXT_EMAIL.getText().length() & Com.execute.validation.Validation.isvalidEmail(TEXT_EMAIL.getText())) {
                            if (!TEXT_MOBILE.getText().equals("") & 2 < TEXT_MOBILE.getText().length()) {
                                if (!TEXT_LAN.getText().equals("") & 2 < TEXT_LAN.getText().length()) {
                                    if (!TEXT_PASSWORD.getText().equals("") & 2 < TEXT_PASSWORD.getText().length()) {
                                        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                                        Transaction tr = ses.beginTransaction();
                                        String gen = Male.isSelected() ? "Male" : "Female";
                                        int status = Active.isSelected() ? 1 : 0;
                                        BPos.DB.User u = (BPos.DB.User) ses.load(BPos.DB.User.class, Integer.parseInt(SelectesValue));
                                        u.setFname(TEXT_FNAME.getText());
                                        u.setLname(TEXT_LASTNAME.getText());
                                        u.setEmail(TEXT_EMAIL.getText());
                                        u.setLanNo(TEXT_LAN.getText());
                                        u.setMobile(TEXT_MOBILE.getText());
                                        u.setGender(gen);

                                        UserLogin ul = (UserLogin) ses.load(BPos.DB.UserLogin.class, u.getIdUser());
                                        ul.setUserName(TEXT_USERNAME1.getText());
                                        ul.setPassword(ul.getPassword());
                                        ul.setStatus(status);
                                        ul.setUser(u);
                                        String[] x = COMBO_USER_TYPE.getSelectedItem().toString().split("_");
                                        int type = Integer.parseInt(x[1]);
                                        UserType ut = (UserType) ses.load(UserType.class, type);
                                        ul.setUserType(ut);

                                        ses.update(u);
                                        ses.update(ul);
                                        tr.commit();
                                        ses.flush();
                                        ses.close();
                                        loadUsers();
                                        clearTEXT();
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Please enter valid password!!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Please enter valid Lan number!!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Please enter valid mobile number!!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Please enter valid email!!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Please enter valid username!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please enter valid lname!!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please enter valid fname!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Update Error!");
            e.printStackTrace();
        }

    }//GEN-LAST:event_BTN_UPDATEActionPerformed

    private void BTN_SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SAVEActionPerformed
        try {

            if (!TEXT_FNAME.getText().equals("") & 2 < TEXT_FNAME.getText().length()) {
                if (!TEXT_LASTNAME.getText().equals("") & 2 < TEXT_LASTNAME.getText().length()) {
                    if (!TEXT_USERNAME1.getText().equals("") & 2 < TEXT_USERNAME1.getText().length()) {
                        if (!TEXT_EMAIL.getText().equals("") & 2 < TEXT_EMAIL.getText().length() & Com.execute.validation.Validation.isvalidEmail(TEXT_EMAIL.getText())) {
                            if (!TEXT_MOBILE.getText().equals("") & 2 < TEXT_MOBILE.getText().length()) {
                                if (!TEXT_LAN.getText().equals("") & 2 < TEXT_LAN.getText().length()) {
                                    if (!TEXT_PASSWORD.getText().equals("") & 2 < TEXT_PASSWORD.getText().length()) {
                                        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                                        Transaction tr = ses.beginTransaction();
                                        String gen = Male.isSelected() ? "Male" : "Female";
                                        int status = Active.isSelected() ? 1 : 0;
                                        BPos.DB.User u = new User();
                                        u.setFname(TEXT_FNAME.getText());
                                        u.setLname(TEXT_LASTNAME.getText());
                                        u.setEmail(TEXT_EMAIL.getText());
                                        u.setLanNo(TEXT_LAN.getText());
                                        u.setMobile(TEXT_MOBILE.getText());
                                        u.setGender(gen);

                                        UserLogin ul = new UserLogin();
                                        ul.setUserName(TEXT_USERNAME1.getText());
                                        ul.setPassword(TEXT_PASSWORD.getText());
                                        ul.setStatus(status);
                                        ul.setUser(u);
                                        String[] x = COMBO_USER_TYPE.getSelectedItem().toString().split("_");
                                        int type = Integer.parseInt(x[1]);
                                        UserType ut = (UserType) ses.load(UserType.class, type);
                                        ul.setUserType(ut);

                                        ses.save(u);
                                        ses.save(ul);
                                        tr.commit();
                                        ses.flush();
                                        ses.close();
                                        loadUsers();
                                        clearTEXT();
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Please enter valid password!!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Please enter valid Lan number!!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Please enter valid mobile number!!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Please enter valid email!!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Please enter valid username!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please enter valid lname!!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please enter valid fname!!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BTN_SAVEActionPerformed

    private void _SEARCH_TXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__SEARCH_TXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__SEARCH_TXTActionPerformed

    private void _SEARCH_TXTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__SEARCH_TXTKeyReleased
        try {
            if (_SEARCH_TXT.getText().equals("")) {
                loadUsers();
            } else {
                Vector v1 = new Vector();
                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(BPos.DB.User.class);
                cr.add(Restrictions.eq(Search_By.getSelectedItem().toString(), _SEARCH_TXT.getText()));
                List<BPos.DB.User> l = cr.list();
                dt.setRowCount(0);
                for (User l1 : l) {
                    BPos.DB.UserLogin u = (BPos.DB.UserLogin) ses.load(BPos.DB.UserLogin.class, l1.getIdUser());
                    if (!u.getStatus().equals(3)) {
                        Vector v = new Vector();
                        v.add(l1.getIdUser());
                        v.add(l1.getFname());
                        v.add(l1.getLname());
                        v.add(l1.getMobile());
                        v.add(u.getUserType().getTypeName());
                        v.add(l1.getEmail());
                        v1.add(v);
                    }
                }
                for (int i = 0; i < v1.size(); i++) {
                    Vector elementAt = (Vector) v1.elementAt(i);
                    dt.addRow(elementAt);
                }
                ses.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event__SEARCH_TXTKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            JTable target = (JTable) evt.getSource();

            int selectedRow = target.getSelectedRow();
            int selectedColumn = target.getSelectedColumn();
            BTN_SAVE.setEnabled(false);
            Object value = target.getValueAt(selectedRow, 0);
            SelectesValue = value.toString();
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.UserLogin.class);
            BPos.DB.User uu = (BPos.DB.User) ses.load(BPos.DB.User.class, Integer.parseInt(value.toString()));
            cr.add(Restrictions.eq("user", uu));
            List<BPos.DB.UserLogin> cs = cr.list();
            for (BPos.DB.UserLogin c : cs) {
                TEXT_FNAME.setText(c.getUser().getFname());
                TEXT_LASTNAME.setText(c.getUser().getLname());
                TEXT_EMAIL.setText(c.getUser().getEmail());
                TEXT_LAN.setText(c.getUser().getLanNo());
                TEXT_MOBILE.setText(c.getUser().getMobile());
                TEXT_USERNAME1.setText(c.getUserName());
                TEXT_PASSWORD.setText("*********");
                if (c.getUser().getGender().equals("Male")) {
                    Male.setSelected(true);
                } else {
                    Female.setSelected(true);
                }
                if (c.getStatus().equals(1)) {
                    Active.setSelected(true);
                } else {
                    Deactive.setSelected(true);
                }
            }
            BTN_DELETE.setEnabled(true);
            BTN_UPDATE.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void BTN_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DELETEActionPerformed
        try {
            if (!SelectesValue.equals("")) {
                try {
                    Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                    Transaction tr = ses.beginTransaction();
                    BPos.DB.UserLogin ul = (BPos.DB.UserLogin) ses.load(BPos.DB.UserLogin.class, Integer.parseInt(SelectesValue));
                    ul.setStatus(3);
                    ses.update(ul);
                    tr.commit();
                    ses.flush();
                    ses.close();
                    loadUsers();
                    clearTEXT();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BTN_DELETEActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clearTEXT();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TEXT_LANKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_LANKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_TEXT_LANKeyTyped

    private void TEXT_MOBILEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_MOBILEKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_TEXT_MOBILEKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double tot;
        double d;
        try {

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.Invoice.class);
            cr.add(Restrictions.between("dateTime", df.format(form.getDate()).toString(), df.format(to.getDate()).toString()));
            List<BPos.DB.Invoice> grn1 = cr.list();
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);
            tot = 0;
            d = 0;
            for (BPos.DB.Invoice in : grn1) {
                Vector v = new Vector();
                v.add(in.getIdInvoice());
                v.add(in.getCustomer().getName());
                v.add(in.getTotalAmount());

                tot += in.getTotalAmount();

                Criteria cr1 = ses.createCriteria(BPos.DB.InvoiceItem.class);
                cr1.add(Restrictions.eq("invoice", in));
                List<BPos.DB.InvoiceItem> intm = cr1.list();

                for (InvoiceItem intm1 : intm) {
                    double t = (intm1.getStock().getSellingPrice() - intm1.getStock().getBuyingPrice());
                    Double xs = t * intm1.getQty();
                    Integer i = xs.intValue();
                    v.add(i);
                    d += i;
                }
                dtm.addRow(v);
            }
            jLabel32.setText(tot + "");
            jLabel33.setText(d + "");
            ses.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.CReturns.class);
            cr.add(Restrictions.between("dateTime", df.format(Iform1.getDate()), df.format(Ito1.getDate())));
            List<BPos.DB.CReturns> grn1 = cr.list();

            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dtm.setRowCount(0);

            for (BPos.DB.CReturns Cus_RE : grn1) {
                Criteria cr1 = ses.createCriteria(BPos.DB.CRetunItems.class);
                cr.add(Restrictions.eq("CReturns", Cus_RE));
                List<BPos.DB.CRetunItems> clist = cr1.list();
                for (CRetunItems cc : clist) {
                    if (Cus_RE.getIdCReturns() == cc.getCReturns().getIdCReturns()) {
                        Vector v = new Vector();
                        v.add(cc.getCReturns().getInvoice().getIdInvoice());
                        v.add(cc.getCReturns().getDateTime());
                        v.add(cc.getReason());
                        v.add(cc.getQty());
                        v.add(cc.getProducts().getProName());
                        dtm.addRow(v);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.SReturns.class);
            cr.add(Restrictions.between("dateTime", df.format(Sform.getDate()).toString(), df.format(Sto.getDate()).toString()));
            List<BPos.DB.SReturns> grn1 = cr.list();
            DefaultTableModel dtm = (DefaultTableModel) STable.getModel();
            dtm.setRowCount(0);
            for (BPos.DB.SReturns Cus_RE : grn1) {
                Criteria cr1 = ses.createCriteria(BPos.DB.SReturnItems.class);
                cr.add(Restrictions.eq("SReturns", Cus_RE));
                List<BPos.DB.SReturnItems> clist = cr1.list();
                for (SReturnItems cc : clist) {
                    if (Cus_RE.getIdSReturns() == cc.getSReturns().getIdSReturns()) {
                        Vector v = new Vector();
                        v.add(cc.getSReturns().getGrn().getGrnId());
                        v.add(cc.getSReturns().getDateTime());
                        v.add(cc.getReson());
                        v.add(cc.getQty());
                        v.add(cc.getProducts().getProName());
                        dtm.addRow(v);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Invoice.class);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        cr.add(Restrictions.between("dateTime", df.format(form3.getDate()).toString(), df.format(to3.getDate()).toString()));
        List<BPos.DB.Invoice> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) Invo_Tbl.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Invoice in : grn1) {
            Vector v = new Vector();
            v.add(in.getIdInvoice());
            v.add(in.getCustomer().getName());
            v.add(in.getDateTime());
            v.add(in.getTotalAmount());
            v.add(in.getPaymentType().getTypename());
            v.add(in.getDiscount().getValue());
            dtm.addRow(v);
        }
        ses.close();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Grn.class);

        cr.add(Restrictions.between("dateTime", df.format(form4.getDate()).toString(), df.format(to4.getDate()).toString()));
        List<BPos.DB.Grn> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) grn_Tbl.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Grn in : grn1) {
            Vector v = new Vector();
            v.add(in.getGrnId());
            v.add(in.getSupplier().getName());
            v.add(in.getDateTime());
            v.add(in.getTotalAmount());
            v.add(in.getPaymentType().getTypename());
            dtm.addRow(v);
        }
        ses.close();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void _SEARCH_TEXTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__SEARCH_TEXTKeyReleased
        double xs = 0;
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.CustomerDue.class);
        List<BPos.DB.CustomerDue> grn1 = cr.list();

        DefaultTableModel dtm = (DefaultTableModel) _Cus_Debit.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.CustomerDue in : grn1) {
            String val = _SEARCH_TEXT.getText();
            if (!val.equals("")) {
                if (in.getCustomer().getMobile().equals(val)
                        || in.getCustomer().getName().equals(val)
                        || in.getCustomer().getLanNo().equals(val)
                        || in.getCustomer().getEmail().equals(val)) {
                    _Customer = in.getCustomer();
                    Vector v = new Vector();
                    v.add(in.getInvoice().getIdInvoice());
                    v.add(in.getCustomer().getName());
                    v.add(in.getTotal());
                    v.add(in.getDueamount());
                    dtm.addRow(v);

                    xs = xs + in.getDueamount();

                }
            } else {
                LoadCUSDebit();
            }
        }
        if (xs != 0) {
            //_BTN_totpay.setEnabled(true);
        } else {
           // _BTN_totpay.setEnabled(false);
        }
        _duetot.setText(xs + "");
        ses.close();

    }//GEN-LAST:event__SEARCH_TEXTKeyReleased

    private void _SEARCH_TEXT1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__SEARCH_TEXT1KeyReleased
        double xs = 0;
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.SupplierDue.class);
        List<BPos.DB.SupplierDue> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) _Sup_DebitTBL.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.SupplierDue in : grn1) {
            String val = _SEARCH_TEXT1.getText();
            if (!val.equals("")) {
                if (in.getSupplier().getMobile().equals(val)
                        || in.getSupplier().getName().equals(val)
                        || in.getSupplier().getLanNo().equals(val)
                        || in.getSupplier().getEmail().equals(val)) {
                    _Supplier = in.getSupplier();
                    Vector v = new Vector();
                    v.add(in.getGrn().getGrnId());
                    v.add(in.getSupplier().getName());
                    v.add(in.getTotal());
                    v.add(in.getDueamount());
                    dtm.addRow(v);

                    xs = xs + in.getDueamount();

                }
            } else {
                Load_SUPLIER_Debit();
            }
        }
        if (xs != 0) {
           // _BTN_totpay1.setEnabled(true);
        } else {
            //_BTN_totpay1.setEnabled(false);
        }
        _duetot1.setText(xs + "");
        ses.close();

    }//GEN-LAST:event__SEARCH_TEXT1KeyReleased

    private void _Cus_DebitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__Cus_DebitMouseClicked
        // TODO add your handling code here:
        int stcid = Integer.parseInt(_Cus_Debit.getModel().getValueAt(_Cus_Debit.getSelectedRow(), 0).toString());
        double tbid = Double.parseDouble(_Cus_Debit.getModel().getValueAt(_Cus_Debit.getSelectedRow(), 3).toString());
        if (!(tbid == 0)) {
            CustomerDue_Pay cdp = new CustomerDue_Pay(stcid, this);
            cdp.setVisible(true);
        }
    }//GEN-LAST:event__Cus_DebitMouseClicked

    private void _BTN_totpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__BTN_totpayActionPerformed
        PayTotal pt = new PayTotal(_Customer, this);
        pt.setVisible(true);
    }//GEN-LAST:event__BTN_totpayActionPerformed

    private void _Sup_DebitTBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__Sup_DebitTBLMouseClicked
        // TODO add your handling code here:
        int stcid = Integer.parseInt(_Sup_DebitTBL.getModel().getValueAt(_Sup_DebitTBL.getSelectedRow(), 0).toString());
        double tbid = Double.parseDouble(_Sup_DebitTBL.getModel().getValueAt(_Sup_DebitTBL.getSelectedRow(), 3).toString());
        if (!(tbid == 0)) {
            Due_Single_pay_Supplier cdp = new Due_Single_pay_Supplier(stcid, this);
            cdp.setVisible(true);
        }
    }//GEN-LAST:event__Sup_DebitTBLMouseClicked

    private void _BTN_totpay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__BTN_totpay1ActionPerformed
        // TODO add your handling code here:
        PayGrnTotalDue pt = new PayGrnTotalDue(_Supplier, this);
        pt.setVisible(true);
    }//GEN-LAST:event__BTN_totpay1ActionPerformed

    private void _SEARCH_TEXTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__SEARCH_TEXTKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event__SEARCH_TEXTKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        LoadReturns();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        LoadSReturns();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        LoadInvoice();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        _LoadGRN();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        _LoadCustomerDebitHistory();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:

        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Customerduerecords.class);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        cr.add(Restrictions.between("datetime", df.format(form5.getDate()).toString(), df.format(to5.getDate()).toString()));
        List<BPos.DB.Customerduerecords> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) Invo_Tbl1.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Customerduerecords in : grn1) {
            Vector v = new Vector();
            v.add(in.getIdDueRecords());
            v.add(in.getCustomerDue().getCustomer().getName());
            v.add(in.getDatetime());
            v.add(in.getAmount());
            dtm.addRow(v);
        }
        ses.close();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:

        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Supplierduerecords.class);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        cr.add(Restrictions.between("datetime", df.format(form6.getDate()).toString(), df.format(to6.getDate()).toString()));
        List<BPos.DB.Supplierduerecords> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) Invo_Tbl2.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Supplierduerecords in : grn1) {
            Vector v = new Vector();
            v.add(in.getIdDueRecords());
            v.add(in.getSupplierDue().getSupplier().getName());
            v.add(in.getDatetime());
            v.add(in.getAmount());
            dtm.addRow(v);
        }
        ses.close();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        LoadSupplierPaymentHistory();
    }//GEN-LAST:event_jButton16ActionPerformed
    public void loadTyps() {
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.QtyType.class);
            List<BPos.DB.QtyType> l = cr.list();
            jComboBox1.removeAllItems();
            for (QtyType l1 : l) {
                jComboBox1.addItem(l1.getTypeName() + "_" + l1.getIdQtyType());
            }
            ses.flush();
            ses.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDiscount() {
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.Discount.class);
            List<BPos.DB.Discount> l = cr.list();
            COMBO_DISCOUNT.removeAllItems();
            for (Discount l1 : l) {
                COMBO_DISCOUNT.addItem(l1.getValue() + "_" + l1.getIdDiscount());
            }
            ses.flush();
            ses.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadpaymenttype() {
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.PaymentType.class);
            List<BPos.DB.PaymentType> l = cr.list();
            COMBO_PAYMENT.removeAllItems();
            for (PaymentType l1 : l) {
                COMBO_PAYMENT.addItem(l1.getTypename() + "_" + l1.getIdPaymentType());
            }
            ses.flush();
            ses.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Active;
    private javax.swing.JButton BTN_DELETE;
    private javax.swing.JButton BTN_DISCOUNT;
    private javax.swing.JButton BTN_DIS_EDIt;
    private javax.swing.JButton BTN_PRO_EDIT;
    private javax.swing.JButton BTN_PTYPE;
    private javax.swing.JButton BTN_SAVE;
    private javax.swing.JButton BTN_UPDATE;
    private javax.swing.JComboBox COMBO_DISCOUNT;
    private javax.swing.JComboBox COMBO_PAYMENT;
    private javax.swing.JComboBox COMBO_USER_TYPE;
    private javax.swing.JRadioButton DIS_ACTIVE;
    private javax.swing.JRadioButton DIS_DEACTIVE;
    private javax.swing.JRadioButton Deactive;
    private javax.swing.JTextField EDIT_DIS;
    private javax.swing.JTextField EDIT_PAYMENT_TYPE;
    private javax.swing.JTextField EDIT_PRO_TYPE;
    private javax.swing.JRadioButton Female;
    private com.toedter.calendar.JDateChooser Iform1;
    private javax.swing.JTable Invo_Tbl;
    private javax.swing.JTable Invo_Tbl1;
    private javax.swing.JTable Invo_Tbl2;
    private com.toedter.calendar.JDateChooser Ito1;
    private javax.swing.JRadioButton Male;
    private javax.swing.JTextField Name;
    private javax.swing.JRadioButton PAY_ACTIVATE;
    private javax.swing.JRadioButton PAY_DEACTIVATE;
    private javax.swing.JRadioButton Pro_Type_Active;
    private javax.swing.JRadioButton Pro_Type_Deative;
    private javax.swing.JTable STable;
    private javax.swing.JComboBox Search_By;
    public javax.swing.JPanel SettingPanel;
    private com.toedter.calendar.JDateChooser Sform;
    private com.toedter.calendar.JDateChooser Sto;
    private javax.swing.JTextField TEXT_DISCOUNT_VAL;
    private javax.swing.JTextField TEXT_EMAIL;
    private javax.swing.JTextField TEXT_FNAME;
    private javax.swing.JTextField TEXT_LAN;
    private javax.swing.JTextField TEXT_LASTNAME;
    private javax.swing.JTextField TEXT_MOBILE;
    private javax.swing.JPasswordField TEXT_PASSWORD;
    private javax.swing.JTextField TEXT_PAYMENT;
    private javax.swing.JTextField TEXT_USERNAME1;
    private javax.swing.JButton _BTN_totpay;
    private javax.swing.JButton _BTN_totpay1;
    private javax.swing.JTable _Cus_Debit;
    private javax.swing.JTextField _SEARCH_TEXT;
    private javax.swing.JTextField _SEARCH_TEXT1;
    private javax.swing.JTextField _SEARCH_TXT;
    private javax.swing.JTable _Sup_DebitTBL;
    private javax.swing.JLabel _duetot;
    private javax.swing.JLabel _duetot1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private com.toedter.calendar.JDateChooser form;
    private com.toedter.calendar.JDateChooser form3;
    private com.toedter.calendar.JDateChooser form4;
    private com.toedter.calendar.JDateChooser form5;
    private com.toedter.calendar.JDateChooser form6;
    private javax.swing.JTable grn_Tbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private com.toedter.calendar.JDateChooser to;
    private com.toedter.calendar.JDateChooser to3;
    private com.toedter.calendar.JDateChooser to4;
    private com.toedter.calendar.JDateChooser to5;
    private com.toedter.calendar.JDateChooser to6;
    private javax.swing.JTable updatedtb;
    // End of variables declaration//GEN-END:variables

    public void clearTEXT() {
        TEXT_FNAME.setText("");
        TEXT_LASTNAME.setText("");
        TEXT_EMAIL.setText("");
        TEXT_LAN.setText("");
        TEXT_MOBILE.setText("");
        TEXT_USERNAME1.setText("");
        TEXT_PASSWORD.setText("");
        BTN_SAVE.setEnabled(true);
        BTN_DELETE.setEnabled(false);
        BTN_UPDATE.setEnabled(false);
    }
//    updatedtb

    public void updateStock() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Stockupdated.class);
        List<BPos.DB.Stockupdated> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) updatedtb.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Stockupdated in : grn1) {
            Vector v = new Vector();
            v.add(in.getStock().getIdstock());
            v.add(in.getStock().getProducts().getProName());
            v.add(in.getReason());
            v.add(in.getDatetime());
            dtm.addRow(v);
        }
    }

    public void LoadReturns() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.CRetunItems.class);
        List<BPos.DB.CRetunItems> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.CRetunItems in : grn1) {
            Vector v = new Vector();
            v.add(in.getCReturns().getInvoice().getIdInvoice());
            v.add(in.getCReturns().getDateTime());
            v.add(in.getReason());
            v.add(in.getQty());
            v.add(in.getProducts().getProName());
            dtm.addRow(v);
        }
        ses.close();
    }

    public void LoadSReturns() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.SReturnItems.class);
        List<BPos.DB.SReturnItems> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) STable.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.SReturnItems in : grn1) {
            Vector v = new Vector();
            v.add(in.getSReturns().getGrn().getGrnId());
            v.add(in.getSReturns().getDateTime());
            v.add(in.getReson());
            v.add(in.getQty());
            v.add(in.getProducts().getProName());
            dtm.addRow(v);
        }
        ses.close();
    }

    public void LoadInvoice() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Invoice.class);
        List<BPos.DB.Invoice> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) Invo_Tbl.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Invoice in : grn1) {
            Vector v = new Vector();
            v.add(in.getIdInvoice());
            
            v.add(in.getCustomer().getName());
            
            v.add(in.getDateTime());
            v.add(in.getTotalAmount());
            v.add(in.getPaymentType().getTypename());
            v.add(in.getDiscount().getValue());
            dtm.addRow(v);
        }
        ses.close();
    }

    public void _LoadGRN() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Grn.class);
        List<BPos.DB.Grn> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) grn_Tbl.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Grn in : grn1) {
            Vector v = new Vector();
            v.add(in.getGrnId());
            v.add(in.getSupplier().getName());
            v.add(in.getDateTime());
            v.add(in.getTotalAmount());
            v.add(in.getPaymentType().getTypename());
            dtm.addRow(v);
        }
        ses.close();
    }

    public void LoadCUSDebit() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.CustomerDue.class);
        List<BPos.DB.CustomerDue> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) _Cus_Debit.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.CustomerDue in : grn1) {
            Vector v = new Vector();
            v.add(in.getInvoice().getIdInvoice());
            v.add(in.getCustomer().getName());
            v.add(in.getTotal());
            v.add(in.getDueamount());
            dtm.addRow(v);
        }
        ses.close();
    }

    public void Load_SUPLIER_Debit() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.SupplierDue.class);
        List<BPos.DB.SupplierDue> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) _Sup_DebitTBL.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.SupplierDue in : grn1) {
            Vector v = new Vector();
            v.add(in.getGrn().getGrnId());
            v.add(in.getSupplier().getName());
            v.add(in.getTotal());
            v.add(in.getDueamount());
            dtm.addRow(v);
        }
        ses.close();
    }

    public void _LoadCustomerDebitHistory() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Customerduerecords.class);
        List<BPos.DB.Customerduerecords> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) Invo_Tbl1.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Customerduerecords in : grn1) {
            Vector v = new Vector();
            v.add(in.getIdDueRecords());
            v.add(in.getCustomerDue().getCustomer().getName());
            v.add(in.getDatetime());
            v.add(in.getAmount());
            dtm.addRow(v);
        }
        ses.close();
    }

    public void LoadSupplierPaymentHistory() {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Supplierduerecords.class);
        List<BPos.DB.Supplierduerecords> grn1 = cr.list();
        DefaultTableModel dtm = (DefaultTableModel) Invo_Tbl2.getModel();
        dtm.setRowCount(0);
        for (BPos.DB.Supplierduerecords in : grn1) {
            Vector v = new Vector();
            v.add(in.getIdDueRecords());
            v.add(in.getSupplierDue().getSupplier().getName());
            v.add(in.getDatetime());
            v.add(in.getAmount());
            dtm.addRow(v);
        }
        ses.close();
    }
}
