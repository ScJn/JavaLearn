package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubTree {


}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        int[] a = new int[10];
        dfs(root);
        return ans;

    }

    String dfs(TreeNode root){
        if(root == null)return "#";
        String leftString = dfs(root.left);
        String rightString = dfs(root.right);

        String subTreeString =  root.val + "," + leftString + "," + rightString;
        Integer cont = map.get(subTreeString);
        if(cont == null)cont = 0;
        map.put(subTreeString, cont + 1);
        if(map.get(subTreeString) == 2)ans.add(root);
        return subTreeString;

    }

    public static void main(String[] args) {
        new Solution().findDuplicateSubtrees(TreeNode.tree(new int[]{1,2,2,4,1,4}));
    }
}