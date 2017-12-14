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
public class Product {

    public static String saveProduct(BPos.DB.Products p) {
        String re = "";
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = ses.beginTransaction();
            ses.save(p);
            tr.commit();
            ses.flush();
            ses.close();
            re = "done";
        } catch (Exception e) {
            re = "error";
        }
        return re;
    }

    public static String updateProduct(BPos.DB.Products p,Session ses) {
        String re = "";
        try {
            Transaction tr = ses.beginTransaction();
            ses.update(p);
            tr.commit();
            ses.flush();
            ses.close();
            re = "done";
        } catch (Exception e) {
            re = "error";
        }
        return re;
    }

    public static String deleteProduct(int id) {
        String re = "";
        try {
            Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = ses.beginTransaction();
            BPos.DB.Products cus = (BPos.DB.Products) ses.load(BPos.DB.Products.class, id);
            cus.setStatus(0);
            ses.update(cus);
            tr.commit();
            ses.flush();
            ses.close();
            re = "done";
        } catch (Exception e) {
            re = "error";
        }
        return re;
    }

}
