package leetcode.xiaozhao.byteDance;

import javafx.scene.layout.Priority;

import java.util.*;

public class Bd01 {

    static int n,m,c;
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        Scanner in =new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        c=in.nextInt();
        ArrayList<Integer>[] a = new ArrayList[c+1];

        for(int i=0;i<a.length;i++){
            a[i]=new ArrayList<>();
        }
        int color_num,ans=0;
        for(int ball=1;ball<=n;ball++){
            color_num = in.nextInt();
            for(int j= 1;j<=color_num;j++){

                int color = in.nextInt();
                a[color].add(ball);

            }
        }

        for(int i=1;i<=c;i++){
            a[i].sort((o1,o2)->o2-o1);
            for(int j=0;j<a[i].size()-1;j++){
                int dis = Math.abs(a[i].get(j+1)-a[i].get(j));
                if(dis<m||n-dis<m){
                    ans++;
                    break;
                }
                int dis2= Math.abs(a[i].get(a[i].size()-1)-a[i].get(0));
                if(n-dis2<m||dis2<m){
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}
