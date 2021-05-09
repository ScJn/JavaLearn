package leetcode.xiaozhao.pdd;

import java.util.Scanner;

public class Pdd2019t_02 {

    public static void main(String[] args) {
        while (true){
            aa();
        }
    }
    static void aa(){
        Scanner in = new Scanner(System.in);

        String s2 = in.next();
        StringBuilder s = new StringBuilder(s2);
        int[] index = new int[28];
        int[] flag = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                if (flag[temp - 'a'] == 1) {
                    index[temp - 'a'] = 1;
                } else flag[temp - 'a'] = 1;
            } else {
                if (flag[temp - 'A'] == 1) {
                    index[temp - 'A'] = 1;
                } else flag[temp - 'A'] = 1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int ind = change(temp);
            if (index[ind] == 0 && i == 0) {
                System.out.println(Character.toLowerCase(temp));
                return;
            }
            if (i + 1 < s.length() && index[ind] != 0 && s.charAt(i + 1) < temp) {
                int ind2 = change(s.charAt(i));
                index[ind2] = 0;
                s.replace(i, i + 1, "0");
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                System.out.println(Character.toLowerCase(s.charAt(i)));
                return;
            }
        }
    }
    private static int change(char temp) {
        int ind = 0;
        if (temp >= 'a' && temp <= 'z') ind = temp - 'a';
        else if (temp <= 'Z' && temp >= 'A') ind = temp - 'A';
        return ind;
    }
}
