package leetcode.linkedList;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, situations that this interface is called, etc.]
 *
 * @author shikamaru
 * @see [String]
 * @see [Document URL]
 * @see [Class name#method name]
 * @since 2022/8/8 10:56 下午
 * <p>
 * Copyright 2020 (C) <Alibaba Global>
 */
public class GroupK {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});

        ListNode listNode1 = new GroupK().reverseKGroup(listNode, 2);
        System.out.println();
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        String cc = "asd";
        if (k <= 1 || head == null) {
            return head;
        }
        ListNode a, b;
        a = head;
        b = head;
        int c = k;

        while (k-- > 0) {
            if (b == null) return head;
            b = b.next;
        }

        ListNode nhead = reverseK(head, c);
        head.next = reverseKGroup(b, c);
        return nhead;

    }

    public ListNode reverseK(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode nhead = reverseK(head.next, k - 1);
        head.next.next = head;
        return nhead;

    }
}
