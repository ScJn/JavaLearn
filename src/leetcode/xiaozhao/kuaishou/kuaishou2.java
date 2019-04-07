package leetcode.xiaozhao.kuaishou;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kuaishou2 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n, k, ans = 1;
        m = in.nextInt();
        n = in.nextInt();
        k = in.nextInt();
        int[][] vis = new int[m+3][n+3];

        if(k == 0){
            System.out.println(0);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        int[][] way = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        vis[0][0]=1;
        for (queue.add(new Node(0, 0)); !queue.isEmpty(); queue.poll()) {

            Node cur = queue.peek();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + way[i][0];
                int ny = cur.y + way[i][1];
                int num = nx%10+nx/10+ny%10+ny/10;
                if(nx<0||m-1<nx||ny<0||n-1<ny||num>k||vis[nx][ny]==1){
                    continue;
                }
                vis[nx][ny]=1;
                queue.add(new Node(nx,ny));
                ans++;
            }
        }
        System.out.println(ans);

    }
}
