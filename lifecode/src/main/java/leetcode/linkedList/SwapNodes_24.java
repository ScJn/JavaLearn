package leetcode.linkedList;

/**
 * 成对地对换节点，思路好想，实现起来有点复杂
 */
public class SwapNodes_24 {

    /**
     * 这个递归太牛逼了
     * 重复动作，就可以尝试递归
     */
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    /**
     * todo 复习
     * this need to be reviewed, and extend understanding
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}
