package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class H_23MergekSortedList {

    //solution1 prority queue
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> heap = new PriorityQueue();
        for(ListNode head : lists){
            while(head != null){
                heap.add(head.val);
                head = head.next;
            }

        }

        if(heap.isEmpty()) return null;
        ListNode head = new ListNode(heap.poll());
        ListNode temp = head;

        while(!heap.isEmpty()){
            ListNode t = new ListNode(heap.poll());
            temp.next = t;
            temp = temp.next;
        }

        return head;

    }

    //solution2 divided and conquer
    //merge sort
    public ListNode mergeKLists2(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }

    //solution3 two arraylist (merge sort)
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(left != null && right != null){
            if(left.val > right.val){
                tail.next = right;
                right = right.next;
            }else{
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }
        if(left == null){
            tail.next = right;
        }
        else if(right == null){
            tail.next = left;
        }
        return dummy.next;
    }
    public ListNode mergeKLists3(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        List<ListNode> record = new ArrayList<>();
        for(ListNode temp : lists){
            record.add(temp);
        }
        while(record.size() > 1){
            List<ListNode> newList = new ArrayList<>();
            for(int i = 0; i < record.size() - 1; i+=2){
                ListNode temp = merge(record.get(i), record.get(i + 1));
                newList.add(temp);
            }
            if(record.size() % 2 == 1){
                newList.add(record.get(record.size() - 1));
            }
            record = newList;
        }
        return record.get(0);
    }
}
