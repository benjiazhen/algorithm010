class Solution {
    public void moveZeroes(int[] nums) {
        violent(nums);
    }
    /*
    时间复杂度：O(n)
    空间复杂度:O(1)
    */
    public void violent(int[] nums)
    {
        int j = 0 ;
        for(int i = 0 ; i < nums.length;i++)
        {
            if(nums[i] != 0 )
            {
                nums[j] = nums[i];
                if(i != j)
                {
                    nums[i] = 0;  
                }
                j++;
            }
        }
    }

}