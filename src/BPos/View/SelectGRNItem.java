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
public class SelectGRNItem extends javax.swing.JFrame {

    public SelectGRNItem() {
    }

    int SelectedValue;
    Add_Grn_Items A_G_I;

    public SelectGRNItem(Add_Grn_Items agi) {
        initComponents();
        String s[] = {"proName", "idProducts", "barcode"};
        for (String s1 : s) {
            jComboBox1.addItem(s1);
        }
        loadproduct();
        A_G_I = agi;
    }

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
            v.add(l1.getProItrmCode());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TEXT_SEARCh = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Add Item");

        jLabel2.setText("Search by : ");

        jButton1.setText("Cancel");

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Size", "Name", "Description"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        TEXT_SEARCh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TEXT_SEARChKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TEXT_SEARCh))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TEXT_SEARCh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Add_Grn_Items(A_G_I, SelectedValue);
        this.dispose();
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
                    } else {
                        cr.add(Restrictions.eq(jComboBox1.getSelectedItem().toString(), TEXT_SEARCh.getText().toString()));
                    }
                    List<BPos.DB.Products> l = cr.list();
                    dt.setRowCount(0);
                    for (BPos.DB.Products l1 : l) {
                        Vector v = new Vector();
                        v.add(l1.getIdProducts());
                        v.add(l1.getProItrmCode());
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
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        new SelectGRNItem().setVisible(true);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectGRNItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectGRNItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectGRNItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectGRNItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TEXT_SEARCh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
