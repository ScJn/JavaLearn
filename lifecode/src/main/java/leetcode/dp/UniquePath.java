package leetcode.dp;

/**
 * m*n grid 从左上到右下有几条路
 */
public class UniquePath {

    /**
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=1;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * have obstacle, just jump.
     * can still be improved. since we can use dp[j] represent both dp[i][j-1],dp[i][j]
     * then the expression is dp[i] = dp[i] + dp[i-1]
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] og=obstacleGrid;
        int m = og.length;
        int n = og[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m && og[i][0] != 1;i++){

            dp[i][0]=1;
        }
        for(int i=0;i<n && og[0][i] != 1;i++){
            dp[0][i]=1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n ; j++){
                if(og[i][j] != 1)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }



    int res=0;
    int ex,ey,bx,by;
    int count=0;
    int m,n;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0;i<m;i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0)count++;
                else if(grid[i][j] == 1){
                    bx = i;
                    by = j;
                }else if(grid[i][j] == 2){
                    ex = i;
                    ey = j;
                }
            }
        }

        dfs(bx, by, 0,grid);
        return res;

    }

    int[][] way ={{0,1},{0,-1},{1,0},{-1,0}};

    void dfs(int nx, int ny, int c, int[][] grid){

        if(nx == ex && ny == ey && c == count){
            res += 1;
            return;
        }

        for(int i = 0; i < 4; i++){
            int nextX = nx + way[i][0];
            int nextY = ny + way[i][1];
            if(0 <= nextX && nextX < m && 0 <= nextY && nextY < n && grid[nextX][nextY] != -1){
                if(grid[nextX][nextY] == '0')dfs(nextX, nextY, c+1, grid);
                else dfs(nextX, nextY, c, grid);

            }
        }


    }


}
