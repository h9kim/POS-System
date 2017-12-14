package BPos.Model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bhagya
 */
public class Customer {

    Session ses;

    public Customer() {
        ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
    }

    public BPos.DB.Customer getcustomer(String mob) {
        BPos.DB.Customer c = null;
        try {
            Criteria cr = ses.createCriteria(BPos.DB.Customer.class);
            cr.add(Restrictions.eq("mobile", mob));
            c = (BPos.DB.Customer) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void saveCustomer(BPos.DB.Customer c) {
        try {
            Transaction tr = ses.beginTransaction();
            ses.save(c);
            tr.commit();
            ses.flush();
            ses.close();
        } catch (Exception e) {
        }
    }

    public void updateCustomer(BPos.DB.Customer c) {
        try {
            Transaction tr = ses.beginTransaction();
            ses.update(c);
            tr.commit();
            ses.flush();
            ses.close();
        } catch (Exception e) {
        }
    }

    public void DeleteCustomer(int id) {
        try {
            Transaction tr = ses.beginTransaction();
            BPos.DB.Customer cus = (BPos.DB.Customer) ses.load(BPos.DB.Customer.class, id);
            cus.setStatus(3);
            ses.update(cus);
            tr.commit();
            ses.flush();
            ses.close();
        } catch (Exception e) {
        }
    }
}
