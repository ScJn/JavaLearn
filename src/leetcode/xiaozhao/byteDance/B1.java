package leetcode.xiaozhao.byteDance;

import java.util.*;

public class B1 {


    public static void main(String[] args) {

        class Node{
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Scanner in = new Scanner(System.in);

        List<List<Integer>> map = new ArrayList<>();
        while (in.hasNextLine()) {
            String t = in.nextLine();
            String[] ts = t.split(" ");
            ArrayList<Integer> list = new ArrayList<>();
            for (String s : ts)
                list.add(Integer.valueOf(s));
            map.add(list);
        }

        int m = map.size();
        int n = map.get(0).size();

        Queue<Node> q=new LinkedList<>();
        int sum=0;
        for(int i=0;i<map.size();i++){
            for(int j=0;j<map.get(i).size();j++){
                int cur = map.get(i).get(j);
                if(cur==2){
                    q.add(new Node(i,j));
                }else if(cur==1)sum++;
            }
        }

        int[][] vis = new int[m+1][n+1];
        int[][] way={{1,0},{-1,0},{0,1},{0,-1}};
        int ans=-1;
        int time = 0;
        for(;!q.isEmpty();q.poll()){
            if(sum == 0){
                System.out.println(ans);
                return;
            }
            Node curNode = q.peek();
            int cx = curNode.x;
            int cy = curNode.y;
            int curNodeNum = map.get(cx).get(cy);
            for(int i=0;i<4;i++){
                int nx = cx+way[i][0];
                int ny = cy+way[i][1];
                if(nx<0||m<=nx||ny<0||n<=ny||vis[nx][ny]==1)continue;
                int p = map.get(nx).get(ny);

                if(p==1){
                    sum--;
                    q.add(new Node(nx,ny));
                    map.get(nx).set(ny,curNodeNum+1);
                    ans=Math.max(ans,curNodeNum-1);
                    vis[nx][ny]=1;
                }
            }


        }
        if(sum!=0){
            System.out.println(-1);
        }
    }
}
