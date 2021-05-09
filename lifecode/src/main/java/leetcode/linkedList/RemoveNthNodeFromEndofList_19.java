package leetcode.linkedList;

/**
 * traverse the whole linkedList first to record the length of it. then calculate the
 * position of node which need to delete.
 */
public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //n==1
        //
        int length=0;
        ListNode now=head;
        while(now!=null){
            length++;
            now=now.next;
        }
        now=head;
        int location=length-n;
        if(location==0){
            return head.next;
        }
        for(int i=0;i!=length-n-1;i++){
            now=now.next;
        }
//        if(length==location){
//
//        }
        now.next= now.next.next;
        return head;
    }

    /**
     * two point, first point advance the second n+1 steps, when first reach the end,
     * the second reach the node before the target
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
    private void print(ListNode head){

        while(head!=null){
            System.out.println(head.val+"->");
            head=head.next;
        }

    }

}
