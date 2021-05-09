package leetcode.xiaozhao.netease;

import java.util.*;

public class N3 {

    static HashMap<Integer, List<Integer>> map;
    static int[]vis;
    public static void main(String[] args) {

         map=new HashMap<>();
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        vis = new int[n+1];
        int edge=0;
        while(in.hasNext()){
            int b = in.nextInt();
            int e = in.nextInt();
            edge++;
            map.putIfAbsent(b,new LinkedList<>());
            map.get(b).add(e);
        }

        int maxNode=-1;
        for(Integer root : map.keySet()){
             int tempMax = dfs(root);
             maxNode = Math.max(tempMax,maxNode);
        }

        int ans = 0;
        if(maxNode==n){
            System.out.println(edge - (n-1));
            return;
        }
        else {
            System.out.println( edge-(maxNode-1));
        };

    }
    static int dfs(int root){
        LinkedList<Integer> list = (LinkedList<Integer>) map.get(root);
        int ans=1;
        for(Integer node:list){
            if(vis[node]!=1){
                vis[node]=1;
                ans = Math.max(ans,dfs(node)+1);
                vis[node]=0;
            }


        }
        return ans;
    }
}
