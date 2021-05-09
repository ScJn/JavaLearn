package forInterview;

import java.util.Stack;

public class MiddleTraverse {

    public static void main(String[] args) {

    }

    public static void middle(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null){

            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val+"-");
            if(cur.right != null){
                cur = cur.right;
            }
        }
    }
}
