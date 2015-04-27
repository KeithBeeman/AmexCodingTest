/*
 * This package is the Data Access Layer.
 */
package DAL;

import SaleItem.Item;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Keith
 * This class simulates a database of products to be sold.
 * Add Products, Delete Products, Clear Database.
 */
public final class databaseSim {
    private final HashMap<String, Item> products = new HashMap<>();
    
    // Initialize the database with the basic set of products.
    public databaseSim() {
        
        AddProduct(new Item("book", 12.49, false, false));
        AddProduct(new Item("music CD", 14.99, true, false));
        AddProduct(new Item("chocolate bar", .85, false, false));
        AddProduct(new Item("imported box of chocolates", 10.00, false, true));
        AddProduct(new Item("imported bottles of perfume", 47.25, true, true));
        AddProduct(new Item("imported bottle of perfume", 27.99, true, true));
        AddProduct(new Item("bottle of perfume", 18.99, true, false));
        AddProduct(new Item("packet of headache pills", 9.75, false, false));
        AddProduct(new Item("box of imported chocolates", 11.25, false, true));
    }
    
    /**
     * Add Products to the database.
     * @param Product 
     */
    public void AddProduct(Item Product){
        if(!products.containsKey(Product.getName()))
        {
            products.put(Product.getName(), Product);
        }
    }
    
    /**
     * Delete Products from the database.
     * @param Product 
     */
    public void DeleteProduct(Item Product) {
        if(products.containsKey(Product.getName()))
        {
            products.remove(Product.getName());
        }
    }
    
    /**
     * Empty the database of products.
     * 
     */
    public void ClearProducts() {
        products.clear();
    }
    
    /**
     * Get Product from the database.
     * @param Name
     * @return 
     */
    public Item GetProduct(String Name) {
        if(!products.isEmpty() && products.containsKey(Name))
        {
            return (Item) (products.get(Name).clone());
        }
        return null;
    }
}
