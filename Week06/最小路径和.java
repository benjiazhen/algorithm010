class Solution {
    public int minPathSum(int[][] grid) {
        return method2(grid);
    }

/*
时间复杂度O(m*n)
空间复杂度O(m*n)
    1.子问题
    2.定义状态空间 dp[i][j] = min(dp[i][j-1],dp[i-1][j])+grid[i][j]
    3.dp方程 dp[i][j] = min(dp[i][j-1],dp[i-1][j])+grid[i][j]
*/
    private int method1(int[][] grid)
    {
        if(grid.length  == 0)
        {
            return 0;
        }
        int[][] dp = grid;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(i != 0 && j != 0)
                {
                    dp[i][j] =Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
                }else if(i ==0 && j != 0 )
                {
                    dp[i][j] =dp[i][j-1]+grid[i][j];
                }else if(i !=0 && j == 0)
                {
                    dp[i][j] =dp[i-1][j]+grid[i][j];
                }
               
            }
        }
        return dp[m-1][n-1];
    }
/*
时间复杂度O(m*n)
空间复杂度O(1)
    1.子问题
    2.定义状态空间 dp[i][j] = min(dp[i][j-1],dp[i-1][j])+grid[i][j]
    3.dp方程 dp[i][j] = min(dp[i][j-1],dp[i-1][j])+grid[i][j]
*/
    private int method2(int[][] grid)
    {
        if(grid.length  == 0)
        {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(i != 0 && j != 0)
                {
                    grid[i][j] =Math.min(grid[i][j-1],grid[i-1][j])+grid[i][j];
                }else if(i ==0 && j != 0 )
                {
                    grid[i][j] =grid[i][j-1]+grid[i][j];
                }else if(i !=0 && j == 0)
                {
                    grid[i][j] =grid[i-1][j]+grid[i][j];
                }
               
            }
        }
        return grid[m-1][n-1];
    }

}