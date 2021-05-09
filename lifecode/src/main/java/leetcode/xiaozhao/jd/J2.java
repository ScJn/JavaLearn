package leetcode.xiaozhao.jd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * 给出m个字符串S1，S2，...，Sm和一个单独的字符串T。请在T中选出尽可能多的子串同时满足：
 *
 * 1）这些子串在T中互不相交。
 *
 * 2）这些子串都是S1，S2，...，Sm中的某个串。
 *
 * 问最多能选出多少个子串。
 *
 *
 * 输入
 * 第一行一个数m（1≤m≤10），接下来m行，每行一个串。最后一行输入一个串T。
 * 输入中所有单个串的长度不超过100000，串中只会出现小写字母。
 *
 * 输出
 * 输出一个数，最多能选出多少串。
 *
 *
 * 样例输入
 * 3
 * aa
 * b
 * ac
 * bbaac
 * 样例输出
 * 3
 *
 * 提示
 */
public class J2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String[] strs = new String[m];
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            strs[i] = in.next();
            stringSet.add(strs[i]);
        }
        String t = in.next();

        int[] dp = new int[t.length() + 1];
        dp[0] = 0;
        for(int index = 0;index<t.length();index++) {
            for (int i = 0; i < m; i++) {
                int len = strs[i].length();
                if (len + index > t.length()) continue;
                dp[index + len] = Math.max(dp[index + len], dp[index] + (strs[i].equals(t.substring(index, len+index)) ? 1 : 0));
            }
        }
        System.out.println(dp[t.length()]);
    }
}
