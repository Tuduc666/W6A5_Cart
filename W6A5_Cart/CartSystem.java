package W6A5_Cart;

import java.io.FileNotFoundException;
// import java.util.HashMap;
import java.util.HashMap;

public class CartSystem extends TheSystem{
    public CartSystem() throws FileNotFoundException {
    }
    public void display() {
        HashMap<String, Item> current = this.getItemCollection();
        Double subtotal=0D; Double tax; Double total;
        String message = "";
		for(Item a : current.values()) {
			message += a.getItemName() + " " + a.getItemDesc() + " " + a.getItemPrice() + " " + a.getQuantity() +  "\r\n";
			subtotal += a.getItemPrice() * a.getQuantity();
		}
		tax = subtotal * 0.05;
		total = subtotal + tax;
		
		message += "Subtotal = " + subtotal  + "\r\n";
		message += "Tax = " + tax  + "\r\n";
		message += "Total = " + total  + "\r\n";
		System.out.println(message);  
    }
}
