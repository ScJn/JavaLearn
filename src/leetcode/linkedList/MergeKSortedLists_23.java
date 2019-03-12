package leetcode.linkedList;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists_23 {


    public ListNode mergeKLists(ListNode[] lists) {
        class Node implements Comparable<Node> {
            int val;
            int loc;

            public Node(int val, int loc) {
                this.val = val;
                this.loc = loc;
            }

            @Override
            public int compareTo(Node o) {
                return this.val > o.val ? 1 : -1;
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        ListNode resHead = new ListNode(0);
        ListNode root = resHead;

        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null)
                queue.add(new Node(head.val, i));
        }

        while (!queue.isEmpty()) {

            Node now = queue.poll();
            root.next = new ListNode(now.val);
            root = root.next;
            lists[now.loc] = lists[now.loc].next;
            if (lists[now.loc] != null)
                queue.add(new Node(lists[now.loc].val, now.loc));


        }

        return resHead.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists_23 a = new MergeKSortedLists_23();
        ListNode[] lists = new ListNode[1];
//        for (int i = 0; i < 3; i++) {
//            ListNode head = new ListNode(i);
//            ListNode head2 = head;
//
//            for (int j = 0; j < 3; j++) {
//                ListNode next = new ListNode(j + 4);
//                head2.next = next;
//                head2 = head2.next;
//            }
//            lists[i] = head;
//
//        }

        ListNode aa = a.mergeKLists(lists);
        System.out.println("ds");

    }

    /**
     * attention: the code of
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        for (ListNode node:lists) {
            if(node!=null)queue.add(node);
        }
        ListNode head = new ListNode(0), tail = head;
        while (!queue.isEmpty()) {
            tail.next=queue.poll();
            tail=tail.next;
            if(tail.next!=null)queue.add(tail.next);


        }

        return head.next;
    }

}
