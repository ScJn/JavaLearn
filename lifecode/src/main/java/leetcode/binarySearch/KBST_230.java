package leetcode.binarySearch;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KBST_230 {

    List<Integer> a = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        in(root);
        return a.get(k-1);
    }

    public void in(TreeNode root){
        if(root == null)return;
        in(root.left);
        a.add(root.val);
        in(root.right);

    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        a2.left = a;
        a2.right = a3;
        int c = new KBST_230().kthSmallest(a2,2);
        System.out.println(c);

    }
}
