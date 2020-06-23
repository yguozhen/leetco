package tree;

public class M_109ConvertSortedListToBinarySearchList {
    int[] nums;
    public TreeNode helper(int left, int right){
        if(left > right){
            return null;
        }
        int p = (left + right) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p -1);
        root.right = helper(p + 1, right);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList();
        if(head == null) return null;
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] array = new int[list.size()];
        for(int i = 0; i < array.length;i++){
            array[i] = list.get(i);
        }
        nums = array;
        return helper(0, nums.length - 1);
    }
}
