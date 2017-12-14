package BPos.View;

import BPos.DB.Customer;
import java.awt.Color;
import java.util.Vector;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class Add_Customer extends javax.swing.JFrame {

    private static String SelectedValue = "";

    public Add_Customer() {
        initComponents();
        String s[] = {"name", "mobile", "lanNo"};
        for (String s1 : s) {
            COMBO_SEARCH.addItem(s1);
        }
        loadCustomer();
        BTN_DELETE.setEnabled(false);
        BTN_UPDATE.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addCustomerMainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TEXT_SEARCH = new javax.swing.JTextField();
        COMBO_SEARCH = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TEXT_NAME = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TEXT_MOB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TEXT_Lan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TEXT_ADD1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TEXT_ADD2 = new javax.swing.JTextField();
        TEXT_ADD3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BTN_SAVE = new javax.swing.JButton();
        BTN_UPDATE = new javax.swing.JButton();
        BTN_DELETE = new javax.swing.JButton();
        BTN_SAVE1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        LAB_COUNT = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Customer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        addCustomerMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        addCustomerMainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        jLabel1.setText("Search By :");

        TEXT_SEARCH.setForeground(new java.awt.Color(204, 204, 204));
        TEXT_SEARCH.setText(" Search Customer");
        TEXT_SEARCH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TEXT_SEARCHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TEXT_SEARCHFocusLost(evt);
            }
        });
        TEXT_SEARCH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TEXT_SEARCHKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Basic Details"));

        jLabel4.setText("Name :");

        TEXT_NAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TEXT_NAMEFocusGained(evt);
            }
        });

        jLabel5.setText("Mobile No :");

        TEXT_MOB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TEXT_MOBFocusGained(evt);
            }
        });
        TEXT_MOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TEXT_MOBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TEXT_MOBKeyTyped(evt);
            }
        });

        jLabel6.setText("Lan No :");

        TEXT_Lan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TEXT_LanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TEXT_LanKeyTyped(evt);
            }
        });

        jLabel7.setText("Address 1 :");

        TEXT_ADD1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TEXT_ADD1FocusGained(evt);
            }
        });

        jLabel8.setText("Address 2 :");

        jLabel9.setText("Address 3 :");

        BTN_SAVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BPos/Img/btn/data-recovery-64.png"))); // NOI18N
        BTN_SAVE.setText("Save");
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

        BTN_SAVE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BPos/Img/btn/Reset S.png"))); // NOI18N
        BTN_SAVE1.setText("Clear");
        BTN_SAVE1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        BTN_SAVE1.setContentAreaFilled(false);
        BTN_SAVE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SAVE1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(TEXT_NAME, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(TEXT_ADD1)))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(TEXT_MOB, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(TEXT_ADD2)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel9)
                                .addGap(27, 27, 27)
                                .addComponent(TEXT_ADD3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(TEXT_Lan))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_SAVE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TEXT_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TEXT_MOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TEXT_Lan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TEXT_ADD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(TEXT_ADD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(TEXT_ADD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_SAVE1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Customer Count :");

        LAB_COUNT.setText("000");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cus ID", "Name", "Mobile", "Lan No", "Address 01", "Address 02", "Address 03"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout addCustomerMainPanelLayout = new javax.swing.GroupLayout(addCustomerMainPanel);
        addCustomerMainPanel.setLayout(addCustomerMainPanelLayout);
        addCustomerMainPanelLayout.setHorizontalGroup(
            addCustomerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(addCustomerMainPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(LAB_COUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(addCustomerMainPanelLayout.createSequentialGroup()
                .addGroup(addCustomerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCustomerMainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(COMBO_SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                        .addComponent(TEXT_SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addCustomerMainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(addCustomerMainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addCustomerMainPanelLayout.setVerticalGroup(
            addCustomerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCustomerMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addCustomerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(addCustomerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(COMBO_SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TEXT_SEARCH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addCustomerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LAB_COUNT))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addCustomerMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addCustomerMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1016, 588));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void TEXT_SEARCHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_SEARCHFocusGained

    }//GEN-LAST:event_TEXT_SEARCHFocusGained

    private void TEXT_SEARCHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_SEARCHFocusLost

    }//GEN-LAST:event_TEXT_SEARCHFocusLost

    private void BTN_SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SAVEActionPerformed
        try {
            if (!TEXT_NAME.getText().equals("") & !TEXT_MOB.getText().equals("") & !TEXT_Lan.getText().equals("") & !TEXT_ADD1.getText().equals("") & !TEXT_ADD2.getText().equals("") & !TEXT_ADD3.getText().equals("")) {
                if (2 < TEXT_NAME.getText().length()) {
                    if (2 < TEXT_ADD1.getText().length() & 2 < TEXT_ADD2.getText().length() & 2 < TEXT_ADD3.getText().length()) {
                        if (Com.execute.validation.Validation.isNumber(TEXT_MOB.getText())) {
                            if (Com.execute.validation.Validation.isNumber(TEXT_Lan.getText())) {
                                BPos.DB.Customer cus = new Customer();
                                cus.setName(TEXT_NAME.getText());
                                cus.setMobile(TEXT_MOB.getText());
                                cus.setLanNo(TEXT_Lan.getText());
                                cus.setAddress01(TEXT_ADD1.getText());
                                cus.setAddress02(TEXT_ADD2.getText());
                                cus.setAddress03(TEXT_ADD3.getText());
                                new BPos.Model.Customer().saveCustomer(cus);
                                clearTEXT();
                                loadCustomer();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "please enter valid Lan Number");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "please enter valid mobile number");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "please enter valid address. 2 + length");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "please enter valid name. 2 + length");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "empty field!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BTN_SAVEActionPerformed

    private void TEXT_MOBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_MOBKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_TEXT_MOBKeyTyped

    private void TEXT_LanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_LanKeyTyped
        char c = evt.getKeyChar();
            if (!(c >= '0' && c <= '9')) {
                evt.consume();
            }
    }//GEN-LAST:event_TEXT_LanKeyTyped

    private void TEXT_NAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_NAMEFocusGained

    }//GEN-LAST:event_TEXT_NAMEFocusGained

    private void TEXT_MOBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_MOBFocusGained

    }//GEN-LAST:event_TEXT_MOBFocusGained

    private void TEXT_ADD1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_ADD1FocusGained

    }//GEN-LAST:event_TEXT_ADD1FocusGained

    private void TEXT_SEARCHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_SEARCHKeyReleased
        try {
            if (TEXT_SEARCH.getText().equals("")) {
                loadCustomer();
            } else {
                Vector v1 = new Vector();
                DefaultTableModel dt = (DefaultTableModel) jTable2.getModel();
                Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(BPos.DB.Customer.class);
                cr.add(Restrictions.eq(COMBO_SEARCH.getSelectedItem().toString(), TEXT_SEARCH.getText()));
                List<BPos.DB.Customer> l = cr.list();
                dt.setRowCount(0);
                for (Customer l1 : l) {
//                    if(!l1.getStatus().equals(3)){
                    Vector v = new Vector();
                    v.add(l1.getIdCustomer());
                    v.add(l1.getName());
                    v.add(l1.getMobile());
                    v.add(l1.getLanNo());
                    v.add(l1.getAddress01());
                    v.add(l1.getAddress02());
                    v.add(l1.getAddress03());
                    v1.add(v);
//                    }
                }
                for (int i = 0; i < v1.size(); i++) {
                    Vector elementAt = (Vector) v1.elementAt(i);
                    dt.addRow(elementAt);
                }
                ses.close();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_TEXT_SEARCHKeyReleased

    private void BTN_UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_UPDATEActionPerformed
        try {
            try {
                if (!TEXT_NAME.getText().equals("") & !TEXT_MOB.getText().equals("") & !TEXT_Lan.getText().equals("") & !TEXT_ADD1.getText().equals("") & !TEXT_ADD2.getText().equals("") & !TEXT_ADD3.getText().equals("")) {
                    if (2 < TEXT_NAME.getText().length()) {
                        if (2 < TEXT_ADD1.getText().length() & 2 < TEXT_ADD2.getText().length() & 2 < TEXT_ADD3.getText().length()) {
                            if (Com.execute.validation.Validation.isNumber(TEXT_MOB.getText())) {
                                if (Com.execute.validation.Validation.isNumber(TEXT_Lan.getText())) {
                                    BPos.DB.Customer cus = new Customer();
                                    cus.setIdCustomer(Integer.parseInt(SelectedValue));
                                    cus.setName(TEXT_NAME.getText());
                                    cus.setMobile(TEXT_MOB.getText());
                                    cus.setLanNo(TEXT_Lan.getText());
                                    cus.setAddress01(TEXT_ADD1.getText());
                                    cus.setAddress02(TEXT_ADD2.getText());
                                    cus.setAddress03(TEXT_ADD3.getText());
                                    new BPos.Model.Customer().updateCustomer(cus);
                                    clearTEXT();
                                    loadCustomer();
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "please enter valid Lan Number");
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "please enter valid mobile number");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "please enter valid address. 2 + length");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "please enter valid name. 2 + length");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "empty field!");
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BTN_UPDATEActionPerformed

    private void BTN_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DELETEActionPerformed
        try {
            if (!SelectedValue.equals("")) {
                new BPos.Model.Customer().DeleteCustomer(Integer.parseInt(SelectedValue));
                loadCustomer();
                clearTEXT();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_DELETEActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            JTable target = (JTable) evt.getSource();
            BTN_SAVE.setEnabled(false);
            int selectedRow = target.getSelectedRow();
            int selectedColumn = target.getSelectedColumn();

            Object value = target.getValueAt(selectedRow, 0);
            SelectedValue = value.toString();
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.Customer.class);
            cr.add(Restrictions.eq("idCustomer", value));
            List<BPos.DB.Customer> cs = cr.list();
            for (Customer c : cs) {
                TEXT_NAME.setText(c.getName());
                TEXT_MOB.setText(c.getMobile());
                TEXT_Lan.setText(c.getLanNo());
                TEXT_ADD1.setText(c.getAddress01());
                TEXT_ADD2.setText(c.getAddress02());
                TEXT_ADD3.setText(c.getAddress03());
            }
            BTN_DELETE.setEnabled(true);
            BTN_UPDATE.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void BTN_SAVE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SAVE1ActionPerformed
        clearTEXT();
    }//GEN-LAST:event_BTN_SAVE1ActionPerformed

    private void TEXT_MOBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_MOBKeyReleased
        if (0 < TEXT_MOB.getText().length() & 10 == TEXT_MOB.getText().length()) {
            TEXT_MOB.setForeground(Color.BLACK);
        } else {
            TEXT_MOB.setForeground(Color.red);
        }
    }//GEN-LAST:event_TEXT_MOBKeyReleased

    private void TEXT_LanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_LanKeyReleased
        if (0 < TEXT_Lan.getText().length() & 10 == TEXT_Lan.getText().length()) {
            TEXT_Lan.setForeground(Color.black);
        }else{
            TEXT_Lan.setForeground(Color.red);
        }
    }//GEN-LAST:event_TEXT_LanKeyReleased

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
            java.util.logging.Logger.getLogger(Add_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Add_Customer dialog = new Add_Customer();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_DELETE;
    private javax.swing.JButton BTN_SAVE;
    private javax.swing.JButton BTN_SAVE1;
    private javax.swing.JButton BTN_UPDATE;
    private javax.swing.JComboBox COMBO_SEARCH;
    private javax.swing.JLabel LAB_COUNT;
    private javax.swing.JTextField TEXT_ADD1;
    private javax.swing.JTextField TEXT_ADD2;
    private javax.swing.JTextField TEXT_ADD3;
    private javax.swing.JTextField TEXT_Lan;
    private javax.swing.JTextField TEXT_MOB;
    private javax.swing.JTextField TEXT_NAME;
    private javax.swing.JTextField TEXT_SEARCH;
    public javax.swing.JPanel addCustomerMainPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    public void clearTEXT() {
        TEXT_ADD1.setText("");
        TEXT_ADD2.setText("");
        TEXT_ADD3.setText("");
        TEXT_Lan.setText("");
        TEXT_MOB.setText("");
        TEXT_NAME.setText("");
        BTN_SAVE.setEnabled(true);
        BTN_DELETE.setEnabled(false);
        BTN_UPDATE.setEnabled(false);
    }

    public void loadCustomer() {

        Vector v1 = new Vector();
        DefaultTableModel dt = (DefaultTableModel) jTable2.getModel();
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Customer.class);
        List<BPos.DB.Customer> l = cr.list();
        dt.setRowCount(0);
        for (Customer l1 : l) {
//            if(){
            Vector v = new Vector();
            v.add(l1.getIdCustomer());
            v.add(l1.getName());
            v.add(l1.getMobile());
            v.add(l1.getLanNo());
            v.add(l1.getAddress01());
            v.add(l1.getAddress02());
            v.add(l1.getAddress03());
            v1.add(v);
//        }
        }
        for (int i = 0; i < v1.size(); i++) {
            Vector elementAt = (Vector) v1.elementAt(i);
            dt.addRow(elementAt);
        }
        ses.close();
    }
}
