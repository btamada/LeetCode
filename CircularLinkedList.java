/**
 * Build a Circular Linked List and delete a node
 */
public class CircularLinkedList {

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = head;
        deleteNode(head,7);
    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    private static Node deleteNode(Node head, int k) {
        if(head == null || k < 0) throw new IllegalArgumentException("invalid input");
        Node curr = head;
        k = k - 2;
        while(k --> 0) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

}
