package leetcode.linkedList;

//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int d = 1, y = 1;
        int a1 = 0, a2 = 0;
        ListNode now = null;
        ListNode head = null;
        int up = 0;

        while (l1 != null && l2 != null) {

            int tmp = l1.val + l2.val;
            if (up == 1) {
                tmp += 1;
                up = 0;
            }
            if (tmp >= 10) {
                tmp -= 10;
                up = 1;
            }
            if (now == null) {
                head = new ListNode(tmp);
                now = head;

            } else {
                now.next = new ListNode(tmp);
                now = now.next;
            }
            l1 = l1.next;
            l2 = l2.next;

        }
        while (l1 != null) {
            int tmp = l1.val;
            if (up == 1) {
                tmp += 1;
                up = 0;
            }
            if (tmp >= 10) {
                tmp -= 10;
                up = 1;
            }
            now.next = new ListNode(tmp);
            now = now.next;

            l1 = l1.next;
        }
        while (l2 != null) {
            int tmp = l2.val;
            if (up == 1) {
                tmp += 1;
                up = 0;
            }
            if (tmp >= 10) {
                tmp -= 10;
                up = 1;
            }
            now.next = new ListNode(tmp);
            now = now.next;

            l2 = l2.next;

        }
        if (up == 1) {
            now.next = new ListNode(1);
        }
        return head;
    }
}
