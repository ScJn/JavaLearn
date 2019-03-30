package leetcode.linkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode create(int[] a){
        if(a == null || a.length == 0)return null;
        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(a[0]);
        dummy.next = head;

        for(int i=1;i<a.length;i++){
            head.next = new ListNode(a[i]);
            head = head.next;
        }
        return dummy.next;
    }

    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
    }
}
