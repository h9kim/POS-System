/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import BPos.DB.CustomerDue;
import BPos.DB.Discount;
import BPos.DB.InvoiceItem;
import BPos.Model.itemsList;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;

/**
 *
 * @author Bhanuka
 */
public class Invoice extends javax.swing.JFrame {

    /**
     * Creates new form Invoice
     */
    int CustomerID;
    Invoice _INVO, _INVONEW;
    BPos.Model.itemsList ItemList = null;

    public Invoice() {
        initComponents();
        loadTyps();
        cusID.setVisible(false);
        loadDiscount();
        balance.setText("0.0");
        Paid.setText("0.0");
        subTotal.setText("0.0");
        grandTot.setText("0.0");
    }

    public Invoice(Invoice in, double qty, int row) {
        in.jTable1.getModel().setValueAt(qty, row, 4);
        double price = Double.parseDouble(in.jTable1.getModel().getValueAt(row, 5).toString());

        double amount = qty * price;
        in.jTable1.getModel().setValueAt(amount, row, 6);

        double sub = amount;
        int di = Integer.parseInt(in.jTable1.getModel().getValueAt(row, 7).toString());
        double s = sub * di / 100;
        sub = sub - s;
        in.jTable1.getModel().setValueAt(sub, row, 8);
        double tot = 0;
        for (int i = 0; i < in.jTable1.getRowCount(); i++) {
            tot += Double.parseDouble(in.jTable1.getModel().getValueAt(i, 8).toString());
        }
        in.subTotal.setText(tot + "");
        in.grandTot.setText(tot + "");
        in.Paid.setText(tot + "");
        in.balance.setText("0.0");

    }

    public Invoice(Invoice i, int val) {
        initComponents();
        CustomerID = val;
        _INVO = i;

        i.cusID.setText(val + "");
        i.cusID.setVisible(false);
        getNames();
    }
    Vector v = new Vector();

    public Invoice(Invoice i, BPos.Model.itemsList il) {
        initComponents();
        _INVONEW = i;
        cusID.setVisible(false);
        ItemList = il;
        boolean b = false;
        int c = 0;
        for (int j = 0; j < i.jTable1.getRowCount(); j++) {
            int t = Integer.parseInt(i.jTable1.getModel().getValueAt(j, 1).toString());
            if (il.getStockID() == t) {
                b = true;
                c = j;
            }
        }
        if (b) {
            double qty = Double.parseDouble(i.jTable1.getModel().getValueAt(c, 4).toString());
            double tot = Double.parseDouble(i.jTable1.getModel().getValueAt(c, 6).toString());
            double gtot = Double.parseDouble(i.jTable1.getModel().getValueAt(c, 8).toString());
            Vector v1 = new Vector();
            v1.add(il.getProductID());
            v1.add(il.getStockID());
            v1.add(il.getName());
            v1.add(il.getDescription());
            double dd = il.getQty() + qty;
            v1.add(dd);
            v1.add(il.getPrice());
            double as = il.getSubAmount() + tot;
            v1.add(as);
            v1.add(il.getDiscount() + "");
            v1.add(il.getGrandtot() + gtot);
            v = v1;
        } else {
            Vector v1 = new Vector();
            v1.add(il.getProductID());
            v1.add(il.getStockID());
            v1.add(il.getName());
            v1.add(il.getDescription());
            v1.add(il.getQty());
            v1.add(il.getPrice());
            v1.add(il.getSubAmount());
            v1.add(il.getDiscount() + "");
            v1.add(il.getGrandtot());
            v = v1;
        }
        load(c, b);

    }

    public void load(int t, boolean b) {
        try {
            DefaultTableModel dt = (DefaultTableModel) _INVONEW.jTable1.getModel();
            if (b) {
                dt.removeRow(t);
            }
            dt.addRow(v);
            _INVONEW.calGrandTot();
        } catch (Exception e) {
        }
    }

