package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BuilderTree_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder==null || inorder.length==0) return null;
        int j=0;
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode node = null;
        for(int i=1; i<preorder.length; i++){
            TreeNode cur = new TreeNode(preorder[i]);
            while(stack.size()>0 && stack.peek().val == inorder[j]){
                node = stack.pop();
                j++;
            }
            if(node!=null){
                node.right = cur;
                node=null;
            }
            else{
                stack.peek().left = cur;
            }
            stack.push(cur);
        }
        return root;
    }

    public static void main(String[] args) {
        new BuilderTree_105().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});

    }
}
