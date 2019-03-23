package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_94 {
    ArrayList<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        middleTraversal(root);
        return res;

    }

    /**
     * recursively
     *
     * @param root
     */
    public void middleTraversal(TreeNode root) {
        if (root == null) return;
        middleTraversal(root.left);
        res.add(root.val);
        middleTraversal(root.right);
    }

    /**
     * iteratively 迭代的
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

}
