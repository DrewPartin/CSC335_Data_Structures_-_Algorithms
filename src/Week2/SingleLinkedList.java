package Week2;

public class SingleLinkedList {
    Node head; // head of the list

    // Insert a new node
    public void insert(int data){

        // create a new node with given data
        Node new_node = new Node(data);

        // if the linked list is empty then make the new node as head
        if(head == null){
            head = new_node;
        }
        else{
            // else traverse till the last node and insert the new_node
            Node last = head;

            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }

    }

    // Delete a node
    public void deleteByKey(int key){
        // store head node
        Node temp = head, prev = null;
        // If the node itself holds the key to be deleted
        if(temp != null && temp.data == key){
            // change head
            head = temp.next;
            return;
        }

        // search for the key to be deleted, keep track of the previous node as we need to change temp.next
        while(temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;

        }
        // if the key was not present in linked list
        if(temp == null)
            return;
        // unlink the node from linked list
        prev.next = temp.next;
    }

    // Search for a node
    public boolean search(int key){
        Node current = head; // initialise the current
        while(current != null){
            if(current.data == key){
                return true; // data found
            }
            current = current.next;
        }
        return false; // data not found
    }

    // Traverse the list
    public void printList(){
        Node tNode = head;
        while(tNode != null){
            System.out.print(tNode.data+ " ");
            tNode = tNode.next;
        }
    }

    public int getLength() {
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Search for an element, return the node
    public Node searchElement(int key) {
        Node current = head; // initialise current
        while (current != null) {
            if (current.data == key) {
                return current; // data found
            }
            current = current.next;
        }
        return null; // data not found
    }

}
