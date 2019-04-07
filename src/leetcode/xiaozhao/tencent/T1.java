package leetcode.xiaozhao.tencent;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else {
                char top = stack.peek();
                if(top-'0'+s.charAt(i)-'0'==1)stack.pop();
                else stack.push(s.charAt(i));
            }


        }
        System.out.println(stack.size());
    }
}
