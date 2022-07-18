package leetcode.bfs;

import java.util.*;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, situations that this interface is called, etc.]
 *
 * @author shikamaru
 * @see [String]
 * @see [Document URL]
 * @see [Class name#method name]
 * @since 2022/7/16 10:58 上午
 * <p>
 * Copyright 2020 (C) <Alibaba Global>
 */
public class SurroundedRegions {
    public static void main(String[] args) {

        char[][] board = new char[][]{
            {'X', 'O', 'X', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'X', 'X'}};

        new SurroundedRegions().solve(board);

        System.out.println(board);
    }


    static class Point{
        int x;
        int y;
        public static Point of(int x, int y) {
            Point point = new Point();
            point.x = x;
            point.y = y;
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }



    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] vis = new int[m][n];
        Queue<Point> begin = new LinkedList<>();
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    begin.add(Point.of(i, j));
                }
            }
        }

        HashSet<Point> set= new HashSet<>();

        while (!begin.isEmpty()) {
            Point poll = begin.poll();
            if (board[poll.x][poll.y] == 'X') continue;
            if (vis[poll.x][poll.y] == 1) continue;
            if (set.contains(poll)) continue;

            queue.add(poll);
            HashSet<Point> tmp= new HashSet<>();

            while (!queue.isEmpty()) {
                Point now = queue.poll();
                tmp.add(now);
                vis[now.x][now.y] = 1;
                for (int i = 0; i < 4; i++) {
                    int x = now.x + way[i][0];
                    int y = now.y + way[i][1];
                    if (!(0 <= x && x < m && 0 <= y && y < n) || set.contains(Point.of(x,y))) {
                        set.addAll(tmp);
                        tmp.clear();
                    } else if (board[x][y] == 'O' && vis[x][y] == 0) {
                        vis[x][y] = 1;
                        Point of = Point.of(x, y);
                        tmp.add(of);
                        queue.add(of);

                    }

                }
            }
            for (Point point : tmp) {
                board[point.x][point.y] = 'X';
            }
            tmp.clear();
            vis = new int[m][n];
        }
    }
}
