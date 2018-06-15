import ecommercial.Cart;
import ecommercial.CartItem;
import ecommercial.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point of the application
 * @author Ana Keredechieva
 * @since 15.06.2018
 */
public class Application {

    public static void main(String[] args) {

        // Creating a product Milk
        Product milk = new Product("Milk",3.15f);
        //Creating a product Bread
        Product bread = new Product("Bread",1.5f);
        CartItem firstCartItem = new CartItem(milk, 2);
        CartItem secondCartItem = new CartItem(bread,4);
        Product product2 = new Product("Sugar",2.65f);
        CartItem cartItem2 = new CartItem(product2,4);
        //Creating new ArrayList for cart items
        List<CartItem> cartItems = new ArrayList<CartItem>();
        //Adding items into a cart
        cartItems.add(firstCartItem);
        cartItems.add(secondCartItem);
        //Creating new cart
        Cart cart = new Cart(cartItems);

        //Printing on the console information about the product Milk
        System.out.println(milk.toString());
        //Printing the information about the item and the quantity
        System.out.println(firstCartItem.toString());
        //Printing total price of the products - number of product * their price
        System.out.println(firstCartItem.totalPrice());
        //Printing information about the cart
        System.out.println(cart.toString());
        //Printing the value of the VAT
        System.out.println(cart.getVAT());
        //Total price of the cart
        System.out.println(cart.getPriceWithTheDeliveryFee());

        // add new item
        cart.addItem(cartItem2);
        System.out.println(cart.toString());
        //delete item
        cart.removeItem(cartItem2);
        System.out.println(cart.toString());
    }
}
