package leetcode.linkedList;

import java.util.HashSet;

public class RemoveDuplicate_83_82 {

    HashSet<Integer> set = new HashSet<>();

    /**
     * remove all duplicate node
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){ // 如果cur没有跳，pre往前走一个
                pre=pre.next;
            }
            else{ // 如果调了，就next = cur.next 串接，cur 所在的位置是duplicate的node
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;

    }

    /**
     * 想着递归就是做好了他的工作，之后怎么处理
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;

    }
}
