package leetcode.xiaozhao.tencent;

import java.util.Scanner;

public class Tencent01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long ans = 0;
        for(int i=0;i<s.length();i++){
//            ans+=(s.charAt(i)-'a')*Math.pow(25,3-i%4);
            ans*=25;
            ans+=(s.charAt(i)-'a');
        }
        System.out.println(ans);
    }
}
