/*
 * This a  simple store example to run inputs and generate outputs for the
 * specific examples given.
 */
package MyStore;

import CustomerOrder.Order;
import DAL.databaseSim;
import SaleItem.Item;

/**
 *
 * @author Keith
 */
public class MyStore {
        
    private static databaseSim Products = new databaseSim();
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Order1();
        Order2();
        Order3();
    }

    

    private static void Order1() {
        Order CustomerOne = new Order();
        
        System.out.print("\nInput 1:\n\n");
        CustomerOne.addItem("book", 1);
        CustomerOne.addItem("music CD", 1);
        CustomerOne.addItem("chocolate bar", 1);
        
        System.out.print("\nOutput 1:\n\n");
        CustomerOne.printReceipt();
        
    }

    private static void Order2() {
        Order CustomerTwo = new Order();
        
        System.out.print("\nInput 2:\n\n");
        CustomerTwo.addItem("imported box of chocolates", 1);
        CustomerTwo.addItem("imported bottles of perfume", 2);
        
        System.out.print("\nOutput 2:\n\n");
        CustomerTwo.printReceipt();
        }

    private static void Order3() {
        Order CustomerThree = new Order();
        
        System.out.print("\nInput 3:\n\n");
        CustomerThree.addItem("imported bottle of perfume", 1);
        CustomerThree.addItem("bottle of perfume", 1);
        CustomerThree.addItem("packet of headache pills", 1);
        CustomerThree.addItem("box of imported chocolates", 1);
        
        System.out.print("\nOutput 3:\n\n");
        CustomerThree.printReceipt();
       
    }

}
