/**
 * Created by Seven on 02/09/2018.
 */
public class EX1_7 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode start1 = head;
        ListNode start2 = head;
        while (start2 != null && start2.next != null) {
            start1 = start1.next;
            start2 = start2.next.next;
        }
        if (start2 != null)
            start1 = start1.next;
        //reverse start1
        ListNode start = reverse(start1);
        //go through both list
        while (start.next != null) {
            if (start.val != head.val) return false;
            start = start.next;
            head = head.next;
        }
        return start.val == head.val;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode end = head;
        while (end.next != null) {
            ListNode nextNode = end.next;
            end.next = end.next.next;
            nextNode.next = prev;
            prev = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        EX1_7 ex = new EX1_7();
        System.out.println(ex.isPalindrome(head));
        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");


    }
}
