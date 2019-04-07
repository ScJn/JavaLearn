package leetcode.xiaozhao.tencent;

import java.util.Scanner;

public class t_2018_01 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int len=s.length();
        int index=0;
        for(int i=0;i<len;i++,index++){
            int n=s.charAt(i)-'a';
            for(int j=0;j<4-i;j++){
                index+=n*Math.pow(25,j);
            }
        }
        System.out.println(index-1);

    }
}
