/*
 * This package managers Items.
 */
package SaleItem;


/**
 *
 * @author Keith
 * This class holds individual items that can be sold.
 * - Name
 * - Cost
 * - Sales Taxed?
 * - Import Taxed?
 * - Quantity of this item.
 * 
 */
public class Item implements Cloneable {
    
    /**
     *  Sales Tax of 10%
     *  Import Tax of 5%
     */
    public static final double SALESTAX = .10;
    public static final double IMPORTTAX  = .05;
    public static final int NICKEL = 5;

    
    private String itemName;
    private double individualCost;
    private boolean salesTaxed;
    private boolean importTaxed;
    private int quantity;

   
    /**
     *  Constructor for Item
     * @param name
     * @param cost
     * @param salestaxed
     * @param importtaxed 
     */
    public Item (String name, double cost, boolean salestaxed, boolean importtaxed) 
    {
        itemName = name;
        individualCost = cost;
        salesTaxed = salestaxed;
        importTaxed = importtaxed;
        quantity = 1;
    }

    /**
     * get the cost of one item of this type.
     * @return 
     */
    public double getIndividualCost() {
        return individualCost;
    }
    
    /**
     * Get the cost of this item at quantity, not including taxes.
     * @return 
     */
    public double getCost() {
        return getQuantity() * getIndividualCost();
    }
    
    /**
     * Set Cost of One item of this type.
     * @param individualCost 
     */
    public void setIndividualCost(double individualCost) {
        this.individualCost = individualCost;
    }
    
    /**
     * Get Name of Item.
     * @return 
     */
    public String getName() {
        return itemName;
    }

    /**
     * Set Name of Item
     * @param itemName 
     */
    public void setName(String itemName) {
        this.itemName = itemName;
    }

    /** 
     * Is this item to have Sales tax.
     * @return 
     */
    public boolean isSalesTaxed() {
        return salesTaxed;
    }

    /**
     * Set if this item should have Sales tax.
     * @param salesTaxed 
     */
    public void setSalesTaxed(boolean salesTaxed) {
        this.salesTaxed = salesTaxed;
    }

    /**
     * Is this item to have Import tax.
     * @return 
     */
    public boolean isImportTaxed() {
        return importTaxed;
    }

    /**
     * Set if this item has Import Taxes.
     * @param importTaxed 
     */
    public void setImportTaxed(boolean importTaxed) {
        this.importTaxed = importTaxed;
    }
    
    /**
     * Get the Quantity of this item ordered.
     * @return 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the Quantity of this item ordered.
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity; 
    }
    
    /**
     * Clone this item.
     * @return 
     */
    public Item clone() {
	try {
            return (Item) super.clone();
	} catch (CloneNotSupportedException e) {		
            e.printStackTrace();
            throw new RuntimeException();
	}
    }

    /**
     * There is sales taxes on some items and separate import taxes on 
     * some items and taxes are rounded up to the nearest nickel
     * 
     * @return 
     */
    public double getTaxes() {
        double taxes = 0;
                 
        if(isSalesTaxed()) {
            taxes += getCost() * SALESTAX;
        }
        if(isImportTaxed()) {
            taxes += getCost() * IMPORTTAX;
        }
        
        // Round up to the next nickel.
        return ((double)(((int)(taxes*100+NICKEL-1)/NICKEL)* NICKEL)/100);
    }
    
    /**
     * Print item line when ordering.
     */
    public void printItem() {
        System.out.println(getQuantity() + " " + getName() + " at " + String.format("%.2f", getIndividualCost()));
    }
    
    /**
     * Print item line on Receipt including taxes.
     */
    public void printReceipt() {
          System.out.println(getQuantity() + " " + getName() + " : " + String.format("%.2f", getCost()+ getTaxes()));
    }
}
