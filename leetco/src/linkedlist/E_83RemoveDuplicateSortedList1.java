package linkedlist;

public class E_83RemoveDuplicateSortedList1 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null){
            if(prev.next.val == prev.next.next.val){
                int val = prev.next.val;

                while(prev.next != null && prev.next.val == val){
                    prev.next = prev.next.next;
                }
                ListNode temp = new ListNode(val);
                temp.next = prev.next;
                prev.next = temp;
            }else{
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
