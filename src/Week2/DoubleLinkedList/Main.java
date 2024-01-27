package Week2.DoubleLinkedList;

public class Main {
    public static <T> void printEven(Node<T> head) {
        Node<T> current = head;

        while (current != null) {
            if ((Integer) current.data % 2 == 0) {
                System.out.print(current.data + " ");
            }
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();

        // Insert elements into the linked list
        myList.listAppend(1);
        myList.listAppend(2);
        myList.listAppend(3);
        myList.listAppend(4);
        myList.listAppend(5);

        // Print even elements
        System.out.print("Even elements: ");
        printEven(myList.getHead());
    }
}
