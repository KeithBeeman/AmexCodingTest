/*
 * This package tests customer orders.
 */

import CustomerOrder.Order;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Keith
 */
public class CustomerOrderTest {
   
    private static Order customerOrder;
    
    public CustomerOrderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        customerOrder = new Order();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        customerOrder = new Order();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test_CustomerOrderEmpty() {
       
        System.out.println("test_CustomerOrderEmpty");
        assertFalse(customerOrder == null);
        assertTrue(customerOrder.numberItems() == 0);
        
    }
    
    
    @Test
    public void test_CustomerOrderNew() {
       
        System.out.println("test_CustomerOrderNew");
        customerOrder.newOrder();
        assertTrue(customerOrder.numberItems() == 0);
        
    }

    @Test
    public void test_CustomerOrderAdd() {
       
        System.out.println("test_CustomerOrderAdd");
        customerOrder.newOrder();
        customerOrder.addItem("book", 1);
        assertTrue(customerOrder.numberItems() == 1);
        
    }
    
    @Test
    public void test_CustomerOrderAddFail() {
       
        System.out.println("test_CustomerOrderAddFail");
        customerOrder.newOrder();
        customerOrder.addItem("books", 1);
        assertTrue(customerOrder.numberItems() == 0);
        
    }
       
    @Test
    public void test_CustomerOrderMultipleAdd() {
       
        System.out.println("test_CustomerOrderMultipleAdd");
        customerOrder.newOrder();
        customerOrder.addItem("book", 1);
        customerOrder.addItem("music CD", 1);
        assertTrue(customerOrder.numberItems() == 2);
        
    }
    
           
    @Test
    public void test_CustomerOrderMultipleAddFail() {
       
        System.out.println("test_CustomerOrderMultipleAdd");
        customerOrder.newOrder();
        customerOrder.addItem("books", 3);
        customerOrder.addItem("music CD", 1);
        assertTrue(customerOrder.numberItems() == 1);
            
    }
    
}
