package Week2.DoubleLinkedList;

public class Main2 {
    public static <T> void printEvenRecursive(Node<T> current) {
        // Base case: If the current node is null, return
        if (current == null) {
            return;
        }

        // Print the data if it's an even number
        if ((Integer) current.data % 2 == 0) {
            System.out.print(current.data + " ");
        }

        // Recursive call on the next node
        printEvenRecursive(current.next);
    }

    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();

        // Insert elements into the linked list
        myList.listAppend(1);
        myList.listAppend(2);
        myList.listAppend(3);
        myList.listAppend(4);
        myList.listAppend(5);

        // Print even elements recursively
        System.out.print("\nEven elements: ");
        printEvenRecursive(myList.getHead());
        System.out.println("\n");
    }
}
