/*
 * This package tests the Data Access Layer. 
 */

import DAL.databaseSim;
import SaleItem.Item;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Keith
 * DatabaseSim JUnit Tests
 * 
 */
public class DALTest {
    
    private databaseSim DB;
    
    public DALTest() {
        DB = new databaseSim();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test_GetProductNull() {
       
        System.out.println("test_GetProductNull");
        assertTrue(DB.GetProduct(null) == null);
    } 
    
    @Test
    public void test_GetProductMissing() {
       
        System.out.println("test_GetProductMissing");
        assertTrue(DB.GetProduct("NotThere") == null);
    } 
    
    @Test
    public void test_GetProductExists() {
       
        System.out.println("test_GetProductExists");
        assertTrue(DB.GetProduct("book") != null);
    } 

    @Test
    public void test_GetProductClearAll() {
       
        final String name = "book";
        
        System.out.println("test_GetProductClearAll");
        assertTrue(DB.GetProduct(name) != null);
        DB.ClearProducts();
        assertTrue(DB.GetProduct(name) == null);
    } 

    @Test
    public void test_GetProductAddProduct() {
       
        final String name = "Keith Beeman";
        
        System.out.println("test_GetProductAddProduct");
        DB.ClearProducts();
        assertTrue(DB.GetProduct(name) == null);
        DB.AddProduct(new Item(name, 100, true, true));
        assertTrue(DB.GetProduct(name) != null);
    } 

    @Test
    public void test_GetProductRemoveProduct() {
       
        final String name = "Keith Beeman";
        
        Item kb = new Item(name, 100, true, true);
        
        System.out.println("test_GetProductRemoveProduct");
        DB.ClearProducts();
        DB.AddProduct(kb);
        assertTrue(DB.GetProduct(name) != null);
        DB.DeleteProduct(kb);
        assertTrue(DB.GetProduct(name) == null);
    } 

    @Test
    public void test_GetProductReAddProduct() {
       
        final String name = "Keith Beeman";
        
        Item kb = new Item(name, 100, true, true);
        
        System.out.println("test_GetProductReAddProduct");
        DB.ClearProducts();
        DB.AddProduct(kb);
        assertTrue(DB.GetProduct(name) != null);
        DB.AddProduct(kb);
        assertTrue(DB.GetProduct(name) != null);
        DB.DeleteProduct(kb);
        assertTrue(DB.GetProduct(name) == null);
    }     
    
}
