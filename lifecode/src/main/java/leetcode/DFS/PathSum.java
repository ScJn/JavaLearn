package leetcode.DFS;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)return new ArrayList<>();
        res = new ArrayList<List<Integer>>();
        pathSum(root, sum, new Stack<Integer>());
        return res;

    }

    List<List<Integer>> res;
    void pathSum(TreeNode root, int remain, Stack<Integer> sub){
        if(root == null){
            return;
        }
        sub.push(root.val);
        if(root.left == null && root.right == null && remain == root.val){
            sub.pop();
            return;
        }
        pathSum(root.left, remain - root.val, sub);
        pathSum(root.right, remain - root.val, sub);
        sub.pop();
    }

    public static void main(String[] args) {
       // TreeNode root = new TreeNode(3);

       // new PathSum().pathSum(root,3);
        Stack<String> s=new Stack<>();
        s.push("ABC");
        s.push("DEF");
        String c = s.pop()+s.pop();
        System.out.println(c);
        PriorityQueue<Integer>aa=new PriorityQueue<>();
        aa.add(4);
        aa.add(5);
        System.out.println(aa.peek());
        PriorityQueue<Integer>ss=new PriorityQueue<>(aa);
    }
}
