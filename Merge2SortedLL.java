/**
 *
 * Problem Statement:
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 */
public class Merge2SortedLL {

    public static void main(String... foobar) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(6);

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(7);

        print(mergeTwoLists(head1,head2));

    }

    public static void print(ListNode head) {
        if(head == null) return;

        System.out.println(head.data);

        print(head.next);
    }

    /**
     *
     *  1 -> 2 -> 4 -> 6 -> //
     *
     *  0 -> 2 -> 3 -> 5 -> 7 -> //
     *
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode node = null;

        if(l1.data < l2.data) {
            node = l1;
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node = l2;
            node.next = mergeTwoLists(l1,l2.next);
        }

        return node;
    }

    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

}
