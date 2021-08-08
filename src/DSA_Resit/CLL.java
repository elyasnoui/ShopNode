package DSA_Resit;

/**
 * This class contains the {@link Thread} {@link CLL#main(String[])}, the entry point of the program.
 * <p>
 *     This class is abstract, as there is no need to create objects of it.
 * </p>
 *
 * @author Elyas Noui, elyas.noui@city.ac.uk [190053026]
 * @version Java SE 16
 */
public abstract class CLL {

    /**
     * This method takes in an unsorted list of {@link CircularLinkedList}, sorts the {@link ShopNode}s in <b>descending</b> order according to {@link ShopNode#price}.
     * <h4><b>Time Complexity</b></h4>
     * <p>
     *     Best Case: O(n) <br>
     *     Average Case: O(n&sup2;) <br>
     *     Worst Case: O(n&sup2;)
     * </p>
     * <h4><b>Space Complexity</b></h4>
     * <p>
     *     Best Case: O(n) <br>
     *     Average Case: O(n&sup2;) <br>
     *     Worst Case: O(n&sup2;)
     * </p>
     *
     * @param unsorted {@link CircularLinkedList}
     * @return sorted - {@link CircularLinkedList}
     */
    public static CircularLinkedList sortByPriceDescending(CircularLinkedList unsorted) {

        // Ensures the list isn't empty
        if (!unsorted.isEmpty()) {

            // Initialise new list and add a node to the head
            CircularLinkedList sorted = new CircularLinkedList();
            sorted.addToHead(new ShopNode(unsorted.head));

            // Traversing the unsorted list
            ShopNode u_node = unsorted.head.next;
            while (u_node != unsorted.head) {
                // Prints current list (testing purposes)
                System.out.println("-----------------------------------------------------------");
                sorted.printList();

                // Traverse through sorted list and compare prices, stops when condition is met
                ShopNode s_node = sorted.head;
                int i = 0;
                while (u_node.price < s_node.price && i < sorted.size()) {
                    s_node = s_node.next;
                    i++;
                }

                // Uses index to determine whether the node should be added to head, tail or inserted in between
                if (i == 0) sorted.addToHead(new ShopNode(u_node));
                else if (i == sorted.size()) sorted.addToTail(new ShopNode(u_node));
                else sorted.insertNode(new ShopNode(u_node), i);

                u_node = u_node.next;  // Selects the next node in the list
            }
            return sorted;  // Returns the sorted list
        }
        System.out.println("List is empty");
        return unsorted;  // Returns the empty list (if list is initially empty)
    }

    /**
     * Program's entry point.
     *
     * @param args is an array of command arguments for the program.
     */
    public static void main(String[] args) {
        System.out.println("Elyas Noui : 190053026 : IN1001 DSA Resit Coursework (E-K)");

        CircularLinkedList cll = new CircularLinkedList();  // Initialise cll

        // Adds nodes in ascending order
        cll.addToHead(new ShopNode(1, "Item 1", 1.00));
        cll.addToTail(new ShopNode(2, "Item 2", 2.00));
        cll.addToTail(new ShopNode(3, "Item 3", 3.00));
        cll.addToTail(new ShopNode(4, "Item 4", 4.00));
        cll.addToTail(new ShopNode(5, "Item 5", 5.00));
        cll.addToTail(new ShopNode(6, "Item 6", 6.00));

        // Output lists before and after sorting

        System.out.println("-----------------------------------------------------------INITIAL");

        cll.printList();

        cll = CLL.sortByPriceDescending(cll);

        System.out.println("-----------------------------------------------------------DESCENDING");

        cll.printList();
    }
}
