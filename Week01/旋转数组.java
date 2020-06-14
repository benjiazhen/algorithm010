class Solution {
    public void rotate(int[] nums, int k) {
        method(nums,  k);
    }
    //1.暴力破解
	//时间复杂度：O(n*k)
	//空间复杂度：O(1)
    // public void method(int[] nums,int k)
    // {
    //     for(int i=0;i<k;i++)
    //     {
    //         int previous = nums[nums.length-1];
    //         for(int j = 0 ;j< nums.length;j++)
    //         {
    //             int tmp = nums[j];
    //             nums[j]=previous;
    //             previous = tmp;
    //         }
    //     }
    // }
	
//2.向右移动k+额外存储空间
	
//时间复杂度：O(n)
//空间复杂度：O(n)
//         public void method(int[] nums,int k)
//     {
//         int[] a = new int[nums.length];
// for (int i = 0; i < nums.length; i++) {
//             a[(i + k) % nums.length] = nums[i];
//         }
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = a[i];
//         }
//     }

//3.三次翻转
//时间复杂度：O(n)
//空间复杂度：O(1)
        public void method(int[] nums,int k)
    {

        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end)
    {
        while(start < end)
        {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start ++;
            end --; 
        }
    }
}