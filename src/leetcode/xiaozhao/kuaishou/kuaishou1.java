package leetcode.xiaozhao.kuaishou;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class kuaishou1 {

    static String[] data;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temp = 0;
        String inStr = in.next();
        String[] a = inStr.split(",");
        data = new String[a.length+1];
        for(String v:a){
            data[++temp]=v;
        }
        boolean f=solution(1,Long.MIN_VALUE,Long.MAX_VALUE);
        System.out.println(f?"True":"False");
    }

    static boolean solution(int i, long min, long max){
        if(i>=data.length||"None".equals(data[i]))return true;
        int val = Integer.valueOf(data[i]);
        if(val < max && val > min)
            return solution(2*i,min,val) && solution(2*i+1,val,max);
        return false;

    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

//class Main{
//    public  static void  main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int temp = 0;
//        TreeNode dummy = new TreeNode(0);
//        TreeNode root = null;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        String inStr = in.next();
//        String[] a = inStr.split(",");
//        boolean isNull = false;
//        for(String str : a){
//            if(str.equals("None")){
//                isNull = true;
//            }else{
//                temp = Integer.valueOf(str);
//            }
//            TreeNode newNode;
//            if(!isNull) newNode = new TreeNode(temp);
//
//            if(!isNull&&root == null){
//                root = newNode;
//            }
//            TreeNode cur = queue.peek();
//            queue.add(newNode);
//            if(cur.left == null)cur.left = newNode;
//            else if(cur.right == null){
//                cur.right = newNode;
//                queue.poll();
//            }
//        }
//    }
//}