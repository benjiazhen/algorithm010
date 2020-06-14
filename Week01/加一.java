class Solution {
    public int[] plusOne(int[] digits) {
       return violent(digits);
    }
    
        /*
    时间复杂度：O(n)
    空间复杂度:O(n)
    */
    public int[] violent(int[] nums)
    {
       for(int i= nums.length -1;i>=0;i--)
       {
           nums[i]++;
           nums[i]%=10;
           if(nums[i] != 0)
           {
               return nums;
           }
       }
       int[] nums_copy = new int[nums.length+1];
       nums_copy[0] = 1;
       return nums_copy; 
       
    }
}