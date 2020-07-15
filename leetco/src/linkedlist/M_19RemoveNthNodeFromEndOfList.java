package linkedlist;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){ this.val = val;}
    ListNode(int val, ListNode next){ this.val = val; this.next = next;}
        }
public class M_19RemoveNthNodeFromEndOfList {
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        head = reverse(head);
        ListNode temp = head;
        ListNode pre = new ListNode(0);
        pre.next = temp;
        int count = 1;

        if(n == 1){
            head = head.next;
        }
        while(temp.next != null && count < n){
            pre = pre.next;
            count ++;
            temp = temp.next;
        }

        pre.next = temp.next;
        return reverse(head);

    }
}
