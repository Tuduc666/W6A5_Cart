package W6A5_Cart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import W6A5_Cart.Item;

public class TheSystem {
    private HashMap<String, Item> itemCollection;
    
    protected TheSystem() throws FileNotFoundException {
        this.itemCollection = new HashMap<String, Item>();  // This constructor initializes the itemCollection member fields
                                                       // would just be empty if not AppSystem (from Cart)
        if (getClass().getSimpleName().equals("AppSystem")) {    // check if the AppSystem is invoking the constructor 
        	String path = "C:\\Users\\Tam Uduc\\Documents\\tempJavaData\\W6A5\\sample.txt";
        	BufferedReader bf = new BufferedReader(new FileReader(path));   // data feed in from sample.txt
        	try {
        		String lineB = bf.readLine();          // read line in sample.txt
        		while (lineB != null) {
				Item item = new Item();
        		String[] line = lineB.split("\\s ");            // parse the string where it sees more the one white space.
				item.setItemName(line[0]);                      // in sample.txt fields are separated by 2 white spaces
				item.setItemDesc(line[1]);
				item.setItemPrice(Double.valueOf(line[2]));                   // convert string to double 
				item.setAvailableQuantity(Integer.parseInt(line[3]));       // convert string to integer
				
				this.itemCollection.put(line[0], item);                   // add item line to hash map
				lineB = bf.readLine();                 // read next line
        		}  // end while       
            	bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

        } 
    }
    
    public HashMap<String, Item> getItemCollection(){
    	HashMap<String, Item> newMap = new HashMap<String, Item>();  // create new HashMap
    	
    	for(Item a : this.itemCollection.values())         // loop thru current item collection
    		   newMap.put(a.getItemName(), a);         // add item line to new hash map
    	return newMap;
    }
    
    public void setItemCollection(HashMap<String, Item> copy ){
    	this.itemCollection.clear();             // clear the existing HashMap
    	for(Item a : copy.values())         // fill it with data from input parm copy
    		this.itemCollection.put(a.getItemName(), a);         
    }
    
    public Boolean add(Item item) {
    	// this.itemCollection.get(item.getItemName()).getQuantity();   //  Bairon put this here
//    	System.out.println("ITEM ADD**** " + item.getItemName() + " " +
//    	item.getItemDesc() + " " + item.getItemPrice() + " " + item.getQuantity() 
//    	+ " " + item.getAvailableQuantity());     // debug, remove this!!!!!!!!!
    	String name = item.getItemName();
    	if(this.itemCollection.get(name)==null){   // not yet exist in inventory
    		this.itemCollection.put(name, item);  
    		return true;
    	} 
    	else {
    	//	boolean check = checkAvailability(item, this.itemCollection.get(item.getItemName()).getQuantity());
    		boolean check = checkAvailability(item, 1);    // adding 1 new item
    		Item t = this.itemCollection.get(name);
    		t.setQuantity(t.getQuantity() + 1);     // add 1 to quantity
    		this.itemCollection.put(name, t);
    		return (check);
    	}
    }
    public Item remove(String itemName) {
        return this.itemCollection.remove(itemName);
    }
    public Boolean checkAvailability(Item item, Integer current) {   // current is the current avail
    	Integer qty = item.getQuantity();
    	String name = item.getItemName();
    	Integer avail = this.itemCollection.get(item.getItemName()).getAvailableQuantity();
    	if(qty+current > avail) {
    		System.out.println("System is unable to add " +
    				(qty+1) + " " +  name);
    	//	System.out.println("System can only add " + (avail - current) + " " + name);
    		System.out.println("System can only add " + avail + " " + name);
    		return false; 
    	}
    	else return true;

    }
}
