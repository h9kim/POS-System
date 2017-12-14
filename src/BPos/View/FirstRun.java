/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import java.io.File;

/**
 *
 * @author Bhagya
 */
public class FirstRun {

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                File f = new File("C:\\ProgramData\\WindowsLog.adxl");

                Login l = new Login();
                   l.setVisible(true);

//                if (f.exists()) {
//                    Login l = new Login();
//                    l.setVisible(true);
//                } else {
//                    CreateAccount c = new CreateAccount();
//                    c.setVisible(true);
//                }
            }
        });

    }
}
