package ecommercial;

/**
 *  Class represent basic structure of a product in online shop.
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public class Product {

    private String label;
    private float price;

    /**
     * Constructor for setting the values of parameter from the input.
     * @param label The name of the product.
     * @param price the price of the product.
     */
    public Product(String label, float price) {
        this.setLabel(label);
        this.setPrice(price);
    }

    /**
     * Overridden method String to return the information about the current product.
     * @return String value of all parameters.
     */
    @Override
    public String toString() {
        return "Product: \n" +
                "label: " + this.getLabel() + '\n' +
                "price: " + this.getPrice() + '\n';
    }

    /**
     * Getter for the label which return tha name of the product.
     * @return the name of the product in String format.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter for the label. It set the input value to the parameter label.
     * @param label input String with tha value of the label.
     * @throws IllegalArgumentException when the label is null
     */
    private void setLabel(String label) {
        if (label == null) {
            throw new IllegalArgumentException("No valid data.");
        }
        this.label = label;
    }

    /**
     * Getter for the price of the product.
     * @return it returns float value of the price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Setter for the price of the product. It set the input value to the parameter price.
     * @param price input value for setting to the property.
     * @throws IllegalArgumentException when the price is lower then 0.
     */
    private void setPrice(float price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("No valid data");
        }
        this.price = price;
    }
}
