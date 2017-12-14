/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import BPos.DB.QtyType;
import BPos.Model.itemsList;
import java.awt.Color;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bhanuka
 */
public class Add_Grn_Items extends javax.swing.JFrame {

    public Add_Grn_Items() {
        initComponents();
        loadTypes();
    }
    Grn grn;

    public Add_Grn_Items(Grn g) {
        initComponents();
        grn = g;
        loadTypes();
    }
    Add_Grn_Items A_G_I;
    int productID;

    public Add_Grn_Items(Add_Grn_Items a, int Pid) {
        initComponents();
        A_G_I = a;
        productID = Pid;
        loadP(Pid, A_G_I);
        loadTypes();
    }

    public void loadP(int id, Add_Grn_Items ag) {
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            BPos.DB.Products p = (BPos.DB.Products) ses.load(BPos.DB.Products.class, id);
            ag.xtProduct.setText(p.getProName());
            ag.xtDescription.setText(p.getDescription());
            ag.itemcode.setText(p.getIdProducts() + "");
            ses.close();
        } catch (Exception e) {
        }
    }

    public void loadTypes() {
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.QtyType.class);
            List<BPos.DB.QtyType> l = cr.list();
            for (QtyType l1 : l) {
                QtyTypes.addItem(l1.getTypeName());
            }
            ses.close();
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        xtProduct = new javax.swing.JTextField();
        jbAdd = new javax.swing.JButton();
        xtSubAmt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        xtQty = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        xtDescription = new javax.swing.JTextField();
        jbNew = new javax.swing.JButton();
        xtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbAdd1 = new javax.swing.JButton();
        xtselling = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        itemcode = new javax.swing.JLabel();
        expireDate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        cloosing = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        QtyTypes = new javax.swing.JComboBox();
        Discount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Product :");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Sub Amount :");

        xtProduct.setBackground(new java.awt.Color(204, 204, 204));
        xtProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xtProduct.setFocusable(false);
        xtProduct.setRequestFocusEnabled(false);
        xtProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xtProductMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xtProductMousePressed(evt);
            }
        });
        xtProduct.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                xtProductMouseMoved(evt);
            }
        });
        xtProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtProductActionPerformed(evt);
            }
        });
        xtProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xtProductFocusGained(evt);
            }
        });
        xtProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xtProductKeyReleased(evt);
            }
        });

        jbAdd.setBackground(new java.awt.Color(255, 255, 255));
        jbAdd.setText("Add");
        jbAdd.setToolTipText("");
        jbAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        xtSubAmt.setEditable(false);
        xtSubAmt.setBackground(new java.awt.Color(204, 204, 204));
        xtSubAmt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        xtSubAmt.setText("0.00");
        xtSubAmt.setFocusable(false);
        xtSubAmt.setRequestFocusEnabled(false);
        xtSubAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtSubAmtActionPerformed(evt);
            }
        });
        xtSubAmt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xtSubAmtFocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Quantity :");

        xtQty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        xtQty.setText("0.00");
        xtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtQtyActionPerformed(evt);
            }
        });
        xtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xtQtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                xtQtyFocusLost(evt);
            }
        });
        xtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xtQtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                xtQtyKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Description :");

        xtDescription.setForeground(Color.gray);
        xtDescription.setBackground(new java.awt.Color(204, 204, 204));
        xtDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        xtDescription.setFocusable(false);
        xtDescription.setRequestFocusEnabled(false);
        xtDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xtDescriptionMouseClicked(evt);
            }
        });
        xtDescription.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                xtDescriptionMouseMoved(evt);
            }
        });
        xtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtDescriptionActionPerformed(evt);
            }
        });
        xtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xtDescriptionFocusGained(evt);
            }
        });
        xtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xtDescriptionKeyReleased(evt);
            }
        });

        jbNew.setText("Select Product");
        jbNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNew.setFocusable(false);
        jbNew.setRequestFocusEnabled(false);
        jbNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewActionPerformed(evt);
            }
        });

        xtPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        xtPrice.setText("0.00");
        xtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtPriceActionPerformed(evt);
            }
        });
        xtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xtPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                xtPriceFocusLost(evt);
            }
        });
        xtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xtPriceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xtPriceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                xtPriceKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Buying Price :");

        jbAdd1.setBackground(new java.awt.Color(255, 255, 255));
        jbAdd1.setText("Cancel");
        jbAdd1.setToolTipText("");
        jbAdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdd1ActionPerformed(evt);
            }
        });

        xtselling.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        xtselling.setText("0.00");
        xtselling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtsellingActionPerformed(evt);
            }
        });
        xtselling.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xtsellingFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                xtsellingFocusLost(evt);
            }
        });
        xtselling.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xtsellingKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xtsellingKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                xtsellingKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Selling Price :");

        jLabel9.setText("Expire Date :");

        cloosing.setText("Can Loosing?");

        jLabel10.setText("Discount :");

        Discount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscountActionPerformed(evt);
            }
        });
        Discount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DiscountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DiscountFocusLost(evt);
            }
        });
        Discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DiscountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DiscountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DiscountKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(xtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(xtProduct)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addGap(21, 21, 21)
                                .addComponent(Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(xtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(xtselling)
                                    .addComponent(xtQty, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(xtSubAmt, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbNew)
                            .addComponent(QtyTypes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(itemcode))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(expireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cloosing)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(xtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNew))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(xtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xtselling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(QtyTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xtSubAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(expireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cloosing))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(itemcode))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(491, 455));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void xtProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xtProductMouseClicked
    }//GEN-LAST:event_xtProductMouseClicked

    private void xtProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xtProductMousePressed

    }//GEN-LAST:event_xtProductMousePressed

    private void xtProductMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xtProductMouseMoved
    }//GEN-LAST:event_xtProductMouseMoved

    private void xtProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xtProductActionPerformed
    }//GEN-LAST:event_xtProductActionPerformed

    private void xtProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtProductFocusGained

        xtProduct.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_xtProductFocusGained

    private void xtProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtProductKeyReleased
    }//GEN-LAST:event_xtProductKeyReleased

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        try {
            if (!xtProduct.getText().equals("") & !xtDescription.getText().equals("")) {
                if (!xtPrice.getText().equals("0.00")) {
                    if (!xtQty.getText().equals("0.00") & !xtQty.getText().equals("")) {
                        if (!xtselling.getText().equals("0.00") & Integer.parseInt(xtPrice.getText()) < Integer.parseInt(xtselling.getText()) | Integer.parseInt(xtPrice.getText()) == Integer.parseInt(xtselling.getText())) {
                            BPos.Model.itemsList IL = new itemsList();
                            IL.setProductID(itemcode.getText());
                            IL.setName(xtProduct.getText());
                            IL.setDescription(xtDescription.getText());
                            IL.setPrice(Double.parseDouble(xtPrice.getText()));
                            IL.setQty(Double.parseDouble(xtQty.getText()));
                            IL.setSubAmount(Double.parseDouble(xtSubAmt.getText()));
                            IL.setSellingPrice(Double.parseDouble(xtselling.getText()));
                            IL.setExDate(expireDate.getDate());
                            
                            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                            Criteria cr = ses.createCriteria(BPos.DB.QtyType.class);
                            cr.add(Restrictions.eq("typeName", QtyTypes.getSelectedItem().toString()));
                            BPos.DB.QtyType qtyp = (BPos.DB.QtyType) cr.uniqueResult();
                            IL.setTypes(qtyp);
                            String val = "No";
                            if(cloosing.isSelected()){
                                val = "Yes";
                            }
                            IL.setCanLoosing(val);
                            IL.setDescount(Integer.parseInt(Discount.getText()));
                            
                            new Grn(grn, IL);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Selling price to low");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Enter valid qty");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Enter valid price");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Plese select product");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbAddActionPerformed

    private void xtSubAmtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtSubAmtFocusGained

        xtSubAmt.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_xtSubAmtFocusGained

    private void xtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xtQtyActionPerformed

    }//GEN-LAST:event_xtQtyActionPerformed

    private void xtQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtQtyFocusLost

    }//GEN-LAST:event_xtQtyFocusLost

    private void xtQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtQtyFocusGained

        xtQty.selectAll();
        xtQty.setBackground(Color.white);
        xtQty.setText(null);
    }//GEN-LAST:event_xtQtyFocusGained
    double p;
    double q;
    private void xtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtQtyKeyReleased

        if (!xtQty.getText().equals("")) {
            if (isNumber(xtPrice.getText())) {
                p = Double.parseDouble(xtPrice.getText());
            }
            if (isNumber(xtQty.getText())) {
                q = Double.parseDouble(xtQty.getText());
            }
        } else {
            xtSubAmt.setText(xtPrice.getText());
        }
        xtSubAmt.setText("");
        xtSubAmt.setText("" + p * q);
    }//GEN-LAST:event_xtQtyKeyReleased
    public static boolean isNumber(String num) {
        boolean b = false;
        try {

            int u = Integer.parseInt(num);
            b = true;
        } catch (Exception e) {
            b = false;
        }
        return b;
    }
    private void xtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtQtyKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0' && c <= '9') || (c == '.' && !xtQty.getText().contains(".")))) {
            evt.consume();
        }
    }//GEN-LAST:event_xtQtyKeyTyped

    private void xtDescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xtDescriptionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_xtDescriptionMouseClicked

    private void xtDescriptionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xtDescriptionMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_xtDescriptionMouseMoved

    private void xtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xtDescriptionActionPerformed

    private void xtDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtDescriptionFocusGained
        xtDescription.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_xtDescriptionFocusGained

    private void xtDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtDescriptionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_xtDescriptionKeyReleased

    private void jbNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewActionPerformed
        new SelectGRNItem(this).setVisible(true);
    }//GEN-LAST:event_jbNewActionPerformed

    private void xtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xtPriceActionPerformed

    }//GEN-LAST:event_xtPriceActionPerformed

    private void xtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtPriceFocusGained

    }//GEN-LAST:event_xtPriceFocusGained

    private void xtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtPriceFocusLost

    }//GEN-LAST:event_xtPriceFocusLost

    private void xtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtPriceKeyReleased
        xtSubAmt.setText(xtPrice.getText());
    }//GEN-LAST:event_xtPriceKeyReleased

    private void xtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtPriceKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_xtPriceKeyTyped

    private void xtSubAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xtSubAmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xtSubAmtActionPerformed

    private void xtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtPriceKeyPressed

    }//GEN-LAST:event_xtPriceKeyPressed

    private void jbAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAdd1ActionPerformed

    private void xtsellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xtsellingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xtsellingActionPerformed

    private void xtsellingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtsellingFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_xtsellingFocusGained

    private void xtsellingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtsellingFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_xtsellingFocusLost

    private void xtsellingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtsellingKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_xtsellingKeyPressed

    private void xtsellingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtsellingKeyReleased

    }//GEN-LAST:event_xtsellingKeyReleased

    private void xtsellingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtsellingKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_xtsellingKeyTyped

    private void DiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiscountActionPerformed

    private void DiscountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DiscountFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_DiscountFocusGained

    private void DiscountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DiscountFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_DiscountFocusLost

    private void DiscountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiscountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiscountKeyPressed

    private void DiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiscountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_DiscountKeyReleased

    private void DiscountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiscountKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_DiscountKeyTyped

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
            java.util.logging.Logger.getLogger(Add_Grn_Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Grn_Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Grn_Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Grn_Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Grn_Items().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Discount;
    private javax.swing.JComboBox QtyTypes;
    private javax.swing.JCheckBox cloosing;
    private com.toedter.calendar.JDateChooser expireDate;
    private javax.swing.JLabel itemcode;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbAdd1;
    private javax.swing.JButton jbNew;
    public javax.swing.JTextField xtDescription;
    public javax.swing.JTextField xtPrice;
    public javax.swing.JTextField xtProduct;
    private javax.swing.JTextField xtQty;
    private javax.swing.JTextField xtSubAmt;
    public javax.swing.JTextField xtselling;
    // End of variables declaration//GEN-END:variables
}
