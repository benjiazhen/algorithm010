class Solution {
    public int numDecodings(String s) {

        return method2(s);
    }

    /*
    时间复杂度O(n)
    空间复杂度O(n)
        */
    private int method1(String s)
    {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        //定义状态空间dp[i] 长度为i的编码个数
        int n =s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) =='0' ? 0:1;
        for(int i = 2;i<=n;i++)
        {
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));
            if(first>=1 && first <=9 )
            {
                dp[i] += dp[i-1];
            }
            if(second >=10 && second <=26)
            {
                dp[i] += dp[i-2];
            } 
        }
        return dp[n];
    }
     /*
    时间复杂度O(n)
    空间复杂度O(n)
        */
    private int method2(String s)
    {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
        {
            return 0;
        }
        //定义状态空间dp[i] 长度为i的编码个数
        int n =s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) =='0' ? 0:1;
        for(int i = 2;i<=n;i++)
        {
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i-1));
             if (first == 0)//1.s[i]为0的情况
                if (second == 1 || second == 2) //s[i - 1]等于1或2的情况
                    dp[i] = dp[i-2];//由于s[1]指第二个下标，对应为dp[2],所以dp的下标要比s大1，故为dp[i+1]
                else 
                   dp[i] = 0;
            else //2.s[i]不为0的情况
                if (second == 1 || (second == 2 && first <= 6))//s[i-1]s[i]两位数要小于26的情况
                    dp[i] = dp[i-1]+dp[i-2];
                else//其他情况
                    dp[i] = dp[i-1];
        
        }
        return dp[n];
    }
}
