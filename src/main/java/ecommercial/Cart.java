package ecommercial;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic representation of a real cart. It consist of basic properties and functionality.
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public class Cart {


    //The VAT value is calculated based ot 20% of the incomes. This constant represent this 20%.
    private static final float VAT_VALUE = 0.2f;
    private static final float MIN_DELIVERY_FEE = 0.0f;
    private static final int NEGATIVE_INDEX_VALUE = -1;
    private static final int DELIVERY_FEE_FIRST_BORDER = 100;
    private static final int DELIVERY_FEE_SECOND_BORDER = 200;

    private List<CartItem> cartItems;
    private float deliveryFee;

    /**
     * Basic constructor representing setting values to the properties.
     * @param cartItem List of input items in the cart.
     */
    public Cart(List<CartItem> cartItem) {
        this.cartItems = new ArrayList<CartItem>();
        this.setCartItems(cartItem);
        this.DeliveryFee();
    }

    /**
     * Overridden method String which represent the values of the properties and some basic information.
     * @return Concatenating basic information and values of the properties into a string.
     */
    @Override
    public String toString() {
        return "Cart:\n" +
                this.getCartItems().toString() +
                "deliveryFee: " + this.DeliveryFee() + '\n';
    }

    /**
     * Method for adding only one item into the cart.
     * @param cartItem the input item which we want to add.
     */
    public void addItem(CartItem cartItem){
        int theIndexOfItem = this.isTheItemPresent(cartItem);
        if (theIndexOfItem!= NEGATIVE_INDEX_VALUE){
            int fullQuantity = this.getCartItems().get(theIndexOfItem).getQuantity() + cartItem.quantity;
            this.getCartItems().get(theIndexOfItem).setQuantity(fullQuantity);
        } else {
            this.getCartItems().add(cartItem);
        }
    }

    /**
     * Setter for adding a list from the input to the property of the class.
     * @param cartItems the input list .
     * @throws IllegalArgumentException when the list from the input is empty.
     */
    private void setCartItems(List<CartItem> cartItems) {
        if (cartItems.isEmpty()) {
            throw new IllegalArgumentException("There is no values in the list.");
        }
        for (CartItem cartItem : cartItems) {
            this.addItem(cartItem);
        }
    }

    /**
     * Method for removing item from the cart.
     * @param cartItem the input item which we want to remove.
     * @throws IllegalArgumentException if we don't have this item in the cart.
     */
    public void removeItem(CartItem cartItem) {
        if (this.getCartItems().contains(cartItem)) {
            this.getCartItems().remove(cartItem);
        } else {
            throw new IllegalArgumentException("The object is not present.");
        }
    }

    /**
     * Getter for all items in the cart.
     * @return list of all items in the cart.
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * Setter for the delivery fee which set from the input value into property.
     * @param deliveryFee input value of the delivery fee.
     * @throws IllegalArgumentException if the value is negative.
     */
    private void setDeliveryFee(float deliveryFee) {
        if (deliveryFee < MIN_DELIVERY_FEE) {
            throw new IllegalArgumentException("Delivery fee can't be negative value.");
        }
        this.deliveryFee = deliveryFee;
    }

    /**
     * Calculation of the delivery fee - all items price plus VAT.
     * @return Float value of the calculation.
     */
    private float DeliveryFee(){
        float deliveryFee =  this.getAllItemsPrice() + this.getVAT();
        this.setDeliveryFee(deliveryFee);
        return deliveryFee;
    }

    /**
     * Getter for the delivery fee.
     * @return Float value of the property.
     */
    public float getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * Getter which calculate the value of the VAT
     * @return Float number of the calculation.
     */
    public float getVAT() {
        return this.getAllItemsPrice()*VAT_VALUE;
    }

    /**
     * Calculate all the price of all items and there quantity.
     * @return Float number of the result of the calculation.
     */
    private float getAllItemsPrice(){
        float priceOfAllItems = 0.0f;
            for (CartItem items : this.getCartItems()) {
                priceOfAllItems += items.totalPrice();
            }
            return priceOfAllItems;
    }

    /**
     * Method calculate how much will be the delivery fee and add it to the price.
     * @return Float number of the calculation.
     */
    public float getPriceWithTheDeliveryFee() {
        float priceWithoutDeliveryFee = this.DeliveryFee();
        if (priceWithoutDeliveryFee < DELIVERY_FEE_FIRST_BORDER ) {
            return priceWithoutDeliveryFee + 10;
        } else if (priceWithoutDeliveryFee < DELIVERY_FEE_SECOND_BORDER) {
            return priceWithoutDeliveryFee + 5;
        } else {
            return priceWithoutDeliveryFee;
        }
    }

    /**
     * Method which search in all items for one exact item.
     * @param cartItem the input parameter for the item we are looking for.
     * @return the index of the parameter if it find it in the list. If it's not present then it return NEGATIVE_INDEX_VALUE.
     */
    private int isTheItemPresent(CartItem cartItem){
        List<CartItem> cartItemList = this.getCartItems();
            for (CartItem cartItemFromList : cartItemList) {
                if (cartItem.product.getLabel().equalsIgnoreCase(cartItemFromList.product.getLabel())) {
                    return cartItemList.indexOf(cartItemFromList);
                }
            }
            return NEGATIVE_INDEX_VALUE;
    }
}
