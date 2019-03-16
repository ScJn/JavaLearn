package leetcode.DFS;

/**
 * check() 函数简单判断边界和-1
 * 走过的位置需要标记，这里直接置-1，一般位置为0就是更新c
 * 回溯将走过的位置恢复
 * <p>
 * 可以提高： return int， 代表符合条件的个数
 * dfs = dfs（i-1,j) + dfs(i+1 ,j)+ dfs(i,j-1) + dfs(i,j+1)
 */
public class UniquePath3_980 {


    int res = 0;
    int ex, ey, bx, by;
    int count = 0;
    int m, n;
    int[][] way = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
                else if (grid[i][j] == 1) {
                    bx = i;
                    by = j;
                    grid[i][j] = -1;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(bx, by, 0, grid);
        return res;
    }

    void dfs(int nx, int ny, int c, int[][] grid) {
        for (int i = 0; i < 4; i++) {
            int nextX = nx + way[i][0];
            int nextY = ny + way[i][1];
            if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && grid[nextX][nextY] != -1) {
                if (grid[nextX][nextY] == 0) {
                    grid[nextX][nextY] = -1;
                    dfs(nextX, nextY, c + 1, grid);
                    grid[nextX][nextY] = 0;
                } else if (nextX == ex && nextY == ey && c == count) {
                    res += 1;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        int c = new UniquePath3_980().uniquePathsIII(a);
        System.out.println(c);
    }

}
