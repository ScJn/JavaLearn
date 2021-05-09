package day_other_learn;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){

        String s;
        Scanner in =new Scanner(System.in);
        s=in.next();
        String[] ss=s.split(";");
        int index=in.nextInt();
        System.out.println(ss[index]);
    }
}
