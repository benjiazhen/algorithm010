class Solution {
    public int findContentChildren(int[] g, int[] s) {
        return method1(g,s);
    }

    /**
     * 贪心算法
     * 时间复杂度O(nlogn+mlogm+min(m,n))
     * 空间复杂度O(1)
     */
    private int method1(int[] g,int[] s)
    {
        int i = 0;
        int j =0 ;
        Arrays.sort(g);
        Arrays.sort(s);
       while(i<g.length && j<s.length)
        {
            if(g[i]<=s[j])
            {
                i++;
            }
            j++;
        }
        return i;
    }
}