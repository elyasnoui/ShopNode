package DSA_Resit;

/**
 * This is a representation of the data structure Circular Linked List. The nodes ({@link ShopNode}) are linked in
 * one direction, with links to both {@link CircularLinkedList#head} and {@link CircularLinkedList#tail}.
 *
 * @author Elyas Noui, elyas.noui@city.ac.uk [190053026]
 * @version Java SE 16
 */
public class CircularLinkedList {
    /**
     * This is the start of the list.
     * <p>
     *     If {@link CircularLinkedList#size} = 0, both head and tail will be null. <br>
     *     If {@link CircularLinkedList#size} = 1, it will point to the tail. <br>
     *     If {@link CircularLinkedList#size} > 1, it will point to the next {@link ShopNode} in list.
     * </p>
     */
    public ShopNode head;
    /**
     * This is the end of the list.
     * <p>
     *     If {@link CircularLinkedList#size} = 0, both tail and head will be null. <br>
     *     If {@link CircularLinkedList#size} = 1, it will point to the head. <br>
     *     If {@link CircularLinkedList#size} > 1, it will still point to the head.
     * </p>
     */
    public ShopNode tail;
    /**
     * This tracks the size of the circularly linked list.
     * <p>
     *     Every time a node is added or removed from the list, size is updated. <br>
     *     This is defaulted to 0.
     * </p>
     */
    private int size = 0;

    /**
     * Initialises the list.
     */
    public CircularLinkedList() {
        head = tail = null;
    }

    /**
     * Returns whether the list is empty or not.
     *
     * @return {@link Boolean}
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the size of the list.
     *
     * @return {@link Integer}
     */
    public int size() {
        return size;
    }

    /**
     * Clears the list and resets {@link CircularLinkedList#size} to 0.
     * <p>
     *     Does not explicitly delete the {@link ShopNode} objects, they are collected by Java's garbage collection.
     * </p>
     */
    public void clear() {

        // Terminates head and tail and resets size
        head = tail = null;
        size = 0;
    }

    /**
     * Inserts a node between the head and tail of the list.
     *
     * @param node {@link ShopNode} that is being inserted.
     * @param pos is the index of the list that {@link ShopNode} will be inserted in, must be between 0
     * and {@link CircularLinkedList#size} for this to execute.
     */
    public void insertNode(ShopNode node, int pos) {

        // Ensures the position is after head and before tail
        if (pos > 0 && pos < size) {

            // Selects head and searches for the node before the position we are inserting in
            ShopNode n = head;
            for (int i=0; i<pos-1; i++)
                n = n.next;

            // Reconfigures nodes in list to point to the new node and vice versa
            node.next = n.next;
            n.next = node;

            size++;  // Increments size
        }
    }

    /**
     * Adds a node to the head of the list.
     * <p>
     *     If the list is empty, it will also set {@link CircularLinkedList#tail} to the new node.
     * </p>
     *
     * @param node {@link ShopNode}
     */
    public void addToHead(ShopNode node) {
        if (isEmpty()) tail = node;  // If the list is empty, initialises the tail

        // Reconfigures the list to make the node the new head in the list
        node.next = head;
        head = node;
        tail.next = head;

        size++;  // Increments size
    }

    /**
     * Adds a node to the tail of the list.
     * <p>
     *     If the list is empty, it will also set {@link CircularLinkedList#head} to the new node.
     * </p>
     *
     * @param node {@link ShopNode}
     */
    public void addToTail(ShopNode node) {

        if (isEmpty()) head = node;  // If empty, Sets head to node, as it's previously set to null
        else tail.next = node;       // If not empty, sets the previous tail's next pointer to the new node

        // Reconfigures new node to be the list's new tail and sets the pointer to head to complete the rotation
        tail = node;
        tail.next = head;

        size++;  // Increments size
    }

    /**
     * This removes a node from the tail of the list.
     */
    public void removeFromTail() {

        // Ensures list is not empty
        if (!isEmpty()) {
            // Terminates head and tail if node size is 1
            if (size == 1)
                head = tail = null;

            else {
                // Traverses through linked list to find the node before the tail
                ShopNode node = head;
                while (node.next != tail) {
                    node = node.next;

                    // When found, the node then becomes the new tail and points to the head to complete the rotation
                    if (node.next == tail) {
                        tail = node;
                        tail.next = head;
                        break;
                    }
                }
            }

            size--;  // Decrements size
        }
    }

    /**
     * This removes a node from the head.
     * <p>
     *     Sets the next node to be the new head. If there is non, is will clear both head and tail.
     * </p>
     */
    public void removeFromHead() {

        // Ensures list is not empty
        if (!isEmpty()) {
            // If there's more than one node in the list, node after head becomes the new head
            if (head != tail) {
                head = head.next;
                tail.next = head;
            } else head = tail = null;  // Terminates head and tail to clear the list

            size--;  // Decrements size
        }
    }

    /**
     * This outputs all the {@link ShopNode}s that is currently stored in the list by invoking {@link ShopNode#toString()}.
     */
    public void printList() {

        // Ensures the list is not empty
        if (!isEmpty()) {
            // Traverses through list and invokes each node's toString() methods.
            ShopNode node = head;
            int i=0;
            do {
                System.out.println("["+i+"] " + node.toString());  // Includes index position in output
                node = node.next;
                i++;
            } while (node != head);
        } else System.out.println("List is empty");
    }
}