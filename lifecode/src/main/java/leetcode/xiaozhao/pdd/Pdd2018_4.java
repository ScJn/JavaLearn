package leetcode.xiaozhao.pdd;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Pdd2018_4 {
}

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int bx = 0, by = 0, ex = 0, ey = 0;
        char[][] maze = new char[n][m];

        in.nextLine();
        for (int i = 0; i < n; i++) {
            String temp = in.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = temp.charAt(j);
                if (maze[i][j] == '2') {
                    bx = i;
                    by = j;
                }
                if (maze[i][j] == '3') {
                    ex = i;
                    ey = j;
                }
            }
        }
        solution(maze, bx, by, ex, ey);
    }

    public static void solution(char[][] maze, int bx, int by, int ex, int ey) {
        class node {
            int x;
            int y;
            int key;// key only have a-z 26. int size is 4*8=32;
            int step;

            node(int x, int y) {
                this.x = x;
                this.y = y;
                key = 0;

            }

            node(int x, int y, int k, int step) {
                this.x = x;
                this.y = y;
                this.key = k;
                this.step = step;

            }
        }
        int[][] way = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        int[][][] vis = new int[maze.length][maze[0].length][1 << 9];
        ArrayDeque<node> q = new ArrayDeque<>();
        vis[bx][by][0] = 1;
        for (q.add(new node(bx, by)); !q.isEmpty(); ) {
            node now = q.poll();
            int step = now.step;
            if (now.x == ex && now.y == ey) {
                System.out.println(step);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int xNext = now.x + way[i][0], yNext = now.y + way[i][1], key = now.key;
                if (xNext < 0 || maze.length <= xNext || yNext < 0 || maze[0].length <= yNext || maze[xNext][yNext] == '0' || vis[xNext][yNext][key] == 1) {
                    continue;
                }
                int kNext=key;
                if(maze[xNext][yNext]=='1'||maze[xNext][yNext]=='2'||maze[xNext][yNext]=='3')q.add(new node(xNext, yNext, now.key, step + 1));
                if ('a' <= maze[xNext][yNext] && maze[xNext][yNext] <= 'z') {
                    kNext=now.key | (1 << (maze[xNext][yNext] - 'a'));
                    q.add(new node(xNext, yNext, kNext, step + 1));
                } else if ('A' <= maze[xNext][yNext] && maze[xNext][yNext] <= 'Z' && ((now.key & (1<<(maze[xNext][yNext] - 'A'))) != 0)) {
                    q.add(new node(xNext, yNext, now.key, step + 1));
                }
                vis[xNext][yNext][kNext]=1;

            }
        }
    }
}
/*
5 5
02111
01a0A
01003
01001
01111

6 10
a110000011
0021111110
11101000A0
1001100111
100B000101
11030001b1

1 8
2abcACB3

1 6
2abAB3
 */