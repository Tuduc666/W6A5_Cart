package W6A5_Cart;

import java.io.FileNotFoundException;
import java.util.Scanner;

import W6A5_Cart.AppSystem;
import W6A5_Cart.CartSystem;
import W6A5_Cart.Item;

public class MainEntryPoint
{
    public static void main(String[] args) throws FileNotFoundException {
        AppSystem app = new AppSystem();
        CartSystem cart = new CartSystem();
        Scanner reader = new Scanner(System.in);
        Integer choice = 0;
        while(choice != 7) {
            menu();
            choice = reader.nextInt();
            switch(choice) {
                case 1:
                    Item item = new Item();
                    reader.nextLine();
                    System.out.print("\nEnter the item name:\n");
                    item.setItemName(reader.nextLine());
                    System.out.print("\nEnter a description for the item:\n");
                    item.setItemDesc(reader.nextLine());
                    System.out.print("\nEnter the item's price:\n");
                    item.setItemPrice(reader.nextDouble()); reader.nextLine();
                    System.out.print("\nEnter the quantity available in the System:\n");
                    item.setAvailableQuantity(reader.nextInt());
                    System.out.println(item.getItemName());
                    if(app.add(item)) {
                        System.out.println("Item successfully added");
                    }else {
                        System.out.println("Try Again");
                    }
                    break;
                case 2:
                    app.display();
                    System.out.println("Enter the name of the item");
                    reader.nextLine();
                    String item_name = reader.nextLine();
                    Item t = app.getItemCollection().get(item_name);      
                    if(t != null) cart.add(t);     // verify that item is in the system before adding to cart
                    else System.out.println("Invalid item entered, item is not in the list.");
                    break;
                case 3:
                    cart.display();
                    break;
                case 4:
                    app.display();
                    break;
                case 5:
                    cart.display();
                    System.out.println("Enter the name of the item");
                    reader.nextLine();
                    item_name = reader.nextLine();
                    cart.remove(item_name);
                    break;
                case 6:
                    app.display();
                    System.out.println("Enter the name of the item");
                    reader.nextLine();
                    item_name = reader.nextLine();
                    app.remove(item_name);
                    break;
                case 7:
                    System.out.println("\nByyyeee!!");
                    break;
            }
        }
        reader.close();
    }
    
    public static void menu() {
        System.out.println("\nChoose an action:");
        System.out.println("1. Add item to System");
        System.out.println("2. Add item to Cart");
        System.out.println("3. Display Cart");
        System.out.println("4. Display System");
        System.out.println("5. Remove item from Cart");
        System.out.println("6. Remove item from System");
        System.out.println("7. Quit");
    }
}
