/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import BPos.DB.Discount;
import BPos.DB.Products;
import BPos.DB.QtyType;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bhagya
 */
public class Add_Product extends javax.swing.JFrame {

    /**
     * Creates new form Add_Product
     */
    public String SelectesValue;

    public Add_Product() {
        initComponents();
        loadProduct();
        String s[] = {"proName", "barcode"};
        for (String s1 : s) {
            Search_By.addItem(s1);
        }
        BTN_DELETE.setEnabled(false);
        BTN_UPDATE.setEnabled(false);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddCusPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Search_By = new javax.swing.JComboBox();
        TEXT_SEARCH = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TEXT_NAME = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TEXT_DESCRI = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BTN_SAVE = new javax.swing.JButton();
        BTN_UPDATE = new javax.swing.JButton();
        BTN_DELETE = new javax.swing.JButton();
        Vector model = new Vector();
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.QtyType.class);
        List <BPos.DB.QtyType> ll = cr.list();
        for (QtyType ll1 : ll) {
            model.addElement( new Data(ll1.getIdQtyType(), ll1.getTypeName() ) );
        }
        CATEGORY = new javax.swing.JComboBox(model);
        TEXT_BARCODE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        size = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        AddCusPanel.setBackground(new java.awt.Color(255, 255, 255));
        AddCusPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        jLabel1.setText("Search By :");

