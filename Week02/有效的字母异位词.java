class Solution {
    public boolean isAnagram(String s, String t) {
        return hashCount(s,t);
    }
    /**
    1.暴力法
    时间复杂度:O(nlogn)
    空间复杂度:O(1)
    */
    public boolean violent(String s,String t)
    {
        if(s.equalsIgnoreCase(t))
        {
            return true;
        }else
        {
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            Arrays.sort(sc);
            Arrays.sort(tc);
            return Arrays.equals(sc,tc);
         }

    }

        /**
    1.哈希计数
    时间复杂度:O(n)
    空间复杂度:O(1)
    */
    public boolean hashCount(String s,String t)
    {
        if(s.length()!=t.length())
        {
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0 ;i<s.length();i++)
        {
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int i =0 ;i<counter.length;i++)
        {
            if(counter[i] != 0)
            {
                return false;
            }
        }
        return true;
    }
}