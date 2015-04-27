/*
 * This package manages Customer orders.
 */
package CustomerOrder;

import DAL.databaseSim;
import SaleItem.Item;
import java.util.ArrayList;

/**
 * This is a single order or list of products that a customer is purchasing.
 * @author Keith
 */
public class Order {
    ArrayList<Item> customerOrder; 
    databaseSim DB = new databaseSim();
    
    public Order() {
        newOrder();
    }
     
    /**
     * Reset the Order to start new.
     */
    public void newOrder() {
        customerOrder = new ArrayList<Item>();   
    }
         
    /**
     * Add Item to the Order.
     * @param name
     * @param quantity 
     */
    public void addItem(String name, int quantity) {
        Item Product = DB.GetProduct(name);
        
        if(Product != null) {
            Product.setQuantity(quantity);
            customerOrder.add(Product);
            Product.printItem();
        }
    }

    /**
     * Return the number of Items in the order so far.
     * @return 
     */
    public int numberItems() {
        return customerOrder.size();
    }
    
    /**
     * Print the Receipt of Items.
     */
    public void printReceipt() {
        
        double SalesTaxes = 0;
        double Total = 0;
        
        for(Item Product : customerOrder) {
            Product.printReceipt();
            SalesTaxes += Product.getTaxes();
            Total += Product.getCost() + Product.getTaxes();
        }
        
        System.out.println("Sales Taxes: " + String.format("%.2f", SalesTaxes));
        System.out.println("Total: " + String.format("%.2f", Total));
    }

}
