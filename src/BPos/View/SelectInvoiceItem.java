/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import java.util.List;
import java.util.Vector;
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
public class SelectInvoiceItem extends javax.swing.JFrame {

    int SelectedValue = 0;
    int stkid = 0;

    public SelectInvoiceItem() {
        initComponents();
    }
    Add_Invoice_Items a_I_I;

    public SelectInvoiceItem(Add_Invoice_Items agi) {
        initComponents();
        String s[] = {"proName", "idProducts", "barcode"};
        for (String s1 : s) {
            jComboBox1.addItem(s1);
        }
        loadproduct();
        a_I_I = agi;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TEXT_SEARCh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TEXT_SEARCh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TEXT_SEARChKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Add Item");

        jLabel2.setText("Search by : ");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Select Price :- ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TEXT_SEARCh))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TEXT_SEARCh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            if (jComboBox2.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "out of stock!!");
            } else {
                String a = "";
                String[] s = jComboBox2.getSelectedItem().toString().split("Stock ID :- ");
                for (int i = 0; i < s.length; i++) {
                    String s1 = s[i];
                    a += s1;
                }
                String x[] = a.split(" / Price");
                stkid = Integer.parseInt(x[0]);
                Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                BPos.DB.Stock ss = (BPos.DB.Stock) ses.load(BPos.DB.Stock.class, stkid);
                if(!(ss.getQty()==0)){
                new Add_Invoice_Items(a_I_I, SelectedValue, stkid, SelectedValue);
                this.dispose();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "out of stock!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TEXT_SEARChKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEXT_SEARChKeyReleased
        try {
            if (!jComboBox1.getSelectedItem().toString().equals("")) {
                if (!TEXT_SEARCh.getText().toString().equals("")) {
                    Vector v1 = new Vector();
                    DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                    Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                    Criteria cr = ses.createCriteria(BPos.DB.Products.class);
                    if (jComboBox1.getSelectedItem().toString().equals("idProducts")) {
                        cr.add(Restrictions.eq(jComboBox1.getSelectedItem().toString(), Integer.parseInt(TEXT_SEARCh.getText().toString())));
                        // cr.add(Restrictions.le("", ""));
                    } else {
                        cr.add(Restrictions.eq(jComboBox1.getSelectedItem().toString(), TEXT_SEARCh.getText().toString()));
                        //cr.add(Restrictions.le("", ""));
                    }
                    List<BPos.DB.Products> l = cr.list();
                    dt.setRowCount(0);
                    for (BPos.DB.Products l1 : l) {
                        Vector v = new Vector();
                        v.add(l1.getIdProducts());
                        v.add(l1.getProName());
                        v.add(l1.getDescription());
                        v1.add(v);
                    }
                    for (int i = 0; i < v1.size(); i++) {
                        Vector elementAt = (Vector) v1.elementAt(i);
                        dt.addRow(elementAt);
                    }
                    ses.close();
                } else {
                    loadproduct();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "please select search option");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_TEXT_SEARChKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        JTable target = (JTable) evt.getSource();
        int selectedRow = target.getSelectedRow();
        int selectedColumn = target.getSelectedColumn();

        Object value = target.getValueAt(selectedRow, 0);
        SelectedValue = Integer.parseInt(value.toString());
        jComboBox2.removeAllItems();
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(BPos.DB.Stock.class);

            BPos.DB.Products p = (BPos.DB.Products) ses.load(BPos.DB.Products.class, SelectedValue);
            cr.add(Restrictions.eq("products", p));
            List<BPos.DB.Stock> s = cr.list();
            for (BPos.DB.Stock s1 : s) {
                int t = s1.getStatus();
                if (t == 1) {
                    jComboBox2.addItem("Stock ID :- " + s1.getIdstock() + " / Price :- " + s1.getSellingPrice() + " / Available :- " + s1.getQty());
                } else if (t == 4) {
//                  JOptionPane.showMessageDialog(rootPane, "this product expired");  
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SelectInvoiceItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectInvoiceItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectInvoiceItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectInvoiceItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectInvoiceItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TEXT_SEARCh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void loadproduct() {

        Vector v1 = new Vector();
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.Products.class);
        List<BPos.DB.Products> l = cr.list();
        dt.setRowCount(0);
        for (BPos.DB.Products l1 : l) {
            Vector v = new Vector();
            v.add(l1.getIdProducts());
            v.add(l1.getProName());
            v.add(l1.getDescription());
            v1.add(v);
        }
        for (int i = 0; i < v1.size(); i++) {
            Vector elementAt = (Vector) v1.elementAt(i);
            dt.addRow(elementAt);
        }
        ses.close();
    }

}
