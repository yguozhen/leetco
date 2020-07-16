package AAAAbasic;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class LinkedList {
    //basic operation
    // 1, insert Node


    // 2, Remove a Node


    // 3, Reverse a LinkedList
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
    // 4, merge two linked list
    public ListNode merget(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(left != null && right != null){
            if(left.val > right.val){
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }else{
                tail.next = left;
                left = left.next;
                tail = tail.next;
            }
            if(left == null){
                tail.next = right;
            }else if(right == null){
                tail.next = left;
            }
        }
        return dummy.next;
    }

    // 5, Middle of a linked list
    public ListNode findMiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
