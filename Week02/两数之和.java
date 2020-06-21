class Solution {
    public int[] twoSum(int[] nums, int target) {
        //return violent(nums,target);
          //return hashForTwoTimes(nums,target);
           return hashForOneTime(nums,target);
    }
    /*
    1.暴力法
    时间复杂度：O(n2)
    空间复杂度:O(1)
    */
    public int[] violent(int[] nums,int target)
    {
        int[] result = new int[2];
        for(int i = 0; i< nums.length-1;i++)
        {
            for(int j = i+1;j < nums.length;j++)
            {
                if((nums[i]+nums[j]) == target)
                {
                   result[0] = i;
                   result[1] = j;
                }
            }
        }
        return result;
    }
        /*
    2.两遍hash
    时间复杂度：O(n)
    空间复杂度:O(n)
    */
    public int[] hashForTwoTimes(int[] nums,int target)
    {
        int[] result = new int[2];
        Map<Integer,Integer> valueAndIndexCache = new HashMap();  
        for(int i = 0; i< nums.length;i++)
        {
            valueAndIndexCache.put(nums[i],i);
        }
         for(int i = 0; i< nums.length;i++)
        {
            
            int j = target - nums[i];
            if(valueAndIndexCache.containsKey(j) && valueAndIndexCache.get(j) != i)
            {
                   return new int[]{i,valueAndIndexCache.get(j)};
            }   
        }
        return result;
    }
            /*
    3.一遍hash
    时间复杂度：O(n)
    空间复杂度:O(n)
    */
    public int[] hashForOneTime(int[] nums,int target)
    {
        int[] result = new int[2];
         Map<Integer,Integer> valueAndIndexCache = new HashMap(); 
         for(int i = 0; i< nums.length;i++)
        {
           int j = target - nums[i];
           if(valueAndIndexCache.containsKey(j) && valueAndIndexCache.get(j) != i)
            {
                   return new int[]{valueAndIndexCache.get(j),i};
            }  
          valueAndIndexCache.put(nums[i],i);  
          
        }
        return result;
    }
}