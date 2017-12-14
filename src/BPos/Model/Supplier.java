/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.Model;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bhagya
 */
public class Supplier {

    public static String saveSupplier(BPos.DB.Supplier sup) {
        String reval = "";
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = ses.beginTransaction();
            ses.save(sup);
            tr.commit();
            ses.flush();
            ses.close();
            reval = "done";
        } catch (Exception e) {
            reval = "error";
        }
        return reval;
    }

    public static String updateSupplier(BPos.DB.Supplier c) {
        String val = "";
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = ses.beginTransaction();
            ses.update(c);
            tr.commit();
            ses.flush();
            ses.close();
            val = "done";
        } catch (Exception e) {
            val = "Error";
        }
        return val;
    }

    public static String DeleteSupplier(int id) {
        String val = "";
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = ses.beginTransaction();
            BPos.DB.Supplier cus = (BPos.DB.Supplier) ses.load(BPos.DB.Supplier.class, id);
            cus.setStatus(3);
            ses.update(cus);
            tr.commit();
            ses.flush();
            ses.close();
            val = "done";
        } catch (Exception e) {
            val = "Error";
        }
        return val;
    }

}
