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
