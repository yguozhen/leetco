package linkedlist;

public class M_61rotateList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}

    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while(temp.next != null){
            temp = temp.next;
            count ++;
        }
        k = k % count;
        if(k == 0){
            return head;
        }
        head = reverse(head);
        temp = head;
        ListNode pre = new ListNode(0);
        pre.next = temp;
        for(int i = 1; i <= k && pre.next != null ; i++){
            pre = pre.next;
            temp = temp.next;
        }
        pre.next = null;
        temp = reverse(temp);
        head = reverse(head);
        pre = head;
        while(pre.next != null){
            pre = pre.next;
        }
        pre.next = temp;
        return head;
    }
}
