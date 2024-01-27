package Week2.DoubleLinkedList;

//public class Node {
//    int data;
//    Node next;
//    Node prev;
//
//    public Node(int data) {
//        this.data = data;
//        next = null;
//        prev = null;
//    }
//}

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node() {
    }

    public Node(T value, Node<T> nextNode) {
        this.data = value;
        this.next = nextNode;
    }
}

