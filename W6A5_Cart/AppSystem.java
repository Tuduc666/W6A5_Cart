package W6A5_Cart;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class AppSystem extends TheSystem {
    public AppSystem() throws FileNotFoundException {
    }
    public void display() {
        HashMap<String, Item> current = this.getItemCollection();
        String message = "";
		for(Item a : current.values()) {
			message += a.getItemName() + " " + a.getItemDesc() + " " + a.getQuantity() + " " + a.getAvailableQuantity() + "\r\n";
		}
		System.out.println(message);    
    }
    @Override
    public Boolean add(Item item) {
    	String name = item.getItemName();
    	if(this.getItemCollection().containsKey(name)) {
    		System.out.println("Item " + name + " is already in the system"); 
    		return false;
    	}
    	else{   // not yet exist in inventory, add item
    		return super.add(item);
    	} 
    }   
}
