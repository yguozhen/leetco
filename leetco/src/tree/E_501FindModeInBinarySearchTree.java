package tree;

public class E_501FindModeInBinarySearchTree {

    //solution 1 iteration
    public int[] findMode(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if(root == null) return new int[]{};
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int count = Integer.MIN_VALUE;
        while(node != null || !stack.isEmpty()){
            while(node != null){

                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            if(map.containsKey(node.val)){
                map.put(node.val, map.get(node.val) + 1);
            }else{
                map.put(node.val, 1);
            }
            if(count < map.get(node.val)) count = map.get(node.val);

            node = node.right;


        }

        for(Integer key : map.keySet()){
            if(map.get(key) == count){
                res.add(key);
            }
        }
        int[] array = new int[res.size()];
        for(int i = 0; i < array.length;i++){
            array[i] = res.get(i);
        }

        return array;

    }

    //solution2 recursive
    // Time O(n)
    // Space O(h)
    int count = 1;
    int max = 0;
    Integer pre = null;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        if (pre != null) {
            if (root.val == pre) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max){
            list.add(root.val);
        }
        pre = root.val;
        helper(root.right, list);
    }
}
