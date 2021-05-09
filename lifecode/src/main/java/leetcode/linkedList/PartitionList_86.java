package leetcode.linkedList;

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)return head;
        ListNode lessHead = new ListNode(0);
        ListNode greatHead = new ListNode(0);

        ListNode cur = head, lcur = lessHead, gcur = greatHead;
        while(cur != null){
            if(cur.val<x){
                lcur.next = cur;
                lcur = cur;
            }else {
                gcur.next = cur;
                gcur = cur;
            }
            cur = cur.next;
        }
        gcur.next = null;
        lcur.next = greatHead.next;
        return lessHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int[] a = {1,5,3,2,5,2};
        for(int i=0;i<6;i++){
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        System.out.println(new PartitionList_86().partition(head,3));
    }
}
