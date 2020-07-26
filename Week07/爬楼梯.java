class Solution {
    public int climbStairs(int n) {
        return method3(n);
    }

/*
    通项公式
    时间复杂度O(logn)
    空间复杂度O(1)
*/
    private int method1(int n)
    {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

    /*
    动态规划
    时间复杂度O(n)
    空间复杂度O(n)
*/
    private int method2(int n)
    {
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1;
       for(int i = 2;i<=n ;i++)
       {
           dp[i] = dp[i-1]+ dp[i-2]; 
       }
       return dp[n];
    }
    /*
    动态规划优化
    时间复杂度O(n)
    空间复杂度O(1)
*/
    private int method3(int n)
    {
       int p = 0;
       int q = 0;
       int r =1;

       for(int i = 1;i<=n ;i++)
       {
           p =q;
           q = r;
           r = p+q;

       }
       return r;
    }



}