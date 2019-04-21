package leetcode.tree;


import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode tree(int[] a) {

        TreeNode root = new TreeNode(a[0]);
        TreeNode cur = root;
        Queue<TreeNode> q = new LinkedList<>();
        for (int i = 1; i < a.length; i++) {
            while (true) {
                TreeNode newNode = new TreeNode(a[i]);
                if (cur.left == null) {
                    cur.left = newNode;
                    q.add(newNode);

                    break;
                } else if (cur.right == null) {
                    cur.right = newNode;
                    q.add(newNode);

                    break;
                } else {
                    cur = q.poll();
                }
            }
        }
        return root;
    }

}