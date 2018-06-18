package ecommercial;

/**
 * Basic functionality of item put in the cart.
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public class CartItem {

    private Product product;
    private int quantity;

    /**
     * Basic constructor for set the properties from the input values.
     * @param product parameter from type Product. Represent the product which is put in the cart.
     * @param quantity the number of products put in the cart.
     */
    public CartItem(Product product, int quantity) {
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    /**
     * Overridden method toString to represent the parameters of the class in readable look.
     * @return String with the values of the parameters and basic information concatenated.
     */
    @Override
    public String toString() {
        return "CartItem: \n" +
                this.getProduct().toString() +
                "quantity: " + this.getQuantity() + '\n';
    }

    /**
     * Method which calculate the total price of the items in the car.
     * @return float number of the calculation.
     */
    public float totalPrice(){
        return this.getProduct().getPrice() * this.getQuantity();
    }

    /**
     * Getter for the product which sends the product.
     * @return the product in the cart.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Setter for the product, which sets the input value to the property.
     * @param product the input value which we want to set up.
     */
    private void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Getter for the quantity of the product in the cart.
     * @return The number of product which we have in the cart.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity. It set the input value to the property.
     * @param quantity input value of the quantity of each product.
     */
    protected void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.quantity = quantity;
    }
}