    public void getNames() {
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.Customer.class);
            cr.add(Restrictions.eq("idCustomer", CustomerID));
            BPos.DB.Customer c = (BPos.DB.Customer) cr.uniqueResult();
            _INVO.cusName.setText(c.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InvoicePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        subTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        grandTot = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Paid = new javax.swing.JTextField();
        balance = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        disc = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        DueAmount = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cusName = new javax.swing.JLabel();
        cusID = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        InvoicePanel.setBackground(new java.awt.Color(255, 255, 255));
        InvoicePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Stock ID", "Item Name", "Description", "Quantity", "Price", "Sub Total", "Discount ( %  )", "Grand Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Sub Total :");

        subTotal.setEditable(false);
        subTotal.setText("0.0");

        jLabel5.setText("Discount :");

        jLabel6.setText("Grand Total :");

        grandTot.setEditable(false);
        grandTot.setText("0.0");

        jLabel7.setText("Payment Type :");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Paid :");

        jLabel10.setText("Balance :");

        Paid.setText("0.0");
        Paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PaidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PaidKeyTyped(evt);
            }
        });

        balance.setEditable(false);
        balance.setText("0.0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("LKR");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("LKR");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("LKR");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("LKR");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("%");

        disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("LKR");

        jLabel14.setText("Due Amount :");

        DueAmount.setEditable(false);
        DueAmount.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel4))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(DueAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Paid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 165, Short.MAX_VALUE)
                            .addComponent(grandTot, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subTotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel12))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel13))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(balance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(disc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grandTot, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Paid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DueAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel17.setText("Customer :");

        jTextField8.setEditable(false);
        jTextField8.setText("       Add Customer");
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField8MousePressed(evt);
            }
        });
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextField9.setEditable(false);
        jTextField9.setText("      Add Products");
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        jTextField9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField9MousePressed(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel2.setText("Invoice Item Count :");

        jLabel3.setText("000");

        jButton2.setText("Remove Item");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BPos/Img/btn/data-recovery-64.png"))); // NOI18N
        jButton4.setText("Save");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cusName.setText(" ");

        jTextField10.setEditable(false);
        jTextField10.setText("          Qty Looing");
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        jTextField10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout InvoicePanelLayout = new javax.swing.GroupLayout(InvoicePanel);
        InvoicePanel.setLayout(InvoicePanelLayout);
        InvoicePanelLayout.setHorizontalGroup(
            InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InvoicePanelLayout.createSequentialGroup()
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InvoicePanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)
                        .addComponent(cusID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InvoicePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(cusName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
        );
        InvoicePanelLayout.setVerticalGroup(
            InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InvoicePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cusName))
                .addGap(18, 18, 18)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cusID)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InvoicePanelLayout.createSequentialGroup()
                    .addGap(498, 498, 498)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InvoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InvoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1016, 589));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        int opt = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to close the Window ?", "Warning", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTextField9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MousePressed

    }//GEN-LAST:event_jTextField9MousePressed

    private void jTextField8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MousePressed

    }//GEN-LAST:event_jTextField8MousePressed

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        Add_Customer_Invoice aci = new Add_Customer_Invoice(this);
        aci.setVisible(true);
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        Add_Invoice_Items aii = new Add_Invoice_Items(this);
        aii.setVisible(true);
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.removeRow(jTable1.getSelectedRow());
            calGrandTot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    static int invoI = 0;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {

            if (!subTotal.getText().equals("") && !subTotal.getText().equals("0.0")) {
                if (!grandTot.getText().equals("") && !grandTot.getText().equals("0.0")) {
                    if (!Paid.getText().equals("") && !Paid.getText().equals("0.0")) {

                        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                        String s[] = disc.getSelectedItem().toString().split("/ ");
                        String a[] = s[0].split("%");
                        int Discount = Integer.parseInt(a[0]);
                        Criteria cr = ses.createCriteria(BPos.DB.Discount.class);
                        cr.add(Restrictions.eq("value", Discount));
                        BPos.DB.Discount _dis = (BPos.DB.Discount) cr.uniqueResult();

                        String v[] = jComboBox1.getSelectedItem().toString().split("/ ");
                        String paymentType = v[0];
                        Criteria cr1 = ses.createCriteria(BPos.DB.PaymentType.class);
                        cr1.add(Restrictions.eq("typename", paymentType));
                        BPos.DB.PaymentType _paym = (BPos.DB.PaymentType) cr1.uniqueResult();

                        final BPos.DB.Invoice invoice = new BPos.DB.Invoice();

                        if (!cusID.getText().equals("")) {
                            BPos.DB.Customer cus = (BPos.DB.Customer) ses.load(BPos.DB.Customer.class, Integer.parseInt(cusID.getText()));
                            invoice.setCustomer(cus);
                        } else {
                            BPos.DB.Customer cus = (BPos.DB.Customer) ses.load(BPos.DB.Customer.class, 3);
                            invoice.setCustomer(cus);
                        }
                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        String date1 = sdf1.format(new Date());
                        invoice.setDateTime(date1 + "");
                        invoice.setTotalAmount(Double.parseDouble(grandTot.getText()));
                        invoice.setPaymentType(_paym);
                        invoice.setDiscount(_dis);
                        ses.save(invoice);
                        boolean b = false;
                        for (int i = 0; i < jTable1.getRowCount(); i++) {
                            int sid = Integer.parseInt(jTable1.getModel().getValueAt(i, 1).toString());
                            double qty = Double.parseDouble(jTable1.getModel().getValueAt(i, 4).toString());
                            BPos.DB.Stock stock = (BPos.DB.Stock) ses.load(BPos.DB.Stock.class, sid);
                            if (qty < stock.getQty() | qty == stock.getQty()) {
                                b = true;
                            } else {
                                jTable1.setRowSelectionInterval(i, i);
                                JOptionPane.showMessageDialog(rootPane, "Quentity problem");
                                b = false;
                            }
                        }

                        if (b) {
                            System.out.println("table size" + jTable1.getRowCount());
                            for (int i = 0; i < jTable1.getRowCount(); i++) {
                                Transaction tr = ses.beginTransaction();
                                int sid = Integer.parseInt(jTable1.getModel().getValueAt(i, 1).toString());
                                double qty = Double.parseDouble(jTable1.getModel().getValueAt(i, 4).toString());
                                double price = Double.parseDouble(jTable1.getModel().getValueAt(i, 5).toString());
                                double gp = Double.parseDouble(jTable1.getModel().getValueAt(i, 8).toString());

                                BPos.DB.Stock stock = (BPos.DB.Stock) ses.load(BPos.DB.Stock.class, sid);
                                System.out.println("Loop Siz");
                                BPos.DB.InvoiceItem IvI = new InvoiceItem();
                                IvI.setInvoice(invoice);
                                IvI.setQty(qty);
                                IvI.setStock(stock);
                                IvI.setSubtotal(gp);
                                IvI.setUnitPrice(price);

                                double d = stock.getQty();
                                double dd = d - qty;

                                stock.setQty(dd);

                                ses.save(IvI);
                                ses.update(stock);
                                tr.commit();
                                ses.flush();
                            }
                            Transaction trs = ses.beginTransaction();
                            BPos.DB.CustomerDue cusDue = new CustomerDue();
                            BPos.DB.Customer cus = (BPos.DB.Customer) ses.load(BPos.DB.Customer.class, Integer.parseInt(cusID.getText()));
                            cusDue.setCustomer(cus);
                            cusDue.setInvoice(invoice);
                            cusDue.setDueamount(Double.parseDouble(DueAmount.getText()));
                            cusDue.setTotal(Double.parseDouble(grandTot.getText()));

                            ses.save(cusDue);
                            trs.commit();
                            ses.flush();

                            int opt = JOptionPane.showConfirmDialog(rootPane, "Are you want print grn?", "Warning", JOptionPane.YES_NO_OPTION);
                            if (opt == 0) {
                                ses.doWork(new Work() {
                                    @Override
                                    public void execute(Connection cnctn) throws SQLException {
                                        try {
                                            Map<String, Object> params = new HashMap<String, Object>();
                                            params.put("InvoiceID", invoice.getIdInvoice());
                                            params.put("totamount", subTotal.getText());
                                            params.put("discount", disc.getSelectedItem() + "%");
                                            params.put("grandtot", grandTot.getText());
                                            params.put("paid", Paid.getText());
                                            params.put("balance", balance.getText());
                                            params.put("paymenttype", jComboBox1.getSelectedItem());
                                            Session ses1 = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                                            BPos.DB.Customer su = (BPos.DB.Customer) ses1.load(BPos.DB.Customer.class, CustomerID);
                                            params.put("customer", "bhagya");
                                            JasperReport jasperReport = JasperCompileManager.compileReport("Report/Invoice.jrxml");
                                            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, cnctn);
                                            JasperViewer.viewReport(jasperPrint, false);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                ClearTXT();
                                JOptionPane.showMessageDialog(rootPane, "payment success");
                                this.repaint();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "payment success");
                                ClearTXT();
                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "empty value");
                        Paid.setForeground(Color.red);
                        Paid.setCaretPosition(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "empty value");
                    grandTot.setForeground(Color.red);
                    grandTot.setCaretPosition(0);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "empty value");
                subTotal.setForeground(Color.red);
                subTotal.setCaretPosition(0);
            }
            //ClearTXT();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discActionPerformed
        try {

            double sub = Double.parseDouble(subTotal.getText());
            String s[] = disc.getSelectedItem().toString().split("/ ");
            String a[] = s[0].split("%");
            double di = Double.parseDouble(a[0]);

            double s1 = sub * di / 100;
            sub = sub - s1;
            grandTot.setText(sub + "");
            Paid.setText(sub + "");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_discActionPerformed

    private void PaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PaidKeyReleased
        try {
            if (!Paid.getText().equals("")) {
                Paid.setBackground(Color.WHITE);
                double d = Double.parseDouble(grandTot.getText());
                double f = Double.parseDouble(Paid.getText());
                if (d <= f) {
                    balance.setForeground(Color.black);
                    balance.setText(f - d + "");
                    DueAmount.setText("0.0");
                } else {
                    balance.setForeground(Color.red);
                    balance.setText("0.0");
                    DueAmount.setText(d - f + "");
                }
            } else {
                DueAmount.setText("0.0");
                Paid.setBackground(Color.red);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_PaidKeyReleased

    private void PaidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PaidKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_PaidKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ClearTXT();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int stcid = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());
        updateStock us = new updateStock(this, stcid, jTable1.getSelectedRow());
        us.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedItem().toString().equals("Debit         / 3")) {
            Paid.setText("0.00");
            Paid.setEditable(false);
            DueAmount.setText(grandTot.getText());
        } else {
            Paid.setEditable(true);
            Paid.setText(grandTot.getText());
            DueAmount.setText("0.00");
            balance.setText("0.00");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseClicked
        // TODO add your handling code here:
        new qty_l().setVisible(true);
    }//GEN-LAST:event_jTextField10MouseClicked

    private void jTextField10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10MousePressed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DueAmount;
    public javax.swing.JPanel InvoicePanel;
    private javax.swing.JTextField Paid;
    private javax.swing.JTextField balance;
    private javax.swing.JLabel cusID;
    private javax.swing.JLabel cusName;
    private javax.swing.JComboBox disc;
    private javax.swing.JTextField grandTot;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField subTotal;
    // End of variables declaration//GEN-END:variables

    public void loadTyps() {
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.PaymentType.class);
            List<BPos.DB.PaymentType> l = cr.list();
            jComboBox1.removeAllItems();
            for (BPos.DB.PaymentType l1 : l) {
                jComboBox1.addItem(l1.getTypename() + "         / " + l1.getIdPaymentType());
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
            disc.removeAllItems();
            for (Discount l1 : l) {
                disc.addItem(l1.getValue() + "%         / " + l1.getIdDiscount());
            }
            ses.flush();
            ses.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calGrandTot() {
        double tot = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            tot += Double.parseDouble(jTable1.getModel().getValueAt(i, 8).toString());
        }
        subTotal.setText(tot + "");
        grandTot.setText(tot + "");
        balance.setText("0.0");
        Paid.setText(tot + "");
    }

    public void ClearTXT() {
        grandTot.setText("0.0");
        subTotal.setText("0.0");
        Paid.setText("0.0");
        balance.setText("0.0");
        cusName.setText("");
        cusID.setText("");
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
    }

}
