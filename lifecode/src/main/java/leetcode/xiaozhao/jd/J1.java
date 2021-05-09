package leetcode.xiaozhao.jd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 体育场突然着火了，现场需要紧急疏散，但是过道真的是太窄了，
 * 同时只能容许一个人通过。现在知道了体育场的所有座位分布，座位分布图是一棵树，
 * 已知每个座位上都坐了一个人，安全出口在树的根部，也就是1号结点的位置上。
 * 其他节点上的人每秒都能向树根部前进一个结点，但是除了安全出口以外，
 * 没有任何一个结点可以同时容纳两个及以上的人，这就需要一种策略，
 * 来使得人群尽快疏散，问在采取最优策略的情况下，体育场最快可以在多长时间内疏散完成。
 */
public class J1 {
    static List<Integer>[] tree;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        tree = new LinkedList[n+1];

        for(int i=1;i<=n;i++){
            tree[i] = new LinkedList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int en = in.nextInt();
            int be = in.nextInt();
            tree[be].add(en);
        }

        int ans=-1;
        for(int i=0;i<tree[1].size();i++){
            ans = Math.max(ans,depth(tree[1].get(i)));
        }
        System.out.println(ans);

    }

    private static int depth(int root){
        if(tree[root].size()==0)return 1;
        int max=0;
        for(int i=0;i<tree[root].size();i++){
            max+=depth(tree[root].get(i));
        }
        return max+1;
    }
}
