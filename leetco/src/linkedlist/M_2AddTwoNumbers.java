package linkedlist;

public class M_2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode head = new ListNode(0);
        pre.next = head;
        int reminder = 0;
        int carry = 0;
        while(l1 != null && l2 != null){
            reminder = (l1.val + l2.val + carry) % 10 ;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode temp = new ListNode(reminder);
            head.next = temp;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            reminder = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode temp = new ListNode(reminder);
            head.next = temp;
            head = head.next;
            l1 = l1.next;
        }
        while(l2 != null){
            reminder = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode temp = new ListNode(reminder);
            head.next = temp;
            head = head.next;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            head.next = temp;
        }
        return pre.next.next;

    }
}
