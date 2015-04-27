/*
 * This package tests the SalesItems.
 */

import SaleItem.Item;
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
public class SaleItemTest {
    
    private Item Product;
    
    public SaleItemTest() {
        
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
    public void test_SaleItemNull() {
       
        System.out.println("test_SaleItemNull");
        assertTrue(Product == null);
    }

  
    @Test
    public void test_SaleItemName() {
       
        String currentName = "TestProduct";
        String newName = "Changed";
        Item testProduct = new Item(currentName, 100.0, true, true);
        
        System.out.println("test_SaleItemName");
        Product = testProduct;
        Product.setName(newName);
        assertFalse(Product.getName().equals(currentName));
        assertTrue(Product.getName().equals(newName));
    }
    
      
    @Test
    public void test_SaleItemCost() {
       
        double currentCost = 100.0;
        double newCost = 101.3;
        Item testProduct = new Item("A", currentCost, true, true);
        
        System.out.println("test_SaleItemCost");
        Product = testProduct;
        Product.setIndividualCost(newCost);
        assertFalse(Product.getCost() == currentCost);
        assertTrue(Product.getCost() == newCost);
        assertFalse(Product.getIndividualCost() == currentCost);
        assertTrue(Product.getIndividualCost() == newCost);
    }
    
    @Test
    public void test_SaleItemQuantity() {
       
        double currentCost = 100.0;
        int quantity = 10;
        Item testProduct = new Item("A", currentCost, true, true);
        
        
        System.out.println("test_SaleItemQuantity");
        Product = testProduct;
        Product.setQuantity(quantity);
        assertFalse(Product.getCost() == currentCost);
        assertTrue(Product.getCost() == currentCost*quantity);
        assertTrue(Product.getIndividualCost() == currentCost);
    }
    
@Test
    public void test_SaleItemSalesTax() {
       
        double currentCost = 100.0;
        int quantity = 10;
        boolean salesTax = false;
        Item testProduct = new Item("A", currentCost, salesTax, false);
        
        System.out.println("test_SaleItemSalesTax");
        Product = testProduct;
        Product.setQuantity(quantity);
        assertFalse(Product.isSalesTaxed() != salesTax);
        assertTrue(Product.isSalesTaxed() == salesTax);
        Product.setSalesTaxed(!salesTax);
        assertFalse(Product.isSalesTaxed() == salesTax);
        assertTrue(Product.isSalesTaxed() != salesTax);
        assertTrue(Product.getTaxes() == quantity * currentCost * Item.SALESTAX);
        Product.setSalesTaxed(salesTax);
        assertFalse(Product.getTaxes() == quantity * currentCost * Item.SALESTAX);
        
    }
   
    @Test
    public void test_SaleItemImportTax() {
       
        double currentCost = 100.0;
        int quantity = 10;
        boolean importTax = false;
        Item testProduct = new Item("A", currentCost, false, importTax);
        
        System.out.println("test_SaleItemImportTax");
        Product = testProduct;
        Product.setQuantity(quantity);
        assertFalse(Product.isImportTaxed() != importTax);
        assertTrue(Product.isImportTaxed() == importTax);
        Product.setImportTaxed(!importTax);
        assertFalse(Product.isImportTaxed() == importTax);
        assertTrue(Product.isImportTaxed() != importTax);
        //System.out.println(String.format("%.2f", Product.getTaxes())+ " " + String.format("%.2f", quantity * currentCost * Item.IMPORTTAX));
        assertTrue(String.format("%.2f", Product.getTaxes()).equals(String.format("%.2f", quantity * currentCost * Item.IMPORTTAX)));
        Product.setImportTaxed(importTax);
        assertFalse(Product.getTaxes() == quantity * currentCost * Item.IMPORTTAX);
        
    }
    
       
    @Test
    public void test_SaleItemCombinedTax() {
       
        double currentCost = 100.0;
        String formattedGetTaxes, formattedCalcTaxes;
        int quantity = 10;
        boolean salesTax = false;
        boolean importTax = false;
        Item testProduct = new Item("A", currentCost, salesTax, importTax);
        
        System.out.println("test_SaleItemCombinedTax");
        Product = testProduct;
        Product.setQuantity(quantity);
        assertTrue(Product.getTaxes() == 0);
        Product.setImportTaxed(!importTax);
        Product.setSalesTaxed(!salesTax);
        formattedGetTaxes = String.format("%.2f", Product.getTaxes());
        formattedCalcTaxes = String.format("%.2f", quantity * currentCost * (Item.IMPORTTAX + Item.SALESTAX));
        //System.out.println(formattedGetTaxes + " " + formattedCalcTaxes);
        assertTrue(formattedGetTaxes.equals(formattedCalcTaxes));
        
    }
    
           
    @Test
    public void test_SaleItemCombinedTaxRounding() {
       
        double currentCost = 100.1;
        String formattedGetTaxes, formattedCalcTaxes;
        boolean salesTax = false;
        boolean importTax = false;
        Item testProduct = new Item("A", currentCost, salesTax, importTax);
        
        System.out.println("test_SaleItemCombinedTaxRounding");
        Product = testProduct;
        assertTrue(Product.getTaxes() == 0);
        Product.setImportTaxed(!importTax);
        Product.setSalesTaxed(!salesTax);
        formattedGetTaxes = String.format("%.2f", Product.getTaxes());
        formattedCalcTaxes = "15.05";
        //System.out.println(formattedGetTaxes + " " + formattedCalcTaxes);
        assertTrue(formattedGetTaxes.equals(formattedCalcTaxes));
        
    }
    
        
}
