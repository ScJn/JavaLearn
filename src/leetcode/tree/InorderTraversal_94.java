package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_94 {
    ArrayList<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();


    public static void main(String[] args) {
        InorderTraversal_94 dd = new InorderTraversal_94();

        int[] a = new int[]{1,2,3,4,5};
        TreeNode root = TreeNode.tree(a);
        dd.inorderTraversal3(root);
        for(Integer aa:dd.res) System.out.println(aa);
    }
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

    public List<Integer> inorderTraversal3(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)return res;

        TreeNode cur = root;
        while (!stack.isEmpty() || root == cur) {
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