        TEXT_SEARCH.setForeground(new java.awt.Color(204, 204, 204));
        TEXT_SEARCH.setText(" Search Products");
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Barcode", "Name", "Description", "Qty Type", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(204, 204, 255));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Basic Details"));

        jLabel5.setText("Pro Name :");

        jLabel6.setText("Description :");

        jLabel9.setText("Qty Type :");

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

        CATEGORY.setRenderer( new ItemRenderer() );

        jLabel7.setText("Barcode   :");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BPos/Img/btn/Reset S.png"))); // NOI18N
        jButton4.setText("Clear");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Size :");

        size.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sizeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TEXT_NAME)
                    .addComponent(TEXT_BARCODE, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel6)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CATEGORY, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TEXT_DESCRI, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BTN_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BTN_UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BTN_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TEXT_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TEXT_DESCRI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(CATEGORY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(TEXT_BARCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setText("Product Count :");

        jLabel3.setText("000");

        javax.swing.GroupLayout AddCusPanelLayout = new javax.swing.GroupLayout(AddCusPanel);
        AddCusPanel.setLayout(AddCusPanelLayout);
        AddCusPanelLayout.setHorizontalGroup(
            AddCusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(AddCusPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AddCusPanelLayout.createSequentialGroup()
                .addGroup(AddCusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddCusPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Search_By, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TEXT_SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddCusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(AddCusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AddCusPanelLayout.setVerticalGroup(
            AddCusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddCusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Search_By, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TEXT_SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(AddCusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddCusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddCusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1016, 588));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TEXT_SEARCHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_SEARCHFocusLost

    }//GEN-LAST:event_TEXT_SEARCHFocusLost

    private void TEXT_SEARCHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_SEARCHFocusGained

    }//GEN-LAST:event_TEXT_SEARCHFocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void BTN_SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SAVEActionPerformed

        if (!TEXT_NAME.getText().equals("") & 2 < TEXT_NAME.getText().length()) {
            if (!TEXT_DESCRI.getText().equals("") & 2 < TEXT_DESCRI.getText().length()) {
                if (!TEXT_BARCODE.getText().equals("") & 2 < TEXT_BARCODE.getText().length()) {
                    if (!CATEGORY.getSelectedItem().toString().equals("")) {

                        try {

                            BPos.DB.Products p = new Products();
                            p.setProItrmCode(size.getText());
                            p.setProName(TEXT_NAME.getText());
                            p.setDescription(TEXT_DESCRI.getText());
                            p.setBarcode(TEXT_BARCODE.getText());
                            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                            Data item = (Data)CATEGORY.getSelectedItem();
                            BPos.DB.QtyType qtyp = (BPos.DB.QtyType) ses.load(BPos.DB.QtyType.class, item.getId());
                            Discount sd = (Discount) ses.load(BPos.DB.Discount.class, 1);
                            p.setDiscount(sd);
                            p.setQtyType(qtyp);
                            p.setStatus(1);
                            ses.close();
                            String re = BPos.Model.Product.saveProduct(p);
                            if (re.equals("done")) {
                                loadProduct();
                                clearTEXT();
                                JOptionPane.showMessageDialog(rootPane, "Save Done!");
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Save Error!");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Please select catrgory");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please enter valid barcode");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please enter valid description");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please enter valid name");
        }

    }//GEN-LAST:event_BTN_SAVEActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            JTable target = (JTable) evt.getSource();

            int selectedRow = target.getSelectedRow();
            int selectedColumn = target.getSelectedColumn();
            BTN_SAVE.setEnabled(false);
            Object value = target.getValueAt(selectedRow, 0);
            SelectesValue = value.toString();
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.Products.class);
            cr.add(Restrictions.eq("idProducts", value));
            List<BPos.DB.Products> cs = cr.list();
            for (BPos.DB.Products c : cs) {
                TEXT_NAME.setText(c.getProName());
                TEXT_BARCODE.setText(c.getBarcode());
                TEXT_DESCRI.setText(c.getDescription());
                setSelectedValue(CATEGORY, c.getQtyType().getIdQtyType());
                size.setText(c.getProItrmCode());

            }
            BTN_DELETE.setEnabled(true);
            BTN_UPDATE.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked
public static void setSelectedValue(JComboBox comboBox, int value)
    {
        Data item;
        for (int i = 0; i < comboBox.getItemCount(); i++)
        {
            item = (Data)comboBox.getItemAt(i);
            if (item.getId() == value)
            {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
    private void BTN_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DELETEActionPerformed
        try {
            if (!SelectesValue.equals("")) {
                String s = new BPos.Model.Product().deleteProduct(Integer.parseInt(SelectesValue));
                if (s.equals("done")) {
                    loadProduct();
                    clearTEXT();
                    //status upate wenna hadanna ona
                    JOptionPane.showMessageDialog(rootPane, "ok");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "error");
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BTN_DELETEActionPerformed

    private void BTN_UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_UPDATEActionPerformed

        if (!TEXT_NAME.getText().equals("") & 2 < TEXT_NAME.getText().length()) {
            if (!TEXT_DESCRI.getText().equals("") & 2 < TEXT_DESCRI.getText().length()) {
                if (!TEXT_BARCODE.getText().equals("") & 2 < TEXT_BARCODE.getText().length()) {
                    if (!CATEGORY.getSelectedItem().toString().equals("")) {
                        try {

                            BPos.DB.Products p = new Products();
                            p.setIdProducts(Integer.parseInt(SelectesValue));
                            p.setProItrmCode(size.getText());
                            p.setProName(TEXT_NAME.getText());
                            p.setDescription(TEXT_DESCRI.getText());
                            p.setBarcode(TEXT_BARCODE.getText());

                            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                            Data item = (Data)CATEGORY.getSelectedItem();
                            BPos.DB.QtyType qtyp = (BPos.DB.QtyType) ses.load(BPos.DB.QtyType.class, item.getId());
                            Discount sd = (Discount) ses.load(BPos.DB.Discount.class, 1);
                            p.setDiscount(sd);
                            p.setQtyType(qtyp);
                            p.setStatus(1);
                            String re = BPos.Model.Product.updateProduct(p, ses);
                            if (re.equals("done")) {
                                loadProduct();
                                clearTEXT();
                                JOptionPane.showMessageDialog(rootPane, "Update Done!");
                                
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Update Error!");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Please enter valid barcode");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please enter valid barcode");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please enter valid name");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please enter valid name");
        }


    }//GEN-LAST:event_BTN_UPDATEActionPerformed

    private void TEXT_SEARCHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_SEARCHKeyReleased
        try {
            if (TEXT_SEARCH.getText().equals("")) {
                loadProduct();
            } else {
                Vector v1 = new Vector();
                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                Criteria cr = ses.createCriteria(BPos.DB.Products.class);
                cr.add(Restrictions.eq(Search_By.getSelectedItem().toString(), TEXT_SEARCH.getText()));
                List<BPos.DB.Products> l = cr.list();
                dt.setRowCount(0);
                for (Products l1 : l) {
                    Vector v = new Vector();
                    v.add(l1.getIdProducts());
                    v.add(l1.getProItrmCode());
                    v.add(l1.getBarcode());
                    v.add(l1.getProName());
                    v.add(l1.getDescription());
                    v.add(l1.getQtyType().getTypeName());
                    v.add(l1.getProItrmCode());
                    v1.add(v);
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
    }//GEN-LAST:event_TEXT_SEARCHKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearTEXT();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void sizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sizeKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0' && c <= '9') || (c == '.' && !size.getText().contains(".")))) {
            evt.consume();
        }
    }//GEN-LAST:event_sizeKeyTyped

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
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Product().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel AddCusPanel;
    private javax.swing.JButton BTN_DELETE;
    private javax.swing.JButton BTN_SAVE;
    private javax.swing.JButton BTN_UPDATE;
    private javax.swing.JComboBox CATEGORY;
    private javax.swing.JComboBox Search_By;
    private javax.swing.JTextField TEXT_BARCODE;
    private javax.swing.JTextField TEXT_DESCRI;
    private javax.swing.JTextField TEXT_NAME;
    private javax.swing.JTextField TEXT_SEARCH;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField size;
    // End of variables declaration//GEN-END:variables

    public void loadProduct() {

        Vector v1 = new Vector();
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Products.class);
        cr.add(Restrictions.eq("status", 1));
        List<BPos.DB.Products> l = cr.list();
        dt.setRowCount(0);
        for (Products l1 : l) {
            Vector v = new Vector();
            v.add(l1.getIdProducts());
            v.add(l1.getBarcode());
            v.add(l1.getProName());
            v.add(l1.getDescription());
            v.add(l1.getQtyType().getTypeName());
            v.add(l1.getProItrmCode());
            v1.add(v);
        }
        for (int i = 0; i < v1.size(); i++) {
            Vector elementAt = (Vector) v1.elementAt(i);
            dt.addRow(elementAt);
        }
        ses.close();
    }

    public void clearTEXT() {
        TEXT_BARCODE.setText("");
        TEXT_DESCRI.setText("");
        TEXT_NAME.setText("");
        size.setText("");
        BTN_DELETE.setEnabled(false);
        BTN_UPDATE.setEnabled(false);
        BTN_SAVE.setEnabled(true);
    }

}
