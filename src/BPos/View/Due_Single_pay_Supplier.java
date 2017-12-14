/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import BPos.DB.Customerduerecords;
import BPos.DB.Supplierduerecords;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
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
 * @author Bhagya
 */
public class Due_Single_pay_Supplier extends javax.swing.JFrame {

    Settings _Settings;

    public Due_Single_pay_Supplier() {
        initComponents();
    }

    public Due_Single_pay_Supplier(int id, Settings s) {
        initComponents();
        _Settings = s;
        LoadData(id);
    }

    public void LoadData(int inID) {
        Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.SupplierDue.class);
        BPos.DB.Grn invo = (BPos.DB.Grn) ses.load(BPos.DB.Grn.class, inID);
        cr.add(Restrictions.eq("grn", invo));
        List<BPos.DB.SupplierDue> grn1 = cr.list();
        for (BPos.DB.SupplierDue in : grn1) {
            this._Customer.setText(in.getSupplier().getName());
            this._DueTXT.setText(in.getDueamount() + "");
            this._InvoiceTXT.setText(in.getGrn().getGrnId() + "");
        }
        ses.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        _balance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        _DueTXT = new javax.swing.JTextField();
        _InvoiceTXT = new javax.swing.JTextField();
        _Paid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        _Customer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pay");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        _balance.setEditable(false);
        _balance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                _balanceKeyTyped(evt);
            }
        });

        jLabel1.setText("Customer Due payment");

        jLabel6.setText("Balance  :");

        jLabel2.setText("Customer   :");

        _DueTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                _DueTXTKeyTyped(evt);
            }
        });

        _InvoiceTXT.setEditable(false);
        _InvoiceTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                _InvoiceTXTKeyTyped(evt);
            }
        });

        _Paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                _PaidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                _PaidKeyTyped(evt);
            }
        });

        jLabel4.setText("Due Amount :");

        jLabel3.setText("GRN ID  :");

        _Customer.setEditable(false);
        _Customer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                _CustomerKeyTyped(evt);
            }
        });

        jLabel5.setText("Paid  :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(_InvoiceTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(_DueTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(_Paid, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(_InvoiceTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(_DueTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(_Paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int _INVO_ID = Integer.parseInt(_InvoiceTXT.getText());

            if (!_Paid.getText().equals("")) {

                Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
                Transaction tr = ses.beginTransaction();
                Criteria cr = ses.createCriteria(BPos.DB.SupplierDue.class);
                final BPos.DB.Grn invo = (BPos.DB.Grn) ses.load(BPos.DB.Grn.class, _INVO_ID);
                cr.add(Restrictions.eq("grn", invo));
                BPos.DB.SupplierDue _Supplier_DUE = (BPos.DB.SupplierDue) cr.uniqueResult();

                double number = Double.parseDouble(_balance.getText());
                if (number < 0) {
                    _Supplier_DUE.setDueamount(Math.abs(number));
                } else if (number >= 0) {

                    _Supplier_DUE.setDueamount(0.0);
                }
                
                BPos.DB.Supplierduerecords cdr = new Supplierduerecords();
                cdr.setSupplierDue(_Supplier_DUE);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(new Date());
                cdr.setDatetime(date);
                cdr.setAmount(_Paid.getText());
                
                ses.save(cdr);
                
                ses.update(_Supplier_DUE);
                tr.commit();
                ses.flush();
            
                _Settings.Load_SUPLIER_Debit();
                this.dispose();
                
                int opt = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to print?", "Warning", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    ses.doWork(new Work() {
                        @Override
                        public void execute(Connection cnctn) throws SQLException {
                            try {
                                Map<String, Object> params = new HashMap<String, Object>();

                                params.put("InvoiceID", invo.getGrnId());
                                params.put("dueamount", _DueTXT.getText());
                                params.put("paid", _Paid.getText());
                                params.put("balance", _balance.getText());
                                params.put("due","0.0");
                                params.put("customer", invo.getSupplier().getName());

                                JasperReport jasperReport = JasperCompileManager.compileReport("Report/Supplier_Due.jrxml");

                                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, cnctn);

                                JasperViewer.viewReport(jasperPrint, false);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    JOptionPane.showMessageDialog(rootPane, "payment success");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "payment success");
                }
                ses.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void _balanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__balanceKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event__balanceKeyTyped

    private void _DueTXTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__DueTXTKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event__DueTXTKeyTyped

    private void _InvoiceTXTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__InvoiceTXTKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event__InvoiceTXTKeyTyped

    private void _PaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__PaidKeyReleased
        try {
            if (!_Paid.getText().equals("")) {
                _Paid.setBackground(Color.WHITE);
                double d = Double.parseDouble(_DueTXT.getText());
                double f = Double.parseDouble(_Paid.getText());

                if (d <= f) {
                    _balance.setForeground(Color.black);
                    _balance.setText(f - d + "");
                } else {
                    _balance.setForeground(Color.red);
                    _balance.setText(f - d + "");
                }
            } else {
                _Paid.setBackground(Color.red);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event__PaidKeyReleased

    private void _PaidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__PaidKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event__PaidKeyTyped

    private void _CustomerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event__CustomerKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '0' && c <= '9')) {
            evt.consume();
        }
    }//GEN-LAST:event__CustomerKeyTyped

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Due_Single_pay_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Due_Single_pay_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Due_Single_pay_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Due_Single_pay_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Due_Single_pay_Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField _Customer;
    private javax.swing.JTextField _DueTXT;
    private javax.swing.JTextField _InvoiceTXT;
    private javax.swing.JTextField _Paid;
    private javax.swing.JTextField _balance;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
