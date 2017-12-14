/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import BPos.DB.Customer;
import BPos.DB.GrnItem;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bhagya
 */
public class GRN_Returns extends javax.swing.JFrame {

    public GRN_Returns() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        TEXT_SEARCH = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        LAB_COUNT = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tot = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Grn Item ID", "Product Name", "Buying Price", "Selling Price", "Qty", "Sub Total", "Available Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        TEXT_SEARCH.setForeground(new java.awt.Color(204, 204, 204));
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TEXT_SEARCHKeyTyped(evt);
            }
        });

        title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        title.setText("GRN ID : ");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LAB_COUNT.setText("000");

        jLabel2.setText("Customer Count :");

        tot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Total :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(LAB_COUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(title)
                        .addGap(18, 18, 18)
                        .addComponent(TEXT_SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TEXT_SEARCH)
                    .addComponent(title)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(LAB_COUNT))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            int grnid = Integer.parseInt(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1).toString());
            int pid = Integer.parseInt(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0).toString());
            double qty = Double.parseDouble(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 4).toString());
            double AvBle = Double.parseDouble(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 7).toString());
            String pnm = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 2).toString();
            int grnID = Integer.parseInt(TEXT_SEARCH.getText());
            Update up = new Update(grnid, pid, qty, pnm, this, grnID, AvBle);
            up.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void TEXT_SEARCHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_SEARCHFocusGained

    }//GEN-LAST:event_TEXT_SEARCHFocusGained

    private void TEXT_SEARCHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TEXT_SEARCHFocusLost

    }//GEN-LAST:event_TEXT_SEARCHFocusLost

    private void TEXT_SEARCHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_SEARCHKeyReleased
        try {
            if (!TEXT_SEARCH.getText().equals("")) {
                _LoadGrn();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_TEXT_SEARCHKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (!TEXT_SEARCH.getText().equals("")) {
                _LoadGrn();
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TEXT_SEARCHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_SEARCHKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();

        }
    }//GEN-LAST:event_TEXT_SEARCHKeyTyped

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
            java.util.logging.Logger.getLogger(Invoice_Returns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice_Returns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice_Returns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice_Returns.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GRN_Returns().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LAB_COUNT;
    private javax.swing.JTextField TEXT_SEARCH;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel title;
    private javax.swing.JLabel tot;
    // End of variables declaration//GEN-END:variables

    public void _LoadGrn() {
        Vector v1 = new Vector();
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        BPos.DB.Grn grn = (BPos.DB.Grn) ses.load(BPos.DB.Grn.class, Integer.parseInt(TEXT_SEARCH.getText()));
        Criteria cr = ses.createCriteria(BPos.DB.GrnItem.class);
        DefaultTableModel dt = (DefaultTableModel) jTable2.getModel();
        cr.add(Restrictions.eq("grn", grn));

        dt.setRowCount(0);
        double count = 0;
        List<BPos.DB.GrnItem> grni = cr.list();
        for (BPos.DB.GrnItem grni1 : grni) {
            Vector v = new Vector();
            v.add(grni1.getProducts().getIdProducts());
            v.add(grni1.getIdGrnItem());
            v.add(grni1.getProducts().getProName());
            v.add(grni1.getUnitPrice());
            v.add(grni1.getSellingPrice());
            v.add(grni1.getQty());
            v.add(grni1.getSubTotal());

            Criteria ccr = ses.createCriteria(BPos.DB.Stock.class);
            ccr.add(Restrictions.eq("idstock", grni1.getIdGrnItem()));
            List<BPos.DB.Stock> stk = ccr.list();
            for (BPos.DB.Stock stk1 : stk) {
                v.add(stk1.getQty());
            }
            v.add(grni1.getStock().getQty());
            // count += grni1.getGrn().getTotalAmount();
            v1.add(v);
        }
        for (int i = 0; i < v1.size(); i++) {
            Vector elementAt = (Vector) v1.elementAt(i);
            dt.addRow(elementAt);
        }

        tot.setText(grn.getTotalAmount() + "");
        ses.close();
    }

}
