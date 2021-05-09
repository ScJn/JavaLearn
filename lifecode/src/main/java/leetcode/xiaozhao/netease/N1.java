package leetcode.xiaozhao.netease;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class N1 {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-->0){
            String tems=in.next();
            set.add(tems);
        }
        System.out.println(set.size());
    }
}
