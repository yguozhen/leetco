package AAAAbasic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelorder {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    //solution1 use queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }

                temp.add(node.val);
            }
            res.add(temp);
        }
        return res;
    }
}
