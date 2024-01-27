//package Week2.DoubleLinkedList;
//
//public class DoubleLinkedList {
//    Node head; // head of the list
//
//    // method to insert a node at the front of the list
//    public void insertFront(int data){
//        // create a new node with given data
//        Node newNode= new Node(data);
//
//        // Make next of new node as head and previous as null
//        newNode.next= head;
//        newNode.prev= null;
//
//        // change prev of head node to new node
//        if(head!=null){
//            head.prev= newNode;
//        }
//        // move the head to point to the new node
//        head= newNode;
//    }
//
//    // Method to delete a node
//    public void deleteNode(Node del){
//        if(head==null || del==null){
//            return;
//        }
//
//        // If node to be deleted is head node
//        if(head==del){
//            head=del.next;
//        }
//
//        // change next if node to be deleted is not the last node
//        if(del.next!=null){
//            del.next.prev=del.prev;
//        }
//
//        // change prev if node to be deleted is not the first node
//        if(del.prev!=null){
//            del.prev.next=del.next;
//        }
//    }
//
//    // Method to search a node
//    public boolean search(int key){
//        Node current= head;
//
//        while(current!=null){
//            if(current.data==key){
//                return true;
//            }
//            current=current.next;
//        }
//        return false;
//    }
//
//    //Method to print double linked list nodes
//    public void printList(){
//        Node node=head;
//        while (node != null) {
//            System.out.print(node.data + " ");
//            node=node.next;
//        }
//    }
//
//    // method to append a node to the end of the list
//    public void append(int data){
//        // create a new node with given data
//        Node newNode= new Node(data);
//
//        // if the linked list is empty, then make the new node as head
//        if(head==null){
//            head=newNode;
//            return;
//        }
//
//        // new node becomes the last node, make next = null
//        newNode.next = null;
//
//        // else traverse till the last node
//        Node last=head;
//        while(last.next!=null){
//            last=last.next;
//        }
//
//        // change the next of last node
//        last.next=newNode;
//
//        // make last node as previous of new node
//        newNode.prev=last;
//    }
//
//    // method to prepend a node to the beginning of the list
//    public void prepend(int data){
//        // create a new node with given data
//        Node newNode= new Node(data);
//
//        // Make next of new node = head and previous = null
//        newNode.next= head;
//        newNode.prev= null;
//
//        // change prev of head node to new node
//        if(head!=null){
//            head.prev= newNode;
//        }
//        // move the head to point to the new node
//        head= newNode;
//    }
//
//    public static void main(String[] args) {
//        DoubleLinkedList dll= new DoubleLinkedList();
//        dll.append(6);
//        dll.append(7);
//        dll.append(8);
//        dll.append(9);
//        dll.append(10);
//        dll.prepend(5);
//        dll.prepend(4);
//        dll.prepend(3);
//        dll.prepend(2);
//        dll.prepend(1);
//        System.out.println(" ");
//        dll.printList();
//        System.out.println("\n");
//    }
//}