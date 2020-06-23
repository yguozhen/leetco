package tree;

public class M_508 {
    //统计次数 用HashMap存
    int max;
    HashMap<Integer, Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        map = new HashMap<>();
        max = 0;
        helper(root);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int sum = left + right + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        max = Math.max(max, count);
        return sum;
    }
}
