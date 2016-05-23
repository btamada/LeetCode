/**

 Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...

 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        print(oddEvenList(head));
    }

    private static void print(ListNode head) {
        if(head == null) return;
        System.out.println(head.val);
        print(head.next);
    }

    private static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode evenItr = head;
        ListNode oddItr = head.next;
        ListNode newList = new ListNode(head.val);
        ListNode newHead = newList;
        int counter = 0;

        while(evenItr != null) {
            if(counter != 0 && counter % 2 == 0) {
                newList.next = new ListNode(evenItr.val);
                newList = newList.next;
            }
            evenItr = evenItr.next;
            ++counter;
        }

        counter = 1;

        while(oddItr != null) {
            if(counter % 2 != 0) {
                newList.next = new ListNode(oddItr.val);
                newList = newList.next;
            }
            oddItr = oddItr.next;
            ++counter;
        }

        return newHead;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {this.val = x;}
    }

}
