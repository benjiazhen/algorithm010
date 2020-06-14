class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //iteration(nums1,m,nums2,n);
        //voilent(nums1,m,nums2,n);
        //iteration2(nums1,m,nums2,n);
        iteration3(nums1,m,nums2,n);
    }
    /**
    1.迭代
    时间复杂度:O(m+n);
    空间复杂度:O(m+n);
    */
    // public void iteration(int[] nums1, int m, int[] nums2, int n)
    // {
    //     int i = 0;
    //     int j =0;
    //     int l = 0;
    //     int[] nums = new int[m+n]; 
    //     while(i < m && j < n)
    //     {
    //         if(nums1[i] <= nums2[j])
    //         {
    //             nums[l++] = nums1[i++];
    //         }else
    //         {
    //              nums[l++] = nums2[j++];
    //         }
    //     }
    //     while(i<m)
    //     {
    //         nums[l++] = nums1[i++];
    //     }
    //     while(j<m)
    //     {
    //          nums[l++] = nums2[j++];
    //     }
    //     for(int q = 0 ;q< n+m;q++)
    //     {
    //         nums1[q] = nums[q];
    //     }
    // }
    
    /*
    2.暴力法
    时间复杂度:O(m+n+(m+n)log(m+n));
    空间复杂度:O(1);
    */
    // public void voilent(int[] nums1, int m, int[] nums2, int n)
    // {
    //     System.arraycopy(nums2,0,nums1,m,n);
    //     Arrays.sort(nums1);
    // }

        /**
    3.迭代
    时间复杂度:O(m+n);
    空间复杂度:O(m);
    */
    // public void iteration2(int[] nums1, int m, int[] nums2, int n)
    // {
    //     int i = 0;
    //     int j =0;
    //     int p = 0;
    //     int[] nums1_copy = new int[m];
    //     System.arraycopy(nums1,0,nums1_copy,0,m); 
    //     while(i < m && j < n)
    //     {
    //         nums1[p++] = nums1_copy[i] <= nums2[j] ? nums1_copy[i++] : nums2[j++];
    //     }
    //     if(i<m)
    //     {
    //         System.arraycopy(nums1_copy,i,nums1,p,m-i);
    //     }
    //     if(j<n)
    //     {
    //           System.arraycopy(nums2,j,nums1,p,n-j);
    //     }
    // }

       /* 4.迭代,将最大值往右移动
    时间复杂度:O(m+n);
    空间复杂度:O(1);
    */
    public void iteration3(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m-1;
        int j = n-1;
        int p = m+n-1;
        while(i >= 0 && j >=0)
        {
            nums1[p--] = nums1[i] <= nums2[j] ? nums2[j--] : nums1[i--];
        }
        if(j>=0)
        System.arraycopy(nums2,0,nums1,0,j+1);
        
    }

}