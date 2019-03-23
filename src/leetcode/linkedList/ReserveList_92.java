package leetcode.linkedList;

import java.util.List;

public class ReserveList_92 {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode pre = null;
        ListNode ahead = null;
        for( ListNode cur = head; cur!=null;){
            ahead = cur.next;
            cur.next = pre;
            pre = cur;
            cur = ahead;
        }
        return pre;
    }

    /**
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        ListNode nHead = head;
        while(nHead.next != null)nHead = nHead.next;
        reverse(head);
        return nHead;
    }
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = reverse(head.next);
        pre.next = head;
        head.next = null;
        return head;
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m==n)return head;

        ListNode nextN = null, preM = null;
        ListNode nNode = head, mNode = head, cur=null, ahead;
        for(int i=0;i<n - 1;i++){
            nNode = nNode.next;
            nextN = nNode.next;
        }
        for(int i=0;i<m - 1 ;i++){
            preM = mNode;
            mNode = mNode.next;
        }
        ListNode pre = nextN;
        for(cur = mNode; cur != nextN; cur = ahead){
            ahead = cur.next;
            cur.next = pre;
            pre = cur;
        }
        if(preM != null)
            preM.next = nNode;
        return m == 1 ? nNode : head;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode head = ListNode.create(a);

        reverseBetween(head,2,4);
        ListNode.print(head);
    }


}
