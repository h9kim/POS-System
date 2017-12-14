///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package BPos.Model;
//
//import BPos.DB.Customer;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Bhagya
// */
//public class CustomerTest {
//    
//    public CustomerTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    /**
//     * Test of saveCustomer method, of class Customer.
//     */
//    @Test
//    public void testSaveCustomer() {
//        System.out.println("saveCustomer");
//        Customer c = new Customer();
//        c.setName("Amal");
//        c.setMobile("0719877862");
//        BPos.Model.Customer instance = new BPos.Model.Customer();
//        instance.saveCustomer(c);
//    }
//
//    @Test
//    public void testGetcustomer() {
//        System.out.println("getcustomer");
//        String mob = "0719877863";
//        BPos.Model.Customer instance = new BPos.Model.Customer();
//        Customer expResult = null;
//        Customer result = instance.getcustomer(mob);
//        assertEquals(mob, result.getMobile());
//    }
//    
//}
