class Solution {
    public int removeDuplicates(int[] nums) {
        return method(nums);
    }
    //1.暴力解法,LinkedSet去重
    // public int method(int[] nums)
    // {
    //     Set<Integer> set = new LinkedSet();
    //     for(int i = 0;i< num.length;i++)
    //     {
    //         set.add(num[i]);
    //         num[i] = 0;
    //     }
    //     for(int i = 0;i<set.size();i++)
    //     {
    //         num[i] = set.get(i);
    //     }
    //     return set.size();
    // }

    //2.升级维度
    public int method(int[] nums)
    {
        
        int j = 0;
        for(int i = 0;i<nums.length-1;i++)
        {
           if(nums[i] != nums[i+1])
           {
            nums[++j] = nums[i+1];
           }
        }
        return j+1;
    }
}