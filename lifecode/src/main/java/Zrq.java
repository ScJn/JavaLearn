

import javafx.util.Pair;

import java.util.Scanner;
import java.util.TreeMap;

public class Zrq {

    public static void main(String[] args) {
        int a = 0;
        int n = 0;
        double b = 1.4;
        char c = 'a';
        char zrq = '3';
        String s = "hello world";

//        int helloworld = 3;
        while (n <= 100) {
            n = n + 1;

            if (n % 10 == 6 && n / 10 == 0) {
                System.out.println(n);
            }

        }


    }
}


class Main {


    static class Node {
        int x,y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int C = 1; C <= T; C++) {


            int N = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            int sr = in.nextInt();
            int sc = in.nextInt();
            String qs = in.next();
            int[][] grid = new int[r + 5][c + 5];
            grid[sr][sc] = 1;
            Node cur = new Node(sr, sc);
            for (int i = 0; i < qs.length(); i++) {
                cur = move(qs.charAt(i), cur.x, cur.y, grid);
            }
            System.out.printf("Case #%d: %d %d", C, cur.x, cur.y);
        }
    }

    private static Node move(char q, int r, int c, int[][] grid) {
        int nr = 0, nc = 0;
        while(true) {

            switch (q) {
                case 'N':
                    nr = r - 1;
                    nc = c;
                    break;
                case 'S':
                    nr = r + 1;
                    nc = c;
                    break;
                case 'W':
                    nr = r;
                    nc = c - 1;
                    break;
                case 'E':
                    nr = r;
                    nc = c + 1;
            }

            if (grid[nr][nc] != 1) {
                grid[nr][nc] = 1;
                break;
            }
        }
        return new Node(nr, nc);
    }
}

