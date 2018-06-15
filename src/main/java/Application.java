import ecommercial.Cart;
import ecommercial.CartItem;
import ecommercial.Product;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Product product = new Product("Milk",3.15f);
        Product product1 = new Product("Bread",1.5f);
        CartItem cartItem = new CartItem(product, 2);
        CartItem cartItem1 = new CartItem(product1,4);
        List<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.add(cartItem);
        cartItems.add(cartItem1);
        Cart cart = new Cart(cartItems);
        System.out.println(product.toString());
        System.out.println(cartItem.toString());
        System.out.println(cartItem.totalPrice());
        System.out.println(cart.toString());
        System.out.println(cart.getVAT());
        System.out.println(cart.getPriceWithTheDeliveryFee());
        Product product2 = new Product("Sugar",2.65f);
        CartItem cartItem2 = new CartItem(product2,4);
        cart.addItem(cartItem2);
        System.out.println(cart.toString());
        cart.removeItem(cartItem2);
        System.out.println(cart.toString());
    }
}
