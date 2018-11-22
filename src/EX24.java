/**
 * Created by Seven on 06/09/2018.
 */
public class EX24 {
    public ListNode swapPairs(ListNode head,int k) {
        if (head == null || head.next == null) return head;
        ListNode fhead = new ListNode(0);
        ListNode prev = fhead;
        prev.next = head;
        while (prev.next != null && prev.next.next != null) {
            //exchange the two nodes
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            //move the pointer
            prev = first;
        }
        return fhead.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        EX24 ex = new EX24();
        ListNode res = ex.swapPairs(head,2);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");


    }
}
