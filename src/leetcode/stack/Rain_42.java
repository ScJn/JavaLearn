package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Rain_42 {

    public static void main(String[] args) {
        new Rain_42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    public int trap(int[] height) {

        Deque<Integer> stack = new LinkedList<>();
        int sum=0, map;
        for(int loc : height){
            if(stack.isEmpty()){
                stack.push(loc);
                continue;
            }
            int top = stack.peek();
            if(loc <= top) {
                stack.push(loc);
            }else {
                int count = 0, temp = 0;
                while(loc > top && stack.size()>1){
                    temp+=stack.poll();
                    count++;
                    top = stack.peek();
                }
                int he = Math.min(loc,stack.peek());
                sum = sum - temp + count*he;
                if(stack.peek()>=loc){
                    while(count-->0){
                        stack.push(he);
                    }
                }else {
                    stack.poll();
                }
                stack.push(loc);
            }

        }
        return sum;
    }
}
