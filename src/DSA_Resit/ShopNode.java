package DSA_Resit;

/**
 * This class is used to structure the nodes that are used in {@link CircularLinkedList}s.
 *
 * <p>
 *     Each node represents a product, holding information on the {@link ShopNode#itemCode}, {@link ShopNode#name}
 *     and {@link ShopNode#price}.
 * </p>
 *
 * @author Elyas Noui, elyas.noui@city.ac.uk [190053026]
 * @version Java SE 16
 */
public class ShopNode {
    /**
     * Item's Code.
     */
    public final int itemCode;
    /**
     * Item's Name.
     */
    public final String name;
    /**
     * Item's Price.
     */
    public final double price;
    /**
     * Used to point to the next {@link ShopNode} in {@link CircularLinkedList}.
     */
    public ShopNode next;

    /**
     * This is a standard node constructor, takes in three parameters and sets {@link ShopNode#next} to null.
     * <p>
     *     This is used when you want to <b>create</b> a new node.
     * </p>
     *
     * @param itemCode {@link Integer}
     * @param name {@link String}
     * @param price {@link Double}
     */
    public ShopNode(int itemCode, String name, double price) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        next = null;
    }

    /**
     * This is the alternative constructor, takes in {@link ShopNode} as a parameter and its member functions to initialise the new object.
     * <p>
     *     This is used when you want to make a <b>copy</b> of an existing {@link ShopNode} object.
     * </p>
     *
     * @param node {@link ShopNode}
     */
    public ShopNode(ShopNode node) {
        this.itemCode = node.itemCode;
        this.name = node.name;
        this.price = node.price;
        next = null;
    }

    /**
     * Outputs the member functions of the object, with exception to {@link ShopNode#next}.
     *
     * @return {@link String}
     */
    public String toString() {
        return "Item Code: " + itemCode + ", Name: " + name + ", Price: " + price;
    }
}