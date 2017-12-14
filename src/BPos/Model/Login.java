/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.Model;

import java.io.IOException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bhagya
 */
public class Login {

    Session ses;

    public Login() {
        ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
    }

    public String Login(String username, String password) {
        String message = "";
        try {
            
            Criteria cr = ses.createCriteria(BPos.DB.UserLogin.class);
            cr.add(Restrictions.eq("userName", username));
            cr.add(Restrictions.eq("password", password));
            cr.add(Restrictions.eq("status", 1));
            BPos.DB.UserLogin ul = (BPos.DB.UserLogin) cr.uniqueResult();
            if (ul == null) {
                message = "login error please contact admin!";
            } else {
                message = "login ok";
            }

        } catch (Exception e) {
        }
        return message;
    }
}
